package br.univel.ejbsstateles;

import javax.annotation.Resource;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.Topic;

import br.univel.model.Venda;

@Stateless
@Remote(ProcessVendaInterface.class)
public class ProcessVenda implements ProcessVendaInterface {

	@Inject
	private JMSContext context;

	@Resource(lookup = "java:/topic/TopicVenda")
	private Topic topic;

	public void processarVenda(Venda venda) {
		System.out.println("Processar Entrega Recebeu : valor total: "+venda.getValorTotal());
		context.createProducer().send(topic, venda);
	}

}