package cz.muni.fi.pv243.lesson03.action;

import javax.ejb.Stateful;
import javax.enterprise.context.ConversationScoped;
import javax.enterprise.inject.Model;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import cz.muni.fi.pv243.lesson03.model.CakeStore;

import java.io.Serializable;
import java.util.List;

@ConversationScoped
@Named
@Stateful
public class CurrentCakeStoreProducer implements Serializable {
	
	private CakeStore cakeStore;
	
	@Inject
	EntityManager em;
	
	public void setCakeStore(CakeStore cakeStore) {
		this.cakeStore = cakeStore;
	}
	
	public void setCakeStoreById(String cakeStoreId) {
		this.cakeStore = em.find(CakeStore.class, Long.parseLong(cakeStoreId));
	}
	
	@Named
	@Produces
	@Current
	public CakeStore getCakeStore() {
		return cakeStore;
	}
}
