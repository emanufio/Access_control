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
	
	public User create(String nome,String cognome,String email) 
	{
		return userRepository.save(new User(nome,cognome,email));
	}
	
	public List<User> getAll()
	{
		return userRepository.findAll();
	}
	
	public User findByTesto(String nome)
	{
		return userRepository.findByNome(nome);
	}
	
}
