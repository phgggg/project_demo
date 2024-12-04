package com.demo.student_management.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "student")
public class StudentEntity {
    // Getters and setters

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

	@Column(name = "password")
	private String password;

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


