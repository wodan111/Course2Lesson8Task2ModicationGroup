package ua.testov.test;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Group implements Military, Serializable {

	private String name;
	private List<Student> st = new ArrayList<Student>();

	public Group() {
		super();
	}

	public Group(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void addStudent(Student... names) {
		if (names.length + st.size() > 10)
			throw new myException();
		for (int i = 0; i < names.length; i++) {
			st.add(names[i]);
		}
	}

	public void delStudent(int i) {
		st.add(i, null);
	}

	public Student searchStudent(String str) {
		Student s = new Student();
		for (int i = 0; i < this.st.size(); i++) {
			if (this.st.get(i) != null) {
				if (this.st.get(i).getSecondName().equals(str)) {
					s = this.st.get(i);
					break;
				}
			}
		}

		if (s.getSecondName() == null) {
			System.out.print("Студента не знайдено! ");
			return null;
		}
		return s;
	}

	public enum En {
		reverse, withoutReverse;
	}

	public List<Student> sortWithParam(int p, En n) {
		if (p < 1 || p > 3) {
			throw new IllegalArgumentException();
		}
		try {
			if (n == En.reverse) {
				Collections.sort(st, Collections.reverseOrder(new SortWithParameter(p)));
			} else {
				Collections.sort(st, new SortWithParameter(p));
			}

		} catch (Exception e) {
			System.out.println("null element(-s) in massive");
		}

		return st;
	}

	public Student[] getDraftees(Student[] student) {
		Student[] recruits = new Student[10];
		int n = 0;
		for (int i = 0; i < student.length; i++) {
			if (student[i] == null) {
				continue;
			}
			if (student[i].getAge() >= 18 & student[i].isGender()) {
				recruits[n] = student[i];
				n++;
			}
		}
		return recruits;
	}

	@Override
	public String toString() {

		return "Group " + st;
	}

}