package com.spring.secondo.dto;

import java.util.List;

public class ListaNC_LenDTO {
	private List<NomeCognomeDTO> lista_nc;
	private int len;
	
	public ListaNC_LenDTO() {
		// TODO Auto-generated constructor stub
	}

	public ListaNC_LenDTO(List<NomeCognomeDTO> lista_nc) {
		super();
		this.lista_nc = lista_nc;
		this.len = lista_nc.size();
	}

	public List<NomeCognomeDTO> getLista_nc() {
		return lista_nc;
	}

	public void setLista_nc(List<NomeCognomeDTO> lista_nc) {
		this.lista_nc = lista_nc;
	}

	public int getLen() {
		return len;
	}

	public void setLen(int len) {
		this.len = len;
	}

}
