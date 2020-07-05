package Basic;

import java.util.*;

public class CompareTest {

	public static void main(String[] args) {
		CompareTest a = new CompareTest();
		
		//1. compareTo 테스트
//		a.compareToTest();
//		System.out.println("===");

//		 2. Comparator
		System.out.println("==comTest_Comparator호출=");
		a.comTest_Comparator();
		
		//3Comparable
//		a.comTest_Comparable();

	}

	// 1. compareTo 테스트
	public void compareToTest() {
		Integer num = 5;
		System.out.println(num.compareTo(3));
		System.out.println(num.compareTo(5));
		System.out.println(num.compareTo(88));
	}

	// 2. Comparator
	public void comTest_Comparator() {
		List<Student> list = new ArrayList<>();
		list.add(new Student("a", 4));
		list.add(new Student("b", 10));
		list.add(new Student("c", 1));
		list.add(new Student("d", 52));
		list.add(new Student("e", 23));

//		Collections.sort(list, comp);//오름차순
		Collections.sort(list, comp2);//오름차순
		
		System.out.println("------------------");
		for (Student s : list)
			System.out.println(s.getScore());

	}

	Comparator<Student> comp2 = new Comparator<Student>() {
		public int compare(Student s1, Student s2) {
			System.out.println("s1.score : "+s1.score+ " s2.score "+s2.score+ " 차이: "+(s1.score-s2.score));
			return s1.score - s2.score;
		}
	};

	Comparator<Student> comp = new Comparator<Student>() {
		@Override
		public int compare(Student s1, Student s2) {
			if (s1.getScore() > s2.getScore()) {
				return 1;
			} else if (s1.getScore() < s2.getScore()) {
				return -1;
			}
			return 0;
		}

	};

	// 3. Comparable
	public void comTest_Comparable() {
		List<Student> list = new ArrayList<>();
		list.add(new Student("a", 5));
		list.add(new Student("b", 10));
		list.add(new Student("c", 1));
		list.add(new Student("d", 52));
		list.add(new Student("e", 23));

		Collections.sort(list);

		for (Student s : list)
			System.out.println(s.getScore());

	}

}

class Student implements Comparable<Student> {
	String name;
	int score;

	public Student(String name, int score) {
		this.name = name;
		this.score = score;
	}

	public String getName() {
		return this.name;
	}

	public int getScore() {
		return this.score;
	}

	@Override
	public int compareTo(Student s) {
		// TODO Auto-generated method stub
		if (this.score > s.getScore()) {
			return 1;
		} else if (this.score < s.getScore()) {
			return -1;
		}
		return 0;
	}

}
