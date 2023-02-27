package exc1;

public class Student {
	private int studentId;
	private String studentName;
	private String emailId;
	private String event;

	public Student(int studentId, String studentName, String emailId, String event) {
		this.studentId = studentId;
		this.studentName = studentName;
		this.emailId = emailId;
		this.event = event;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	@Override
	public boolean equals(Object student) {
		Student otherStudent = (Student) student;
		if (this.emailId.equals(otherStudent.emailId))
			return true;
		return false;
	}

	@Override
	public int hashCode() {
		return emailId.hashCode();
	}

	@Override
	public String toString() {
		return "Student Id: " + studentId + ", Student Name: " + studentName + ", Email Id: " + emailId;
	}

}
