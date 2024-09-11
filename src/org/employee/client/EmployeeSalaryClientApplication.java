package org.employee.client;

import java.sql.Time;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.employee.model.AttendencaModel;
import org.employee.model.EmployeeModel;
import org.employee.service.AdminService;
import org.employee.service.AttendenceService;
import org.employee.service.EmployeeService;
import org.employee.service.SalaryService;

public class EmployeeSalaryClientApplication {

	public static void main(String[] args) {
		AdminService aSer = new AdminService();
		EmployeeService eSer = new EmployeeService();
		SalaryService sSer=new SalaryService();

		int choice;
		boolean result;

		do {
			System.out.println("0.Enter 0 to exit");
			System.out.println("1.ADMIN LOGIN");
			System.out.println("2.EMPLOYEE LOGIN");

			System.out.println("Enter your role to login");
			Scanner sc = new Scanner(System.in);
			choice = sc.nextInt();

			switch (choice) {
			case 0:
				System.out.println("You are successfully exited!");
				break;

			case 1:

				sc.nextLine();
				System.out.println("Please enter username and password");
				String username = sc.nextLine();
				String password = sc.nextLine();

				List<String> str = aSer.getAdminDetails();

				for (String lst : str) {
					if (username.equals(str.get(0)) && password.equals(str.get(1))) {
						
						
						System.out.println("LOG IN SUCCESSFUL!!");
						do {
							System.out.println("0.Enter 0 to exit");
							System.out.println("1.Employee Details");
							System.out.println("2.Employee Salary");
							System.out.println("3.Show Salary by Id");
							System.out.println("Enter your choice");
							choice = sc.nextInt();
							
							switch (choice) {
							case 0:
								System.out.println("You are successfully exited!");
								break;

							case 1:

								do 
								{
									
									System.out.println("0.Enter 0 to exit");
									System.out.println("1.Add Employee");
									System.out.println("2.View Employee");
									System.out.println("3.Delete Employee");
									System.out.println("4.Update Employee");
									System.out.println("5.Search Employee");


									System.out.println("Enter your choice");                       
									choice = sc.nextInt();
									switch (choice) {
									case 0:
										System.out.println("You are successfully exited!");
										break;

									case 1:							
										aSer.AddEmployee();
										break;

									case 2:
										aSer.viewEmployee();
										break;

									case 3:
										aSer.deleteEmployee();
										break;

									case 4:
										aSer.updateEmployee();
										break;

									case 5:
										aSer.searchEmployee();
										break;
										
									case 6:
										
										break;

									default:
										System.out.println("Invalid choice!");
										break;

									}

								} while (choice != 0);

								break;
								
							case 2:
								sSer.showSalary();
								break;
								
							case 3:
								sSer.calcMonthandDayWise();
								break;

							default:
								System.out.println("Invalid choice!");
								break;

							}

						} while (choice != 0);

						break;
					} else {
						System.out.println("You have entered wrong username and password!");
						break;
					}
				}

				break;

			case 2:

				sc.nextLine();
				System.out.println("Enter id Username and password of employee");
				int id = sc.nextInt();
				sc.nextLine();
				username = sc.nextLine();
				password = sc.nextLine();

				List<String> lst = eSer.validEmployee(id);

				for (String l : lst) {
					if (username.equals(lst.get(0)) && password.equals(lst.get(1))) {
						System.out.println("LOG IN SUCCESSFUL!!");
						do {
							System.out.println("0.Enter 0 to exit");
							System.out.println("1.View Employee");
							System.out.println("2.Take attendance of Employee");
							System.out.println("Enter your choice");

							choice = sc.nextInt();
							switch (choice) {
							case 0:
								System.out.println("You are successfully exited!");
								break;

							case 1:
								
								eSer.viewEmployee();
								break;

							case 2:
								do {
									System.out.println("0.Enter 0 to exit");
									System.out.println("1.Mark Presenty");
									System.out.println("2.Mark Absenty");
									System.out.println("Enter your choice");
									
									 AttendenceService atSer=new  AttendenceService();
									
									choice = sc.nextInt();
									
									switch (choice) {
									case 0:
										System.out.println("You are successfully exited!");                                                   
										break;

									case 1:
										atSer.markPresenty(id);
										choice=0;
										break;

									case 2:
										atSer.markAbsenty(id);
										choice=0;
										break;

									default:
										System.out.println("Invalid choice!");
										break;

									}

								} while (choice != 0);

								break;

							default:
								System.out.println("Invalid choice!");
								break;

							}

						} while (choice != 0);

						break;
					} else {
						System.out.println("You have entered wrong username and password!");
						break;
					}

				}

				break;

			case 3:
				System.out.println("");

				break;

			default:
				System.out.println("Invalid choice!");
				break;

			}

		} while (choice != 0);
	}

}




