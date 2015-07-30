package dockercontroller.daedalus.conf;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

public class CommandLineConf {
	private static Logger logger = Logger.getLogger(CommandLineConf.class);
	
	public static String DOCKER_RUN;
	public static String DOCKER_STOP;
	public static String DOCKER_START;
	public static String DOCKER_RESTART;
	public static String DOCKER_REMOVE;
	public static String DOCKER_FORCE_REMOVE;
	public static String DOCKER_INSPECT;
	
	static{
		Properties p = new Properties();
		InputStream in = CommandLineConf.class.getClassLoader().getResourceAsStream("container.properties");
		try {
			p.load(in);
			
			DOCKER_RUN = p.getProperty("DOCKER_RUN");
			logger.info("DOCKER_RUN: " + DOCKER_RUN);
			
			DOCKER_STOP = p.getProperty("DOCKER_STOP");
			logger.info("DOCKER_STOP: " + DOCKER_STOP);
			
			DOCKER_START = p.getProperty("DOCKER_START");
			logger.info("DOCKER_START: " + DOCKER_START);
			
			DOCKER_RESTART = p.getProperty("DOCKER_RESTART");
			logger.info("DOCKER_RESTART: " + DOCKER_RESTART);
			
			DOCKER_REMOVE = p.getProperty("DOCKER_REMOVE");
			logger.info("DOCKER_REMOVE: " + DOCKER_REMOVE);
			
			DOCKER_FORCE_REMOVE = p.getProperty("DOCKER_FORCE_REMOVE");
			logger.info("DOCKER_FORCE_REMOVE: " + DOCKER_FORCE_REMOVE);
			
			DOCKER_INSPECT = p.getProperty("DOCKER_INSPECT");
			logger.info("DOCKER_INSPECT: " + DOCKER_INSPECT);
			
		} catch(IOException e) {
			logger.error("init command line failed!", e);
		}
	}
}
