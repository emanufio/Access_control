package Second_site.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import Second_site.Entity.Session;
import Second_site.Entity.User;

//indica che la classe fornisce il meccanismo per il salvataggio, recupero, ricerca
//aggiornamento e cancellazione oggetti nel db
@Repository
public interface UserRepository extends MongoRepository <User, String> {
	
	public User findByNome(String nome);

	public User findByPsw(String psw);
	
}