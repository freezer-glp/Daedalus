#!/bin/bash

#start Jetty
cd /root/jetty/etc
mv -f jetty.xml jetty.xml.bk
cp /root/jetty.xml /root/jetty/etc/

#mv war to jetty
cd /home

#copy the package to right location
cp ./* /root/jetty/webapps/

#make /root/jetty/webapps 777
chmod -R 777 /root/jetty/webapps
#start service
sh /root/jetty/bin/jetty.sh start

#prevent the docker from stopping
while true;do
	sleep 1000;
done
