package dockercontroller.daedalus.manager;

import java.awt.Container;
import java.io.IOException;

import org.apache.log4j.Logger;

import dockercontroller.daedalus.conf.CommandLineConf;
import dockercontroller.daedalus.service.ContainerService;
import dockercontroller.daedalus.util.CommandHelper;
import dockercontroller.daedalus.util.CommandResult;

public class ContainerManager implements ContainerService{
	Logger logger = Logger.getLogger(ContainerManager.class);
	private static final String INT_NULL = "-1";
	private static final String STRING_NULL = "";
	private static final Integer DEFAULT_STOP_TIME = 10;
	
    @Override
    public CommandResult create(String appID,String location) {
        
        logger.info("receive create request:appId="+appID+" location="+location);
        
        String runCmd = CommandLineConf.DOCKER_RUN;
        logger.info("basic run cmd is:"+runCmd);
        runCmd = runCmd.replace("-appID%s", appID);
        runCmd = runCmd.replace("-location%s", location);
        runCmd = runCmd.replace("-buildImage%s", new ImageManager().getPHPBuildImage());
        runCmd = runCmd.replace("-extend%s", "");
        logger.info("final runCmd is:"+runCmd);
        CommandResult result = null;
        try {
            result =  new CommandHelper().exec(runCmd);
        } catch (IOException e) {
            logger.error("execute run command failed, caused by "+ e.getMessage());
        }
        logger.info("create container done");
        return result;
    }
    @Override
    public CommandResult stop(String containerID, Integer time) {
        logger.info("receive stop request:containerID="+containerID );
        CommandResult result = null;
        if(!isEmpty(containerID)){
            if(time == null){
                time = DEFAULT_STOP_TIME;
            }
            String stopCmd = CommandLineConf.DOCKER_STOP;
            logger.info("basic stop runCMD is="+stopCmd);
            stopCmd = String.format(stopCmd,time,containerID);
            CommandHelper cmdHelper = new CommandHelper();
            try {
                result = cmdHelper.exec(stopCmd);
            } catch (IOException e) {
                logger.error("caused exception while execute stop command "+ e.getMessage());
            }
            
        }
        return result;
    }
    @Override
    public CommandResult start(String containerID) {
        logger.info("receive start container request "+containerID);
        String startCmd = CommandLineConf.DOCKER_START;
        startCmd = String.format(startCmd, containerID);
        CommandResult result = null;
        CommandHelper cmdHelper = new CommandHelper();
        try {
            result = cmdHelper.exec(startCmd);
        } catch (IOException e) {
            logger.error("caused exception while execute start command "+ e.getMessage());
        }
        return result;
    }
    @Override
    public CommandResult restart(String containerID, Integer time) {
        if(time == null)
            time = DEFAULT_STOP_TIME;
        CommandResult result = null;
        String restartCmd = CommandLineConf.DOCKER_RESTART;
        restartCmd = String.format(restartCmd, time, containerID);
        CommandHelper cmdHelper = new CommandHelper();
        try {
            result = cmdHelper.exec(restartCmd);
        } catch (IOException e) {
            logger.error("caused exception while execute restart command "+ e.getMessage());
        }
        return result;
    }
    @Override
    public CommandResult remove(String containerID) {
        String removeCmd = CommandLineConf.DOCKER_REMOVE;
        removeCmd = String.format(removeCmd, containerID);
        CommandResult result = null;
        CommandHelper cmdHelper = new CommandHelper();
        try {
            result = cmdHelper.exec(removeCmd);
        } catch (IOException e) {
            logger.error("caused exception while execute start command "+ e.getMessage());
        }
        return result;
    }
    @Override
    public CommandResult forceRemove(String containerID) {
        String forceRemoveCmd = CommandLineConf.DOCKER_FORCE_REMOVE;
        forceRemoveCmd = String.format(forceRemoveCmd, containerID);
        CommandResult result = null;
        CommandHelper cmdHelper = new CommandHelper();
        try {
            result = cmdHelper.exec(forceRemoveCmd);
        } catch (IOException e) {
            logger.error("caused exception while execute start command "+ e.getMessage());
        }
        return result;
    }
    @Override
    public CommandResult inspect(String containerID) {
        String inspectCmd = CommandLineConf.DOCKER_INSPECT;
        inspectCmd = String.format(inspectCmd, containerID);
        CommandResult result = null;
        CommandHelper cmdHelper = new CommandHelper();
        try {
            result = cmdHelper.exec(inspectCmd);
        } catch (IOException e) {
            logger.error("caused exception while execute inspect command "+ e.getMessage());
        }
        return result;
    }
    
    
    private boolean isEmpty(String str) {
        if(str == null || str.trim().equals(""))
            return true;
        else 
            return false;
    }
	public static void main(String[] args) {
	    ContainerManager cm = new ContainerManager();
	    cm.create(args[0], args[1]);
    }
   
}
