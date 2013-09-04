#!/bin/bash

dbname="dspui"
dbuser="root"
dbpswd=""

mysql -u $dbuser -p $dbpswd -e "create database if not exists $dbname default charset utf8;"


if [ "" = "$dbpswd" ]
then
	mysql -u $dbuser -e "drop database if exists $dbname;"
	mysql -u $dbuser -e "create database if not exists $dbname default charset utf8;"
	mysql -u $dbuser -e "use $dbname; set names utf8; source dspui.sql;"
	echo "source dspui.sql completed"
	for file in *sql ; do
		if [ "dspui.sql" != "$file" ] ; then
		    mysql -u $dbuser -e "use $dbname; set names utf8; source $file;"
		    echo "source $file completed"
		fi
	done
else
	mysql -u $dbuser -p $dbpswd -e "drop database if exists $dbname;"
	mysql -u $dbuser -p $dbpswd -e "create database if not exists $dbname default charset utf8;"
	mysql -u $dbuser -p $dbpswd -e "use $dbname; set names utf8; source dspui.sql;"
	echo "source dspui.sql completed"
	for file in *sql;do
		if [ "dspui.sql" != "$file" ] ; then
				mysql -u $dbuser -p $dbpswd -e "use $dbname; set names utf8; source $file;"
				echo "source $file completed"
		fi
	done
fi