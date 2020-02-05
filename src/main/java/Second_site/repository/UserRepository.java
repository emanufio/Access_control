package Second_site.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import Second_site.Entity.User;

//indica che la classe fornisce il meccanismo per il salvataggio, recupero, ricerca
//aggiornamento e cancellazione oggetti nel db
@Repository
public interface UserRepository extends MongoRepository <User, Integer> {
	
	public User findByNome(String nome);
	
}