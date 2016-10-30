@echo off
title MyStack
color a
javac -d bin App.java & java -cp bin App
pause > nul
exit