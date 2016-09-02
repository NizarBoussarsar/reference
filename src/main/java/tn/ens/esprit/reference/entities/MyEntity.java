package tn.ens.esprit.reference.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.URL;

@Entity
public class MyEntity {

	@Id
	@GeneratedValue
	private int id;

	@Size(min = 1, message = "Name cannot be empty!")
	private String name;

	@Size(min = 1, message = "URL cannot be empty!")
	@URL(message = "Invalid url!")
	private String url;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
