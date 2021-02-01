/**
 * 
 */
package com.OrchidBank.Model;

import java.io.Serializable;

/**
 * @author Samuel Columbus Jan 30, 2021
 */
public class Account implements Serializable {
  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  /**
   * @param accountName
   * @param accountPassword
   * @param initialDeposit
   */
  public Account(String accountName, String accountPassword, Double initialDeposit) {
    this.accountName = accountName;
    this.accountPassword = accountPassword;
    this.initialDeposit = initialDeposit;
  }

  private String accountName;
  private String accountPassword;
  private Double initialDeposit;

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
   * @return the accountPassword
   */
  public String getAccountPassword() {
    return accountPassword;
  }

  /**
   * @param accountPassword the accountPassword to set
   */
  public void setAccountPassword(String accountPassword) {
    this.accountPassword = accountPassword;
  }

  /**
   * @return the initialDeposit
   */
  public Double getInitialDeposit() {
    return initialDeposit;
  }

  /**
   * @param initialDeposit the initialDeposit to set
   */
  public void setInitialDeposit(Double initialDeposit) {
    this.initialDeposit = initialDeposit;
  }

}
