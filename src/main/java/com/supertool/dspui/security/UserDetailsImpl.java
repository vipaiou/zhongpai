package com.supertool.dspui.security;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.supertool.dspui.model.Authority;
import com.supertool.dspui.model.User;

public class UserDetailsImpl implements UserDetails {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Collection<GrantedAuthority> authorities;

    String password;

    String Username;

    boolean isAccountNonExpired;

    boolean isAccountNonLocked;

    boolean isCredentialsNonExpired;

    boolean isEnabled;
    List<List<Authority>> userAuthoritys;
    User user;

  public  UserDetailsImpl( String Username,String password, boolean isEnabled, boolean isAccountNonExpired,
            boolean isCredentialsNonExpired,boolean isAccountNonLocked,Collection<GrantedAuthority> authorities,List<List<Authority>> userAuthoritys,User user) {
        this.authorities = authorities;
        this.isAccountNonExpired = isAccountNonExpired;
        this.isAccountNonLocked = isAccountNonLocked;
        this.isEnabled = isEnabled;
        this.password = password;
        this.Username = Username;
        this.isCredentialsNonExpired = isCredentialsNonExpired;
        this.userAuthoritys=userAuthoritys;
        this.user=user;
    }

    public Collection<GrantedAuthority> getAuthorities() {

        return authorities;
    }

    public String getPassword() {
        // TODO Auto-generated method stub
        return password;
    }

    public String getUsername() {
        // TODO Auto-generated method stub
        return Username;
    }

    public boolean isAccountNonExpired() {
        // TODO Auto-generated method stub
        return isAccountNonExpired;
    }

    public boolean isAccountNonLocked() {
        // TODO Auto-generated method stub
        return isAccountNonLocked;
    }

    public boolean isCredentialsNonExpired() {
        // TODO Auto-generated method stub
        return isCredentialsNonExpired;
    }

    public boolean isEnabled() {
        // TODO Auto-generated method stub
        return isEnabled;
    }

	public List<List<Authority>> getUserAuthoritys() {
		return userAuthoritys;
	}

	public void setUserAuthoritys(List<List<Authority>> userAuthoritys) {
		this.userAuthoritys = userAuthoritys;
	}

	public void setAuthorities(Collection<GrantedAuthority> authorities) {
		this.authorities = authorities;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public void setAccountNonExpired(boolean isAccountNonExpired) {
		this.isAccountNonExpired = isAccountNonExpired;
	}

	public void setAccountNonLocked(boolean isAccountNonLocked) {
		this.isAccountNonLocked = isAccountNonLocked;
	}

	public void setCredentialsNonExpired(boolean isCredentialsNonExpired) {
		this.isCredentialsNonExpired = isCredentialsNonExpired;
	}

	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
    
}
