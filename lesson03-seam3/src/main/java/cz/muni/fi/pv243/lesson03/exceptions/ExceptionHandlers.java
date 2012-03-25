package cz.muni.fi.pv243.lesson03.exceptions;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.OptimisticLockException;

import org.jboss.solder.exception.control.CaughtException;
import org.jboss.solder.exception.control.Handles;
import org.jboss.solder.exception.control.HandlesExceptions;
import org.jboss.solder.servlet.WebRequest;

@HandlesExceptions
public class ExceptionHandlers {
	
	void handleOptimisticLock(
		       @Handles @WebRequest CaughtException<OptimisticLockException> caught) {
	   
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Data has been modified in the meantime, your data was NOT saved! Sorry..."));
		FacesContext.getCurrentInstance().getApplication().getNavigationHandler().handleNavigation(FacesContext.getCurrentInstance(), null, "bakerylist");
	}
}
