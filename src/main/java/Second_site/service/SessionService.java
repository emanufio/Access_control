package Second_site.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Second_site.Entity.Session;
import Second_site.repository.SessionRepository;

//indica il livello service
@Service
public class SessionService {
	
	@Autowired
	private SessionRepository dataRepository;
	
	public Session create(String data,String ora,String nome,String cognome) 
	{
		return dataRepository.save(new Session(data,ora,nome,cognome));
	}
	
	public List<Session> getAll()
	{
		return dataRepository.findAll();
	}
	
	public List<Session> findByUscita(boolean uscita)
	{
		return dataRepository.findByUscita(uscita);
	}
	
	public Session update(String nome, String data, String ora)
	{ 
		//Session s = dataRepository.findByNomeAndUscita("stefano", "false");
		Session s = dataRepository.findByNomeAndUscita(nome, false);
		s.setData_uscita(data);
		s.setOra_uscita(ora);
		return dataRepository.save(s);
	}
	
}
