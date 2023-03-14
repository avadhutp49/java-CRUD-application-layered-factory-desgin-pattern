package com.avadhutp49.persistence;
import com.avadhutp49.dto.Student;

public interface IStudentDao {
	// operations to be implemented
	public String addStudent(String sname, Integer sage, String saddress);
	public Student searchStudent(Integer sid);
	public String updateStudent(Student student);
	public String deleteStudent(Integer sid);
}
