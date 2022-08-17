package com.cg.school.dto;

import java.sql.Date;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor(staticName="build")
@NoArgsConstructor
public class Student {
	@NotNull(message = "First Name shouldn't be null")
	private String firstName;
    @NotNull(message = "Last Name shouldn't be null")
	private String lastName;
    private Date dob;
	private String standarded;
    @NotNull(message = "Father Name shouldn't be null")
	private String fatherName;
	private String motherName;
    private Long phone;
    private String address;

}
