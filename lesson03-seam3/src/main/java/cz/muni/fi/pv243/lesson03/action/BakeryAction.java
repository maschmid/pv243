package cz.muni.fi.pv243.lesson03.action;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

import org.jboss.seam.faces.context.conversation.Begin;
import org.jboss.seam.faces.context.conversation.End;
import org.jboss.seam.security.Identity;
import org.jboss.solder.exception.control.ExceptionHandled;
import org.jboss.solder.logging.Category;

import cz.muni.fi.pv243.lesson03.logging.BakeryLogger;
import cz.muni.fi.pv243.lesson03.model.Bakery;

@Named
@Stateless
public class BakeryAction
{
   @Inject @Category("bakery")
   BakeryLogger log;
   
   @Inject
   EntityManager em;
   
   @Begin
   public void edit()
   {
   }
   
   @Inject
   Identity identity;
   
   @Inject
   @Current
   Bakery bakery;

   @End
   @ExceptionHandled
   public void save()
   {
      em.flush();
      log.bakeryEdited(identity.getUser().getId(), bakery.getName());
   }
}
