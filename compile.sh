#!/bin/bash

JAVAC=${JAVA_HOME}/bin/javac
JAVA=${JAVA_HOME}/bin/java
JAR=${JAVA_HOME}/bin/jar

rm -rf target/classes
mkdir -p target/classes

find ./src/ -type f -name "*.java" > target/sources.txt

${JAVAC} --enable-preview -source 21 --add-modules=jdk.incubator.vector -sourcepath ./src/ -d ./target/classes/  @./target/sources.txt
