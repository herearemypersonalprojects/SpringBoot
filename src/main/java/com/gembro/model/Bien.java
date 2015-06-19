/**
 * 
 */
package com.gembro.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * @author quocanh
 *
 */
@Entity
@Table(name="LOC_BIEN")
public class Bien {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name = "id", nullable = false, updatable = false) 
	private int id;
	
	@ManyToOne	@JoinColumn(name="id_proprietaire") 
	private Proprietaire proprietaire;
	
	//@Column(name="id_proprietaire")	int id_proprietaire;
	@Column(name="adresse") 
	private String adresse;
	
	@Column(name="cp") 
	private int cp;
	
	@Column(name="ville") 
	private String ville;
	
	
	
	protected Bien() {}
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the id_proprietaire
	 *
	public int getId_proprietaire() {
		return id_proprietaire;
	}
	/**
	 * @param id_proprietaire the id_proprietaire to set
	 *
	public void setId_proprietaire(int id_proprietaire) {
		this.id_proprietaire = id_proprietaire;
	}
	/**
	 * @return the adresse
	 */
	public String getAdresse() {
		return adresse;
	}
	/**
	 * @param adresse the adresse to set
	 */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	/**
	 * @return the cp
	 */
	public int getCp() {
		return cp;
	}
	/**
	 * @param cp the cp to set
	 */
	public void setCp(int cp) {
		this.cp = cp;
	}
	/**
	 * @return the ville
	 */
	public String getVille() {
		return ville;
	}
	/**
	 * @param ville the ville to set
	 */
	public void setVille(String ville) {
		this.ville = ville;
	}
	/**
	 * @return the proprietaire
	 */
	public Proprietaire getProprietaire() {
		return proprietaire;
	}
	/**
	 * @param proprietaire the proprietaire to set
	 */
	public void setProprietaire(Proprietaire proprietaire) {
		this.proprietaire = proprietaire;
	}
	
	
}
