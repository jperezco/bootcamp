package com.example.domains.entities.core;

import java.util.Set;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.persistence.Transient;
import javax.validation.ConstraintViolation;

public class EntityBase<E> {
	
	@Transient
	public Set<ConstraintVioation<E>> getErrors(){
		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
		return validator.validate((E)this);
	}
	
	@Transient
	public boolean isValid() {
		return getErrors().size() == 0;
	}
	
	public boolean isInvalid() {
		return !isValid();
	}

}
