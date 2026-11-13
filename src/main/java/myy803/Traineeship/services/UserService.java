package myy803.Traineeship.services;

import myy803.Traineeship.domainmodel.User;

public interface UserService {
	public void saveUser(User user);
    public boolean isUserPresent(User user);
	public User findById(String username);
}
