package cz.muni.fi.pv243.lesson03.action;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.UndeclaredThrowableException;

import javax.ejb.Stateless;
import javax.enterprise.context.Conversation;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

import org.jboss.seam.faces.context.conversation.Begin;
import org.jboss.seam.faces.context.conversation.End;
import org.jboss.seam.persistence.FlushModeType;
import org.jboss.seam.persistence.PersistenceContexts;
import org.jboss.solder.exception.control.ExceptionHandled;

@Named
public class BakeryAction {
	
	@Inject
	private EntityManager em;
	
	@Inject
	Conversation conversation;
	
	@Inject
	PersistenceContexts pcs;
	
	@Begin
	public void edit() {		
		pcs.changeFlushMode(FlushModeType.MANUAL);
	}
	
	public String view() {
		return "view";
	}
	
	@ExceptionHandled
	@End
	public String save() {
		em.flush();
		return "success";
	}
}
