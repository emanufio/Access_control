package Second_site.Entity;

import org.bson.types.ObjectId;
import org.passay.CharacterRule;
import org.passay.EnglishCharacterData;
import org.passay.PasswordGenerator;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.*;

@Document
public class User {

	private String nome;
	private String cognome;
	private String email;
	private String number;
	private String psw;
	private ObjectId _id;

	public User(String nome, String cognome, String email, String number) {
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
		this.number = number;
		this.psw = this.generapsw();
	}
	

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return this.nome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getCognome() {
		return this.cognome;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return this.email;
	}

	public void setPsw(String psw) {
		this.psw = psw;
	}

	public String getPsw() {
		return this.psw;
	}
	
	public void setNumber(String number)
	{
		this.number = number;
	}
	
	public String getNumber()
	{
		return this.number;
	}
	
	public void set_id(ObjectId id)
	{
		this._id = id;
	}
	
	public ObjectId get_id()
	{
		return _id;
	}


	public String generapsw()
	{	
		PasswordGenerator pg = new PasswordGenerator();
		List<CharacterRule> digits = Arrays.asList(
	            // at least one upper-case character
	            new CharacterRule(EnglishCharacterData.UpperCase, 1),
	            // at least one lower-case character
	            new CharacterRule(EnglishCharacterData.LowerCase, 1),
	            // at least one digit character
	            new CharacterRule(EnglishCharacterData.Digit, 1)
	            );
		String psw = pg.generatePassword(8, digits);
		return psw;
	}

	public String toString() {
		return "[ \" " + nome + " \", \" " + cognome + " \", \" " + email + " \" , \" " + psw + " \" ]";
	}

}
