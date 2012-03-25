package cz.muni.fi.pv243.lesson03.action;

import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

import org.jboss.solder.logging.Logger;

import cz.muni.fi.pv243.lesson03.model.Cake;


@Named
public class CakeEditAction
{
   @Inject
   @Current
   private Cake cake;
   
   @Inject
   private Logger log;
   
   @Inject
   private EntityManager em;
   
   public void removeIngredient(String ingredient) {
      cake.getIngredients().remove(ingredient);
   }
   
   public void addIngredient(String ingredient) {
      cake.getIngredients().add(ingredient);
   }
}
