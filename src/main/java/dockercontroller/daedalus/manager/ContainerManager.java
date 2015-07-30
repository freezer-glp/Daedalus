package dockercontroller.daedalus.manager;

import org.apache.log4j.Logger;

import dockercontroller.daedalus.service.ContainerService;
import dockercontroller.daedalus.util.CommandResult;

public class ContainerManager implements ContainerService{
	Logger logger = Logger.getLogger(ContainerManager.class);
	private static final String INT_NULL = "-1";
	private static final String STRING_NULL = "";
    @Override
    public CommandResult create() {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public CommandResult stop() {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public CommandResult start() {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public CommandResult restart() {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public CommandResult remove() {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public CommandResult forceRemove() {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public CommandResult inspect() {
        // TODO Auto-generated method stub
        return null;
    }
	
}
