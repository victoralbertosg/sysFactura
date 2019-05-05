package com.titannet.springboot.app.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name= "clientes")
public class Cliente implements Serializable {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY )
	private Long Id;
	private String nombre;
	private String apellido;
	private String email;
	
	@Column(name="create_at")
	@Temporal(TemporalType.DATE)	
	private Date createAt;
	
	
	
	public Long getId() {
		return Id;
	}



	public void setId(Long id) {
		Id = id;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getApellido() {
		return apellido;
	}



	public void setApellido(String apellido) {
		this.apellido = apellido;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public Date getCreateAt() {
		return createAt;
	}



	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	@PrePersist	
	public void prePersist() {
		createAt=new Date();
	}

	private static final long serialVersionUID = 1L;

}
