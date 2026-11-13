package myy803.Traineeship.Controllers;





import java.security.Principal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import myy803.Traineeship.domainmodel.Student;
import myy803.Traineeship.domainmodel.TraineeshipPosition;
import myy803.Traineeship.mappers.StudentMapper;
import myy803.Traineeship.mappers.TraineeshipPositionsMapper;
import myy803.Traineeship.services.StudentService;

@Controller
public class StudentController {

	
	@Autowired
	StudentService studentService;
	@Autowired
	StudentMapper studentMapper;
	@Autowired
	TraineeshipPositionsMapper traineeshipMapper;

	@RequestMapping("/student/student-homepage")
	public String getStudentDashboard(Model model, Principal principal){
	    String username = principal.getName();
	    Optional<Student> studentOpt = studentMapper.findByUsername(username);

	   
	    if (!studentOpt.isPresent() || studentOpt.get().getStudentName() == null) {
	        return "redirect:/student/createProfileForm";
	    }

	    model.addAttribute("student", studentOpt.get());

	    return "student/student-homepage";
	}

	
	@GetMapping("/student/createProfileForm")
	public String showCreateProfileForm(Model model, Principal principal) {
	    String username = principal.getName(); 
	    Optional<Student> optionalStudent = studentMapper.findByUsername(username); 
	    
	    if (optionalStudent.isPresent()) {
	        model.addAttribute("student", optionalStudent.get());
	    } else {
	        model.addAttribute("student", optionalStudent.orElse(new Student())); // fallback
	    }
	    
	    return "student/createProfileForm";
	}


	@PostMapping("/student/createProfileForm")
	public String saveProfile(@ModelAttribute("student") Student formStudent, Principal principal) {
		String username = principal.getName();
	    Student existingStudent = studentMapper.findByUsername(username)
	        .orElseThrow(() -> new RuntimeException("Student not found"));

	    existingStudent.setPassword(formStudent.getPassword());
	    existingStudent.setRole(formStudent.getRole());
	    existingStudent.setPreferredLocation(formStudent.getPreferredLocation());
	    existingStudent.setStudent_AM(formStudent.getStudent_AM());
	    existingStudent.setStudent_skills(formStudent.getStudent_skills());
	    existingStudent.setStudent_interests(formStudent.getStudent_interests());
	    existingStudent.setStudentName(formStudent.getStudentName());
	    
	    studentMapper.save(existingStudent);

	    return "redirect:/student/student-homepage";
	}
	
	@GetMapping("/student/apply")
	public String applyToTraineeship(@RequestParam String committeeUsername, Model model) {
		String studentUsername = SecurityContextHolder.getContext().getAuthentication().getName(); 
		try {
	        String message = studentService.applyToTraineeship(studentUsername, committeeUsername);
	        model.addAttribute("message", message);
	    } catch (RuntimeException e) {
	        model.addAttribute("message", e.getMessage());
	    }
	    return "student/student-homepage";
	}


	
	
}
	
    
    
    
    
    
 