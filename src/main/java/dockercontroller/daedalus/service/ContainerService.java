package dockercontroller.daedalus.service;

import dockercontroller.daedalus.util.CommandResult;

public interface ContainerService {
	
	CommandResult create();

	
	CommandResult stop();

	CommandResult start();

	
	CommandResult restart();

	
	CommandResult remove();

	
	CommandResult forceRemove ();

	
	CommandResult inspect ();
}
