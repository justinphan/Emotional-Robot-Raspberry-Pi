#/usr/bin/env bash
mkdir -p ./bin
javac -d ./bin -Xlint:unchecked -classpath .:classes:lib/'*' ./src/edu/ccsu/cs417/cs417group1/groveboard/robot/*.java ./src/edu/ccsu/cs417/cs417group1/groveboard/*.java ./src/edu/ccsu/cs417/cs417group1/camera/*.java ./src/edu/ccsu/cs417/cs417group1/emotion/*.java ./src/edu/ccsu/cs417/cs417group1/twitter/*.java ./src/edu/ccsu/cs417/cs417group1/picturedetection/*.java ./src/edu/ccsu/cs417/cs417group1/*.java
