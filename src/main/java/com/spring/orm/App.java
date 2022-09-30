package com.spring.orm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.orm.dao.StudentDao;
import com.spring.orm.entities.Student;

public class App {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
		StudentDao studentdao = context.getBean("studentDao", StudentDao.class);

		/*
		 * Student stud=new Student(1234,"Mayur Thitame","Sangamner"); int
		 * r=studentdao.insert(stud); System.out.println("done "+r);
		 */
		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean flag = true;

		while (flag) {
			System.out.println("*********Application Started*************");
			System.out.println("Press 1  for add new Student");

			System.out.println("Press 2  for Display all Students");

			System.out.println("Press 3  for Display details of single Student");

			System.out.println("Press 4  for delete Student");

			System.out.println("Press 5  for update Student");

			System.out.println("Press 6  for Exit");

			try {
				int input = Integer.parseInt(br.readLine());

				switch (input) {
				case 1:

					System.out.println("enter id to insert");
					int No = sc.nextInt();
					sc.nextLine();
					System.out.println("enter city to insert");
					String city = sc.nextLine();
					System.out.println("enter name of student to insert");
					String name = sc.nextLine();

					Student stud = new Student(No, city, name);

					studentdao.insert(stud);

					System.out.println("Data inserted Successfully");

					break;
				case 2:

					List<Student> allStudents = studentdao.getAllStudents();
					System.out.println("student details are ");
					for (Student s : allStudents) {
						System.out.println(s);
					}
					break;

				case 3:
					System.out.println("Enter Id of student to Display details");
					int No1 = sc.nextInt();
					Student student = studentdao.getStudent(No1);
					System.out.println("student details are " + student);
					break;
				case 4:

					System.out.println("enter id to delete student record");
					int No2 = sc.nextInt();
					studentdao.deleteStudent(No2);
					System.out.println("student deleted successfully");
					break;

				case 5:
					System.out.println("enter id to update");
					int No3 = sc.nextInt();
					sc.nextLine();
					System.out.println("enter city to update");
					String uCity = sc.nextLine();
					System.out.println("enter name of student to update");
					String uName = sc.nextLine();

					Student stud1 = new Student(No3, uCity, uName);

					studentdao.updateStudent(stud1);
					System.out.println("details of student updated successfully");

					break;

				case 6:

					flag = false;
					break;
				}

			} catch (Exception e) {
				System.out.println("Invaid Input please try again");
			}
		}
		System.out.println("Application Exit..Thank you..!");

	}
}
