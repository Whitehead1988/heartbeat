package com.capgemini.heartbeat;

import java.net.MalformedURLException;
import java.util.logging.Logger;

import org.openqa.selenium.WebDriverException;

public class GridConnectionTesterMock extends GridConnectionTester {
	private static final Logger LOG = Logger.getLogger(GridConnectionTesterMock.class.getName());
	public boolean hubStatus = true;
	public String nodeTestResult = "TEST PASS";

	public boolean hubConnectionTest(Property property) {
		LOG.info("Mocking hub status to: " + hubStatus);
		return hubStatus;

	}

	public String nodeConnectionTest(GridProperty property, GridNode node)
			throws MalformedURLException, WebDriverException {
		LOG.info("Mocking node test result to: " + nodeTestResult);
		return nodeTestResult;
	}
}
