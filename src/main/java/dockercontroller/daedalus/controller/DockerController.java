package dockercontroller.daedalus.controller;

import org.apache.log4j.Logger;

import dockercontroller.daedalus.manager.ContainerManager;

public class DockerController {
	private static ContainerManager manager = new ContainerManager();
	private Logger logger = Logger.getLogger(DockerController.class);
	private static final String EXPOSE = "8080/tcp";
	
	private String inspect(String containerID) {
        return containerID;
	}
	
	public String create() {
        return null;
	}

	public String stop() {
        return null;
	}

	public String start() {
        return null;
	}

	public String restart(String containerID, int time)  {
        return containerID;
	}

	public boolean remove( ) {
        return false;
	}

	public boolean forceRemove() {
        return false;
	}
	
}
