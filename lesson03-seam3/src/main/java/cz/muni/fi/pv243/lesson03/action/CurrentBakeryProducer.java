package cz.muni.fi.pv243.lesson03.action;

import javax.ejb.Stateful;
import javax.enterprise.context.ConversationScoped;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Model;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import cz.muni.fi.pv243.lesson03.model.Bakery;

import java.io.Serializable;
import java.util.List;

@ConversationScoped
// @SessionScoped
@Named
@Stateful
public class CurrentBakeryProducer implements Serializable {
	
	private Bakery bakery;
	
	@Inject
	// @PersistenceContext
	EntityManager em;
	
	public void setBakery(Bakery bakery) {
		this.bakery = bakery;
	}
	
	public void setBakeryById(String bakeryId) {
		this.bakery = em.find(Bakery.class, Long.parseLong(bakeryId));
	}
	
	@Named
	@Produces
	@Current
	public Bakery getBakery() {
		return bakery;
	}
}
