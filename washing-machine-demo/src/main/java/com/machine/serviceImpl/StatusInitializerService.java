package com.machine.serviceImpl;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.machine.dao.StatusDao;
import com.machine.model.States;

@Service
public class StatusInitializerService {
	@Autowired
	StatusDao statusDao;

	@PostConstruct
	public void init() {
		States status = new States(false);
		statusDao.save(status);
	}

}
