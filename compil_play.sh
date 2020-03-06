#!/bin/bash
FORMER=$(sed '173q;d' ../teams/robocup.dsc | awk '{print $NF}')
javac $1.java
javac subsomption/*.java
javac swarm/*.java
mv $1.class ../teams/$1.class
mv subsomption/*.class ../teams/subsomption
mv swarm/*.class ../teams/swarm
for NUM in 165 167 169 171 173
do
  sed -i "${NUM}s/$FORMER/$1/g" ../teams/robocup.dsc
done
cd ../teams
./demo
