package com.ashokit.ies.ar.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashokit.ies.ar.entity.ApplicationEntity;

public interface AppRegistrationRepo extends JpaRepository<ApplicationEntity,Serializable> {

}
