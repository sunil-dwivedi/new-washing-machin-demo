package com.machine.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.machine.dao.StatusDao;
import com.machine.service.MachineService;

@Service
public class MachineServiceImpl implements MachineService {
	@Autowired
	StatusDao statusDao;

	@Override
	public boolean getStatus() {
		return statusDao.getStaus();
	}

	@Override
	public boolean setStatus(boolean status) {
		 statusDao.setStatus(status);
		 return true;

	}

}