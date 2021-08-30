package br.com.ourmind.posproductmovement.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.ourmind.posproductmovement.dto.MovementDTO;
import br.com.ourmind.posproductmovement.dto.UserDTO;
import br.com.ourmind.posproductmovement.errors.RestException;
import br.com.ourmind.posproductmovement.feignclients.AdministratorFeignClient;

@Service
public class UserService {

	@Autowired
	private AdministratorFeignClient administratorFeignClient;

	public void validateClients(List<MovementDTO> listMovementDTO) {
		List<Long> clientsIds = listMovementDTO.stream().map(item -> item.getClientId()).collect(Collectors.toList());
		ResponseEntity<List<UserDTO>> responseClients = this.administratorFeignClient.getClientsByIds(clientsIds);

		if (!HttpStatus.OK.equals(responseClients.getStatusCode())) {
			throw new RestException(HttpStatus.INTERNAL_SERVER_ERROR, "Unknown error");
		}
		List<UserDTO> clients = responseClients.getBody();
		if (clientsIds.size() != clients.size()) {
			throw new RestException(HttpStatus.BAD_REQUEST, "Client not found");
		}

	}

}
