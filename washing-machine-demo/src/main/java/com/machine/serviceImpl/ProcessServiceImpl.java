package com.machine.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.machine.dao.ProcessDao;
import com.machine.service.ProcessService;

@Service
public class ProcessServiceImpl implements ProcessService {

	@Autowired
	ProcessDao processDao;
	
	@Override
	public List<String> getProcessList() {
		return processDao.getAllProcess();
	}

	@Override
	public void setProcess(int processId) {
		 processDao.getProcess(processId);

	}

	@Override
	public String getProcess(int processId) {
		return processDao.getProcess(processId);
	}

}
