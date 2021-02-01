/**
 * 
 */
package com.OrchidBank.ResponseEntity;

/**
 * @author Samuel Columbus Jan 31, 2021
 */
public class Create_Depo_Withdraw_Response {

  /**
   * @param responseCode
   * @param success
   * @param message
   */
  public Create_Depo_Withdraw_Response(int responseCode, boolean success, String message) {
    this.responseCode = responseCode;
    this.success = success;
    this.message = message;
  }

  private int responseCode;
  private boolean success;
  private String message;

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

}
