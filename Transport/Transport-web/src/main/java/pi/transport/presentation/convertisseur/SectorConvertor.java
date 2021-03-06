package pi.transport.presentation.convertisseur;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;


import pi.transport.persistance.Sector;
import pi.transport.services.RoutesSuggestionServiceLocal;

@ManagedBean
public class SectorConvertor  implements Converter {
	@EJB
	private RoutesSuggestionServiceLocal routessuggestionServiceLocal;

	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		Sector eqSector= null;
		
		eqSector = routessuggestionServiceLocal.findSectorByArea(value);
		return eqSector;
	}

	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		String eqString = null;
		if (value==null || value.equals("")) {
			eqString = "";
		}else{
			eqString = ((Sector)value).getArea();
		}
		return eqString;
	}


}
