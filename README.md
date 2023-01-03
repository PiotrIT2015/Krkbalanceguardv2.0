## BalanceGuard(system for entertainment in free time, version 2.0)

## Table of contents
* [General info](#general-info)
* [Technologies](#technologies)
* [Setup](#setup)
* [Running](#running)

## General info
This is main part of my system which can share i.e. music or mems. It'll also remind you about shopping and will communicate in other ways. It helps maintain balance i.e.in COVID-19. It should be
use with "HealthMonitor" and "Reminder". These are another project which I created. 
	
## Technologies
Project is created with:
* python version: 3.10
* Java version: 17.0.5
	
## Setup
To setup this project on Windows you must first install a Docker for Windows.

This can be do it by visit this website: https://hub.docker.com/editions/community/docker-ce-desktop-windows/

...,then install it locally using Docker(using following commands):

```
$ docker pull piotrit2015/greenroomos
$ docker container run -i -t --name GuardOS piotrit2015/greenroomos
$ cd home
$ mkdir <username>
$ cd <username>
$ git clone https://github.com/PiotrIT2015/krkbalanceguard.git
$ cd ./balanceguard
$ systemctl start docker
$ systemctl enable docker
$ docker-compose up
$ docker container run -d -p -P 80:80 nextcloud
$ docker container inspect nextcloud | grep IP
$ docker container run -d -p -P 443:443 mariadb
$ docker container inspect mariadb | grep IP
$ elinks http://<IP>:80
$ elinks http://<IP>:443  
```

How to configure Nextcloud with Apache on Ubuntu: https://www.youtube.com/watch?v=-tW3_cmGkns

## Running
To run this project(inside greenroomos container):
* run several services(they send data to mobile apps i.e.shopping list, images or youtube's links)

```
$ cd ../io.balanceguard/services/<certain-cervice>
$ mvn install
$ mvn clean install
$ mvn test
$ mvn install
$ mvn clean
$ mvn clean install
```

To use rest of project's functionalities use following commands:

* To refresh your 'galery.html' in gui package use following commands:

```
$ cd ../io.balanceguard/gui/rwdIkigaiscript
$ python main.py
```

* To scann your network use following commands:

```
$ cd ../io.balanceguard/mapper/networktools
$ python netscans.py
```


