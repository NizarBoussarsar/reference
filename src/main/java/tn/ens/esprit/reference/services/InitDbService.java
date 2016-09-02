package tn.ens.esprit.reference.services;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.ens.esprit.reference.entities.MyEntity;
import tn.ens.esprit.reference.repositories.MyEntityRepository;

@Service
public class InitDbService {

	@Autowired
	private MyEntityRepository myEntityRepository;

	public void setMyEntityRepository(MyEntityRepository myEntityRepository) {
		this.myEntityRepository = myEntityRepository;
	}

	@PostConstruct
	public void init() {
		{
			MyEntity myEntity = new MyEntity();
			myEntity.setName("example");
			myEntity.setUrl("http://www.example.com");
			myEntityRepository.save(myEntity);
		}
		{
			MyEntity myEntity = new MyEntity();
			myEntity.setName("sitemonitoring");
			myEntity.setUrl("http://sitemonitoring.sourceforge.net");
			myEntityRepository.save(myEntity);
		}
		{
			MyEntity myEntity = new MyEntity();
			myEntity.setName("javavids");
			myEntity.setUrl("http://www.javavids.com");
			myEntityRepository.save(myEntity);
		}
	}
}
