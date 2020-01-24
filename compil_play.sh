#!/bin/bash
FORMER=$(sed '173q;d' ../teams/robocup.dsc | awk '{print $NF}')
echo $FORMER
javac $1.java
mv $1.class ../teams/$1.class
sed -i "165s/$FORMER/$1/g" ../teams/robocup.dsc
sed -i "167s/$FORMER/$1/g" ../teams/robocup.dsc
sed -i "169s/$FORMER/$1/g" ../teams/robocup.dsc
sed -i "171s/$FORMER/$1/g" ../teams/robocup.dsc
sed -i "173s/$FORMER/$1/g" ../teams/robocup.dsc
cd ../teams
./demo
