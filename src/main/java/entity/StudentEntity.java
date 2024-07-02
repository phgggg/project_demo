package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String firstName;
    private String lastname;
    private String studentID;
    private String department;
    private String major;
    private String country;
    // Getters and setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getStudentID() {
		return studentID;
	}
	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public StudentEntity(int id, String firstName, String lastname, String studentID, String department, String major,
			String country) {
//		super();
		this.id = id;
		this.firstName = firstName;
		this.lastname = lastname;
		this.studentID = studentID;
		this.department = department;
		this.major = major;
		this.country = country;
	}
	@Override
	public String toString() {
		return "student [id=" + id + ", firstName=" + firstName + ", lastname=" + lastname + ", studentID=" + studentID
				+ ", department=" + department + ", major=" + major + ", country=" + country + "]";
	}
    
}

