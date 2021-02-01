/**
 * 
 */
package com.OrchidBank.Model;

import java.util.Date;

/**
 * @author Samuel Columbus Jan 31, 2021
 */
public class AccountStatement {
  public AccountStatement() {};

  /**
   * @param transactionDate
   * @param transactionType
   * @param narration
   * @param amount
   * @param accountBalance
   */
  public AccountStatement(Date transactionDate, String transactionType, String narration,
      Double amount, Double accountBalance) {
    super();
    this.transactionDate = transactionDate;
    this.transactionType = transactionType;
    this.narration = narration;
    this.amount = amount;
    this.accountBalance = accountBalance;
  }

  private Date transactionDate;
  private String transactionType;
  private String narration;
  private Double amount;
  private Double accountBalance;

  /**
   * @return the transactionDate
   */
  public Date getTransactionDate() {
    return transactionDate;
  }

  /**
   * @param transactionDate the transactionDate to set
   */
  public void setTransactionDate(Date transactionDate) {
    this.transactionDate = transactionDate;
  }

  /**
   * @return the transactionType
   */
  public String getTransactionType() {
    return transactionType;
  }

  /**
   * @param transactionType the transactionType to set
   */
  public void setTransactionType(String transactionType) {
    this.transactionType = transactionType;
  }

  /**
   * @return the narration
   */
  public String getNarration() {
    return narration;
  }

  /**
   * @param narration the narration to set
   */
  public void setNarration(String narration) {
    this.narration = narration;
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

  /**
   * @return the accountBalance
   */
  public Double getAccountBalance() {
    return accountBalance;
  }

  /**
   * @param accountBalance the accountBalance to set
   */
  public void setAccountBalance(Double accountBalance) {
    this.accountBalance = accountBalance;
  }

}
