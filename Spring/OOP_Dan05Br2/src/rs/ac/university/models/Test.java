package rs.ac.university.models;

public class Test {
	private Subject subject;
	private Student student;
	private String dateIso; // "2022-04-12"
	private double score;

	public Test(Subject subject, Student student, String dateIso, double score) {
		this.subject = subject;
		this.student = student;
		this.dateIso = dateIso;
		this.score = score;
	}

	public Subject getSubject() {
		return subject;
	}

	public Student getStudent() {
		return student;
	}

	public String getDateIso() {
		return dateIso;
	}

	public double getScore() {
		return score;
	}

	@Override
	public String toString() {
		return "Test [subject=" + subject + ", student=" + student + ", dateIso=" + dateIso + ", score=" + score + "]";
	}
	
}
