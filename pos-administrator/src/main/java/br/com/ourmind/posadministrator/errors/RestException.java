package br.com.ourmind.posadministrator.errors;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RestException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private HttpStatus status;
	private String message;

}
