package com.apiSquad.filmes.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.apiSquad.filmes.models.FilmesDto;

@Repository
public interface FilmesRepository extends JpaRepository<FilmesDto, Long> {
	
	FilmesDto findById(long id);
	
	/**
	 * @Query para customizar o filtro pelo nome do filme 
	 * @param searchTerm busca pelo termo
	 * @param pageable paginação
	 * @return o retorno como Page<FilmesDto> porque o Spring já implementa a paginação 
	 */
	@Query("FROM FilmesDto as " +
           "WHERE LOWER(as.nomeFilme) like %:searchTerm% " ) 
                		
     Page<FilmesDto> search(
             @Param("searchTerm") String searchTerm, 
             Pageable pageable);
    
}
	 
	
	



