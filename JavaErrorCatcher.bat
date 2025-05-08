@echo off 
chcp 1251 > nul 

set MSGTITLE=Java Error 
set MSGTEXT=Download new version of Java
set TMPSCRIPT=%TEMP%\~tmpscript.vbs 
echo msgbox "%MSGTEXT%", 16, "%MSGTITLE%" > "%TMPSCRIPT%" 
wscript "%TMPSCRIPT%" > nul 
del /F /Q "%TMPSCRIPT%" 
