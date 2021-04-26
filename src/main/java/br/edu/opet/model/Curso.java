package br.edu.opet.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name="curso")
@XmlNamedQueries({
	@NamedQuery(name="Curso.findByNome", query="SELECT c FROM curso c WHERE c.nome = :nome")})
public class Curso implements Serializable {
	
	@Id
	@Column(name="nome")
	private string nome;
		
	//Contrutor
	public Curso() {
	}
	
	//Getters & Setters
	public string getNome() {
		return nome;
	}
	public void setNome(string nome) {
		this.nome = nome;
	}	
}
