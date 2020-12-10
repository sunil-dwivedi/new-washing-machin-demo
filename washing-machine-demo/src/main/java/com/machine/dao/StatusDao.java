package com.machine.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.machine.model.States;

@Transactional
public interface StatusDao extends JpaRepository<States, Long> {

	@Modifying
	@Query("update States s set s.isStart= ?1")
	void setStatus(boolean status);

	@Query("SELECT s.isStart FROM States s")
	boolean getStaus();

}
