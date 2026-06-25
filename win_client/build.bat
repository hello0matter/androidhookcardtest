@echo off
rem build.bat — compile c2sdk.dll and c2agent.exe with MinGW-w64 (gcc)
rem Requires gcc in PATH. Recommended: https://winlibs.com or MSYS2

cd /d "%~dp0src"

echo [1/2] building c2sdk.dll ...
gcc -shared -o ..\bin\c2sdk.dll c2sdk.c ^
    -lwininet -lrpcrt4 -lcredui -ladvapi32 ^
    -mwindows -O2 -s -Wall ^
    -municode
if errorlevel 1 ( echo DLL build failed & pause & exit /b 1 )

echo [2/2] building c2agent.exe ...
gcc -o ..\bin\c2agent.exe c2agent.c ^
    -lwininet -lrpcrt4 -lcredui -ladvapi32 ^
    -mwindows -O2 -s -Wall ^
    -municode
if errorlevel 1 ( echo EXE build failed & pause & exit /b 1 )

echo.
echo Build complete. Output: %~dp0bin\
echo   c2sdk.dll   -- DLL for injection / loader use
echo   c2agent.exe -- standalone background process
pause
