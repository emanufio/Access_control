package Second_site.Entity;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;


@Document
public class Session {
	
	private long tsEntry;
	private long tsExit;
	private String name;
	private String surname;
	private String password;
	private ObjectId _id;
	
	public Session(long tsEntry, String name, String surname, String password) 
	{
		this.tsEntry = tsEntry;
		this.tsExit = 0;
		this.name = name;
		this.surname = surname;
		this.password = password;
	}
	
	public long getTsEntry() {
		return tsEntry;
	}

	public void setTsEntry(long tsEntry) {
		this.tsEntry = tsEntry;
	}

	public long getTsExit() {
		return tsExit;
	}

	public void setTsExit(long tsExit) {
		this.tsExit = tsExit;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public ObjectId get_id() {
		return _id;
	}

	public void set_id(ObjectId _id) {
		this._id = _id;
	}

}
