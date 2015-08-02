package dockercontroller.daedalus.service;

import dockercontroller.daedalus.util.CommandResult;

public interface ContainerService {
	
	CommandResult create(String appID,String location);

	
	CommandResult stop(String containerID, Integer time);

	CommandResult start(String containerID);

	
	CommandResult restart(String containerID,  Integer time);

	
	CommandResult remove(String containerID);

	
	CommandResult forceRemove (String containerID);

	
	CommandResult inspect (String containerID);
}
