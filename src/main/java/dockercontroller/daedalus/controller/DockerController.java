package dockercontroller.daedalus.controller;

import java.util.Scanner;

import org.apache.log4j.Logger;

import dockercontroller.daedalus.manager.ContainerManager;

public class DockerController {
	private static ContainerManager manager = new ContainerManager();
	private Logger logger = Logger.getLogger(DockerController.class);
	private static final String EXPOSE = "8080/tcp";
	ContainerManager cm = new ContainerManager();
	
	private String inspect(String containerID) {
	    cm.inspect(containerID);
        return containerID;
	}
	
	public String create(String appID,String location) {
        cm.create(appID, location);
	    return appID;
	}

	public String stop(String containerID, Integer time) {
	    cm.stop(containerID, time);
        return null;
	}

	public String start(String containerID) {
	    cm.start(containerID);
        return null;
	}

	public String restart(String containerID, int time)  {
	    cm.restart(containerID, time);
        return containerID;
	}

	public boolean remove(String containerID) {
	    cm.remove(containerID);
        return false;
	}

	public boolean forceRemove(String containerID) {
	    cm.forceRemove(containerID);
        return false;
	}
	
	public void menu(){
	    Scanner sc = new Scanner(System.in);
	    String containerID = null;
	    String appID = null;
	    String location = null;
	    Integer time = null;
	    DockerController dc = new DockerController();
	    while(true){
	        System.out.println("1.create\n2.start\n3.stop\n4.restart\n5.remove\n6.forceRemove\n7.inspect\ninput:");
	        int m = sc.nextInt();
	        sc.nextLine();
	        switch(m){
	            case 1:
	                System.out.println("appID:");
	                appID = sc.nextLine();
	                System.out.println("location:");
	                location = sc.nextLine();
	                dc.create(appID, location);
	                break;
	            case 2:
	                System.out.println("ContainerID:");
	                containerID = sc.nextLine();
	                dc.start(containerID);
	                break;
	            case 3:
                    System.out.println("ContainerID:");
                    containerID = sc.nextLine();
                    System.out.println("time:");
                    time = sc.nextInt();
                    dc.stop(containerID, time);
                    break;
	            case 4:
                    System.out.println("ContainerID:");
                    containerID = sc.nextLine();
                    System.out.println("time:");
                    time = sc.nextInt();
                    dc.restart(containerID, time);
                    break;
	            case 5:
                    System.out.println("ContainerID:");
                    containerID = sc.nextLine();
                    dc.remove(containerID);
                    break;
	            case 6:
                    System.out.println("ContainerID:");
                    containerID = sc.nextLine();
                    dc.forceRemove(containerID);
                    break;
	            case 7:
                    System.out.println("ContainerID:");
                    containerID = sc.nextLine();
                    dc.inspect(containerID);
                    break;
                default:
                    break;
	                
	        }
	    }
	}
	public static void main(String[] args) {
        new DockerController().menu();
    }
	
}
