package nl.maartenwinkels.library.process.impl;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.junit.Test;

public class ProcessEngineStartTest {

	@Test
	public void test() {
		ProcessEngine defaultProcessEngine = ProcessEngines.getDefaultProcessEngine();
		assertThat(defaultProcessEngine, is(notNullValue()));
	}

}
