package myy803.Traineeship.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import myy803.Traineeship.domainmodel.User;
import myy803.Traineeship.mappers.UserMapper;


@Service
public class UserServiceImpl implements UserService, UserDetailsService {

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public void saveUser(User user) {
		System.out.println(">>> Before saving user: " + user.getUsername());
	    System.out.println(">>> Password: " + user.getPassword());
	    System.out.println(">>> Role: " + user.getRole());
	    
		String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        userMapper.save(user);	
    }

	
	@Override
	public boolean isUserPresent(User user) {
		Optional<User> storedUser = userMapper.findByUsername(user.getUsername());
		return storedUser.isPresent();
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println(">>> Login attempt for user: " + username);
		User user = userMapper.findByUsername(username)
			        .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));
		
		if (user.getRole() == null) {
	        throw new UsernameNotFoundException("User " + username + " does not have a role assigned.");
	    }

		List<GrantedAuthority> authorities = List.of(new SimpleGrantedAuthority(user.getRole().toString()));

		return new org.springframework.security.core.userdetails.User(
				user.getUsername(),
			    user.getPassword(),
			    authorities
				);
	}
	
	public User findById(String username) {
		return userMapper.findByUsername(username)
				.orElseThrow(()-> new UsernameNotFoundException(String.format("USER_NOT_FOUND", username)));
	}

}
