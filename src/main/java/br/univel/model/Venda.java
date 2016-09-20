package br.univel.model;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;

public class Venda implements Serializable{

	private String[] items;
	private BigDecimal valorTotal;
	public String[] getItems() {
		return items;
	}
	public void setItems(String[] items) {
		this.items = items;
	}
	public BigDecimal getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(BigDecimal bigDecimal) {
		this.valorTotal = bigDecimal;
	}
}
