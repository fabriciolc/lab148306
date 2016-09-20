package br.univel.mdb;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import br.univel.model.Entrega;
import br.univel.model.Venda;

@MessageDriven(name = "TopicVenda", activationConfig = {
		@ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "topic/TopicVenda"),
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic"),
		@ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge") })
public class TopicVenda implements MessageListener {

	@Override
	public void onMessage(Message rcvMessage) {

		try {
			Venda venda = (Venda) rcvMessage.getBody(Venda.class);

			System.out.println("Received Message from queue: " + venda.getValorTotal());

		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

}