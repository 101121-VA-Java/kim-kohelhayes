package com.kim.drivers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.kim.exceptions.*;

public class LoggingDriver {

	private static Logger log = LogManager.getRootLogger();
	
	public static void main(String[] args) {
		log.trace("This is a trace!");
		log.debug("This is a debug!");
		log.info("This is an info!");
		log.warn("This is a warning!");
		log.error("This is an error!");
		log.fatal("This is fatal!");
		
		try {
			throwAnException();
		} catch (AnException e) {
			log.error("Exception was thrown and handled: " + e.getMessage());
		}
	}

	public static void throwAnException() throws AnException {
		throw new AnException("My Exception is being thrown here");
	}
}