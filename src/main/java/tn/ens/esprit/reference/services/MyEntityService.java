package tn.ens.esprit.reference.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.ens.esprit.reference.entities.MyEntity;
import tn.ens.esprit.reference.repositories.MyEntityRepository;

@Service
public class MyEntityService {

	@Autowired
	private MyEntityRepository myEntityRepository;

	public void setMyEntityRepository(MyEntityRepository myEntityRepository) {
		this.myEntityRepository = myEntityRepository;
	}

	public MyEntity findOneByName(String name) {
		return myEntityRepository.findOneByName(name);
	}

	public MyEntity findOneByUrl(String url) {
		return myEntityRepository.findOneByUrl(url);
	}

	public List<MyEntity> findAll() {
		return myEntityRepository.findAll();
	}

	public void save(MyEntity myEntity) {
		myEntityRepository.save(myEntity);
	}

	public void remove(MyEntity myEntity) {
		myEntityRepository.delete(myEntity);
	}

}
