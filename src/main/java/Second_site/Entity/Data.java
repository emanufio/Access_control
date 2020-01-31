package Second_site.Entity;

import org.springframework.data.mongodb.core.mapping.Document;


@Document
public class Data {
	
	private String data;
	private String testo;
	
	public Data(String data,String testo) 
	{
		this.data=data;
		this.testo=testo;
	}
	
	public void setData(String data)
	{
		this.data = data;
	}
	
	public String getData()
	{
		return data;
	}
	
	public void setTesto(String testo)
	{
		this.testo = testo;
	}
	
	public String getTesto()
	{
		return testo;
	}
	
	public String toString() 
	{
		return "[ \" "+data+" \", \" "+testo+" \" ]" ;
	}

}
