package cz.muni.fi.pv243.lesson03.action;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

import org.jboss.seam.faces.context.conversation.Begin;
import org.jboss.seam.faces.context.conversation.End;
import org.jboss.solder.exception.control.ExceptionHandled;
import org.jboss.solder.logging.Logger;

@Named
@Stateless
public class BakeryAction
{
   @Inject
   Logger log;
   
   @Inject
   EntityManager em;
   
   @Begin
   public void edit()
   {
   }

   @End
   @ExceptionHandled
   public void save()
   {
      log.info("pre flush");
      em.flush();
      log.info("post flush");
   }
}
