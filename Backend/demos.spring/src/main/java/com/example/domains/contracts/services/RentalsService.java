package com.example.domains.contracts.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.example.domains.entities.Rental;

public interface RentalsService extends ProjectionDomainService <Rental, Integer>{
	<T> List<T> getByProjection(Class<T> type);
	<T> Iterable<T> getByProjection(Sort sort, Class<T> type);
	<T> Page<T> getByProjection(Pageable pageable, Class<T> type);
}
