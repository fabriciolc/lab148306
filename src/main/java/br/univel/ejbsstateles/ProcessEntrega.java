package br.univel.ejbsstateles;
import javax.annotation.Resource;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.Queue;

import br.univel.model.Entrega;

@Stateless
@Remote(ProcessEntregaInterface.class)
public class ProcessEntrega implements ProcessEntregaInterface{

	@Inject
	private JMSContext context;

	@Resource(lookup = "java:/queue/QueuePedido")
	private Queue queue;

	public void processarEntrega (Entrega entrega) {
		System.out.println("Processar Entrega Recebeu endereco: "+entrega.getEndereco());
		context.createProducer().send(queue, entrega);
    }

}