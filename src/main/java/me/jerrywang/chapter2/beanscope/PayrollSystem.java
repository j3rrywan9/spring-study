package me.jerrywang.chapter2.beanscope;

import me.jerrywang.chapter2.setterinjection.EmployeeService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PayrollSystem {

  public static void main(final String[] args) {
    final ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

    final IEmployeeService employeeServiceA = (EmployeeServiceImpl) context.getBean("empServiceBeanScope");
    employeeServiceA.setMessage("Message by service A");
    System.out.println("employeeServiceA: " + employeeServiceA.getMessage());

    final IEmployeeService employeeServiceB = (EmployeeServiceImpl) context.getBean("empServiceBeanScope");
    System.out.println("employeeServiceB: " + employeeServiceB.getMessage());
  }
}
