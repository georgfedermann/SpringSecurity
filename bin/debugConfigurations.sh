#!/usr/bin/env bash
export MAVEN_OPTS='-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=4000'

# export MAVEN_OPTS="-Xdebug -Xnoagent -Djava.compiler=NONE -Xrunjdwp:transport=dt_socket,address=8000,server=y,suspend=n"
