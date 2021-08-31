package br.com.ourmind.posfreebieroulette.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ourmind.posfreebieroulette.dto.FreebieDTO;
import br.com.ourmind.posfreebieroulette.services.FreebieService;

@RestController
@RequestMapping(value = "/freebies")
public class FreebieController {
	
	@Autowired
	private FreebieService service;
	
	@PostMapping
	public ResponseEntity<Void> saveAllFreebies(@RequestBody List<FreebieDTO> freebies){
		this.service.saveListFreebie(freebies);
		return ResponseEntity.noContent().build();
	}

}
