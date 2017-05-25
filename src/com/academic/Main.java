package com.academic;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.academic.db.DAOFactory;
import com.academic.db.dao.Dao;
import com.academic.model.Course;
import com.academic.model.Person;

public class Main {

	public static void main(String[] args) {

		printCourses();
		Scanner sc = null;
		System.out.println("Choose 1 for create course or 2 for update course. Press anything else for exit.");
		sc = new Scanner(System.in);
		int i = sc.nextInt();
		if (i != 1 && i != 2) {
			System.exit(0);
		}

		if (i == 1) {
			addCourse();
		}

		if (i == 2) {
			updateCourse();
		}

		printCourses();
		printPersons();

		try {
			DAOFactory.getInstance().close();
		} catch (SQLException e) {
			System.out.println("Could not close the DAO Factory instance");
			e.printStackTrace();
		}

		/*
		 * printPersons();
		 * 
		 * 
		 * Scanner sc = null; System.out.println(
		 * "Choose 1 for create person or 2 for update person. Press anything else for exit."
		 * ); sc = new Scanner(System.in); int i = sc.nextInt(); if (i != 1 && i
		 * != 2) { System.exit(0); }
		 * 
		 * if (i == 1) { addPerson(); }
		 * 
		 * if (i == 2) { updatePerson(); } printPersons();
		 * 
		 * try { DAOFactory.getInstance().close(); } catch (SQLException e) {
		 * System.out.println("Could not close the DAO Factory instance");
		 * e.printStackTrace(); }
		 * 
		 * 
		 */
	}

	public static void printCourses() {
		Dao<Course> courseDao = getCourseDao();

		int coursesCount = courseDao.countAll();
		System.out.println("Academicmanager Database contains: " + coursesCount + " courses");

		System.out.println("Acquiring all courses");
		List<Course> allCourses = courseDao.getAll();
		if (allCourses != null) {
			for (int i = 0; i < allCourses.size(); i++) {
				Course currentCourse = allCourses.get(i);
				System.out.println(currentCourse);
			}
		} else {
			System.out.println("Could not retrieve courses");
		}

		System.out.println("Retrieving course by id");
		Course courseById = courseDao.get(3);

		if (courseById != null) {
			System.out.println(courseById);
		}

	}

	public static void printPersons() {
		Dao<Person> personDao = null;
		try {
			personDao = DAOFactory.getInstance().getPersonDao();
		} catch (SQLException e) {
			System.out.println("Could not connect to the database");
			e.printStackTrace();
			return;
		}

		int personsCount = personDao.countAll();
		System.out.println("Academicmanager Database contains: " + personsCount + " persons");

		System.out.println("Acquiring all persons");
		List<Person> allPersons = personDao.getAll();
		if (allPersons != null) {
			for (int i = 0; i < allPersons.size(); i++) {
				Person currentPerson = allPersons.get(i);
				System.out.println(currentPerson);
			}
		} else {
			System.out.println("Could not retrieve persons");
		}

		System.out.println("Retrieving person by id");
		Person personById = personDao.get(3);

		if (personById != null) {
			System.out.println(personById);
		}

	}

	public static void addCourse() {
		Dao<Course> courseDao = getCourseDao();

		Course t = getCourse();

		courseDao.add(t);

	}

	public static void addPerson() {
		Dao<Person> personDao = getPersonDao();
		Person p = new Person();
		personDao.add(p);
	}

	public static void updateCourse() {
		Dao<Course> courseDao = getCourseDao();

		Course t = getCourse();

		System.out.println("Input courseId");
		Scanner sc = new Scanner(System.in);
		int courseId = sc.nextInt();
		t.setCourseId(courseId);
		courseDao.update(t);
	}

	public static void updatePerson() {
		Dao<Person> personDao = getPersonDao();
		Person p = getPerson();

		System.out.println("Input personId");
		Scanner sc = new Scanner(System.in);
		int personId = sc.nextInt();
		p.setPersonId(personId);
		personDao.update(p);

	}

	public static Dao<Course> getCourseDao() {
		Dao<Course> courseDao = null;

		try {
			courseDao = DAOFactory.getInstance().getCourseDao();

		} catch (SQLException e) {
			System.out.println("Could not connect to the database");
			e.printStackTrace();
			System.exit(0);
		}
		return courseDao;

	}

	public static Dao<Person> getPersonDao() {
		Dao<Person> personDao = null;

		try {
			personDao = DAOFactory.getInstance().getPersonDao();

		} catch (SQLException e) {
			System.out.println("Could not connect to the database");
			e.printStackTrace();
			System.exit(0);
		}
		return personDao;

	}

	public static Course getCourse() {

		Scanner sc = null;
		sc = new Scanner(System.in);

		System.out.println("Input title");
		sc = new Scanner(System.in);
		String title = sc.nextLine();

		System.out.println("Input cost");
		sc = new Scanner(System.in);
		int cost = sc.nextInt();

		System.out.println("Input description");
		sc = new Scanner(System.in);
		String description = sc.nextLine();

		System.out.println("Input startingDate");
		sc = new Scanner(System.in);
		String startingDate = sc.nextLine();

		System.out.println("Input endingDate");
		sc = new Scanner(System.in);
		String endingDate = sc.nextLine();

		System.out.println("Input isActive");
		sc = new Scanner(System.in);
		boolean isActive = sc.nextBoolean();

		Course t = new Course();
		t.setTitle(title);
		t.setCost(cost);
		t.setDescription(description);
		t.setStartingDate(startingDate);
		t.setEndingDate(endingDate);
		t.setActive(isActive);

		return t;

	}

	public static Person getPerson() {
		Scanner sc = null;
		sc = new Scanner(System.in);

		System.out.println("Input name");
		sc = new Scanner(System.in);
		String name = sc.nextLine();

		System.out.println("Input surname");
		sc = new Scanner(System.in);
		String surname = sc.nextLine();

		System.out.println("Input type");
		sc = new Scanner(System.in);
		String type = sc.nextLine();

		System.out.println("Input date of birth");
		sc = new Scanner(System.in);
		String dateOfBirth = sc.nextLine();

		System.out.println("Input sex");
		sc = new Scanner(System.in);
		String sex = sc.nextLine();

		System.out.println("Input email");
		sc = new Scanner(System.in);
		String email = sc.nextLine();

		System.out.println("Input phoneNumber");
		sc = new Scanner(System.in);
		String phoneNumber = sc.nextLine();

		System.out.println("Input address");
		sc = new Scanner(System.in);
		String address = sc.nextLine();

		System.out.println("Input taxNumber");
		sc = new Scanner(System.in);
		String taxNumber = sc.nextLine();

		System.out.println("Input bankAccount");
		sc = new Scanner(System.in);
		String bankAccount = sc.nextLine();

		Person p = new Person();
		p.setName(name);
		p.setSurname(surname);
		p.setType(type);
		p.setDateOfBirth(dateOfBirth);
		p.setSex(sex);
		p.setEmail(email);
		p.setPhoneNumber(phoneNumber);
		p.setAddress(address);
		p.setTaxNumber(taxNumber);
		p.setBankAccount(bankAccount);

		return p;

	}
}
