package com.machine.dao;

import java.util.List;
import com.machine.model.Process;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProcessDao extends JpaRepository<Process, Long> {

	@Query("SELECT p.processName FROM Process p")
	List<String> getAllProcess();

	@Query("SELECT p.processName FROM Process p where p.processId=?1")
	String getProcess(int processId);
}
