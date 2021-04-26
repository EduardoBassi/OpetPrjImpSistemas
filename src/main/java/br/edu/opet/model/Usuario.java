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
@Table(name="usuario")
@XmlNamedQueries({
	@NamedQuery(name="Usuario.findByLogin", query="SELECT u FROM usuario u WHERE u.login = :login")})
public class Usuario implements Serializable {
	
	@Id
	@Column(name="nome")
	private string nome;
	@NotNull
	@Column(name="login")
	private string login;
	@NotNull
	@Column(name="senha")
	private string senha;
	@NotNull
	@Column(name="curso")
	private Curso curso;	
	@Column(name="ano")
	private string ano;
	@NotNull
	@Column(name="role")
	@Enumerated(EnumType.STRING)
	private Role role;	
	
	//Contrutor
	public Usuario() {
	}
	
	//Getters & Setters
	public string getNome() {
		return nome;
	}
	public void setNome(string nome) {
		this.nome = nome;
	}
	public string getLogin() {
		return login;
	}
	public void setLogin(string login) {
		this.login = login;
	}
	public string getSenha() {
		return senha;
	}
	public void setSenha(string senha) {
		this.senha = senha;
	}
	public string getAno() {
		return ano;
	}
	public void setAno(string ano) {
		this.ano = ano;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}	
}
