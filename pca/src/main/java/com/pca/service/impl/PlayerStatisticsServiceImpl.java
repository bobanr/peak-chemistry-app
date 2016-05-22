package com.pca.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pca.domain.PlayerStatistics;
import com.pca.repository.PlayerStatisticsRepository;
import com.pca.service.PlayerStatisticsService;

@Service
@Transactional
public class PlayerStatisticsServiceImpl extends
		DefaultModelCrudServiceImpl<PlayerStatistics, PlayerStatisticsRepository> implements PlayerStatisticsService {

	@Autowired
	private PlayerStatisticsRepository playerStatisticsRepository;
	
	@Override
	protected PlayerStatisticsRepository getRepository() {
		return playerStatisticsRepository;
	}
	
}
