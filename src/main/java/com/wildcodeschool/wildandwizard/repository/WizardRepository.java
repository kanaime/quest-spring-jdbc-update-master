package com.wildcodeschool.wildandwizard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wildcodeschool.wildandwizard.entity.Wizard;

@Repository
public interface WizardRepository extends JpaRepository<Wizard, Long> {

}
