@echo off
setlocal
cd /d "%~dp0"
java -cp "bin;lib\*" src.Main %*
endlocal
