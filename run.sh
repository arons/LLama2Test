#!/bin/bash

JAVA=${JAVA_HOME}/bin/java

JAVA_OPTS="-client"
#Memory
JAVA_OPTS="${JAVA_OPTS} -Xms2g -Xmx16g"
#Garbage Collector
JAVA_OPTS="${JAVA_OPTS} -XX:+UseG1GC -XX:MaxGCPauseMillis=1000 -XX:InitiatingHeapOccupancyPercent=2"

${JAVA} ${JAVA_OPTS} --enable-preview --add-modules=jdk.incubator.vector -cp ./target/classes/ ch.arons.llama.Llama2  "$@"

