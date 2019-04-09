package ua.testov.test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main {

	public static void main(String[] args) {
		Student st1 = new Student(12345, "Бондар", false, 18);
		Student st2 = new Student(12342, "Журавель", true, 19);
		Student st3 = new Student(12347, "Кваша", false, 19);
		Student st4 = new Student(12343, "Зелененко", true, 17);
		Student st5 = new Student(12341, "Мельник", true, 18);

		Group gr1 = new Group("Group One");

		gr1.addStudent(st1, st2, st3, st4, st5);
		Faculty facult = new Faculty();
		facult.addGroup(1, gr1);
		System.out.println(facult);

		try (ObjectOutputStream ou = new ObjectOutputStream(new FileOutputStream("test.doc",true))) {
			ou.writeObject(facult);
		} catch (IOException e) {
			System.out.println("ERROR save faculty");
		}
		Faculty f = null;
		try (ObjectInputStream inp = new ObjectInputStream(new FileInputStream("test.doc"))) {
			f = (Faculty) inp.readObject();
		} catch (IOException | ClassNotFoundException e) {
			System.out.println("ERROR load faculty");
		}
		System.out.println();
		System.out.println(f);
		
		System.out.println("Фільтр:");
		System.out.println(gr1.filterStudentByName('Б'));
		
	}
}
