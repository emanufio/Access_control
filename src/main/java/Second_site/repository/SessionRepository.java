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
	
	public List<Session> findByPassword(String password);
	
	@Query("{'password' : ?0 , 'tsExit' : 0}")
	public Session findByPswAndUscita(String psw);
	
	@Query("{'name' : ?0 , 'tsExit' : 0}")
	public Session findByNameAndUscita(String nome);
	
	@Query(" { 'tsExit': 0 , 'tsEntry' : {$gte: ?0} }")
	public List<Session> findByUscitaAndData(long data);
	
	@Query(" { 'tsEntry' : {$gte: ?0} }")
	//@Query(" { {?0 : $gte} : 'data_ingresso' }")
	public List<Session> findByData(long data);
	
	@Query(" { 'tsEntry' : {$gte: ?0 , $lte: ?1} }")
	public List<Session> findBetweenData(long d1,long d2);
	
	@Query(" { 'password': ?0 , 'tsExit' : 0 , 'tsEntry' : {$gte: ?1} }")
	public Session findByPswAndUscitaAndData(String psw, long data);
	
	public List<Session> findByTsExit();
	
}
