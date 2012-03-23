package cz.muni.fi.pv243.lesson03.action;

import java.util.List;

import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Model;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import cz.muni.fi.pv243.lesson03.model.CakeStore;

@Stateless
//@Stateful
// @RequestScoped
@Named
public class StoreList {

	// @PersistenceContext
	// @PersistenceContext(type=PersistenceContextType.EXTENDED)
	@Inject
	private EntityManager em;
	
	@Inject
	CurrentCakeStoreProducer currentCakeStoreProducer;
	
	
	@Produces
    @Model
    public List<CakeStore> getCakeStores() {
        return em.createQuery("select store from CakeStore store order by store.name", CakeStore.class)
                .getResultList();
    }
/*	
	public String viewStore(CakeStore store) {
		currentCakeStoreProducer.setCakeStore(store);		
		return "view";
	}
	
	public String editStore(CakeStore store) {
		currentCakeStoreProducer.setCakeStore(store);
		conversation.begin();
		return "edit";
	}*/
}
