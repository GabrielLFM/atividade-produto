package com.login.exemplo.dto;

import com.login.exemplo.entity.Usuario;

public class UsuarioResponseDTO {
	
	private int id;
	private String name;
	private String email;
	
	public UsuarioResponseDTO(Usuario user) {
		this.id = user.getId();
		this.name = user.getName();
		this.email = user.getEmail();
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
