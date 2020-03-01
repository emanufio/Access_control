package Second_site.Entity;

import org.bson.types.ObjectId;
import org.passay.CharacterRule;
import org.passay.EnglishCharacterData;
import org.passay.PasswordGenerator;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.*;

@Document
public class User {

	private String name;
	private String surname;
	private String email;
	private String number;
	private String password;
	private ObjectId _id;

	public User(String name, String surname, String email, String number) {
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.number = number;
		this.password = this.createPassword();
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void set_id(ObjectId id)
	{
		this._id = id;
	}
	
	public ObjectId get_id()
	{
		return _id;
	}

	public String createPassword()
	{	
		PasswordGenerator pg = new PasswordGenerator();
		List<CharacterRule> digits = Arrays.asList(
	            // at least one lower-case character
	            //new CharacterRule(EnglishCharacterData.LowerCase, 1),
	            // at least one digit character
	            new CharacterRule(EnglishCharacterData.Digit, 1)
	            );
		String psw = pg.generatePassword(4, digits);
		return psw;
	}

}
