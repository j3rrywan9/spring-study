package me.jerrywang.chapter2.autowiring;

/**
 * A class implements me.jerrywang.chapter2.autowiring.EmployeeService.
 */
public class EmployeeServiceImpl implements EmployeeService {

  private EmployeeDao employeeDao = null;

  // Setter-based dependency injection
  public void setEmployeeDao(EmployeeDao employeeDao) {
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