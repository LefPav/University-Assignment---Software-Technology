package myy803.Traineeship.config;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import myy803.Traineeship.domainmodel.Student;
import myy803.Traineeship.mappers.StudentMapper;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Configuration
public class CustomSecuritySuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
	
	@Autowired
	private StudentMapper studentMapper;


	 @Override
	    protected void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication)throws java.io.IOException 
	 	{
	
	        String targetUrl = determineTargetUrl(authentication);
	        if(response.isCommitted()) 
	        	return;
	        RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	        redirectStrategy.sendRedirect(request, response, targetUrl);
	    }

	    protected String determineTargetUrl(Authentication authentication){
	        String url = "/login?error=true";
	        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
	        List<String> roles = new ArrayList<String>();
	        
	        for(GrantedAuthority a : authorities){
	            roles.add(a.getAuthority());
	        }
	        
	        System.out.println("ROLES: " + roles);
	        
	        if (roles.contains("STUDENT")) {	     
	        	url = "/student/student-homepage";         
	        }
	        
	        else if(roles.contains("PROFESSOR")){
	        	url = "/professor/professor-homepage";
	    	}
	        
	        else if(roles.contains("COMPANY")){
	        	url = "/company/company-homepage";
	    	}
	        else if(roles.contains("COMMITTEE")){
	        	url = "/committee/committee-homepage";
	    	}
	        else {
	            return "/login?error=true"; 
	        }
	        System.out.println("Redirecting to: " + url);
	        
	        return url;
	    }
}