package com.machine.test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.machine.dao.ProcessDao;
import com.machine.dao.StatusDao;
import com.machine.model.Process;

@DataJpaTest
public class ServiceTest {
	@Autowired
	private ProcessDao processDao;
	@Autowired
	private StatusDao statusDao;

	@Test
	public void testsaveProcessess() {
		List<Process> processList = Arrays.asList(new Process(101, "Washing", "SN-1234567890-123", "ABC22133","inactive"),
		new Process(102, "Squeaking", "SN-1234567890-123", "ABC22133","inactive"),
		new Process(103, "Drying", "SN-1234567890-123", "ABC22133","inactive"));
		List<Process> processList1 = processDao.saveAll(processList);
		assertThat(processList1).size().isGreaterThan(0);

	}

	@Test
	public void testListStatus() {
		boolean status = statusDao.getStaus();
		assertThat(status).isTrue();
	}

	@Test
	public void testFindProductByName() {
		String product = processDao.getProcess(101);
		assertThat(product).isEqualTo("Washing");
	}

	@Test
	public void testListProducts() {
		List<String> products = processDao.getAllProcess();
		assertThat(products).size().isGreaterThan(0);
	}

	@Test
	@Rollback(false)
	public void testUpdateStatus() {
		statusDao.setStatus(true);
		boolean status = statusDao.getStaus();
		assertThat(status).isTrue();
	}

}
