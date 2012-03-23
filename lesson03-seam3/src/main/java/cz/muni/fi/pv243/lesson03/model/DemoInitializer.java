package cz.muni.fi.pv243.lesson03.model;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Singleton
@Startup
public class DemoInitializer {
	
	//@Inject
	@PersistenceContext
	private EntityManager em;
	
	/*@Inject
	@DefaultTransaction
	SeamTransaction transaction;*/
	

    @PostConstruct
	public void initialize() {
		
		List<Cake> cakes = new LinkedList<Cake>();
		Cake cake = new Cake("Strawberry Paradise", BigDecimal.valueOf(19990, 2), "white flavor", "strawberry filling", "lemon icing");
		em.persist(cake);
		cakes.add(cake);
		
		cake = new Cake("Chocolate Dream", BigDecimal.valueOf(29990, 2), "chocolate");
		em.persist(cake);
		cakes.add(cake);
		
		cake = new Cake("Orange Cheesecake", BigDecimal.valueOf(29990, 2), "cream cheese", "orange", "chocolate");		
		em.persist(cake);
		cakes.add(cake);
		
		CakeStore store = new CakeStore("Buttercup Bakery", "7 W.Well St., Neverland");
		store.setCakes(cakes);
		em.persist(store);
		
		
		cakes = new LinkedList<Cake>();
		cake = new Cake("Whiskey Pie", BigDecimal.valueOf(59990, 2), "12 yr. Aberlor Whiskey", "chocolate");
		em.persist(cake);
		cakes.add(cake);
		
		cake = new Cake("Cake Lie", BigDecimal.valueOf(0, 2), "testing");
		em.persist(cake);
		cakes.add(cake);
		
		cake = new Cake("Búček Cake", BigDecimal.valueOf(19990, 2), "meat");
		em.persist(cake);
		cakes.add(cake);
		
		store = new CakeStore("Aperture Bakery", "42 Meme Lane, Xanadu");
		store.setCakes(cakes);
		em.persist(store);
	}
	
}