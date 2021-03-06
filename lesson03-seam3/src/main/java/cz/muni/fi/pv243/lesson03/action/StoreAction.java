package cz.muni.fi.pv243.lesson03.action;

import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import org.jboss.seam.transaction.Transactional;

import cz.muni.fi.pv243.lesson03.model.CakeStore;

@Named
@Stateless
public class StoreAction {
	
	// @PersistenceContext(type=PersistenceContextType.EXTENDED)
	@PersistenceContext
	// @Inject
	private EntityManager em;
	
	@Inject
	Conversation conversation;
	
	@Inject
	CurrentCakeStoreProducer currentCakeStoreProducer;
	
	public void edit(String cakeStoreId) {
		currentCakeStoreProducer.setCakeStoreById(cakeStoreId);
		conversation.begin();
	}
	
	public String view() {
		return "view";
	}
	
	// @Transactional
	public String save() {
		conversation.end();
		return "storelist";
	}
}
