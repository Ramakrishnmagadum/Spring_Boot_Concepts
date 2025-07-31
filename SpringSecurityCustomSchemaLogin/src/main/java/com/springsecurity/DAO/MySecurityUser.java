package com.springsecurity.DAO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class MySecurityUser implements UserDetails {

	private static final long serialVersionUID = 1L;
	
	private String xusername;
	private String xpassword;
	private String xrole;
	public MySecurityUser(String xusername, String xpassword, String xrole) {
		this.xusername=xusername;
		this.xpassword=xpassword;
		this.xrole=xrole;
	}

	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		SimpleGrantedAuthority role1=new SimpleGrantedAuthority(xrole);
		authorities.add(role1);
		return authorities;
	}

	public String getPassword() {
		return xpassword;
	}

	public String getUsername() {
		return xusername;
	}

	public boolean isAccountNonExpired() {
		return true;
	}

	public boolean isAccountNonLocked() {
		return true;
	}

	public boolean isCredentialsNonExpired() {
		return true;
	}

	public boolean isEnabled() {
		return true;
	}

}
