package Second_site.Entity;

import org.springframework.data.mongodb.core.mapping.Document;


@Document
public class Session {
	
	private String data_ingresso;
	private String data_uscita;
	private String nome;
	private String cognome;
	private boolean uscita;
	
	public Session(String data_ingresso,String nome,String cognome) 
	{
		this.data_ingresso = data_ingresso;
		this.nome=nome;
		this.cognome=cognome;
		this.data_uscita=null;
		this.uscita=false;
	}
	
	public void setData_ingresso(String data)
	{
		this.data_ingresso = data;
	}
	
	public String getData_ingresso()
	{
		return data_ingresso;
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
	
	public void setData_uscita(String data)
	{
		this.data_uscita = data;
	}
	
	public String getData_uscita()
	{
		return this.data_uscita;
	}

	public void setUscita(boolean uscita)
	{
		this.uscita = uscita;
	}
	
	public boolean getUscita()
	{
		return uscita;
	}
	
	
	public String toString() 
	{
		return "[ \" "+data_ingresso+" \", \" "+nome+" \", \" "+cognome+" \", \" "+uscita+" \", \" "+data_uscita+" \" ]" ;
	}

}
