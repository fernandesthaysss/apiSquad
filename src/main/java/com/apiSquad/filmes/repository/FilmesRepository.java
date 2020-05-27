package com.apiSquad.filmes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apiSquad.filmes.models.FilmesDto;

@Repository
public interface FilmesRepository  extends JpaRepository<FilmesDto, Long>{

	FilmesDto findById(long id);
	

}
