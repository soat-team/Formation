package fr.soat.interco.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Agent {
/*
 *  `idagent` INT NOT NULL,
  `nom` VARCHAR(45) NOT NULL,
  `prenom` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idagent`))
 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idAgent;
	
	private String nom;
	private String prenom;
	
	public Integer getIdAgent() {
		return idAgent;
	}
	public void setIdAgent(Integer idAgent) {
		this.idAgent = idAgent;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	
	
}
