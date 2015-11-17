#introduction:Jetty + MySQL 
#author: GongLingpu
#Time: 2015-10-08 
FROM centos
MAINTAINER GongLingpu gonglingpu@foxmail.com
WORKDIR /root/
RUN yum -y install java-1.7.0-openjdk-devel vim mysql
RUN yum clean all
ENV TERM linux
ENV LC_ALL en_US.UTF-8
#ADD will unpackage tar.gz automatically
ADD jetty.tar.gz /root/
RUN mv jetty* jetty
ADD jetty.xml /root/jetty.xml 
#new jetty.xml change service port to 8081
#we use 8081 here,since 8080 is used by cadvisor
EXPOSE 8081
ADD run.sh /root/run.sh
RUN chmod +777 /root/run.sh
CMD /root/run.sh
 
