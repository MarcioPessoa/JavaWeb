package com.aliandro.agenda.jsf.validators;

import java.util.Random;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import sun.applet.Main;

@FacesValidator("com.aliandro.emailValidator")
public class EmailValidator implements Validator{

	@Override
	public void validate(FacesContext context, UIComponent component, Object object) throws ValidatorException {
	
		String email = (String) object;
		
		if ( email.contains("@") ){
			return;
		}
		throw new ValidatorException( new FacesMessage("Forneça um e-mail válido!") );
		
	}
	
}


