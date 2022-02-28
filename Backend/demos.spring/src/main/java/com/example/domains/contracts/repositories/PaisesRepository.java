package com.example.domains.contracts.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.domains.entities.Country;

public interface PaisesRepository extends JpaRepository<Country, Integer>{

	//Estos métodos luego los tendremos que usar en el PaisesServiceImpl.	
	
	// Los tres métodos hacen lo mismo, pero el primero "a lo loco", el segundo ordenado
	// y el tercero paginado.
	<T> List<T> findByCountryIdIsNotNull(Class<T> type);
	<T> Iterable<T> findByCountryIdIsNotNull(Sort sort, Class<T> type);
	// Con este método pedimos todos los países ya que la Id nunca será nula.
	<T> Page<T> findByCountryIdIsNotNull(Pageable pageable, Class<T> type);
	
}
