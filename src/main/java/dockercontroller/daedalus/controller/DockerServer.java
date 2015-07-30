package dockercontroller.daedalus.controller;

import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TTransportException;


public class DockerServer implements Runnable{
	private static Logger logger = Logger.getLogger(DockerServer.class);
	public int PORT = 7923;
	
	public DockerServer() {
		try {
			InputStream in = getClass().getClassLoader().getResourceAsStream("server.properties");
			Properties property = new Properties();
			property.load(in);
			if(property.containsKey("port")) {
				String port = property.getProperty("port");
				PORT = Integer.valueOf(port);
				logger.info("set the server port:" + PORT);
			}
		} catch (Exception e) {
			logger.error("Using the default configueration. PORT:"+ PORT +
					     "Loading configuration file failed. " + e.getMessage());
		}
	}
	
	@Override
	public void run() {
//		try {
//			TServerSocket serverTransport = new TServerSocket(PORT);
//			@SuppressWarnings({ "rawtypes", "unchecked" })
//			IDockerGCService.Processor processor = new IDockerGCService.Processor(new DockerController());
//			TServer server = new TThreadPoolServer(new TThreadPoolServer.Args(serverTransport).processor(processor));
//			logger.info("Starting server on port " + PORT);
//			server.serve();
//		} catch (TTransportException e) {
//			logger.error(e.getMessage());
//		}
	}
    
    public static void main(String[] args) {        
    	new Thread(new DockerServer()).run();
    }
}
