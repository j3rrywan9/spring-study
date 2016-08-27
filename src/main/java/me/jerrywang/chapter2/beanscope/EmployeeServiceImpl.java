package me.jerrywang.chapter2.beanscope;

public class EmployeeServiceImpl implements IEmployeeService {

  private String message;

  @Override
  public String getMessage() {
    return this.message;
  }

  @Override
  public void setMessage(final String message) {
    this.message = message;
  }
}
