package myy803.Traineeship.Controllers;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import myy803.Traineeship.domainmodel.Committee;
import myy803.Traineeship.domainmodel.Company;
import myy803.Traineeship.domainmodel.Student;
import myy803.Traineeship.domainmodel.TraineeshipPosition;
import myy803.Traineeship.mappers.CommitteeMapper;
import myy803.Traineeship.services.CommitteeService;

@Controller
public class CommitteeController {
	
	@Autowired
	CommitteeService committeeService;
	
	@Autowired
	CommitteeMapper committeeMapper;

	@RequestMapping("/committee/committee-homepage")
	public String getCompanyDashboard(Model model, Principal principal){
	    String username = principal.getName();
	    Optional<Committee> committeeOpt = committeeMapper.findByUsername(username);

	   
	    if (!committeeOpt.isPresent() || committeeOpt.get().getCommitteeName() == null) {
	        return "redirect:/committee/createProfileForm";
	    }

	    model.addAttribute("committee", committeeOpt.get());
	    return "committee/committee-homepage";
	}
	
	@GetMapping("/committee/createProfileForm")
	public String showCreateProfileForm(Model model, Principal principal) {
	    String username = principal.getName(); 
	    Optional<Committee> optionalCommittee = committeeMapper.findByUsername(username); 
	    
	    if (optionalCommittee.isPresent()) {
	        model.addAttribute("committee", optionalCommittee.get());
	    } else {
	        model.addAttribute("committee", optionalCommittee.orElse(new Committee()));
	    }
	    
	    return "committee/createProfileForm";
	}


	@PostMapping("/committee/createProfileForm")
	public String saveProfile(@ModelAttribute("committee") Committee formCommittee, Principal principal) {
		String username = principal.getName();
	    Committee existingCommittee = committeeMapper.findByUsername(username)
	        .orElseThrow(() -> new RuntimeException("Company not found"));
	    
	    existingCommittee.setCommitteeName(formCommittee.getCommitteeName());

	    committeeMapper.save(existingCommittee);
	    return "redirect:/committee/committee-homepage";
	}
	
	@GetMapping("/committee/listOfAppliedStudents")
	public String listOfStudentsWhoApplied(Model model) {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		List<Student> applicants = committeeService.listOfStudentsWhoAppliedForPositions(username);
		model.addAttribute("applicants", applicants);
		return "committee/listOfAppliedStudents";
	}
}
