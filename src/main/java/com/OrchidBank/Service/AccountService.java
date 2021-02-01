/**
 * 
 */
package com.OrchidBank.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;
import com.OrchidBank.Model.Account;
import com.OrchidBank.Model.AccountStatement;
import com.OrchidBank.Model.ObjectAccount;

/**
 * @author Samuel Columbus Jan 30, 2021
 */
@Repository
public class AccountService {
  private static List<Account> accountList;
  private static List<ObjectAccount> ObjectAccountList;
  private static Map<String, AccountStatement> AccountStatementList;
  static {
    // User Accounts
    accountList = new ArrayList<>();
    Account initAccount = new Account("AC036733du", "123456", 500.00);
    accountList.add(initAccount);
    // Object Accounts
    ObjectAccountList = new ArrayList<>();
    ObjectAccount obj_acc = new ObjectAccount("testuser", "AC036733du", 500.00);
    ObjectAccountList.add(obj_acc);
    // Account Statement Map Object
    AccountStatementList = new HashMap<>();
    AccountStatementList.put("AC036733du", new AccountStatement());
  }

  public ObjectAccount creatAccount(String accountName, String accountPassword,
      Double initialDeposit) {
    if (initialDeposit < 500.00) {
      return null;
    }
    String formed_accountNumber = accountNumberGenerator() + accountName.substring(0, 3);
    Account newAccount = new Account(accountName, accountPassword, initialDeposit);
    addAccount(newAccount);

    ObjectAccount objectAccount =
        new ObjectAccount(accountName, formed_accountNumber, initialDeposit);
    addObjectAccount(objectAccount);
    // to add ease of access to formed_accountNumber
    System.out.println(
        "formed accountNumber: " + formed_accountNumber + " and accountName: " + accountName);

    return objectAccount;
  }

  public ObjectAccount withdraw(String accountNumber, String accountPassword,
      Double withdrawnAmount) {

    ObjectAccount objectAccount = findByObjectAccountNumber(accountNumber);
    if (objectAccount != null) {
      objectAccount.setBalance(objectAccount.getBalance() - withdrawnAmount);
      updateObjectAccount(objectAccount);

      Account newAccount = findByUserAccountName(objectAccount.getAccountName());

      newAccount.setInitialDeposit(newAccount.getInitialDeposit() - withdrawnAmount);
      updateAccount(newAccount);

      // setup account statement
      Date transactionDate = Calendar.getInstance().getTime();
      String transactionType = "Withdrawal";
      String narration = "For Payment of products purchased.";
      Double accountBalance = objectAccount.getBalance();
      AccountStatement acct_statement = new AccountStatement(transactionDate, transactionType,
          narration, withdrawnAmount, accountBalance);
      updateAccountStatement(objectAccount.getAccountNumber(), acct_statement);

      return objectAccount;
    }
    return null;
  }

  public ObjectAccount deposit(String accountNumber, Double amount) {

    ObjectAccount objectAccount = findByObjectAccountNumber(accountNumber);
    if (objectAccount != null) {
      objectAccount.setBalance(objectAccount.getBalance() + amount);
      updateObjectAccount(objectAccount);

      Account newAccount = findByUserAccountName(objectAccount.getAccountName());
      newAccount.setInitialDeposit(newAccount.getInitialDeposit() + amount);
      updateAccount(newAccount);

      // setup account statement
      Date transactionDate = Calendar.getInstance().getTime();
      String transactionType = "Deposit";
      String narration = "Credited my customer's account.";
      Double accountBalance = objectAccount.getBalance();
      AccountStatement acct_statement =
          new AccountStatement(transactionDate, transactionType, narration, amount, accountBalance);
      updateAccountStatement(objectAccount.getAccountNumber(), acct_statement);

      return objectAccount;
    }
    return null;
  }

  public Account findByUserAccountName(String accountName) {
    List<Account> accountRepo = getAccountList();
    List<String> name = new ArrayList<>();
    for (Account c : accountRepo) {
      name.add(c.getAccountName());
    }
    System.out.println(name);
    System.out.println(accountRepo);

    for (Account account : accountRepo) {
      if (account.getAccountName().equals(accountName))
        return account;
    }
    return null;
  }

  // For User Accounts
  private List<Account> getAccountList() {
    return accountList;
  }

  private void addAccount(Account account) {
    accountList.add(account);
  }

  private void updateAccount(Account account) {
    accountList.set(accountList.indexOf(account), account);
  }

  public ObjectAccount findByObjectAccountNumber(String accountNumber) {
    List<ObjectAccount> ObjAccountRepo = getObjectAccountList();
    List<String> number = new ArrayList<>();
    for (ObjectAccount c : ObjAccountRepo) {
      number.add(c.getAccountNumber());
    }
    System.out.println(number);
    for (ObjectAccount ObjAccount : ObjAccountRepo) {
      if (ObjAccount.getAccountNumber().equals(accountNumber))
        return ObjAccount;
    }
    return null;
  }

  public ObjectAccount findByObjectAccountName(String accountName) {
    List<ObjectAccount> ObjAccountRepo = getObjectAccountList();
    List<String> name = new ArrayList<>();
    for (ObjectAccount c : ObjAccountRepo) {
      name.add(c.getAccountName());
    }

    System.out.println(name);

    for (ObjectAccount ObjAccount : ObjAccountRepo) {
      if (ObjAccount.getAccountName().equals(accountName))
        return ObjAccount;
    }
    return null;
  }

  // For Object Accounts
  private List<ObjectAccount> getObjectAccountList() {
    return ObjectAccountList;
  }

  private void addObjectAccount(ObjectAccount ObjAccount) {
    ObjectAccountList.add(ObjAccount);
  }

  private void updateObjectAccount(ObjectAccount ObjAccount) {
    ObjectAccountList.set(ObjectAccountList.indexOf(ObjAccount), ObjAccount);
  }

  // For Account statements
  private Map<String, AccountStatement> getAccountStatementList() {
    return AccountStatementList;
  }

  private void updateAccountStatement(String accountNumber, AccountStatement accountStatement) {
    for (Map.Entry<String, AccountStatement> data : getAccountStatementList().entrySet())
      if (data.getKey().equals(accountNumber)) {
        AccountStatementList.replace(accountNumber, accountStatement);
      } else {
        AccountStatementList.put(accountNumber, accountStatement);
      }
  }

  public AccountStatement findAccountStatementByAccountNumber(String accountNumber) {
    Map<String, AccountStatement> accountStatements = getAccountStatementList();
    if (accountStatements.get(accountNumber) != null) {
      return accountStatements.get(accountNumber);
    }
    return null;
  }



  public static String accountNumberGenerator() {
    // Generate Random Long number between 1 -1000 (Accept only 1000 accounts)
    String accountNum = "";
    long rightlimit = 1000L;
    long leftlimit = 1L;
    long generatedAccountNum = leftlimit + (long) (Math.random() * (rightlimit - leftlimit));
    if (generatedAccountNum <= 9)
      accountNum = "AC0000" + generatedAccountNum;
    if (generatedAccountNum >= 10)
      accountNum = "AC000" + generatedAccountNum;
    if (generatedAccountNum >= 100)
      accountNum = "AC00" + generatedAccountNum;
    if (generatedAccountNum == 1000)
      accountNum = "AC0" + generatedAccountNum;
    return accountNum;
  }
}
