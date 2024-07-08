package com.demo.student_management.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "student")
public class StudentEntity {
    @Id
//    @GeneratedValue dValue(strategy = GenerationType.IDENTITY)
    private int id;

	@Size(min=2,max=45, message = "firstname from 2 to 45 characters")
    @Column(name = "firstName")
    private String firstName;

	@Size(min=2,max=45)
    @Column(name = "lastName")
    private String lastName;

	@Size(min=2,max=45)
    @Column(name = "studentID")
    private String studentID;
    
    @Column(name = "department")
    private String department;
    
    @Column(name = "major")
    private String major;
    
    @Column(name = "country")
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
		return lastName;
	}
	public void setLastname(String lastName) {
		this.lastName = lastName;
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
		this.lastName = lastname;
		this.studentID = studentID;
		this.department = department;
		this.major = major;
		this.country = country;
	}
	public StudentEntity() {

	}
	@Override
	public String toString() {
		return "student [id=" + id + ", firstName=" + firstName + ", lastname=" + lastName + ", studentID=" + studentID
				+ ", department=" + department + ", major=" + major + ", country=" + country + "]";
	}
    
}


