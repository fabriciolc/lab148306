package br.univel.model;
import java.io.Serializable;
import java.math.BigInteger;

public class Venda implements Serializable{

	private String[] items;
	private BigInteger valorTotal;
	public String[] getItems() {
		return items;
	}
	public void setItems(String[] items) {
		this.items = items;
	}
	public BigInteger getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(BigInteger valorTotal) {
		this.valorTotal = valorTotal;
	}
}
