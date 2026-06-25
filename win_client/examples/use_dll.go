// examples/use_dll.go — Go 通过 syscall 调用 c2sdk.dll
package main

import (
	"fmt"
	"syscall"
	"time"
)

func main() {
	dll := syscall.MustLoadDLL(`bin\c2sdk.dll`)
	start := dll.MustFindProc("C2_Start")
	stop  := dll.MustFindProc("C2_Stop")

	swType, _ := syscall.BytePtrFromString("momo_pc")
	ver, _     := syscall.BytePtrFromString("1.0.0")

	// 第二个参数 kami 传 0 = NULL（服务端 auto_issue 或弹框）
	start.Call(uintptr(unsafe.Pointer(swType)), 0, uintptr(unsafe.Pointer(ver)))
	fmt.Println("C2 已启动")

	// 主程序逻辑...
	time.Sleep(99999 * time.Hour)
	stop.Call()
}
