package com.avadhutp49.servicefactory;
import com.avadhutp49.service.IStudentService;
import com.avadhutp49.service.StudentServiceImpl;
//Abstraction logic of implementation
public class StudentServiceFactory {

	private StudentServiceFactory() {
		//make constuctor private to avoid object creation from outside environment.
	}

	private static IStudentService studentService = null;

	public static IStudentService getStudentService() {
		
		//singleton pattern code
		if (studentService == null) {
			studentService = new StudentServiceImpl();
		}
		return studentService;
	}
}