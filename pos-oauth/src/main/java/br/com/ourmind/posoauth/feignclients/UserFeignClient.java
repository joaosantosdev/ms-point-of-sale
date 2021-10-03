package br.com.ourmind.posoauth.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.ourmind.posoauth.entities.feignclients.User;

@FeignClient(name = "pos-administrator", path = "/users")
@Component
public interface UserFeignClient {

	@GetMapping(value = "/search")
	ResponseEntity<User> getByEmail(@RequestParam String email);

}
