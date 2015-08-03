#!/bin/bash

#start Apache

#delete the old httpd pid file
httpdPidFile="/run/httpd/httpd.pid"
if [ -e $httpdPidFile ];then
	echo "remove pid file"
	rm -f $httpdPidFile
else
	echo "pid file not exist"
fi

#delete the authdigest_shm file, * present the pid 
rm -f /var/run/httpd/authdigest_shm.*

#start service
httpd

#prevent the docker from stopping
while true;do
	sleep 1000;
done
