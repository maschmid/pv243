package cz.muni.fi.pv243.lesson03.security;

import javax.enterprise.event.Observes;

import org.jboss.seam.international.status.Messages;
import org.jboss.seam.security.events.LoggedInEvent;
import org.jboss.solder.logging.Logger;

public class ManagerLogging {
	
	public void addLoginSuccessMessage(@Observes LoggedInEvent event, Logger log, Messages messages) {
		log.info("User" + event.getUser().getId() + " logged in");
		messages.add(messages.info("User " + event.getUser().getId() + " logged in"));
    }
}
