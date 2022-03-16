package com.kelvin.dbapp.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kelvin.dbapp.order.model.Aorder;

@Repository
public interface AorderRepository extends JpaRepository<Aorder, Integer>{

}
