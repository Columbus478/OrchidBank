/**
 * 
 */
package com.OrchidBank.ResponseEntity;

/**
 * @author Samuel Columbus Jan 30, 2021
 */
public class AuthResponse {
  private boolean success;
  private String accessToken;

  public AuthResponse(boolean success, String accessToken) {
    this.success = success;
    this.accessToken = accessToken;
  }

  /**
   * @return the status
   */
  public boolean isSuccess() {
    return success;
  }

  /**
   * @param status the status to set
   */
  public void setSuccess(boolean success) {
    this.success = success;
  }

  /**
   * @return the message
   */
  public String getAccessToken() {
    return accessToken;
  }

  /**
   * @param message the message to set
   */
  public void setAccessToken(String accessToken) {
    this.accessToken = accessToken;
  }
}
