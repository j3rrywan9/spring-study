package me.jerrywang.chapter2;

/**
 * A class implements me.jerrywang.chapter2.EmployeeService.
 */
public class EmployeeServiceImpl implements EmployeeService {
  /**
   * Generate a unique employee ID based on system's current time.
   */
  @Override
  public Long generateEmployeeId() {
    return System.currentTimeMillis();
  }
}
