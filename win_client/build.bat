@echo off
rem build.bat — 用 MinGW-w64 (gcc) 编译 c2sdk.dll 和 c2agent.exe
rem 需要 gcc 在 PATH 中。推荐安装：https://winlibs.com 或 MSYS2

cd /d "%~dp0src"

echo [1/2] 编译 c2sdk.dll ...
gcc -shared -o ..\bin\c2sdk.dll c2sdk.c ^
    -lwininet -lrpcrt4 -lcredui ^
    -mwindows -O2 -s -Wall ^
    -municode
if errorlevel 1 ( echo DLL 编译失败 & pause & exit /b 1 )

echo [2/2] 编译 c2agent.exe ...
gcc -o ..\bin\c2agent.exe c2agent.c ^
    -lwininet -lrpcrt4 -lcredui ^
    -mwindows -O2 -s -Wall ^
    -municode
if errorlevel 1 ( echo EXE 编译失败 & pause & exit /b 1 )

echo.
echo 编译完成！输出目录：%~dp0bin\
echo   c2sdk.dll   — 供其他程序 DLL 调用
echo   c2agent.exe — 独立后台进程，直接运行或由目标软件 Shell 启动
pause
