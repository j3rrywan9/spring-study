package me.jerrywang.chapter2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PayrollSystem {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        EmployeeService empService = (EmployeeService) context.getBean("empServiceBean");

        System.out.println("Unique Employee ID: " + empService.generateEmployeeId());
    }
}
