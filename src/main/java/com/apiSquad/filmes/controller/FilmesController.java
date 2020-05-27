package com.apiSquad.filmes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apiSquad.filmes.models.FilmesDto;
import com.apiSquad.filmes.repository.FilmesRepository;

@RestController
@RequestMapping(value="/api")
public class FilmesController {

	@Autowired
	FilmesRepository filmesRepository;

	/**
	 * Lista todos os filmes da base
	 * @return busca e trás todos os filmes
	 */
	@GetMapping("/filmes")
	public List<FilmesDto> listaFilmes(){
		return filmesRepository.findAll();
	}


	/**
	 * Lista um unico filme passando o identificador como parâmetro
	 * @param identificador
	 * @return retorna o filme conforme o identificador passado
	 */
	@GetMapping("/filmes/{identificador}")
	public FilmesDto listaUnicoFilme(@PathVariable(value="identificador")long identificador) {
		return filmesRepository.findById(identificador);
	}

	/**
	 * Método que salva um ou mais filmes
	 * @param filmes
	 * @return retorna o filme salvo
	 */
	@PostMapping("/filmes")
	public FilmesDto salvaNovosFilmes(@RequestBody FilmesDto filmes) {
		return filmesRepository.save(filmes);
	}

	/**
	 * Método que deleta um ou mais filmes
	 * @param filmes
	 */
	@DeleteMapping("/filmes")
	public void deletaFilme(@RequestBody FilmesDto filmes) {
		filmesRepository.delete(filmes);
	}

	/**
	 * Método que atualiza um ou mais filmes
	 * @param filmes
	 * @return retorna o filme atualizado
	 */
	@PutMapping("/filmes")
	public FilmesDto atualizaFilme(@RequestBody FilmesDto filmes) {
		return filmesRepository.save(filmes);
	}



}

