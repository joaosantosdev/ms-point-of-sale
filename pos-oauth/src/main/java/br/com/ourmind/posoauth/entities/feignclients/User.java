package br.com.ourmind.posoauth.entities.feignclients;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class User implements UserDetails{
	
	private static final long serialVersionUID = 1L;

	private Long id;

	private String name;

	private String email;

	private String password;

	private Role role;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		System.out.println(this.role.getRoleName());
		return Arrays.asList(new SimpleGrantedAuthority(this.role.getRoleName()));
	}

	@Override
	public String getUsername() {
		return this.email;
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
		return true;
	}

}
