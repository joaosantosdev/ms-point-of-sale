package br.com.ourmind.posoauth.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.ourmind.posoauth.entities.feignclients.User;
import br.com.ourmind.posoauth.feignclients.UserFeignClient;

@Service
public class UserService implements UserDetailsService{
	
	@Autowired
	private UserFeignClient userFeignClient;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		ResponseEntity<User> response =  this.userFeignClient.getByEmail(username);
		User user = response.getBody();
		if(user == null) {
			throw new UsernameNotFoundException("User not found");
		}
		System.out.println(user.getPassword());
		return user;
	}

}
