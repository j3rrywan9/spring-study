package me.jerrywang.chapter2.dependencyinjection;

public class EmployeeDaoImpl implements EmployeeDao {
    @Override
    public String getName() {
        return "Jerry Wang";
    }
}
