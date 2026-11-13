package myy803.Traineeship.Controllers;

import java.security.Principal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import myy803.Traineeship.domainmodel.Professor;
import myy803.Traineeship.mappers.ProfessorMapper;
import myy803.Traineeship.services.ProfessorService;

@Controller
public class ProfessorController {
	
	@Autowired
	ProfessorService professorService;
	
	@Autowired
	ProfessorMapper professorMapper;
	
	@RequestMapping("/professor/professor-homepage")
	public String getStudentDashboard(Model model, Principal principal){
	    String username = principal.getName();
	    Optional<Professor> professorOpt = professorMapper.findByUsername(username);

	   
	    if (!professorOpt.isPresent() || professorOpt.get().getProfessorName() == null) {
	        return "redirect:/professor/createProfileForm";
	    }

	    model.addAttribute("professor", professorOpt.get());

	    return "professor/professor-homepage";
	}

	
	@GetMapping("/professor/createProfileForm")
	public String showCreateProfileForm(Model model, Principal principal) {
	    String username = principal.getName(); 
	    Optional<Professor> optionalProfessor = professorMapper.findByUsername(username); 
	    
	    if (optionalProfessor.isPresent()) {
	        model.addAttribute("professor", optionalProfessor.get());
	    } else {
	        model.addAttribute("professor", optionalProfessor.orElse(new Professor())); 
	    }
	    
	    return "professor/createProfileForm";
	}


	@PostMapping("/professor/createProfileForm")
	public String saveProfile(@ModelAttribute("professor") Professor formProfessor, Principal principal) {
		String username = principal.getName();
	    Professor existingProfessor = professorMapper.findByUsername(username)
	        .orElseThrow(() -> new RuntimeException("Professor not found"));

	    existingProfessor.setPassword(formProfessor.getPassword());
	    existingProfessor.setRole(formProfessor.getRole());
	    existingProfessor.setProfessorName(formProfessor.getProfessorName());
	    existingProfessor.setProfessor_interests(formProfessor.getProfessor_interests());

	    professorMapper.save(existingProfessor);
	    return "redirect:/professor/professor-homepage";
	}
	
}
