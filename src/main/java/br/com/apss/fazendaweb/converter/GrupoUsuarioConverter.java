package br.com.apss.fazendaweb.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;

import br.com.apss.fazendaweb.model.GrupoUsuario;
import br.com.apss.fazendaweb.repository.GrupoUsuarioRepository;


@FacesConverter(forClass = GrupoUsuario.class)
public class GrupoUsuarioConverter implements Converter {

	@Inject
	private GrupoUsuarioRepository grupo;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		GrupoUsuario retorno = null;
		System.out.println("V A L O R --> "+value);
		if (StringUtils.isNotBlank(value)) {
			retorno = this.grupo.porId(new Long(value));
		}

		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			Long id = ((GrupoUsuario) value).getId();
			String retorno = (id == null ? null : id.toString());

			return retorno;
		}

		return "";
	}


}
