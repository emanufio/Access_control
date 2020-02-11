package Second_site.Entity;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;


@Document
public class Session {
	
	private String data_ingresso;
	private String ora_ingresso;
	private String name;
	private String cognome;
	private boolean uscita;
	private String data_uscita;
	private String ora_uscita;
	private ObjectId _id;
	
	public Session(String data_ingresso,String ora_ingresso,String name,String cognome) 
	{
		this.data_ingresso = data_ingresso;
		this.ora_ingresso = ora_ingresso;
		this.name=name;
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
	
	public void setOra_ingresso(String ora) 
	{
		this.ora_ingresso = ora;
	}
	
	public String getOra_ingresso()
	{
		return ora_ingresso;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getNome()
	{
		return this.name;
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

	public void setOra_uscita(String ora) 
	{
		this.ora_uscita = ora;
	}
	
	public String getOra_uscita()
	{
		return this.ora_uscita;
	}
	
	public void setUscita(boolean uscita)
	{
		this.uscita = uscita;
	}
	
	public boolean getUscita()
	{
		return uscita;
	}
	
	public void set_id(ObjectId id)
	{
		this._id = id;
	}
	
	public ObjectId get_id()
	{
		return _id;
	}
	
	public String toString() 
	{
		return "[ \" "+data_ingresso+" \", \" "+name+" \", \" "+cognome+" \", \" "+uscita+" \", \" "+data_uscita+" \" ]" ;
	}

}
