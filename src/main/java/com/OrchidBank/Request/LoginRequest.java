/**
 * 
 */
package com.OrchidBank.Request;

/**
 * @author Samuel Columbus Jan 30, 2021
 */
public class LoginRequest {
  private String accountNumber;

  private String accountPassword;

  public String getAccountNumber() {
    return accountNumber;
  }

  public void setAccountNumber(String accountNumber) {
    this.accountNumber = accountNumber;
  }

  public String getAccountPassword() {
    return accountPassword;
  }

  public void setAccountPassword(String accountPassword) {
    this.accountPassword = accountPassword;
  }
}
