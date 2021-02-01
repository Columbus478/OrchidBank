/**
 * 
 */
package com.OrchidBank.ResponseEntity;

import java.util.Map;

/**
 * @author Columbus
 *
 *         Jan 30, 2021
 */
public class AppGeneralResponse {

  private int responseCode;
  private boolean success;
  private String message;
  private Map<String, Object> result;

  public AppGeneralResponse(int responseCode, String message) {
    this.responseCode = responseCode;
    this.message = message;
  }

  public AppGeneralResponse(int responseCode, boolean success, String message) {
    this.responseCode = responseCode;
    this.success = success;
    this.message = message;
  }

  public AppGeneralResponse(int responseCode, boolean success, String message,
      Map<String, Object> result) {
    this.responseCode = responseCode;
    this.success = success;
    this.message = message;
    this.result = result;
  }

  public int getResponseCode() {
    return responseCode;
  }

  public void setResponseCode(int responseCode) {
    this.responseCode = responseCode;
  }

  public boolean getSuccess() {
    return success;
  }

  public void setSuccess(boolean success) {
    this.success = success;
  }

  public String getMessage() {
    return message;
  }

  public void setResponse(String message) {
    this.message = message;
  }

  public Map<String, Object> getResult() {
    return result;
  }

  public void setResult(Map<String, Object> result) {
    this.result = result;
  }

}
