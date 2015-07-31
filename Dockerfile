#introduction: Apache + PHP
#author: GongLingpu
#Time: 2015-07-31 
FROM centos
MAINTAINER GongLingpu gonglingpu@foxmail.com
WORKDIR /root/
RUN yum -y install httpd php || true
RUN yum -y install mysql php-mysqlnd
RUN mkdir /var/log/httpd
RUN mkdir /var/www/
RUN mkdir /var/www/html/
ENV TERM linux
ENV LC_ALL en_US.UTF-8
ADD test.php /var/www/html/test.php
EXPOSE 80
ADD run.sh /root/run.sh
RUN chmod u+x /root/run.sh
CMD /root/run.sh
 
