' examples/use_exe.vbs — VBScript / 易语言逻辑等价（Shell 启动 EXE）
' 易语言中对应：运行程序 ("c2agent.exe momo_pc  1.0", 假, 假)

Dim ws : Set ws = CreateObject("WScript.Shell")
' 参数：software_type="momo_pc"，kami 留空（auto_issue 或弹框），version="1.0"
ws.Run """c2agent.exe"" momo_pc  1.0", 0, False
' 第三个参数 False = 不等待，程序继续运行
WScript.Echo "C2 agent 已在后台启动"
