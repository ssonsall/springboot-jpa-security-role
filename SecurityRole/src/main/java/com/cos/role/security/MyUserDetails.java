package com.cos.role.security;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.cos.role.model.User;

//Principal (접근 주체) = 세션처럼 사용 = Spring Security Context에 보관된다.
public class MyUserDetails implements UserDetails{
	
	private User user;


	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}	
	
	// 계정이 갖고있는 권한 목록을 리턴한다. (화)
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

		/* 예전 방식 */
//		Collection<SimpleGrantedAuthority> collectors = new ArrayList<>();
//		List<UserRole> roles = user.getRoles();
//		for(UserRole ur : roles) {
//			System.out.println(ur.getRole().getRole());
//			collectors.add(new SimpleGrantedAuthority("ROLE_"+ur.getRole().getRole()));
//		}
//				
//		return collectors;

		/* 요새 방식 */
		return user.getRoles().stream()
				.map(role-> new SimpleGrantedAuthority("ROLE_"+role.getRole().getRole()))
				.collect(Collectors.toList());
	}
	
}
