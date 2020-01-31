package Second_site.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Second_site.Entity.Data;
import Second_site.repository.DataRepository;

//indica il livello service
@Service
public class DataService {
	
	@Autowired
	private DataRepository dataRepository;
	
	public Data create(String data,String testo) 
	{
		return dataRepository.save(new Data(data,testo));
	}
	
	public List<Data> getAll()
	{
		return dataRepository.findAll();
	}
	
	public Data findByTesto(String testo)
	{
		return dataRepository.findByTesto(testo);
	}
	
}
