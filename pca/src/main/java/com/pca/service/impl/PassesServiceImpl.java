package com.pca.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pca.domain.Passes;
import com.pca.repository.PassesRepository;
import com.pca.service.PassesService;

@Service
@Transactional
public class PassesServiceImpl extends DefaultModelCrudServiceImpl<Passes, PassesRepository> implements PassesService {

	@Autowired
	private PassesRepository passesRepository;

	@Override
	protected PassesRepository getRepository() {
		return passesRepository;
	}

}
