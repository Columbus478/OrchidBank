/**
 * 
 */
package com.OrchidBank.Model;

/**
 * @author Samuel Columbus Jan 30, 2021
 */
public class ObjectAccount {

  /**
   * @param accountName
   * @param accountNumber
   * @param balance
   */
  public ObjectAccount(String accountName, String accountNumber, Double balance) {
    super();
    this.accountName = accountName;
    this.accountNumber = accountNumber;
    this.balance = balance;
  }

  private String accountName;
  private String accountNumber;
  private Double balance;

  /**
   * @return the accountName
   */
  public String getAccountName() {
    return accountName;
  }

  /**
   * @param accountName the accountName to set
   */
  public void setAccountName(String accountName) {
    this.accountName = accountName;
  }

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
   * @return the balance
   */
  public Double getBalance() {
    return balance;
  }

  /**
   * @param balance the balance to set
   */
  public void setBalance(Double balance) {
    this.balance = balance;
  }

}
