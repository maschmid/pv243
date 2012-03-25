package cz.muni.fi.pv243.lesson03.action;

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

import cz.muni.fi.pv243.lesson03.model.Bakery;

@Named
@Stateless
public class BakeryAction
{

   @Inject
   private EntityManager em;

   @Inject
   Conversation conversation;

   @Inject
   PersistenceContexts pcs;

   @Inject
   @Current
   Bakery bakery;

   @Begin
   public void edit()
   {
      pcs.changeFlushMode(FlushModeType.MANUAL);
   }

   public String view()
   {
      return "view";
   }

   @ExceptionHandled
   @End
   public String save()
   {
      em.flush();
      return "success";
   }

   public Object getDelegate()
   {
      return em.getDelegate();
   }
}
