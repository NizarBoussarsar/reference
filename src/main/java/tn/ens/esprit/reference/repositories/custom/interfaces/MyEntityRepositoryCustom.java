package tn.ens.esprit.reference.repositories.custom.interfaces;

import tn.ens.esprit.reference.entities.MyEntity;

public interface MyEntityRepositoryCustom {

	MyEntity findOneByName(String name);

	MyEntity findOneByUrl(String url);

}