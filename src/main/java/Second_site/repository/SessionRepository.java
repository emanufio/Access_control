package Second_site.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import Second_site.Entity.Session;

//indica che la classe fornisce il meccanismo per il salvataggio, recupero, ricerca
//aggiornamento e cancellazione oggetti nel db
@Repository
public interface SessionRepository extends MongoRepository <Session, Integer> 
{
	public List<Session> findByUscita(boolean uscita);
	
	public Session findByNome(String nome);
	
	@Query("{'name' : ?0 , 'uscita' : ?1}")
	public Session findByNomeAndUscita(String nome,boolean uscita);
	
}
