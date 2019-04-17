package com.csdepartment.mvc.model.validators;

import java.util.regex.Pattern;

import com.csdepartment.mvc.model.entities.Administrator;
import com.csdepartment.mvc.model.entities.Student;

public class RegisterValidator {
	private static final String EMAIL_PATTERN = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";

	public void validate(Student student)
	{
		Pattern pattern1 = Pattern.compile("[0-9]");
		if(pattern1.matcher(student.getNume()).find())
		{
			throw new IllegalArgumentException("Nume incorect!");
		}
		Pattern pattern = Pattern.compile(EMAIL_PATTERN);
		if(!pattern.matcher(student.getEmail()).matches()){
			throw new IllegalArgumentException("Mail incorect!");
		}
		if(student.getCnp().length()!=13)
		{
			throw new IllegalArgumentException("CNP incorect!");
		}
	}
	
	public void validate(Administrator admin)
	{
		Pattern pattern1 = Pattern.compile("[0-9]");
		if(pattern1.matcher(admin.getNume()).find())
		{
			throw new IllegalArgumentException("Nume incorect!");
		}
		Pattern pattern = Pattern.compile(EMAIL_PATTERN);
		if(!pattern.matcher(admin.getEmail()).matches()){
			throw new IllegalArgumentException("Mail incorect!");
		}
		if(admin.getCnp().length()!=13)
		{
			throw new IllegalArgumentException("CNP incorect!");
		}
	}
}