/**
 * 
 */
package com.OrchidBank.ResponseEntity;

import com.OrchidBank.Model.ObjectAccount;

/**
 * @author Samuel Columbus Jan 31, 2021
 */
public class AccountInfoResponse {
  /**
   * @param responseCode
   * @param success
   * @param message
   * @param object_account
   */
  public AccountInfoResponse(int responseCode, boolean success, String message,
      ObjectAccount object_account) {
    this.responseCode = responseCode;
    this.success = success;
    this.message = message;
    this.object_account = object_account;
  }

  /**
   * @return the responseCode
   */
  public int getResponseCode() {
    return responseCode;
  }

  /**
   * @param responseCode the responseCode to set
   */
  public void setResponseCode(int responseCode) {
    this.responseCode = responseCode;
  }

  /**
   * @return the success
   */
  public boolean isSuccess() {
    return success;
  }

  /**
   * @param success the success to set
   */
  public void setSuccess(boolean success) {
    this.success = success;
  }

  /**
   * @return the message
   */
  public String getMessage() {
    return message;
  }

  /**
   * @param message the message to set
   */
  public void setMessage(String message) {
    this.message = message;
  }

  /**
   * @return the object_account
   */
  public ObjectAccount getObject_account() {
    return object_account;
  }

  /**
   * @param object_account the object_account to set
   */
  public void setObject_account(ObjectAccount object_account) {
    this.object_account = object_account;
  }

  private int responseCode;
  private boolean success;
  private String message;
  private ObjectAccount object_account;
}
