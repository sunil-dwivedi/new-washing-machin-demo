package com.machine.service;

import java.util.List;

public interface ProcessService {
	public List<String> getProcessList();

	public String getProcess(int processId);

}
