package com.pca.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pca.domain.Matches;
import com.pca.repository.MatchesRepository;
import com.pca.service.MatchesService;

@Service
@Transactional
public class MatchesServiceImpl extends DefaultModelCrudServiceImpl<Matches, MatchesRepository>
		implements MatchesService {

	@Autowired
	private MatchesRepository matchesRepository;

	@Override
	protected MatchesRepository getRepository() {
		return matchesRepository;
	}

}
