package myy803.Traineeship.services;

import org.springframework.security.core.userdetails.UserDetails;

public interface UserDetailsService {
	public UserDetails loadUserByUsername(String username);
}
