package com.example.domains.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.domains.contracts.repositories.LanguageRepository;
import com.example.domains.contracts.services.LanguageService;
import com.example.domains.entities.Language;
import com.example.exceptions.DuplicateKeyException;
import com.example.exceptions.InvalidDataException;
import com.example.exceptions.NotFoundException;

@Service
public class LanguageServiceImpl implements LanguageService {
	
	private LanguageRepository dao;
	
	public LanguageServiceImpl(LanguageRepository dao) {
		this.dao = dao;
	}
	
	@Override
	public List<Language> getAll() {
		return dao.findAll();
	}
	
	@Override
	public Language getOne(Integer id) throws NotFoundException {
		var item = dao.findById(id);
		if(item.isEmpty())
			throw new NotFoundException();
		return item.get();
	}
	
	@Override
	public Language add(Language item) throws DuplicateKeyException, InvalidDataException {
		if(item == null)
			throw new IllegalArgumentException();
		if(dao.findById(item.getLanguageId()).isPresent())
			throw new DuplicateKeyException();
		if(item.isInvalid())
			throw new InvalidDataException(item.getErrorsMessage());
		return dao.save(item);
	}
	
	@Override
	public Language change(Language item) throws NotFoundException, InvalidDataException  {
		if(item == null)
			throw new IllegalArgumentException();
		if(dao.findById(item.getLanguageId()).isEmpty())
			throw new NotFoundException();
		if(item.isInvalid())
			throw new InvalidDataException(item.getErrorsMessage());
		return dao.save(item);
	}
	
	@Override
	public void delete(Language item) {
		if(item == null)
			throw new IllegalArgumentException();
		deleteById(item.getLanguageId());
		
	}
	
	@Override
	public void deleteById(Integer id) {
		dao.deleteById(id);
	}
}