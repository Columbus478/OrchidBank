/**
 * 
 */
package com.OrchidBank.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import com.OrchidBank.Model.User;

/**
 * @author Samuel Columbus Jan 30, 2021
 */
@Repository
public class UserService {
  private static List<User> userList = null;
  static {
    User user1 =
        new User("AC0001", "$2y$12$2SFxY5Xu.2iEJJVt3ieG9uIWo8ZAQmjFQ2/yvFdH5E/AfcxvHQ1vW", true);
    User user2 =
        new User("AC0002", "$2y$12$2SFxY5Xu.2iEJJVt3ieG9uIWo8ZAQmjFQ2/yvFdH5E/AfcxvHQ1vW", true);
    User user3 =
        new User("AC0003", "$2y$12$2SFxY5Xu.2iEJJVt3ieG9uIWo8ZAQmjFQ2/yvFdH5E/AfcxvHQ1vW", true);
    User user4 =
        new User("AC0004", "$2y$12$2SFxY5Xu.2iEJJVt3ieG9uIWo8ZAQmjFQ2/yvFdH5E/AfcxvHQ1vW", true);
    List<User> innerListuserList = new ArrayList<>();
    innerListuserList.add(user1);
    innerListuserList.add(user2);
    innerListuserList.add(user3);
    innerListuserList.add(user4);
    setUserList(innerListuserList);
  }

  public User findByUserAccountNumber(String accountNumber) {
    List<User> userRepo = getUserList();
    List<User> result_user = userRepo.stream().map(x -> {
      if (x.getAccountNumber() == accountNumber) {
        return x;
      }
      return x;
    }).collect(Collectors.toList());
    return result_user.get(0);
  }

  private static void setUserList(List<User> userlist) {
    userList = userlist;
  }

  private List<User> getUserList() {
    return userList;
  }

  public static void addUser(User user) {
    userList.add(user);
  }

  public static PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

}
