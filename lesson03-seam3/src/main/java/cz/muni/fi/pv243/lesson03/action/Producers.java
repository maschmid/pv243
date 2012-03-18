package cz.muni.fi.pv243.lesson03.action;

import javax.enterprise.context.ConversationScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import org.jboss.solder.core.ExtensionManaged;

public class Producers {
	@ExtensionManaged
	@Produces
	@PersistenceUnit
	@ConversationScoped
	EntityManagerFactory entityManagerFactory;
}
