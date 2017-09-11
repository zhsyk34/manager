#!/bin/sh

ps -aux | grep -e -jar.*supermarket\.jar$ | grep -v grep | awk '{print $2}' | xargs kill
