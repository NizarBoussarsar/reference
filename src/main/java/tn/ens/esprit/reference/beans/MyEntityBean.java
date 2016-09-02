package tn.ens.esprit.reference.beans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import tn.ens.esprit.reference.entities.MyEntity;
import tn.ens.esprit.reference.services.MyEntityService;

@ManagedBean
@ViewScoped
public class MyEntityBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManagedProperty("#{myEntityService}")
	private MyEntityService myEntityService;

	public void setMyEntityService(MyEntityService myEntityService) {
		this.myEntityService = myEntityService;
	}

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private MyEntity myEntity;
	private List<MyEntity> myEntities;

	public MyEntityBean() {
		myEntity = new MyEntity();
	}

	public MyEntity getMyEntity() {
		return myEntity;
	}

	public void setMyEntity(MyEntity myEntity) {
		this.myEntity = myEntity;
	}

	public List<MyEntity> getMyEntities() {
		return myEntities;
	}

	public void setMyEntities(List<MyEntity> myEntities) {
		this.myEntities = myEntities;
	}

	@PostConstruct
	public void loadMyEntity() {
		myEntities = myEntityService.findAll();
	}

	public void find() {
		myEntity = myEntityService.findOneByName(this.name);
		if (myEntity != null) {
			myEntities.clear();
			myEntities.add(myEntity);
		} else {
			System.out.println("No entity with this name !!");
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "No entity with this name !!", null));
			myEntities = myEntityService.findAll();
		}
	}

	public void save() {
		myEntityService.save(myEntity);
		myEntity = new MyEntity();
		myEntities = myEntityService.findAll();
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "MyEntity saved!", null));
	}

	public void remove(MyEntity myEntity) {
		myEntityService.remove(myEntity);
		myEntities = myEntityService.findAll();
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "MyEntity removed!", null));
	}

	public void clear() {
		myEntity = new MyEntity();
	}

	public void clearSearch() {
		this.name = "";
		myEntity = new MyEntity();
		myEntities = myEntityService.findAll();
	}

}
