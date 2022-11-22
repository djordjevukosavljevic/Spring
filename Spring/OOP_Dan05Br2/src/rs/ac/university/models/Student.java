package rs.ac.university.models;

public class Student {
	private String forename, surrname, index;

	public Student(String forename, String surrname, String index) {
		this.forename = forename;
		this.surrname = surrname;
		this.index = index;
	}

	public String getForename() {
		return forename;
	}

	public void setForename(String forename) {
		this.forename = forename;
	}

	public String getSurrname() {
		return surrname;
	}

	public void setSurrname(String surrname) {
		this.surrname = surrname;
	}

	public String getIndex() {
		return index;
	}

	public void setIndex(String index) {
		this.index = index;
	}

	@Override
	public String toString() {
		return "Student [forename=" + forename + ", surrname=" + surrname + ", index=" + index + "]";
	}

	
}
