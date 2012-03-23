package cz.muni.fi.pv243.lesson03.viewconfig;

import org.jboss.seam.faces.rewrite.FacesRedirect;
import org.jboss.seam.faces.rewrite.UrlMapping;
import org.jboss.seam.faces.view.config.ViewConfig;
import org.jboss.seam.faces.view.config.ViewPattern;

@ViewConfig
public interface Pages {
	static enum Pages1 {
		@ViewPattern("/view.xhtml")
		@UrlMapping(pattern="/view/#{id}/")
        VIEW,
        
        @ViewPattern("/edit.xhtml")
		@UrlMapping(pattern="/edit/#{id}/")
        EDIT,
    }
}
