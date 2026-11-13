package myy803.Traineeship.domainmodel;

import java.util.Collection;
import java.util.Collections;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "users")
public class User implements UserDetails{
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="username", unique = true)
	protected String username;
	
	@Column(name="password", nullable = false)
	protected String password;
	
	
	@Enumerated(EnumType.STRING)
	@Column(name="role", nullable = false, length = 255)
	protected Role role;
	
	
	public Collection<? extends GrantedAuthority> getAuthorities() {
		 SimpleGrantedAuthority authority = new SimpleGrantedAuthority(role.name());
	     return Collections.singletonList(authority);
	}

	
	public String getUsername() {
		 return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password= password;
	}
	
	public Role getRole() {
		return role;
	}
	
	public void setRole(Role role) {
		this.role = role;
	}

}
