/**
 * 
 */
package com.OrchidBank.SpringSecurity.Services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.OrchidBank.Model.User;
import com.OrchidBank.Service.UserService;

/**
 * @author Samuel Columbus Jan 30, 2021
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
  private static final Logger logger = LogManager.getLogger(UserDetailsServiceImpl.class);
  @Autowired
  UserService userRepository;

  @Override
  public UserDetails loadUserByUsername(String accountNumber) throws UsernameNotFoundException {
    User user = userRepository.findByUserAccountNumber(accountNumber);
    // .orElseThrow(() -> new UsernameNotFoundException(
    // "User account Not Found with accountNumber: " + accountNumber));
    if (user == null) {
      logger.info("No Orchid Bank User: {} was found for loadUserByUsername()", user);
      throw new UsernameNotFoundException("User not found.");
    }
    return UserDetailsImpl.build(user);
  }
}
