package com.machine.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.machine.service.MachineService;
import com.machine.service.ProcessService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api")
@Api(value = "Washing-machine-api", description = "Washing Machine's Operations")
public class WashingMachinController {

	@Autowired
	MachineService machineService;

	@Autowired
	ProcessService processService;

	@ApiOperation(value = "get the washing machine state", response = String.class)
	@RequestMapping(value = "/state", method = RequestMethod.GET)
	public String getState() {
		if (machineService.getStatus()) {
			return "machin is running";
		}
		return "machin is stop please start";
	}
	@ApiOperation(value = "start washing machine", response = String.class)
	@RequestMapping(value = "/start", method = RequestMethod.GET)
	public String start() throws InterruptedException {
		if (machineService.getStatus()) {
			return "machin is already started";
		} else if (machineService.setStatus(true)) {
			return "washing machine has been started";
		}
		return "washing machine has some problem not started";
	}
	@ApiOperation(value = "stop washing machine", response = String.class)
	@RequestMapping(value = "/stop", method = RequestMethod.GET)
	public String stop() {
		if (!machineService.getStatus()) {
			return "machin is already stoped";
		} else if (machineService.setStatus(false)) {
			return "washing machine has been stopeed";
		}
		return "washing machine has some problem not stopped";
	}
	@ApiOperation(value = "set the appliance program by using process index", response = String.class)
	@RequestMapping(value = "/process", method = RequestMethod.GET)
	public String selectProcess(@RequestParam Integer processId) {
		if (!machineService.getStatus()) {
			return "machin is stoped please start first";
		}
		 processService.setProcess(processId);
		return processService.getProcess(processId);
	}
	 @ApiOperation(value = "list of all  washing-machine  programs", response = String.class)
	@RequestMapping(value = "/processes", method = RequestMethod.GET, produces = "application/json")
	public List<String> getAllProcesses() {
		if (machineService.getStatus()) {
			return processService.getProcessList();
		}
		return null;
	}

}
