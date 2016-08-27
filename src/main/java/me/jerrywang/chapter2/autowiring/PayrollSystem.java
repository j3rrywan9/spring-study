package me.jerrywang.chapter2.autowiring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Main class for package me.jerrywang.chapter2.autowiring.
 */
public class PayrollSystem {
  public static void main(final String[] args) {
    // Load the bean definition from the XML file "beans.xml"
    final ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

    final IEmployeeService empService = (EmployeeServiceImpl) context.getBean("empServiceBeanAutowire");

    System.out.println("Unique Employee ID: " + empService.generateEmployeeId());

    System.out.println("Employee Name: " + empService.getEmployeeName());
  }
}
