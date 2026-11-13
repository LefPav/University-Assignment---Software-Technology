package myy803.Traineeship.Controllers;

import java.security.Principal;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import myy803.Traineeship.domainmodel.Company;
import myy803.Traineeship.domainmodel.TraineeshipPosition;
import myy803.Traineeship.mappers.CompanyMapper;
import myy803.Traineeship.services.CompanyService;

@Controller
public class CompanyController {

	@Autowired
	CompanyService companyService;
	
	@Autowired
	CompanyMapper companyMapper;
	
	@RequestMapping("/company/company-homepage")
	public String getCompanyDashboard(Model model, Principal principal){
	    String username = principal.getName();
	    Optional<Company> companyOpt = companyMapper.findByUsername(username);

	   
	    if (!companyOpt.isPresent() || companyOpt.get().getCompanyName() == null) {
	        return "redirect:/company/createProfileForm";
	    }

	    model.addAttribute("company", companyOpt.get());
	    return "company/company-homepage";
	}
	
	@GetMapping("/company/createProfileForm")
	public String showCreateProfileForm(Model model, Principal principal) {
	    String username = principal.getName(); 
	    Optional<Company> optionalCompany = companyMapper.findByUsername(username); 
	    
	    if (optionalCompany.isPresent()) {
	        model.addAttribute("company", optionalCompany.get());
	    } else {
	        model.addAttribute("company", optionalCompany.orElse(new Company())); // fallback
	    }
	    
	    return "company/createProfileForm";
	}


	@PostMapping("/company/createProfileForm")
	public String saveProfile(@ModelAttribute("company") Company formCompany, Principal principal) {
		String username = principal.getName();
	    Company existingCompany = companyMapper.findByUsername(username)
	        .orElseThrow(() -> new RuntimeException("Company not found"));

	    
	    existingCompany.setCompanyName(formCompany.getCompanyName());
	    existingCompany.setCompanyLocation(formCompany.getCompanyLocation());

	    companyMapper.save(existingCompany);
	    return "redirect:/company/company-homepage";
	}
	
	@GetMapping("/company/announceAvailablePosition")
	public String showForm(Model model) {
	    model.addAttribute("traineeshipPosition", new TraineeshipPosition());
	    return "company/announceAvailablePosition"; 
	}
	
	@PostMapping("/company/addTraineeshipPosition")
	public String saveForm(@ModelAttribute("traineeshipPosition") TraineeshipPosition traineeshipPosition, Principal principal) {
	    String username = principal.getName();
	    companyService.addTraineeshipPosition(username, traineeshipPosition);
	    return "redirect:/company/company-homepage"; 
	}
	
	@RequestMapping("/company/listAvailablePositions")
	public String listAvailableTraineeshipPositions(Model model, Principal principal) {
		String username = principal.getName();
		List<TraineeshipPosition> positions = companyService.listAvailablePositions(username);
		model.addAttribute("positions", positions);
		return "company/listAvailablePositions";
		
	}


}
