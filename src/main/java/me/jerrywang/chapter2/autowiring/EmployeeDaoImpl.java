package me.jerrywang.chapter2.autowiring;

/**
 * A class implements me.jerrywang.chapter2.autowiring.EmployDao
 */
public class EmployeeDaoImpl implements IEmployeeDao {
  @Override
  public String getName() {
    return "Jerry Wang";
  }
}
