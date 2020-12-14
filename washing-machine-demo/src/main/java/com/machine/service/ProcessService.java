package com.machine.service;

import java.util.List;

public interface ProcessService {
	public List<String> getProcessList();

	public void setProcess(int processId);

	public String getProcess(int processId);

}
