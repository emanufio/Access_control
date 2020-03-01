package Second_site.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Second_site.Entity.User;
import Second_site.repository.UserRepository;

//indica il livello service
@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public User create(String nome,String cognome,String email,String number) 
	{
		return userRepository.save(new User(nome,cognome,email,number));
	}
	
	public List<User> getAll()
	{
		return userRepository.findAll();
	}
	
	public User findByTesto(String name)
	{
		return userRepository.findByName(name);
	}
	
	public void delete(String password) {
		User u = userRepository.findByPassword(password);
		userRepository.delete(u);
	}
	
	public User findByPsw(String password) {
		User u = userRepository.findByPassword(password);
		return u;
	}
	
}
