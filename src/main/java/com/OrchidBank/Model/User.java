/**
 * 
 */
package com.OrchidBank.Model;

import java.io.Serializable;

/**
 * @author Samuel Columbus Jan 30, 2021
 */
public class User implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  private String accountNumber;
  private String accountPassword;
  private boolean enabled;


  public User(String accountNumber, String accountPassword, boolean enabled) {
    this.accountNumber = accountNumber;
    this.accountPassword = accountPassword;
    this.enabled = enabled;
  }


  public String getAccountNumber() {
    return accountNumber;
  }

  public void setAccountNumber(String accountNumber) {
    this.accountNumber = accountNumber;
  }

  public String getAccountPassword() {
    return accountPassword;
  }

  public void setAccountPassword(String password) {
    this.accountPassword = password;
  }


  /**
   * @return the enabled
   */
  public boolean isEnabled() {
    return enabled;
  }


  /**
   * @param enabled the enabled to set
   */
  public void setEnabled(boolean enabled) {
    this.enabled = enabled;
  }

}
