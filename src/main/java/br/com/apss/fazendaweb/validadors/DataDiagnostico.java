package br.com.apss.fazendaweb.validadors;

import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

public class DataDiagnostico implements Validator {

	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		UIInput sd = (UIInput) component.getAttributes().get("resultado");
		String res  = (String) sd.getValue();
		Date data = (Date) value;
		if (data != null && res == null) {
			FacesMessage msg = new FacesMessage("Selecione um resultado para o diagnostico");
			throw new ValidatorException(msg);
		}
	}
}