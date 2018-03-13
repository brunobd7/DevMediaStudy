package crudhibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity //DEFINE QUE ESSA CLASSE É MANIPULADA PELA JPA
@Table(name ="cliente") //
public class Cliente {
	
	@Id
	private int Id;
	@Column
	private String nome;
	@Column
	private String cpf;
	@Column
	private String rg;
	
	// GETS SETS
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	
	
	
	
	

}
