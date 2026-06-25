# examples/use_dll.py — Python 通过 ctypes 调用 c2sdk.dll
import ctypes, os, time

dll = ctypes.CDLL(os.path.join(os.path.dirname(__file__), '..', 'bin', 'c2sdk.dll'))

dll.C2_Start.argtypes = [ctypes.c_char_p, ctypes.c_char_p, ctypes.c_char_p]
dll.C2_Start.restype  = ctypes.c_int
dll.C2_Stop.argtypes  = []
dll.C2_Stop.restype   = None

# 启动：software_type="momo_pc", 无卡密（服务端开了 auto_issue_card 或用户首次弹框）
dll.C2_Start(b"momo_pc", None, b"2.0.0")

# 你自己的程序逻辑在这里 ...
print("C2 已在后台运行，主程序继续...")
time.sleep(999999)

dll.C2_Stop()
