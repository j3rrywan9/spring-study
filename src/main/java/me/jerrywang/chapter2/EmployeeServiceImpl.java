package me.jerrywang.chapter2;

public class EmployeeServiceImpl implements EmployeeService {
    @Override
    public Long generateEmployeeId() {
        return System.currentTimeMillis();
    }
}
