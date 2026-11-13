package myy803.Traineeship.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import myy803.Traineeship.domainmodel.Committee;
import myy803.Traineeship.domainmodel.Company;
import myy803.Traineeship.domainmodel.Professor;
import myy803.Traineeship.domainmodel.Student;
import myy803.Traineeship.domainmodel.User;
import myy803.Traineeship.services.UserService;


@Controller
public class AuthController {
	@Autowired
    UserService userService;

    @RequestMapping("/login")
    public String login(){
    	System.out.println("LOGIN PAGE REQUESTED");
        return "auth/login";
    }

    @RequestMapping("/register")
    public String register(Model model){
        model.addAttribute("user", new User());
        return "auth/register";
    }

    @RequestMapping("/save")
    public String registerUser(@ModelAttribute("user") User user, Model model){
    	System.out.println("POST /save called with: " + user);
       
    	if (user.getUsername() == null || user.getUsername().isEmpty() ||
    	        user.getPassword() == null || user.getPassword().isEmpty() ||
    	        user.getRole() == null || user.getRole().isEmpty()) {

    	        model.addAttribute("errorMessage", "All fields are required.");
    	        return "auth/register";
    	}
    	
        if(userService.isUserPresent(user)){
            model.addAttribute("successMessage", "User already registered!");
            return "auth/login";
        }
  
        switch (user.getRole()) {
	        case STUDENT -> {
	            Student student = new Student(user.getUsername(),user.getPassword(), user.getRole());
	            userService.saveUser(student);
	        }
	        case PROFESSOR -> {
	            Professor professor = new Professor(user.getUsername(), user.getPassword(), user.getRole());
	            userService.saveUser(professor);
	        }
	        case COMPANY -> {
	            Company company = new Company(user.getUsername(), user.getPassword(), user.getRole());
	            userService.saveUser(company);
	        }
	        case COMMITTEE -> {
	            Committee committee = new Committee(user.getUsername(), user.getPassword(), user.getRole());
	            userService.saveUser(committee);
	        }
	    }
        
        model.addAttribute("successMessage", "User registered successfully!");
        return "auth/login";
    }
}
