package com.machine.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Process {

	public Process(int processId, String processName, String Serial, String modelNumber, String processStatus) {
		this.processId = processId;
		this.processName = processName;
		this.Serial = Serial;
		this.modelNumber = modelNumber;
		this.processStatus = processStatus;
	}
	@Column(name = "processStatus")
	String processStatus;

	public String getProcessStatus() {
		return processStatus;
	}

	public void setProcessStatus(String processStatus) {
		this.processStatus = processStatus;
	}

	public String getModelNumber() {
		return modelNumber;
	}

	public void setModelNumber(String modelNumber) {
		this.modelNumber = modelNumber;
	}

	public String getSerial() {
		return Serial;
	}

	public void setSerial(String serial) {
		Serial = serial;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "processId")
	private int processId;
	@Column(name = "processName")
	private String processName;
	@Column(name = "modelNumber")
	private String modelNumber;
	@Column(name = "Serial")
	private String Serial;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getProcessId() {
		return processId;
	}

	public void setProcessId(int processId) {
		this.processId = processId;
	}

	public String getProcessName() {
		return processName;
	}

	public void setProcessName(String processName) {
		this.processName = processName;
	}

}
