package tn.ens.esprit.reference.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.ens.esprit.reference.entities.MyEntity;
import tn.ens.esprit.reference.repositories.custom.interfaces.MyEntityRepositoryCustom;

public interface MyEntityRepository extends JpaRepository<MyEntity, Integer>, MyEntityRepositoryCustom {

}
