package exc1;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
public class Tester6 {
	 public static Set<Student> findUnique(List<Student> students) {
	        Set<Student> uniqueStudents = new HashSet<Student>();
	        Set<String> emailIds = new HashSet<String>();
	        for (Student student : students) {
	            if (!emailIds.contains(student.getEmailId())) {
	                uniqueStudents.add(student);
	                emailIds.add(student.getEmailId());
	            }
	        }
	        return uniqueStudents;
	    }

	    public static Set<Student> findDuplicates(List<Student> students) {
	        Set<Student> duplicateStudents = new HashSet<Student>();
	        Set<String> emailIds = new HashSet<String>();
	        for (Student student : students) {
	            if (emailIds.contains(student.getEmailId())) {
	                duplicateStudents.add(student);
	            } else {
	                emailIds.add(student.getEmailId());
	            }
	        }
	        return duplicateStudents;
	    }

	    public static void main(String[] args) {
	        List<Student> students = new ArrayList<Student>();

	        students.add(new Student(5004, "Wyatt", "Wyatt@example.com", "Dance"));
	        students.add(new Student(5010, "Lucy", "Lucy@example.com", "Dance"));
	        students.add(new Student(5550, "Aaron", "Aaron@example.com", "Dance"));
	        students.add(new Student(5560, "Ruby", "Ruby@example.com", "Dance"));
	        students.add(new Student(5013, "Clara", "Clara@example.com", "Music"));
	        students.add(new Student(5015, "Sophie", "Sophie@example.com", "Music"));
	        students.add(new Student(5011, "Ivan", "Ivan@example.com", "Music"));
	        students.add(new Student(4556, "Ben", "Ben@example.com", "Music"));
	        students.add(new Student(3656, "John", "John@example.com", "Music"));
	        students.add(new Student(6543, "Sam", "Sam@example.com", "Music"));
	        students.add(new Student(455, "Ben", "Ben@example.com", "Dance"));

	        System.out.println("Unique students:");
	        Set<Student> uniqueStudents = findUnique(students);
	        for (Student student : uniqueStudents) {
	            System.out.println(student);
	        }

	        System.out.println("\nDuplicate students:");
	        Set<Student> duplicateStudents = findDuplicates(students);
	        for (Student student : duplicateStudents) {
	            System.out.println(student);
	        }
	    }


}
