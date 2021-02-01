/**
 * 
 */
package com.OrchidBank.Request;

/**
 * @author Samuel Columbus Jan 30, 2021
 */
public class WithdrawalRequest {
  private String accountName;
  private String accountPassword;
  private Double withdrawnAmount;

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

  public Double getWithdrawnAmount() {
    return withdrawnAmount;
  }

  public void setWithdrawnAmount(Double withdrawnAmount) {
    this.withdrawnAmount = withdrawnAmount;
  }
}
