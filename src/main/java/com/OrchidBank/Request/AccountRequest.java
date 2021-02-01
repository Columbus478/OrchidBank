/**
 * 
 */
package com.OrchidBank.Request;

/**
 * @author Samuel Columbus Jan 30, 2021
 */
public class AccountRequest {
  private String accountName;

  private String accountPassword;
  private Double initialDeposit;

  public String getAccountName() {
    return accountName;
  }

  public void setAccountName(String accountName) {
    this.accountName = accountName;
  }

  public String getAccountPassword() {
    return accountPassword;
  }

  public void setAccountPassword(String accountPassword) {
    this.accountPassword = accountPassword;
  }

  public Double getInitialDeposit() {
    return initialDeposit;
  }

  public void setInitialDeposit(Double initialDeposit) {
    this.initialDeposit = initialDeposit;
  }
}
