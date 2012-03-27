package cz.muni.fi.pv243.lesson03.exceptions;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.OptimisticLockException;

import org.jboss.solder.exception.control.CaughtException;
import org.jboss.solder.exception.control.Handles;
import org.jboss.solder.exception.control.HandlesExceptions;

@HandlesExceptions
public class ExceptionHandlers
{

   void handleOptimisticLock(@Handles CaughtException<OptimisticLockException> caught, FacesContext facesContext)
   {
	  facesContext.addMessage(null,
            new FacesMessage("Data has been modified in the meantime, your data was NOT saved! Sorry..."));
      facesContext.getApplication().getNavigationHandler()
            .handleNavigation(facesContext, null, "bakerylist");
   }
}
