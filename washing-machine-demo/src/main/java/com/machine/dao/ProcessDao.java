package com.machine.dao;

import java.util.List;

import javax.transaction.Transactional;

import com.machine.model.Process;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
@Transactional

public interface ProcessDao extends JpaRepository<Process, Long> {

	@Query("SELECT p.processName,p.processId FROM Process p")
	List<String> getAllProcess();

	@Query("SELECT p.processName FROM Process p where p.processId=?1")
	String getProcess(int processId);
	
	@Modifying
	@Query("update Process p set p.processStatus='active' where p.processId=?1")
	String setProcess(int processId);
}
