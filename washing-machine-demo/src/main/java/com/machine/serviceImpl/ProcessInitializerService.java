package com.machine.serviceImpl;

import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.machine.dao.ProcessDao;
import com.machine.model.Process;

@Service
public class ProcessInitializerService {
	@Autowired
	ProcessDao processDao;

	@PostConstruct
	public void init() {
		List<Process> processList = Arrays.asList(new Process(101, "Washing", "SN-1234567890-123", "ABC22133"),
				new Process(102, "Squeaking", "SN-1234567890-123", "ABC22133"),
				new Process(103, "Drying", "SN-1234567890-123", "ABC22133"));
		processDao.saveAll(processList);
	}

}
