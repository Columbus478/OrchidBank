/**
 * 
 */
package com.OrchidBank.Controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.OrchidBank.Model.Account;
import com.OrchidBank.Model.AccountStatement;
import com.OrchidBank.Model.ObjectAccount;
import com.OrchidBank.Request.AccountRequest;
import com.OrchidBank.Request.DepositRequest;
import com.OrchidBank.Request.WithdrawalRequest;
import com.OrchidBank.ResponseEntity.AccountInfoResponse;
import com.OrchidBank.ResponseEntity.Create_Depo_Withdraw_Response;
import com.OrchidBank.Service.AccountService;

/**
 * @author Samuel Columbus Jan 30, 2021
 */
@RestController
@RequestMapping("/api")
public class AccountController {
  private static int ORCHID_BAD_REQUEST_CODE = 400;
  private static int ORCHID_SUCCESS_CODE = 200;
  private static double INITIAL_DEPOSIT_AMOUNT_LIMIT = 500.00;
  private static double ORCHID_MAX_DEPOSIT_LIMIT = 1000000.00;
  private static double ORCHID_MIN_WITH_DEPO_NEG_LIMIT = 1.00;
  @Autowired
  AccountService accountService;

  @PostMapping("/create_account")
  public ResponseEntity<?> createAccount(@RequestBody AccountRequest accountRequest) {
    // check if account already exit
    Account found_account = accountService.findByUserAccountName(accountRequest.getAccountName());
    if (found_account != null) {
      return ResponseEntity.badRequest().body(new Create_Depo_Withdraw_Response(
          ORCHID_BAD_REQUEST_CODE, false, "Error: Account is already taken!"));
    }
    if (accountRequest.getInitialDeposit() < INITIAL_DEPOSIT_AMOUNT_LIMIT) {
      return ResponseEntity.badRequest()
          .body(new Create_Depo_Withdraw_Response(ORCHID_BAD_REQUEST_CODE, false,
              "Initial deposit can not be less than" + INITIAL_DEPOSIT_AMOUNT_LIMIT));
    }
    accountService.creatAccount(accountRequest.getAccountName(),
        accountRequest.getAccountPassword(), accountRequest.getInitialDeposit());

    return ResponseEntity.ok(new Create_Depo_Withdraw_Response(ORCHID_SUCCESS_CODE, true,
        "Account created successfully."));
  }

  @GetMapping("/account_info/{accountNumber}")
  public ResponseEntity<?> getAccountInfo(@PathVariable("accountNumber") String accountNumber) {
    ObjectAccount found_ObjAccount = accountService.findByObjectAccountNumber(accountNumber);
    if (found_ObjAccount == null) {
      return ResponseEntity.badRequest().body(new Create_Depo_Withdraw_Response(
          ORCHID_BAD_REQUEST_CODE, false, "Sorry, account doesn't exit!"));
    } else {
      return ResponseEntity.ok(new AccountInfoResponse(ORCHID_SUCCESS_CODE, true,
          "Account details found successfully.", found_ObjAccount));
    }
  }

  @GetMapping("/account_statement/{accountNumber}")
  public ResponseEntity<?> getAccountStatement(
      @PathVariable("accountNumber") String accountNumber) {
    ObjectAccount found_ObjAccount = accountService.findByObjectAccountNumber(accountNumber);
    if (found_ObjAccount == null) {
      return ResponseEntity.badRequest().body(new Create_Depo_Withdraw_Response(
          ORCHID_BAD_REQUEST_CODE, false, "Sorry, account doesn't exit!"));
    } else {
      AccountStatement accountStatement =
          accountService.findAccountStatementByAccountNumber(accountNumber);

      List<AccountStatement> list_object = new ArrayList<>();
      list_object.add(accountStatement);
      return ResponseEntity.ok(list_object);
    }
  }

