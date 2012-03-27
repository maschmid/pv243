package cz.muni.fi.pv243.lesson03.logging;

import org.jboss.solder.logging.Log;
import org.jboss.solder.logging.MessageLogger;
import org.jboss.solder.messages.Message;

@MessageLogger
public interface BakeryLogger {
	@Log @Message("Manager %s edited bakery %s.")
	void bakeryEdited(String manager, String bakery);
}
