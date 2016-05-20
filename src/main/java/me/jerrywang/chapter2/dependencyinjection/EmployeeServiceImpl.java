package me.jerrywang.chapter2.dependencyinjection;

public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDao employeeDao = null;

    // Constructor-based dependency injection
    public EmployeeServiceImpl(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    public Long generateEmployeeId() {
        return System.currentTimeMillis();
    }

    @Override
    public String getEmployeeName() {
        return employeeDao.getName();
    }
}