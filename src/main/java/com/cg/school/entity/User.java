package com.cg.school.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Entity
@Table(name="USER_TBL")
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class User {
	@Id
	@GeneratedValue
	private int userId;
	private String firstName;
	private String lastName;
	private Date dob;
	private String standarded;
	private String fatherName;
	private String motherName;
    private Long phone;
    private String address;
}