  @PostMapping("/deposit")
  public ResponseEntity<?> deposit(@RequestBody DepositRequest depositRequest) {
    // first, get account name from Object Account
    ObjectAccount obj_account =
        accountService.findByObjectAccountNumber(depositRequest.getAccountNumber());
    // use object account number to get user account
    Account found_account = accountService.findByUserAccountName(obj_account.getAccountName());
    if (found_account == null) {
      return ResponseEntity.badRequest().body(new Create_Depo_Withdraw_Response(
          ORCHID_BAD_REQUEST_CODE, false, "Sorry, account for Deposit doesn't exit!"));
    } else if (depositRequest.getAmount() > ORCHID_MAX_DEPOSIT_LIMIT) {
      return ResponseEntity.badRequest()
          .body(new Create_Depo_Withdraw_Response(ORCHID_BAD_REQUEST_CODE, false,
              "Sorry, You can not deposit above " + ORCHID_MAX_DEPOSIT_LIMIT + "!"));
    } else if (depositRequest.getAmount() < ORCHID_MIN_WITH_DEPO_NEG_LIMIT) {
      return ResponseEntity.badRequest().body(new Create_Depo_Withdraw_Response(
          ORCHID_BAD_REQUEST_CODE, false,
          "Sorry, You can not deposit negative amount like " + depositRequest.getAmount() + "!"));
    } else {
      accountService.deposit(depositRequest.getAccountNumber(), depositRequest.getAmount());
      return ResponseEntity.ok(new Create_Depo_Withdraw_Response(ORCHID_SUCCESS_CODE, true,
          "Deposit of " + depositRequest.getAmount() + " to " + depositRequest.getAccountNumber()
              + " made successfully."));
    }
  }

  @PostMapping("/withdrawal")
  public ResponseEntity<?> withdraw(@RequestBody WithdrawalRequest withdrawReq) {
    // first, get account name from Object Account
    ObjectAccount obj_account =
        accountService.findByObjectAccountName(withdrawReq.getAccountName());
    System.out.println("Found object: " + obj_account.getAccountNumber());
    // use object account number to get user account
    Account found_account = accountService.findByUserAccountName(obj_account.getAccountName());
    System.out.println("Found account: " + found_account);
    if (found_account == null) {
      return ResponseEntity.badRequest().body(new Create_Depo_Withdraw_Response(
          ORCHID_BAD_REQUEST_CODE, false, "Sorry, account doesn't exit!"));
    } else {
      // // check again if account name matches
      if (!found_account.getAccountName().equalsIgnoreCase(withdrawReq.getAccountName())) {
        return ResponseEntity.badRequest().body(new Create_Depo_Withdraw_Response(
            ORCHID_BAD_REQUEST_CODE, false, "Error: Sorry, your account doesn't match again!"));
      }
      // check if amount is greater than balance
      else if (found_account.getInitialDeposit() < withdrawReq.getWithdrawnAmount()) {
        return ResponseEntity.badRequest()
            .body(new Create_Depo_Withdraw_Response(ORCHID_BAD_REQUEST_CODE, false,
                "Error: Amount to withdraw is more than your balance!"));
      } else if (found_account.getInitialDeposit() > withdrawReq.getWithdrawnAmount()
          && withdrawReq.getWithdrawnAmount() < ORCHID_MIN_WITH_DEPO_NEG_LIMIT) {
        return ResponseEntity.badRequest()
            .body(new Create_Depo_Withdraw_Response(ORCHID_BAD_REQUEST_CODE, false,
                "Error: Sorry, you can not withdraw negative amount like: "
                    + withdrawReq.getWithdrawnAmount() + "!"));
      } else if (found_account.getInitialDeposit() <= INITIAL_DEPOSIT_AMOUNT_LIMIT
          || (found_account.getInitialDeposit()
              - withdrawReq.getWithdrawnAmount()) < INITIAL_DEPOSIT_AMOUNT_LIMIT) {
        return ResponseEntity.badRequest().body(new Create_Depo_Withdraw_Response(
            ORCHID_BAD_REQUEST_CODE, false,
            "Error: Sorry, you can not withdraw all your money and you must have more than your initial deposit of 500.00 remaining before you can withdraw again!"));
      } else if (!found_account.getAccountPassword().equals(withdrawReq.getAccountPassword())) {
        return ResponseEntity.badRequest()
            .body(new Create_Depo_Withdraw_Response(ORCHID_BAD_REQUEST_CODE, false,
                "Error: Sorry, your password doesn't match with your account password!"));
      } else {
        accountService.withdraw(obj_account.getAccountNumber(), withdrawReq.getAccountPassword(),
            withdrawReq.getWithdrawnAmount());
        return ResponseEntity.ok(new Create_Depo_Withdraw_Response(ORCHID_SUCCESS_CODE, true,
            "Withdrawn made successfully."));
      }
    }
  }
}
