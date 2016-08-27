package me.jerrywang.chapter2.demo;

/**
 * A class implements me.jerrywang.chapter2.demo.EmployeeService.
 */
public class EmployeeServiceImpl implements IEmployeeService {
  /**
   * Generate a unique employee ID based on system's current time.
   */
  @Override
  public Long generateEmployeeId() {
    return System.currentTimeMillis();
  }
}
