package br.univel.mdb;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import br.univel.model.Entrega;

@MessageDriven(name = "QueuePedido", activationConfig = {
		@ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "queue/QueuePedido"),
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
		@ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge") })
public class QueuePedido implements MessageListener {

	@Override
	public void onMessage(Message rcvMessage) {

		try {
			Entrega entrega = (Entrega) rcvMessage.getBody(Entrega.class);

			System.out.println("Received Message from queue: " + entrega.getDataEntrega().toString());

		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

}