/**
 * 
 */
package com.gembro.model;

import java.util.Date;	

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

/**
 * This is a Plain Old Java Object (POJO) programming model. 
 * All Java classes that will be persisted need a default constructor.
 * All classes should contain an ID in order to allow easy identification of your objects within Hibernate and the database. This property maps to the primary key column of a database table.
 * All attributes that will be persisted should be declared private and have getXXX and setXXX methods defined in the JavaBean style.
 * A central feature of Hibernate, proxies, depends upon the persistent class being either non-final, or the implementation of an interface that declares all public methods.
 * All classes that do not extend or implement some specialized classes and interfaces required by the EJB framework.

 * @author quocanh
 *
 */
@Entity
@Table (name = "LOC_PROPRIETAIRE")
public class Proprietaire {
	/**
	 * Property <code>name</code> (no capitalization) readable/writable.
	 */
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy="increment")
	@Column(name="id")	private Long id;
	
	@Column(name="nom")	private String nom;
	
	@Column(name="prenom")	private String prenom;
	
	/** No-arg constructor (takes no arguments). */
	protected Proprietaire() {
		// no-args constructor required by JPA spec
		// this one is protected since it shouldn't be used directly		
	}
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}	
}
