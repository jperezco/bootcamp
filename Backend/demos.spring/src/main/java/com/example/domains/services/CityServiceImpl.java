package com.example.domains.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.domains.contracts.repositories.CityRepository;
import com.example.domains.contracts.services.CitiesService;
import com.example.domains.entities.City;
import com.example.exceptions.DuplicateKeyException;
import com.example.exceptions.InvalidDataException;
import com.example.exceptions.NotFoundException;

@Service
public class CityServiceImpl implements CitiesService{

private CityRepository dao;
	
	public CityServiceImpl(CityRepository dao) {
		this.dao = dao;
	}
	
	@Override
	public List<City> getAll() {
		return dao.findAll();
	}
	
	@Override
	public City getOne(Integer id) throws NotFoundException {
		var item = dao.findById(id);
		if(item.isEmpty())
			throw new NotFoundException();
		return item.get();
	}
	
	@Override
	public City add(City item) throws DuplicateKeyException, InvalidDataException {
		if(item == null)
			throw new IllegalArgumentException();
		if(dao.findById(item.getCityId()).isPresent())
			throw new DuplicateKeyException();
		if(item.isInvalid())
			throw new InvalidDataException(item.getErrorsMessage());
		return dao.save(item);
	}
	
	@Override
	public City change(City item) throws NotFoundException, InvalidDataException  {
		if(item == null)
			throw new IllegalArgumentException();
		if(dao.findById(item.getCityId()).isEmpty())
			throw new NotFoundException();
		if(item.isInvalid())
			throw new InvalidDataException(item.getErrorsMessage());
		return dao.save(item);
	}
	
	@Override
	public void delete(City item) {
		if(item == null)
			throw new IllegalArgumentException();
		deleteById(item.getCityId());
		
	}
	
	@Override
	public void deleteById(Integer id) {
		dao.deleteById(id);
	}

}
