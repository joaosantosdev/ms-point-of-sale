package br.com.ourmind.posproductmovement.feignclients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.ourmind.posproductmovement.dto.ProductDTO;
import br.com.ourmind.posproductmovement.dto.UserDTO;

@Component
@FeignClient(name = "pos-administrator", path = "/")
public interface AdministratorFeignClient {

	@GetMapping("products/search")
	ResponseEntity<List<ProductDTO>> getProductsByIds(@RequestParam List<Long> ids);

	@GetMapping(value = "users/search/clients")
	public ResponseEntity<List<UserDTO>> getClientsByIds(@RequestParam List<Long> ids);
}
