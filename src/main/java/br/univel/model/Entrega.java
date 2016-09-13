package br.univel.model;

import java.io.Serializable;
import java.util.Date;

public class Entrega implements Serializable{

	private Date dataEntrega;
	private String endereco;
	public Date getDataEntrega() {
		return dataEntrega;
	}
	public void setDataEntrega(Date dataEntrega) {
		this.dataEntrega = dataEntrega;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
}
