/**
 * 
 */
package com.OrchidBank;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import com.OrchidBank.Authentication.Token_generator;
import com.OrchidBank.Controller.AuthController;
import com.OrchidBank.ResponseEntity.AuthResponse;
import com.OrchidBank.Service.UserService;

/**
 * @author Samuel Columbus Jan 31, 2021
 */
@ContextConfiguration(classes = {AuthController.class})
@WebMvcTest
@AutoConfigureMockMvc
class AuthControllerTestIT {
  // Integration test for AuthController

  private String TEST_USER = "AC0002";
  @MockBean
  AuthenticationManager authenticationManager;
  @MockBean
  Token_generator token_generator;
  @MockBean
  UserService userService;

  @Autowired
  MockMvc mockmvc;
  @MockBean
  AuthResponse authres;

  @Test
  void testLogin() {
    testDoLogin();
  }

  @Test
  void testGetAccountInto() {
    testGetAccount_info("AC036733du");
  }

  @Test
  void testGetAccountStatement() {
    testGetAccount_statement("AC036733du");
  }

  private void testDoLogin() {
    try {
      MvcResult mvcr = mockmvc.perform(MockMvcRequestBuilders.get("/login").with(csrf())
          .with(user(TEST_USER)).contentType(MediaType.APPLICATION_JSON)).andReturn();
      assertNotNull(mvcr.getResponse());
      assertEquals(200, mvcr.getResponse().getStatus());
    } catch (Exception e) {
      e.getMessage();
    }
  }

  private void testGetAccount_info(String accountNumber) {
    try {
      MvcResult mvcr =
          mockmvc.perform(MockMvcRequestBuilders.get("/account_info/{accountNumber}", accountNumber)
              .with(user("")).with(csrf()).contentType(MediaType.APPLICATION_JSON)
              .accept(MediaType.APPLICATION_JSON)).andDo(print()).andReturn();
      mvcr.getResponse();
      assertNotNull(mvcr.getResponse());
      assertEquals(200, mvcr.getResponse().getStatus());
    } catch (Exception e) {
      e.getMessage();
    }
  }

  private void testGetAccount_statement(String accountNumber) {
    try {
      MvcResult mvcr = mockmvc.perform(MockMvcRequestBuilders
          .get("/account_statement/{accountNumber}", accountNumber).with(user("")).with(csrf())
          .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
          .andDo(print()).andReturn();
      mvcr.getResponse();
      assertNotNull(mvcr.getResponse());
      assertEquals(200, mvcr.getResponse().getStatus());
    } catch (Exception e) {
      e.getMessage();
    }
  }
}
