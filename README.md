# Daedalus
Daedalus is a Docker controller for PHP application deployment and management.
## Introduction
The main features of Daedalus are as follows:

 * **Create** a Docker  container with PHP environment, and deploy your PHP app to that container only need to tell Daedalus what's your app's name and the path of your PHP source code.
 * **Stop** that container if you don't need it at present.
 * **Start** a stopped container any time  you want.
 * **Restart** is provided of course.
 * **Remove** a container you don't need any more.
 * **Forceremove** a container which is not recommended.
 

##Usage
###Install Docker 
Well,first of all,you need make sure your Docker  was Installed.[get started with Docker.](https://www.docker.com/)
###Get the Docker image
You can pull image from DockerHub
> `docker pull freezerglp/centos-apache-php:v1`

or you can build the image yourself using the given Dockerfile.


###Run Daedalus
You can package the Daedals as a jar package.This project was organized by maven.You just need:
	
> `maven package`

You can get the *Dadalus-0.1-SNAPSHOT.jar* and a directory *lib* which contains the related jar packages.Then put them in the same directory and 
> `java -cp Dadalus-0.1-SNAPSHOT.jar:lib/* dockercontroller.daedalus.controller.DockerController`

then you can see the basic menu.

###Create && Deploy 
Just input the appID(app name) and the absolute path of your PHP source code.

###Stop
Just input the containerID and the time given to the container to prepare to be stop.Default time is 10s.

###Start
Just input the containrID of  the container you want to start.
###Restart
Just input the containerID and the time given to the container to prepare to be stop.Default time is 10s.

###Remove
Just input the containrID of  the container you want to remove.But you can not remove a running container using this method.
###Forceremove
Just input the containrID of  the container you want to forceremove.No matter running or stopped container can be removed.But it can cause unpredictable problem，which is not  recommended.

##TODO
Future work are as follows:

* Container search:get containerID trough appID.
* Container inspect:get more detailed info about a specific container
* Image management:manage your images.
* etc

##Feedback
Any feedback and suggestion are highly appreciated.

E-mail:gonglingpu@foxmail.com