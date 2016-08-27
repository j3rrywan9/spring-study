package me.jerrywang.chapter2.dependencyinjection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PayrollSystem {
  public static void main(String[] args) {
    ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

    IEmployeeService empService = (EmployeeServiceImpl) context.getBean("empServiceBeanDI");

    System.out.println("Unique Employee ID: " + empService.generateEmployeeId());

    System.out.println("Employee Name: " + empService.getEmployeeName());
  }
}
