package br.com.hugo.jokenpo.controller;

import java.net.URI;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.hugo.jokenpo.controller.form.JogadaForm;
import br.com.hugo.jokenpo.model.Disputa;
import br.com.hugo.jokenpo.model.Jogador;
import br.com.hugo.jokenpo.model.Resultado;
import br.com.hugo.jokenpo.model.Rodada;

@RestController
@RequestMapping("/jokenpo")
public class JokenpoController {
	
	@PostMapping
	public ResponseEntity<Map<Jogador, Resultado>> jogar(@RequestBody @Valid JogadaForm form, UriComponentsBuilder uriBuilder) {
		Rodada rodada = form.converter();	
		Rodada.setJogada(rodada);
		URI uri = uriBuilder.path("/jokenpo").buildAndExpand().toUri();
		return ResponseEntity.created(uri).body(rodada.jogar(rodada.getDisputas()));
	}
	
	@GetMapping
	public ResponseEntity<?> listar(@PageableDefault(sort="name", direction = Direction.ASC, page=0, size=10)Pageable paginacao, UriComponentsBuilder uriBuilder){
		Rodada rodada = Rodada.getJogada();
		if(rodada.getDisputas() == null){
			return ResponseEntity.badRequest().body("Nenhuma jogada registrada!");
		}
		return ResponseEntity.ok().body(rodada);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> remover(@PathVariable int id){
		Rodada rodada = Rodada.getJogada();
		
		if(rodada.getDisputas() == null){
			return ResponseEntity.badRequest().body("Nenhuma jogada registrada!");
		}
		
		boolean existeIdJogador = rodada.existeIdDisputa(id);
		if(!existeIdJogador) {
			return ResponseEntity.badRequest().body("Disputa não encontrada!");
		}
		
		Disputa disputa = rodada.getDisputa(id);
		System.out.println(disputa);
		rodada.removerDisputa(id);
		
		Rodada.setJogada(rodada);
		return ResponseEntity.ok().body(rodada);
	}
}
