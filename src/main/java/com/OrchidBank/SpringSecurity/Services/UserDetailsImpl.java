/**
 * 
 */
package com.OrchidBank.SpringSecurity.Services;

import java.util.Collection;
import java.util.Objects;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import com.OrchidBank.Model.User;

/**
 * @author Samuel Columbus Jan 30, 2021
 */
public class UserDetailsImpl implements UserDetails {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  private User user;
  private String accountNumber;
  // @JsonIgnore

  UserDetailsImpl(User user) {
    this.user = user;
  }

  public static UserDetailsImpl build(User user) {
    return new UserDetailsImpl(user);
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return null;
  }

  @Override
  public String getPassword() {
    return user.getAccountPassword();
  }

  @Override
  public String getUsername() {
    return user.getAccountNumber();
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return user.isEnabled();
  }

  public User getUserDetail() {
    return user;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    UserDetailsImpl user = (UserDetailsImpl) o;
    return Objects.equals(accountNumber, user.getUsername());
  }
}
