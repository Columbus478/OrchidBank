/**
 * 
 */
package com.OrchidBank.Request;

/**
 * @author Samuel Columbus Jan 31, 2021
 */
public class DepositRequest {
  private String accountNumber;

  private Double amount;

  /**
   * @return the accountNumber
   */
  public String getAccountNumber() {
    return accountNumber;
  }

  /**
   * @param accountNumber the accountNumber to set
   */
  public void setAccountNumber(String accountNumber) {
    this.accountNumber = accountNumber;
  }

  /**
   * @return the amount
   */
  public Double getAmount() {
    return amount;
  }

  /**
   * @param amount the amount to set
   */
  public void setAmount(Double amount) {
    this.amount = amount;
  }


}
