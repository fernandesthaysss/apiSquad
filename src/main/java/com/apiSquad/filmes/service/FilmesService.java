package com.apiSquad.filmes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.apiSquad.filmes.models.FilmesDto;
import com.apiSquad.filmes.repository.FilmesRepository;

@Service
public class FilmesService {
	
	@Autowired
    FilmesRepository filmesRepository;
	
	/**
	 * PageRequest para passar o parâmetro Pageable que é como o Spring saberá os detalhes da paginação.
	 * @param searchTerm busca o termo
	 * @param page pagina
	 * @param size tamanho
	 * @return retorna a lista com o que contém passado no termo
	 */
    public Page<FilmesDto> search(
            String searchTerm,
            int page,
            int size) {
        PageRequest pageRequest = PageRequest.of(
                page,
                size,
                Sort.Direction.ASC,
                "nomeFilme");

        return filmesRepository.search(
                searchTerm.toLowerCase(),
                pageRequest);
    }
    
    /**
     * 
     * @return retorno todos os dados
     */

   public Page<FilmesDto> findAll() {
        int page = 0;
        int size = 10;
        PageRequest pageRequest = PageRequest.of(
                page,
                size,
                Sort.Direction.ASC,
                "nomeFilme");
        return new PageImpl<>(
        		filmesRepository.findAll(), 
                pageRequest, size);
    }

}


