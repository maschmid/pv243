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
import cz.muni.fi.pv243.lesson03.model.Cake;

import java.io.Serializable;
import java.util.List;

@ConversationScoped
@Named
@Stateful
public class CurrentCakeProducer implements Serializable {
	
	private Cake cake;
	
	@Inject
	EntityManager em;
	
	public void setCake(Cake cake) {
		this.cake = cake;
	}
	
	@Named
	@Produces
	@Current
	public Cake getCake() {
		return cake;
	}
}
