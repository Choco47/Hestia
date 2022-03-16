package com.kelvin.dbapp.Aservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kelvin.dbapp.Aservice.model.Aservice;

@Repository
public interface AserviceRepository extends JpaRepository<Aservice, Integer>{

}
