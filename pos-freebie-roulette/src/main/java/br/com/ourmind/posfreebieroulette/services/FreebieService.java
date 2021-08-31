package br.com.ourmind.posfreebieroulette.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import br.com.ourmind.posfreebieroulette.dto.FreebieDTO;
import br.com.ourmind.posfreebieroulette.errors.RestException;
import br.com.ourmind.posfreebieroulette.repositories.FreebieRepository;

@Service
public class FreebieService {

	@Autowired
	private FreebieRepository repository;

	private final static int SIZE_FREEBIES = 5;

	public void saveListFreebie(List<FreebieDTO> freebies) {
		this.repository.deleteAll();

		if (freebies.size() != SIZE_FREEBIES) {
			throw new RestException(HttpStatus.BAD_REQUEST, "Size freebies invalid!");
		}

		this.repository.saveAll(freebies.stream().map(item -> item.toEntity()).collect(Collectors.toList()));
	}

}
