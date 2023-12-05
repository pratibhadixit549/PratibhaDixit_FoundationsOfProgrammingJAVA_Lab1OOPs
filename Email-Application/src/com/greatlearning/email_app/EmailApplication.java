package com.greatlearning.email_app;

import java.util.Scanner;

public class EmailApplication {

	public void init() {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter your first name");		
		String firstname = input.nextLine();
		
		System.out.println("Enter your last name");		
		String lastname = input.nextLine();
		
		System.out.println("Enter your department");
		System.out.println("Specify the following department code values");
		System.out.println("1. Technical");
		System.out.println("2. Admin");
		System.out.println("3. Human Resource");
		System.out.println("4. Legal");
		
		int departmentCode = input.nextInt();
		
		int validationCount = 0;
		
		while(EmailAppUtils.validateDepartmentCode(departmentCode)!=true && validationCount!=2) {
			System.out.println();
			System.out.println();
			System.out.println("Invalid Department Code");
			System.out.println("Enter a department code between 1 and 4");
			System.out.println("Please try again...");
			
			departmentCode = input.nextInt();
			
			//validationCount = validationCount + 1;
			if(departmentCode==1 || departmentCode==2 || departmentCode==3 || departmentCode==4) {
				//validationCount++;
			}
			else {
				validationCount++ ;
			}
			
		}

		//if (EmailAppUtils.validateDepartmentCode(departmentCode)) {
			
			// Integrate the email address generation
			// emailAddress
		if(validationCount==2) {
			System.out.println();
			System.out.println();
			System.out.println("Enter a department code between 1 and 4");
			System.out.println("Please try again later...");
		}
		else {
			CredentialsManagerServiceImpl serviceObj = 
				new CredentialsManagerServiceImpl();
			
			
			String emailAddress  = serviceObj.generateEmailAddress(
					firstname, lastname, departmentCode);
			
			//System.out.println(emailAddress);
			
			// Integrate the password
			// password
			
			String password = serviceObj.generatePassword();
			//System.out.println(password);
			
			Employee empObj 
				= new Employee(firstname, lastname, emailAddress);
			empObj.setPassword(password);
			
			serviceObj.displayGeneratedCredentials(empObj);		
		}
		//}else {
			
			//System.out.println("Invalid Department Code");
			//System.out.println("Enter a department code between 1 and 4");
			//System.out.println("Please try again...");
			
			
		//}
		
		
	}
}
