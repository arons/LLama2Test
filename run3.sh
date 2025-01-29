#!/bin/bash

JAVA=${JAVA_HOME}/bin/java

JAVA_OPTS="-client"
#Memory
JAVA_OPTS="${JAVA_OPTS} -Xms16g -Xmx32g"
#Garbage Collector
JAVA_OPTS="${JAVA_OPTS} -XX:+UseG1GC -XX:MaxGCPauseMillis=1000 -XX:InitiatingHeapOccupancyPercent=2"

${JAVA} ${JAVA_OPTS} --enable-preview --add-modules=jdk.incubator.vector -cp ./target/classes/ ch.arons.llama3.Llama3  "$@"

