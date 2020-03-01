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
	private SessionRepository sessionRepository;
	
	public Session create(long date,String name,String surname,String password) 
	{
		return sessionRepository.save(new Session(date,name,surname,password));
	}
	
	public List<Session> getAll()
	{
		return sessionRepository.findAll();
	}
	
	public List<Session> findBetweenData(long d1,long d2)
	{
		return sessionRepository.findBetweenData(d1, d2);
	}
	
	public List<Session> findByData(long data)
	{
		return sessionRepository.findByData(data);
	}
	
	public List<Session> findByTs_exit()
	{
		return sessionRepository.findByTsExit();
	}
	
	public List<Session> findByUscitaAndData(long data)
	{
		return sessionRepository.findByUscitaAndData(data);
	}
	
	public Session update(String psw, long data1, long data2)
	{ 
		//Session s = dataRepository.findByNomeAndUscita("stefano", "false");
		Session s = sessionRepository.findByPswAndUscitaAndData(psw, data1);
		if (s!=null)
		{
			s.setTsExit(data2);
			return sessionRepository.save(s);
		}
		else
		{
			System.out.println("sessione non trovata");
			return null;
		}	
	}
	
}
