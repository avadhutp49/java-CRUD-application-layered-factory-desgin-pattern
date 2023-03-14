package com.avadhutp49.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import com.avadhutp49.dto.Student;
import com.avadhutp49.service.IStudentService;
import com.avadhutp49.servicefactory.StudentServiceFactory;

//controller logic
public class TestApp {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			System.out.println("\n \t Implementation of CRUD Application");
			SimpleDateFormat formatter = new SimpleDateFormat("\t\t dd/MM/yyyy HH:mm:ss");  
		    Date date = new Date();  
		    
		    System.out.println(formatter.format(date));
		    System.out.println("\n");
			System.out.println("\t 1. C-Create Record");
			System.out.println("\t 2. R-Read Record");
			System.out.println("\t 3. U-Update Record");
			System.out.println("\t 4. D-Delete Record\n ");
			System.out.println("\t 5. Terminate\n");
			System.out.print("\t Enter Your Choice : ");
			String option = br.readLine();

			switch (option) {
			case "1":
				insertOperation();
				break;
			case "2":
				selectOperation();
				break;
			case "3":
				updateRecord();
				break;
			case "4":
				deleteRecord();
				break;
			case "5":
				System.out.println(" #### Thank You For Using My Application ####");
				System.exit(0);
			default:
				System.out.println("Invalid...!");
				break;
			}

		}
	}

	private static void updateRecord() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("\t Enter Student ID for Updation: ");
		String sid = br.readLine();

		IStudentService studentService = StudentServiceFactory.getStudentService();
		Student student = studentService.searchStudent(Integer.parseInt(sid));

		if (student != null) {
			Student newStudent = new Student();

			System.out.println("\t Student ID: " + student.getSid());
			newStudent.setSid(student.getSid());

			System.out.print("\t Old Name: " + student.getSname() + "\t Enter New Name: ");
			String newName = br.readLine();
			if (newName.equals("") || newName == "") {
				newStudent.setSname(student.getSname());
			} else {
				newStudent.setSname(newName);
			}
			System.out.print("\t Old Age: " + student.getSage() + "\t Enter New Age: ");
			String newAge = br.readLine();
			if (newAge.equals("") || newAge == "") {
				newStudent.setSage(student.getSage());
			} else {
				newStudent.setSage(Integer.parseInt(newAge));
			}
			System.out.print("\t Old Address: " + student.getSaddress() + "\t Enter New Address: ");
			String newAddress = br.readLine();
			if (newAddress.equals("") || newAddress == "") {
				newStudent.setSaddress(student.getSaddress());
			} else {
				newStudent.setSaddress(newAddress);
			}

			System.out.println("\t New Object Data: " + newStudent);
			System.out.println();

			String status = studentService.updateStudent(newStudent);
			if (status.equalsIgnoreCase("success")) {
				System.out.println("\t Record Updated Succesfully...!");
			} else {
				System.out.println("\t Record Updation Failed...!");
			}

		} else {
			System.out.println("\t Record Not Available For Id:  " + sid);
		}

	}

	private static void deleteRecord() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("\t Enter Student ID: ");
		int sid = scanner.nextInt();

		IStudentService studentService = StudentServiceFactory.getStudentService();
		String msg = studentService.deleteStudent(sid);
		if (msg.equalsIgnoreCase("success")) {
			System.out.println("\t Record Deleted Succesfully...!");
		} else if (msg.equalsIgnoreCase("not found")) {
			System.out.println("\t Record Not Found for ID: " + sid);
		} else {
			System.out.println("\t Record Deletion Failed...!");
		}

	}

	private static void selectOperation() {
		// insertOperation();
		Scanner scanner = new Scanner(System.in);
		System.out.print("\t Enter Student ID: ");
		int sid = scanner.nextInt();

		IStudentService studentService = StudentServiceFactory.getStudentService();
		Student std = studentService.searchStudent(sid);
		if (std != null) {
			System.out.println(std);
			System.out.println("\t Id\tName\tSAge\tSAddress");
			System.out.println("\t "+std.getSid() + "\t" + std.getSname() + "\t" + std.getSage() + "\t" + std.getSaddress());
		} else {
			System.out.println("\t Record Not Found for ID: " + sid);
		}

	}

	private static void insertOperation() {
		IStudentService studentService = StudentServiceFactory.getStudentService();

		Scanner scanner = new Scanner(System.in);

		System.out.print("\t Enter Student Name: ");
		String sname = scanner.next();

		System.out.print("\t Enter Student Age: ");
		int sage = scanner.nextInt();

		System.out.print("\t Enter Student Address: ");
		String saddress = scanner.next();

		String msg = studentService.addStudent(sname, sage, saddress);
		if (msg.equalsIgnoreCase("success")) {
			System.out.println("\t Record Inserted Succesfully...!");
		} else {
			System.out.println("\t Record Insertion Failed...!");
		}
	}

}
