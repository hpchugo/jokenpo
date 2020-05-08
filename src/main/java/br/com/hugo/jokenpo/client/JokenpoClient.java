package br.com.hugo.jokenpo.client;

import javax.validation.Valid;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.hugo.jokenpo.controller.dto.JogadaDto;
import br.com.hugo.jokenpo.controller.form.JogadaForm;

@FeignClient("jokenpo")
public interface JokenpoClient {
	@RequestMapping(method=RequestMethod.POST, value = "/jokenpo")
	public ResponseEntity<JogadaDto> jogar(@RequestBody @Valid JogadaForm form, UriComponentsBuilder uriBuilder);
}
