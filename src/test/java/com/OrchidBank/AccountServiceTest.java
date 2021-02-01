/**
 * 
 */
package com.OrchidBank;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import com.OrchidBank.Model.ObjectAccount;
import com.OrchidBank.Service.AccountService;

/**
 * @author Samuel Columbus Jan 31, 2021
 */
class AccountServiceTest {
  // Unit Test for AccountService

  AccountService accountService = new AccountService();

  @Test
  void testCreateAccount() {
    ObjectAccount obj_acct1 = accountService.creatAccount("John Muse", "123456", 500.00);
    assertEquals("John Muse", obj_acct1.getAccountName());
    ObjectAccount obj_acct2 = accountService.creatAccount("Ariel Jack", "123456", 100.00);
    assertEquals(null, obj_acct2);
  }

  @Test
  void testWithdrawandDeposit() {
    ObjectAccount obj_acct1 = accountService.creatAccount("Vanice Shank", "123456", 1000.00);
    ObjectAccount obj_acct2 =
        accountService.withdraw(obj_acct1.getAccountNumber(), "123456", 200.00);
    assertEquals(800.0, obj_acct2.getBalance());

    ObjectAccount obj_acct3 = accountService.deposit(obj_acct1.getAccountNumber(), 1000.00);
    assertEquals(1800.0, obj_acct3.getBalance());
  }
}
