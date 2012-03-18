package cz.muni.fi.pv243.lesson03.action;

import javax.enterprise.context.ConversationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Named;

import cz.muni.fi.pv243.lesson03.model.CakeStore;

import java.io.Serializable;

@ConversationScoped
@Named
public class CurrentCakeStoreProducer implements Serializable {
	
	private CakeStore cakeStore;
	
	public void setCakeStore(CakeStore cakeStore) {
		this.cakeStore = cakeStore;
	}
	
	@Named
	@Produces
	@Current
	public CakeStore getCakeStore() {
		return cakeStore;
	}
}
