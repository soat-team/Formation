package fr.soat.interco.bean;

import javax.persistence.*;

@Entity
@Table(name = "agent")
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
