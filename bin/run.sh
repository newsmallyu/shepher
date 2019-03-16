#!/bin/sh


exec java -jar lib/shepher-web-1.0.jar --spring.config.location=conf/application-base.properties,conf/application-default.properties  -Djava.ext.dirs=lib
