package com.kelvin.dbapp.Aservice.model;

import java.util.List;

import javax.persistence.*;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.kelvin.dbapp.order.model.Aorder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Aservice {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String sname;
	private Double price;
	
	private String description;
	
	@OneToMany(mappedBy="aservice")
	private List<Aorder> aorder;

}
