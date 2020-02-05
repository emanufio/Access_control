package Second_site.Entity;

import org.springframework.data.mongodb.core.mapping.Document;
import java.util.*;

@Document
public class User {
	
	private String nome;
	private String cognome;
	private String email;
	private String psw;
	
	public User(String nome, String cognome, String email)
	{
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
		this.psw = this.generapsw();
	}
	
	public void setNome(String nome)
	{
		this.nome = nome;
	}
	
	public String getNome()
	{
		return this.nome;
	}
	
	public void setCognome(String cognome)
	{
		this.cognome = cognome;
	}
	
	public String getCognome()
	{
		return this.cognome;
	}
	
	public void setEmail(String email)
	{
		this.email = email;
	}
	
	public String getEmail()
	{
		return this.email;
	}
	
	public void setPsw(String psw)
	{
		this.psw = psw;
	}
	
	public String getPsw()
	{
		return this.psw;
	}
	
	public String generapsw()
	{
		String CHARACTER_SET = ("aA1bB2cC3dD4eE5fF6gG8hH9iI0jJkKlLmMnNoOpP&qQrRsStT_uUvV-wWxX+yYzZ");
		String psw="";
		Random random = new Random();
		for(int i=0;i<5;i++)
		{
			psw = psw+String.valueOf(CHARACTER_SET.charAt(random.nextInt(65)));
		}
		return psw;
	}
	
	public String toString() 
	{
		return "[ \" "+nome+" \", \" "+cognome+" \", \" "+email+" \" , \" "+psw+" \" ]" ;
	}
	

}
