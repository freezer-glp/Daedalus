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

#unpack the php source package
cd /home
cp ./* /var/www/html/ #copy the package to right location
cd /var/www/html
fileName="";
packType="";
for file in *
do 
	fileName=${file%.*};
	packType=${file##*.};
done

fullFileName=$fileName"."$packType;
case "$packType" in
	"zip" )
		unzip $fullFileName;		
	;;
	"tar" )
		tar -xf $fullFileName;
	;;
	"gz" )
		tar -zxf $fullFileName;
	;;
	#"rar" )
	#	unrar $fullFileName;
	#;;
	* )
		echo "wrong packageType "$packType >> /var/log/runsh.log;
	;;
esac

#make /var/www/html 777
chmod -R 777 /var/www/html
#start service
httpd

#prevent the docker from stopping
while true;do
	sleep 1000;
done
