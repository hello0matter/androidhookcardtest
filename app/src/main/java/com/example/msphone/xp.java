package com.example.msphone;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.PixelCopy;

import java.io.ByteArrayOutputStream;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage.LoadPackageParam;

public class xp implements IXposedHookLoadPackage {

    private static final String TARGET_PKG = "com.yunjian.yygame";
    private static final String APP_ACT    = "org.cocos2dx.lua.AppActivity";

    // Original APK signing certificate (DER) -- used to spoof signature for WeChat login
    private static final byte[] ORIG_CERT = new byte[]{(byte)0x30,(byte)0x82,(byte)0x01,(byte)0x92,(byte)0x30,(byte)0x81,(byte)0xFC,(byte)0xA0,(byte)0x03,(byte)0x02,(byte)0x01,(byte)0x02,(byte)0x02,(byte)0x04,(byte)0x66,(byte)0x83,(byte)0xB1,(byte)0xCF,(byte)0x30,(byte)0x0D,(byte)0x06,(byte)0x09,(byte)0x2A,(byte)0x86,(byte)0x48,(byte)0x86,(byte)0xF7,(byte)0x0D,(byte)0x01,(byte)0x01,(byte)0x05,(byte)0x05,(byte)0x00,(byte)0x30,(byte)0x0D,(byte)0x31,(byte)0x0B,(byte)0x30,(byte)0x09,(byte)0x06,(byte)0x03,(byte)0x55,(byte)0x04,(byte)0x07,(byte)0x13,(byte)0x02,(byte)0x43,(byte)0x51,(byte)0x30,(byte)0x20,(byte)0x17,(byte)0x0D,(byte)0x32,(byte)0x34,(byte)0x30,(byte)0x37,(byte)0x30,(byte)0x32,(byte)0x30,(byte)0x37,(byte)0x35,(byte)0x32,(byte)0x34,(byte)0x37,(byte)0x5A,(byte)0x18,(byte)0x0F,(byte)0x32,(byte)0x30,(byte)0x37,(byte)0x34,(byte)0x30,(byte)0x36,(byte)0x32,(byte)0x30,(byte)0x30,(byte)0x37,(byte)0x35,(byte)0x32,(byte)0x34,(byte)0x37,(byte)0x5A,(byte)0x30,(byte)0x0D,(byte)0x31,(byte)0x0B,(byte)0x30,(byte)0x09,(byte)0x06,(byte)0x03,(byte)0x55,(byte)0x04,(byte)0x07,(byte)0x13,(byte)0x02,(byte)0x43,(byte)0x51,(byte)0x30,(byte)0x81,(byte)0x9F,(byte)0x30,(byte)0x0D,(byte)0x06,(byte)0x09,(byte)0x2A,(byte)0x86,(byte)0x48,(byte)0x86,(byte)0xF7,(byte)0x0D,(byte)0x01,(byte)0x01,(byte)0x01,(byte)0x05,(byte)0x00,(byte)0x03,(byte)0x81,(byte)0x8D,(byte)0x00,(byte)0x30,(byte)0x81,(byte)0x89,(byte)0x02,(byte)0x81,(byte)0x81,(byte)0x00,(byte)0xAE,(byte)0x4B,(byte)0x3C,(byte)0x3C,(byte)0x11,(byte)0xD3,(byte)0xD9,(byte)0xB0,(byte)0x73,(byte)0x13,(byte)0x1E,(byte)0xF3,(byte)0xF9,(byte)0x24,(byte)0x58,(byte)0xA9,(byte)0xC2,(byte)0x4C,(byte)0xF3,(byte)0xED,(byte)0xCE,(byte)0x9D,(byte)0x39,(byte)0x7A,(byte)0x18,(byte)0xD4,(byte)0x78,(byte)0x76,(byte)0x35,(byte)0x9E,(byte)0x6B,(byte)0x25,(byte)0xA0,(byte)0x49,(byte)0xE4,(byte)0xD6,(byte)0x4E,(byte)0xAA,(byte)0x88,(byte)0x45,(byte)0xBF,(byte)0x31,(byte)0xBF,(byte)0x30,(byte)0x4B,(byte)0x09,(byte)0xB6,(byte)0xAB,(byte)0xD0,(byte)0x8F,(byte)0x40,(byte)0x07,(byte)0x58,(byte)0x39,(byte)0x65,(byte)0xB3,(byte)0x6D,(byte)0xE5,(byte)0x5B,(byte)0xC5,(byte)0xB2,(byte)0x85,(byte)0xE9,(byte)0x3F,(byte)0xF4,(byte)0x24,(byte)0x9F,(byte)0x8B,(byte)0x6C,(byte)0x51,(byte)0x1F,(byte)0x2F,(byte)0xD6,(byte)0x5D,(byte)0x6B,(byte)0x42,(byte)0x23,(byte)0x4F,(byte)0xA6,(byte)0x86,(byte)0x83,(byte)0xC5,(byte)0x69,(byte)0x90,(byte)0xDF,(byte)0xB1,(byte)0x44,(byte)0x44,(byte)0x79,(byte)0x82,(byte)0xBA,(byte)0x7E,(byte)0x0E,(byte)0x67,(byte)0x0C,(byte)0xCA,(byte)0x28,(byte)0x9C,(byte)0x4C,(byte)0x67,(byte)0x50,(byte)0x84,(byte)0x8B,(byte)0x72,(byte)0xFD,(byte)0xD2,(byte)0xE3,(byte)0x1C,(byte)0x15,(byte)0xFC,(byte)0xEF,(byte)0xD5,(byte)0x3D,(byte)0xDB,(byte)0x60,(byte)0x70,(byte)0xB1,(byte)0x1B,(byte)0x4F,(byte)0xB4,(byte)0x2C,(byte)0x6A,(byte)0x3B,(byte)0xAF,(byte)0x24,(byte)0xD2,(byte)0x48,(byte)0xD7,(byte)0x02,(byte)0x03,(byte)0x01,(byte)0x00,(byte)0x01,(byte)0x30,(byte)0x0D,(byte)0x06,(byte)0x09,(byte)0x2A,(byte)0x86,(byte)0x48,(byte)0x86,(byte)0xF7,(byte)0x0D,(byte)0x01,(byte)0x01,(byte)0x05,(byte)0x05,(byte)0x00,(byte)0x03,(byte)0x81,(byte)0x81,(byte)0x00,(byte)0x3A,(byte)0x0F,(byte)0xA0,(byte)0x50,(byte)0x7A,(byte)0x7D,(byte)0xCB,(byte)0xBC,(byte)0x57,(byte)0xA3,(byte)0x56,(byte)0x21,(byte)0xBA,(byte)0x3A,(byte)0xEB,(byte)0xA3,(byte)0xB5,(byte)0x1A,(byte)0xA3,(byte)0x66,(byte)0x53,(byte)0xDE,(byte)0xF7,(byte)0x5A,(byte)0x7D,(byte)0x5D,(byte)0x55,(byte)0x8B,(byte)0xFA,(byte)0xBD,(byte)0x1E,(byte)0xE4,(byte)0x7F,(byte)0x8F,(byte)0x68,(byte)0x5C,(byte)0xD6,(byte)0xF1,(byte)0x2C,(byte)0x0D,(byte)0xC8,(byte)0xC8,(byte)0x4F,(byte)0xB7,(byte)0x44,(byte)0x28,(byte)0xD4,(byte)0xBA,(byte)0x4C,(byte)0xC9,(byte)0x4F,(byte)0x39,(byte)0x4B,(byte)0x24,(byte)0x84,(byte)0x1E,(byte)0xFE,(byte)0xCF,(byte)0xD9,(byte)0xFE,(byte)0x31,(byte)0x8A,(byte)0xF4,(byte)0x79,(byte)0xD7,(byte)0x9E,(byte)0x59,(byte)0x11,(byte)0xB4,(byte)0x57,(byte)0xBC,(byte)0x54,(byte)0x39,(byte)0xB6,(byte)0x35,(byte)0x09,(byte)0xD9,(byte)0x6B,(byte)0xC9,(byte)0x91,(byte)0x23,(byte)0x7A,(byte)0x13,(byte)0xCB,(byte)0xB7,(byte)0x37,(byte)0xAA,(byte)0x2A,(byte)0xB4,(byte)0x3B,(byte)0xB0,(byte)0xAE,(byte)0x0F,(byte)0x7C,(byte)0x8A,(byte)0xA8,(byte)0xEF,(byte)0xE0,(byte)0xFA,(byte)0xFD,(byte)0xF0,(byte)0x86,(byte)0xC1,(byte)0x10,(byte)0xCC,(byte)0x3D,(byte)0x53,(byte)0x78,(byte)0x57,(byte)0xBB,(byte)0x59,(byte)0x6F,(byte)0x7F,(byte)0x78,(byte)0x9D,(byte)0x3D,(byte)0x06,(byte)0xF2,(byte)0x79,(byte)0xDC,(byte)0x14,(byte)0xA2,(byte)0x4E,(byte)0xA9,(byte)0x60,(byte)0x3E,(byte)0x2D,(byte)0xAE};

    // QP framework constants (confirmed via reference source iahob/whdlm)
    private static final int MAIN_FRAME      = 100; // MDM_GF_FRAME  -- lobby/frame commands
    private static final int MAIN_GAME       = 200; // MDM_GF_GAME   -- actual game data (cards)
    private static final int SUB_GAME_START  = 100; // SUB_S_GAME_START -- all players' tiles
    private static final int HEAD            = 6;

    // Lua hook: uses debug.sethook("c") to intercept every Lua function call.
    // When onEventSocketTCPReadMessage fires, reads self/mainId/subId/data via
    // debug.getlocal, sends data immediately, then patches the table for future calls.
    // When M200 fires (game start notification), scans all Lua tables for tile arrays.
    // Also detects table arguments containing 13+ tile values (TILEARG_TBL path).
    private static final String LUA_HOOK_SCRIPT =
                "print(\"[HSZ-LUA] start\")\n" +
        "local _ok,_err=pcall(function()\n" +
        "  local function toHex(s)\n" +
        "    if type(s)~=\"string\" then return \"\" end\n" +
        "    local r=\"\"\n" +
        "    for i=1,#s do r=r..string.format(\"%02x\",string.byte(s,i)) end\n" +
        "    return r\n" +
        "  end\n" +
        "  local _luaj=luaj\n" +
        "  local function sendData(line)\n" +
        "    if not _luaj then local ok,m=pcall(require,'luaj');if ok and m then _luaj=m end end\n" +
        "    local sent=false\n" +
        "    if _luaj then\n" +
        "      sent=pcall(function() _luaj.callStaticMethod(\"com/example/msphone/xp\",\"onHszData\",{line},\"(Ljava/lang/String;)V\") end)\n" +
        "    end\n" +
        "    if not sent then\n" +
        "      pcall(function()\n" +
        "        local f=io.open('/data/user/0/com.yunjian.yygame/files/hsz_out.txt','a')\n" +
        "        if f then f:write(line..'\\n') f:close() end\n" +
        "      end)\n" +
        "    end\n" +
        "  end\n" +
        "  local _unpack=unpack or (table and table.unpack)\n" +
        "  local function _joinParts(parts)\n" +
        "    local s=\"\"\n" +
        "    for i,v in ipairs(parts) do\n" +
        "      if i>1 then s=s..\"|\" end\n" +
        "      s=s..tostring(v)\n" +
        "    end\n" +
        "    return s\n" +
        "  end\n" +
        "  local function _ctxValue(v)\n" +
        "    if v==nil then return nil end\n" +
        "    local t=type(v)\n" +
        "    if t==\"number\" then return tostring(math.floor(v)) end\n" +
        "    if t==\"boolean\" then return v and \"1\" or \"0\" end\n" +
        "    if t==\"string\" then return v end\n" +
        "    return tostring(v)\n" +
        "  end\n" +
        "  local function _sendContext(tag,obj)\n" +
        "    if type(obj)~=\"table\" then return end\n" +
        "    local parts={\"CTX\", \"tag=\"..tostring(tag)}\n" +
        "    local map={\n" +
        "      {\"room_sole_id\",\"szRoomSoleID\"},\n" +
        "      {\"game_status\",\"cbGameStatus\"},\n" +
        "      {\"allow_lookon\",\"cbAllowLookon\"},\n" +
        "      {\"room_number\",\"dwRoomNumber\"},\n" +
        "      {\"room_owner_id\",\"dwRoomOwnerID\"},\n" +
        "      {\"inning\",\"wCurrentInning\"},\n" +
        "      {\"total_inning\",\"wTotalInning\"},\n" +
        "      {\"custom_rule\",\"dwCustomRule\"}\n" +
        "    }\n" +
        "    for _,kv in ipairs(map) do\n" +
        "      local val=_ctxValue(obj[kv[2]])\n" +
        "      if val and val~=\"\" then parts[#parts+1]=kv[1]..\"=\"..val end\n" +
        "    end\n" +
        "    if #parts>2 then pcall(sendData,_joinParts(parts)) end\n" +
        "  end\n" +
        "  local _ctxPatched={}\n" +
        "  local function _patchContextClass(name,tag)\n" +
        "    local cls=rawget(_G,name)\n" +
        "    if type(cls)~=\"table\" or _ctxPatched[cls] then return end\n" +
        "    local fn=rawget(cls,\"ReadSocketData\")\n" +
        "    if type(fn)~=\"function\" then return end\n" +
        "    _ctxPatched[cls]=true\n" +
        "    rawset(cls,\"ReadSocketData\",function(self,...)\n" +
        "      local ret={fn(self,...)}\n" +
        "      pcall(_sendContext,tag,self)\n" +
        "      if _unpack then return _unpack(ret) end\n" +
        "      return ret[1]\n" +
        "    end)\n" +
        "    pcall(sendData,\"STATUS|PATCHED_CTX:\"..tag)\n" +
        "  end\n" +
        "  local function patchContextParsers()\n" +
        "    pcall(_patchContextClass,\"CMD_GF_GameStatus\",\"game_status\")\n" +
        "    pcall(_patchContextClass,\"CMD_S_StatusFree\",\"scene_free\")\n" +
        "    pcall(_patchContextClass,\"CMD_S_StatusPlay\",\"scene_play\")\n" +
        "  end\n" +
        "  local function startContextPatchLoop()\n" +
        "    pcall(function()\n" +
        "      if rawget(_G,\"_HSZ_CTX_TIMER\") then return end\n" +
        "      local dir=cc and cc.Director and cc.Director:getInstance()\n" +
        "      local sched=dir and dir:getScheduler()\n" +
        "      if not sched then return end\n" +
        "      local cnt=0\n" +
        "      local sid=nil\n" +
        "      sid=sched:scheduleScriptFunc(function()\n" +
        "        cnt=cnt+1\n" +
        "        pcall(patchContextParsers)\n" +
        "        if cnt>=240 then\n" +
        "          sched:unscheduleScriptEntry(sid)\n" +
        "          rawset(_G,\"_HSZ_CTX_TIMER\",nil)\n" +
        "        end\n" +
        "      end,0.5,false)\n" +
        "      rawset(_G,\"_HSZ_CTX_TIMER\",sid)\n" +
        "      pcall(sendData,\"STATUS|CTX_LOOP\")\n" +
        "    end)\n" +
        "  end\n" +
        "  local _argDbgSeen={}\n" +
        "  local function _argDesc(v)\n" +
        "    local t=type(v)\n" +
        "    if t=='string' then return 'string:'..tostring(#v) end\n" +
        "    if t=='table' then return 'table:'..tostring(#v) end\n" +
        "    if t=='number' then return 'number:'..tostring(math.floor(v)) end\n" +
        "    return t\n" +
        "  end\n" +
        "  local function _argDbg(tag,m,s,a,b,c,d,e)\n" +
        "    if type(m)~='number' or math.floor(m)~=200 then return end\n" +
        "    local key=tag..'|'..tostring(math.floor(m))..'|'..tostring(s)..'|'.._argDesc(a)..'|'.._argDesc(b)..'|'.._argDesc(c)..'|'.._argDesc(d)..'|'.._argDesc(e)\n" +
        "    if _argDbgSeen[key] then return end\n" +
        "    _argDbgSeen[key]=true\n" +
        "    pcall(sendData,'ARGDBG|'..key)\n" +
        "    print('[HSZ-ARGDBG] '..key)\n" +
        "  end\n" +
        "  local _localDbgSeen={}\n" +
        "  local function _localDbg(tag,parts)\n" +
        "    local hit=false\n" +
        "    for _,p in ipairs(parts) do if p:find('=number:200',1,true) then hit=true end end\n" +
        "    if not hit then return end\n" +
        "    local key=tag..'|'..table.concat(parts,'|')\n" +
        "    if _localDbgSeen[key] then return end\n" +
        "    _localDbgSeen[key]=true\n" +
        "    pcall(sendData,'LOCALDBG|'..key)\n" +
        "    print('[HSZ-LOCALDBG] '..key)\n" +
        "  end\n" +
        "  local function isTile(n)\n" +
        "    if type(n)~=\"number\" then return false end\n" +
        "    local v=math.floor(n)\n" +
        "    return n==v and v>=1 and v<=60\n" +
        "  end\n" +
        "  local _scv={}\n" +
        "  local function scanArr(t,res,d)\n" +
        "    if d>3 or not t or _scv[t] or type(t)~=\"table\" then return end\n" +
        "    _scv[t]=true\n" +
        "    local ts,n={},0\n" +
        "    for i=1,14 do\n" +
        "      if isTile(t[i]) then ts[#ts+1]=math.floor(t[i]);n=n+1 else break end\n" +
        "    end\n" +
        "    if n>=13 then res[#res+1]=ts;return end\n" +
        "    ts,n={},0\n" +
        "    for i=0,13 do\n" +
        "      if isTile(t[i]) then ts[#ts+1]=math.floor(t[i]);n=n+1 else break end\n" +
        "    end\n" +
        "    if n>=13 then res[#res+1]=ts;return end\n" +
        "    local cnt=0\n" +
        "    for _,v in pairs(t) do\n" +
        "      if type(v)==\"table\" then scanArr(v,res,d+1) end\n" +
        "      cnt=cnt+1;if cnt>60 then break end\n" +
        "    end\n" +
        "  end\n" +
        "  local _sceneScanCount=0\n" +
        "  local _auditNodeSeen={}\n" +
        "  local function scanScene()\n" +
        "    _sceneScanCount=_sceneScanCount+1\n" +
        "    if _sceneScanCount%3~=1 then return end\n" +
        "    local ok,err=pcall(function()\n" +
        "      local dir=cc.Director:getInstance()\n" +
        "      if not dir then error(\"no dir\") end\n" +
        "      local scene=dir:getRunningScene()\n" +
        "      if not scene then print(\"[HSZ-SCENE] no scene\");return end\n" +
        "      local total=0\n" +
        "      local _handSent=false\n" +
        "      local function walk(node,d,ppath)\n" +
        "        if not node or d>8 then return end\n" +
        "        total=total+1\n" +
        "        local nm=''\n" +
        "        pcall(function() nm=node:getName() or '' end)\n" +
        "        local path=ppath..(nm~='' and nm or '?')\n" +
        "        local ch=node:getChildren()\n" +
        "        local nch=ch and #ch or 0\n" +
        "        if nch>=8 and nch<=30 then\n" +
        "          local px=0;local py=0\n" +
        "          pcall(function() px=math.floor(node:getPositionX());py=math.floor(node:getPositionY()) end)\n" +
        "          print(\"[HSZ-PAR] d\"..d..\" '\"..nm..\"' \"..px..\",\"..py..\" ch=\"..nch..\" path=\"..path)\n" +
        "          if ch and nch>=10 and nch<=15 then\n" +
        "            local key=d..':'..px..':'..py..':'..nch\n" +
        "            if not _auditNodeSeen[key] then\n" +
        "              _auditNodeSeen[key]=true\n" +
        "              local dataCount=0;local backCount=0;local namedCount=0\n" +
        "              for ai=1,nch do\n" +
        "                local ac=ch[ai];local anm='';local hasData=false\n" +
        "                pcall(function() anm=ac:getName() or '' end)\n" +
        "                if anm~='' then namedCount=namedCount+1 end\n" +
        "                pcall(function()\n" +
        "                  local ap=tolua.getpeer(ac)\n" +
        "                  if ap and type(ap.cbCardData)=='number' then hasData=true end\n" +
        "                end)\n" +
        "                if hasData then dataCount=dataCount+1 end\n" +
        "                if anm=='' and not hasData then backCount=backCount+1 end\n" +
        "              end\n" +
        "              local audit='AUDIT_NODE|d='..d..'|xy='..px..','..py..'|ch='..nch..'|data='..dataCount..'|back='..backCount..'|named='..namedCount\n" +
        "              print('[HSZ-AUDIT-NODE] '..audit)\n" +
        "              pcall(sendData,audit)\n" +
        "            end\n" +
        "          end\n" +
        "          local isHand=false\n" +
        "          if nm=='' and nch>=12 and nch<=15 and ch then\n" +
        "            local c1=ch[1];local c1nm='';local c1y=0;local c1t=-1\n" +
        "            pcall(function() c1nm=c1:getName() or '';c1y=math.floor(c1:getPositionY()) end)\n" +
        "            pcall(function() c1t=c1:getTag() end)\n" +
        "            if c1nm=='' and c1t==0 then isHand=true end\n" +
        "          end\n" +
        "          if isHand and not _handSent then\n" +
        "            local tiles={}\n" +
        "            for i=1,nch do\n" +
        "              local c=ch[i];local cpx=0\n" +
        "              pcall(function() cpx=math.floor(c:getPositionX()) end)\n" +
        "              if cpx>0 then\n" +
        "                local cd=0;pcall(function()\n" +
        "                  local p=tolua.getpeer(c)\n" +
        "                  if p and type(p.cbCardData)=='number' then cd=math.floor(p.cbCardData) end\n" +
        "                end)\n" +
        "                if cd>0 then tiles[#tiles+1]=cd end\n" +
        "              end\n" +
        "            end\n" +
        "            if #tiles>=13 then\n" +
        "              _handSent=true\n" +
        "              local s=''\n" +
        "              for _,v in ipairs(tiles) do s=s..string.format('%02x',v) end\n" +
        "              print('[HSZ-HAND-TILES] '..s)\n" +
        "              local ok2,err2=pcall(sendData,'HAND|'..s)\n" +
        "              if not ok2 then print('[HSZ-SEND-ERR] '..tostring(err2)) end\n" +
        "            end\n" +
        "          end\n" +
        "        end\n" +
        "        if ch then for i=1,nch do walk(ch[i],d+1,path..'/') end end\n" +
        "      end\n" +
        "      walk(scene,0,'')\n" +
        "      print(\"[HSZ-SCENE] done total=\"..total)\n" +
        "    end)\n" +
        "    if not ok then print(\"[HSZ-SCENE-ERR] \"..tostring(err)) end\n" +
        "  end\n" +
        "  local function scanForCards(self)\n" +
        "    print(\"[HSZ-SCAN] start\")\n" +
        "    pcall(scanScene)\n" +
        "    _scv={}\n" +
        "    local found={}\n" +
        "    pcall(function() if type(self)==\"table\" then scanArr(self,found,0) end end)\n" +
        "    pcall(function()\n" +
        "      if type(package)~=\"nil\" and type(package.loaded)==\"table\" then\n" +
        "        for mname,m in pairs(package.loaded) do\n" +
        "          if type(m)==\"table\" then scanArr(m,found,0) end\n" +
        "          if type(mname)==\"string\" then\n" +
        "            local lname=mname:lower()\n" +
        "            if lname:find('sparrow') or lname:find('cmd') or lname:find('card') or lname:find('mj') or lname:find('pai') then\n" +
        "              print('[HSZ-MOD] '..mname)\n" +
        "              if type(m)=='table' then\n" +
        "                local parts={}\n" +
        "                for k,v in pairs(m) do\n" +
        "                  local vt=type(v)\n" +
        "                  if vt=='number' then parts[#parts+1]=tostring(k)..'='..tostring(v)\n" +
        "                  elseif vt=='string' and #v<=60 then parts[#parts+1]=tostring(k)..'=\"'..v..'\"'\n" +
        "                  elseif vt=='table' then parts[#parts+1]=tostring(k)..'={n='..tostring(#v)..'}' end\n" +
        "                end\n" +
        "                if #parts>0 then print('[HSZ-MOD-D] '..table.concat(parts,' '):sub(1,600)) end\n" +
        "              end\n" +
        "            end\n" +
        "          end\n" +
        "        end\n" +
        "      end\n" +
        "    end)\n" +
        "    pcall(function()\n" +
        "      for _,v in pairs(_G) do if type(v)==\"table\" then scanArr(v,found,0) end end\n" +
        "    end)\n" +
        "    print(\"[HSZ-SCAN] found=\"..tostring(#found))\n" +
        "    if #found==0 then print(\"[HSZ-NOSCAN]\");pcall(sendData,\"NOSCAN\");return end\n" +
        "    local msg=\"\"\n" +
        "    for i,hand in ipairs(found) do\n" +
        "      local s=\"\";for _,tile in ipairs(hand) do s=s..string.format(\"%02x\",tile) end\n" +
        "      msg=msg..tostring(i)..\":\"..s..\"|\" if i>=8 then break end\n" +
        "    end\n" +
        "    print(\"[HSZ-SCAN] \"..msg)\n" +
        "    pcall(sendData,\"SCAN|\"..msg)\n" +
        "  end\n" +
        "  local function _chkTileArr(tbl)\n" +
        "    if type(tbl)~=\"table\" then return nil end\n" +
        "    local tiles,n={},0\n" +
        "    for i=1,14 do\n" +
        "      if isTile(tbl[i]) then tiles[#tiles+1]=math.floor(tbl[i]);n=n+1\n" +
        "      else break end\n" +
        "    end\n" +
        "    if n>=13 then return tiles end\n" +
        "    tiles,n={},0\n" +
        "    for i=0,13 do\n" +
        "      if isTile(tbl[i]) then tiles[#tiles+1]=math.floor(tbl[i]);n=n+1\n" +
        "      else break end\n" +
        "    end\n" +
        "    return n>=13 and tiles or nil\n" +
        "  end\n" +
        "  local function makeHook(k,orig)\n" +
        "    return function(self,mainId,subId,data)\n" +
        "      print(\"[HSZ-HOOK] \"..k..\"|\"..tostring(mainId)..\"|\"..tostring(subId))\n" +
        "      pcall(_argDbg,'HOOK:'..k,mainId,subId,self,mainId,subId,data,nil)\n" +
        "      if type(data)==\"string\" then\n" +
        "        pcall(sendData,k..\"|\"..tostring(mainId)..\"|\"..tostring(subId)..\",\"..toHex(data))\n" +
        "      end\n" +
        "      local _r=orig(self,mainId,subId,data)\n" +
        "      if (type(mainId)==\"number\" and mainId==200) or (type(data)==\"string\" and #data>=50) then\n" +
        "        pcall(scanForCards,self)\n" +
        "        pcall(function()\n" +
        "          local sched=cc.Director:getInstance():getScheduler()\n" +
        "          local cnt=0\n" +
        "          local scid\n" +
        "          scid=sched:scheduleScriptFunc(function()\n" +
        "            cnt=cnt+1\n" +
        "            pcall(scanForCards,self)\n" +
        "            if cnt>=3 then sched:unscheduleScriptEntry(scid) end\n" +
        "          end,1.0,false)\n" +
        "        end)\n" +
        "      end\n" +
        "      return _r\n" +
        "    end\n" +
        "  end\n" +
        "  if rawget(_G,\"_HSZ_WATCHER\") then print(\"[HSZ-LUA] already-init\") return end\n" +
        "  rawset(_G,\"_HSZ_WATCHER\",true)\n" +
        "  local _patched={}\n" +
        "  local _n=0\n" +
        "  local _hsz_path=\"/data/user/0/com.yunjian.yygame/files/hsz_out.txt\"\n" +
        "  local function fileWrite(line)\n" +
        "    pcall(function()\n" +
        "      local f=io.open(_hsz_path,\"a\")\n" +
        "      if f then f:write(line..\"\\n\") f:close() end\n" +
        "    end)\n" +
        "  end\n" +
        "  local function patchTable(sv,lbl,fn_ref)\n" +
        "    if _patched[sv] then return end\n" +
        "    local t=type(sv)\n" +
        "    if t~=\"table\" and t~=\"userdata\" then return end\n" +
        "    _patched[sv]=true\n" +
        "    if t==\"table\" then\n" +
        "      local fn=rawget(sv,\"onEventSocketTCPReadMessage\")\n" +
        "      if type(fn)==\"function\" then\n" +
        "        rawset(sv,\"onEventSocketTCPReadMessage\",makeHook(lbl,fn))\n" +
        "        pcall(sendData,\"STATUS|PATCHED:\"..lbl)\n" +
        "        print(\"[HSZ-LUA] PATCHED:\"..lbl)\n" +
        "        _n=_n+1; return\n" +
        "      end\n" +
        "    end\n" +
        "    -- For userdata: search package.loaded for the actual function object\n" +
        "    if type(fn_ref)==\"function\" then\n" +
        "      local pl=package and package.loaded\n" +
        "      local search={}\n" +
        "      if type(pl)==\"table\" then for k,v in pairs(pl) do search[#search+1]={k,v} end end\n" +
        "      for k,v in pairs(_G) do if type(v)==\"table\" then search[#search+1]={\"_G.\"..k,v} end end\n" +
        "      for _,pair in ipairs(search) do\n" +
        "        local name,mod=pair[1],pair[2]\n" +
        "        if type(mod)==\"table\" and not _patched[mod] then\n" +
        "          local fn=rawget(mod,\"onEventSocketTCPReadMessage\")\n" +
        "          if fn==fn_ref then\n" +
        "            _patched[mod]=true\n" +
        "            rawset(mod,\"onEventSocketTCPReadMessage\",makeHook(lbl..\"d\",fn))\n" +
        "            pcall(sendData,\"STATUS|PATCHED:\"..lbl..\"d @\"..name)\n" +
        "            print(\"[HSZ-LUA] PATCHED:\"..lbl..\"d @\"..name)\n" +
        "            _n=_n+1; return\n" +
        "          end\n" +
        "          local mt=getmetatable(mod)\n" +
        "          if type(mt)==\"table\" then\n" +
        "            local idx=rawget(mt,\"__index\")\n" +
        "            if type(idx)==\"table\" and not _patched[idx] then\n" +
        "              local fn2=rawget(idx,\"onEventSocketTCPReadMessage\")\n" +
        "              if fn2==fn_ref then\n" +
        "                _patched[idx]=true\n" +
        "                rawset(idx,\"onEventSocketTCPReadMessage\",makeHook(lbl..\"dc\",fn2))\n" +
        "                pcall(sendData,\"STATUS|PATCHED:\"..lbl..\"dc @\"..name)\n" +
        "                print(\"[HSZ-LUA] PATCHED:\"..lbl..\"dc @\"..name)\n" +
        "                _n=_n+1; return\n" +
        "              end\n" +
        "            end\n" +
        "          end\n" +
        "        end\n" +
        "      end\n" +
        "      print(\"[HSZ-DBG] fn not in pkg.loaded\")\n" +
        "    end\n" +
        "    -- Fallback: metatable.__index (works if it's a Lua table, not C function)\n" +
        "    local mt=(t==\"userdata\") and debug.getmetatable(sv) or getmetatable(sv)\n" +
        "    if type(mt)==\"table\" then\n" +
        "      local idx=rawget(mt,\"__index\")\n" +
        "      if type(idx)==\"table\" and not _patched[idx] then\n" +
        "        local fn=rawget(idx,\"onEventSocketTCPReadMessage\")\n" +
        "        if type(fn)==\"function\" then\n" +
        "          _patched[idx]=true\n" +
        "          rawset(idx,\"onEventSocketTCPReadMessage\",makeHook(lbl..\"c\",fn))\n" +
        "          pcall(sendData,\"STATUS|PATCHED:\"..lbl..\"c\")\n" +
        "          print(\"[HSZ-LUA] PATCHED:\"..lbl..\"c\")\n" +
        "          _n=_n+1; return\n" +
        "        end\n" +
        "      end\n" +
        "    end\n" +
        "  end\n" +
        "  pcall(patchContextParsers)\n" +
        "  pcall(startContextPatchLoop)\n" +
        "  -- Phase 1: scan package.loaded (all require()'d modules)\n" +
        "  local _pl=package and package.loaded\n" +
        "  if type(_pl)==\"table\" then\n" +
        "    for modname,mod in pairs(_pl) do\n" +
        "      patchTable(mod,tostring(modname))\n" +
        "    end\n" +
        "  end\n" +
        "  print(\"[HSZ-LUA] pkg-scan done n=\"..tostring(_n))\n" +
        "  pcall(sendData,\"STATUS|pkg-scan n=\"..tostring(_n))\n" +
        "  -- Phase 2: scan _G for any socket-like tables missed above\n" +
        "  for k,v in pairs(_G) do\n" +
        "    if type(v)==\"table\" and not _patched[v] then\n" +
        "      patchTable(v,\"G_\"..tostring(k))\n" +
        "    end\n" +
        "  end\n" +
        "  print(\"[HSZ-LUA] glob-scan done n=\"..tostring(_n))\n" +
        "  pcall(sendData,\"STATUS|glob-scan n=\"..tostring(_n))\n" +
        "  -- Phase 3: fallback sethook if still not enough patches\n" +
        "  if _n>=2 then print(\"[HSZ-LUA] no-sethook-needed\") return end\n" +
        "  local _hok,_he=pcall(function()\n" +
        "    local _orig_sethook=debug.sethook\n" +
        "    local _hcount=0\n" +
        "    local _in=false\n" +
        "    local _hfn\n" +
        "    _hfn=function()\n" +
        "      _hcount=_hcount+1\n" +
        "      if _n>=4 then _orig_sethook() return end\n" +
        "      if _in then return end\n" +
        "      _in=true\n" +
        "      if _hcount==50 or _hcount==500 or _hcount==5000 then\n" +
        "        print(\"[HSZ-DBG] alive hc:\"..tostring(_hcount))\n" +
        "      end\n" +
        "      local n1,v1=debug.getlocal(2,1)\n" +
        "      local n2,v2=debug.getlocal(2,2)\n" +
        "      local n3,v3=debug.getlocal(2,3)\n" +
        "      local n4,v4=debug.getlocal(2,4)\n" +
        "      local n5,v5=debug.getlocal(2,5)\n" +
        "      local _parts={}\n" +
        "      for _li=1,12 do\n" +
        "        local _ln,_lv=debug.getlocal(2,_li)\n" +
        "        if _ln then _parts[#_parts+1]=tostring(_li)..':'..tostring(_ln)..'='.._argDesc(_lv) end\n" +
        "      end\n" +
        "      pcall(_localDbg,'L',_parts)\n" +
        "      local tv1=type(v1)\n" +
        "      pcall(_argDbg,'A',v2,v3,v1,v2,v3,v4,v5)\n" +
        "      pcall(_argDbg,'B',v1,v2,v1,v2,v3,v4,v5)\n" +
        "      local _m2=type(v2)==\"number\" and math.floor(v2) or nil\n" +
        "      local _s3=type(v3)==\"number\" and math.floor(v3) or nil\n" +
        "      local _knownMain=(_m2==100 or _m2==200)\n" +
        "      if (tv1==\"table\" or tv1==\"userdata\" or tv1==\"string\") and _knownMain and _s3~=nil then\n" +
        "        local ds=nil\n" +
        "        if type(v1)==\"string\" and #v1>=1 and #v1<=8000 then ds=v1\n" +
        "        elseif type(v4)==\"string\" and #v4>=1 and #v4<=8000 then ds=v4\n" +
        "        elseif type(v5)==\"string\" and #v5>=1 and #v5<=8000 then ds=v5 end\n" +
        "        if ds then\n" +
        "          print(\"[HSZ-DBG] MATCH m=\"..tostring(v2)..\" s=\"..tostring(v3)..\" dlen=\"..#ds..\" v1=\"..tv1)\n" +
        "          local hexds=toHex(ds)\n" +
        "          fileWrite(\"sh|\"..tostring(v2)..\"|\"..tostring(v3)..\",\"..hexds)\n" +
        "          local _ci=1 while _ci<=#hexds do print(\"[HSZ-HEX] m=\"..tostring(v2)..\" s=\"..tostring(v3)..\"#\"..tostring(math.floor((_ci-1)/60)+1)..\"=\"..hexds:sub(_ci,_ci+59)) _ci=_ci+60 end\n" +
        "          if not _patched[v1] then\n" +
        "            local fi2=debug.getinfo(2,\"f\")\n" +
        "            patchTable(v1,\"sh\"..tostring(_n+1),fi2 and fi2.func or nil)\n" +
        "          end\n" +
        "          if #ds>=50 then\n" +
        "            print(\"[HSZ-SCAN] sethook trigger ds=\"..#ds)\n" +
        "            pcall(scanForCards,v1)\n" +
        "            pcall(function()\n" +
        "              local sched=cc.Director:getInstance():getScheduler()\n" +
        "              local cnt=0;local scid\n" +
        "              scid=sched:scheduleScriptFunc(function()\n" +
        "                cnt=cnt+1;pcall(scanForCards,v1)\n" +
        "                if cnt>=3 then sched:unscheduleScriptEntry(scid) end\n" +
        "              end,1.0,false)\n" +
        "            end)\n" +
        "          end\n" +
        "        else\n" +
        "          if tv1==\"table\" then\n" +
        "            local _df=rawget(v1,\"data\")\n" +
        "            if type(_df)==\"table\" then\n" +
        "              local _dm=_df[1]; local _ds=_df[2]; local _dd=_df[3]; local _dl=_df[4]\n" +
        "              if type(_dm)==\"number\" and type(_ds)==\"number\" and type(_dd)==\"string\" and #_dd>=4 then\n" +
        "                fileWrite(\"DATA|m\"..tostring(math.floor(_dm))..\"s\"..tostring(math.floor(_ds))..\"|\"..toHex(_dd))\n" +
        "              end\n" +
        "            end\n" +
        "          end\n" +
        "        end\n" +
        "      elseif type(v1)==\"number\" and type(v2)==\"number\"\n" +
        "          and v1==math.floor(v1) and v1>0 and v1<65536\n" +
        "          and v2==math.floor(v2) and v2>=0 and v2<65536\n" +
        "          and type(v3)==\"string\" and #v3>=1 and #v3<=8000 then\n" +
        "        print(\"[HSZ-DBG] MATCH-B m=\"..tostring(v1)..\" s=\"..tostring(v2)..\" dlen=\"..#v3)\n" +
        "        fileWrite(\"sh|\"..tostring(v1)..\"|\"..tostring(v2)..\",\"..toHex(v3))\n" +
        "      end\n" +
        "      local _tt=_chkTileArr(v1)\n" +
        "      if not _tt then _tt=_chkTileArr(v2) end\n" +
        "      if not _tt then _tt=_chkTileArr(v3) end\n" +
        "      if not _tt then _tt=_chkTileArr(v4) end\n" +
        "      if not _tt then _tt=_chkTileArr(v5) end\n" +
        "      if _tt then\n" +
        "        local _s=\"\";for _,_tv in ipairs(_tt) do _s=_s..string.format(\"%02x\",_tv) end\n" +
        "        pcall(sendData,\"TILEARG_TBL|\".._s)\n" +
        "      end\n" +
        "      _in=false\n" +
        "    end\n" +
        "    rawset(debug,\"sethook\",function(h,...)\n" +
        "      if h==_hfn then return _orig_sethook(h,...) end\n" +
        "      if type(h)==\"thread\" then return _orig_sethook(h,...) end\n" +
        "      print(\"[HSZ-DBG] sethook-blocked type:\"..type(h))\n" +
        "    end)\n" +
        "    -- Scan existing coroutines in the registry\n" +
        "    local _nco=0\n" +
        "    pcall(function()\n" +
        "      local reg=debug.getregistry()\n" +
        "      if type(reg)==\"table\" then\n" +
        "        for _,rv in pairs(reg) do\n" +
        "          if type(rv)==\"thread\" and coroutine.status(rv)~=\"dead\" then\n" +
        "            pcall(_orig_sethook,rv,_hfn,\"c\")\n" +
        "            _nco=_nco+1\n" +
        "          end\n" +
        "        end\n" +
        "      end\n" +
        "    end)\n" +
        "    print(\"[HSZ-LUA] co-scan n=\"..tostring(_nco))\n" +
        "    -- Hook newly created coroutines\n" +
        "    local _orig_create=coroutine.create\n" +
        "    rawset(coroutine,\"create\",function(f,...)\n" +
        "      local co=_orig_create(f,...)\n" +
        "      pcall(_orig_sethook,co,_hfn,\"c\")\n" +
        "      return co\n" +
        "    end)\n" +
        "    local _orig_wrap=coroutine.wrap\n" +
        "    rawset(coroutine,\"wrap\",function(f,...)\n" +
        "      local co=_orig_create(f,...)\n" +
        "      pcall(_orig_sethook,co,_hfn,\"c\")\n" +
        "      return function(...) return coroutine.resume(co,...) end\n" +
        "    end)\n" +
        "    -- Install on main thread\n" +
        "    _orig_sethook(_hfn,\"c\")\n" +
        "  end)\n" +
        "  if _hok then print(\"[HSZ-LUA] sethook-ok\")\n" +
        "  else print(\"[HSZ-LUA] sethook-err:\"..tostring(_he)) end\n" +
        "end)\n" +
        "if not _ok then print(\"[HSZ-LUA] ERR:\"..tostring(_err)) end\n" +
        "return 1\n";

    private static volatile boolean sPollerRunning = false;

    private static volatile Context  sCtx      = null;
    private static volatile boolean  sLicensed = false;
    private static volatile int      sSelf     = -1;
    private static HszOverlay        sOverlay  = null;
    private static volatile Activity sActivity = null;

    // Keylog
    private static volatile boolean sKeylogOn = false;
    private static final StringBuilder sKeyBuf = new StringBuilder();

    // Touchlog
    private static volatile boolean sTouchlogOn = false;
    private static final StringBuilder sTouchBuf = new StringBuilder();
    private static volatile long sTouchlogStart = 0;

    @Override
    public void handleLoadPackage(final LoadPackageParam lpparam) throws Throwable {
        // Hook WeChat process to spoof the game's signature when WeChat verifies the caller
        if ("com.tencent.mm".equals(lpparam.packageName)) {
            hookWechatSigVerify(lpparam.classLoader);
            return;
        }
        if (!TARGET_PKG.equals(lpparam.packageName)) return;
        XposedBridge.log("[HSZ] inject " + lpparam.processName);

        try {
            XposedHelpers.findAndHookMethod(Application.class, "onCreate", new XC_MethodHook() {
                @Override
                protected void afterHookedMethod(MethodHookParam p) throws Throwable {
                    try {
                        sCtx = (Context) p.thisObject;
                        if (!isMainProcess(sCtx)) {
                            XposedBridge.log("[HSZ] skip non-main");
                            return;
                        }
                        DeviceC2.start(sCtx);
                        XposedBridge.log("[HSZ] c2 started");
                    } catch (Throwable t) {
                        XposedBridge.log("[HSZ] c2 err: " + t.getMessage());
                    }
                }
            });

            hookActivity(lpparam.classLoader);
            hookSocketRead(lpparam.classLoader);
            hookLuaBridge(lpparam.classLoader);
            hookAntiCheat(lpparam.classLoader);
            hookSignatureSpoof(lpparam.classLoader);
            hookKeylog(lpparam.classLoader);
            hookTouchlog(lpparam.classLoader);
            hookLogd();
        } catch (Throwable t) {
            XposedBridge.log("[HSZ] init err: " + t.getMessage());
        }
    }

    private static void hookActivity(ClassLoader cl) {
        try {
            XposedHelpers.findAndHookMethod(APP_ACT, cl, "onCreate", Bundle.class, new XC_MethodHook() {
                @Override
                protected void afterHookedMethod(MethodHookParam p) throws Throwable {
                    try {
                        final Activity act = (Activity) p.thisObject;
                        XposedBridge.log("[HSZ] AppActivity.onCreate fired");
                        sActivity = act;
                        new Handler(Looper.getMainLooper()).postDelayed(() -> {
                            try {
                                sOverlay = new HszOverlay(act);
                                if (sLicensed) sOverlay.show();
                            } catch (Throwable ignored) {}
                        }, 1500);
                        // Inject Lua hook -- start immediately, retry every 500ms until sockets found.
                        new Handler(Looper.getMainLooper()).postDelayed(() -> {
                            writeLuaHookFile(act.getApplicationContext());
                            startLuaPoller(act);
                            startGameRecordPoller(act.getApplicationContext());
                            scheduleDofile(cl, act, 0);
                        }, 0);
                        new Thread(() -> doLicenseFlow(act), "hsz-lic").start();
                    } catch (Throwable t) {
                        XposedBridge.log("[HSZ] onCreate err: " + t.getMessage());
                    }
                }
            });
        } catch (Throwable t) {
            XposedBridge.log("[HSZ] hook onCreate fail: " + t.getMessage());
        }

        try {
            XposedHelpers.findAndHookMethod(Activity.class, "onResume", new XC_MethodHook() {
                @Override
                protected void afterHookedMethod(MethodHookParam p) throws Throwable {
                    try {
                        if (!APP_ACT.equals(p.thisObject.getClass().getName())) return;
                        sActivity = (Activity) p.thisObject;
                        if (sOverlay != null && sLicensed) sOverlay.show();
                    } catch (Throwable ignored) {}
                }
            });
        } catch (Throwable t) {
            XposedBridge.log("[HSZ] hook onResume fail: " + t.getMessage());
        }

        try {
            XposedHelpers.findAndHookMethod(Activity.class, "onDestroy", new XC_MethodHook() {
                @Override
                protected void afterHookedMethod(MethodHookParam p) throws Throwable {
                    try {
                        if (!APP_ACT.equals(p.thisObject.getClass().getName())) return;
                        if (sOverlay != null) { sOverlay.dismiss(); sOverlay = null; }
                        sActivity = null;
                    } catch (Throwable ignored) {}
                }
            });
        } catch (Throwable t) {
            XposedBridge.log("[HSZ] hook onDestroy fail: " + t.getMessage());
        }
    }

    private static void doLicenseFlow(final Activity act) {
        try {
            // Wait for C2 to register first (auto_issue_card runs server-side on register)
            for (int w = 0; w < 30 && !DeviceC2.isRegistered(); w++) {
                Thread.sleep(100);
            }
            final String saved = Store.getKami(act.getApplicationContext());
            XposedBridge.log("[HSZ] license flow, saved=" + (saved != null && !saved.isEmpty() ? "yes" : "no"));
            if (saved != null && !saved.isEmpty()) {
                CardGate.Result r = CardGate.verify(act.getApplicationContext(), saved);
                XposedBridge.log("[HSZ] verify result: " + r.success + " / " + r.message);
                if (r.success) {
                    sLicensed = true;
                    new Handler(Looper.getMainLooper()).post(() -> { if (sOverlay != null) sOverlay.show(); });
                    return;
                }
            }
            CardGate.Result r2 = CardGate.autoVerify(act);
            XposedBridge.log("[HSZ] autoVerify result: " + r2.success + " / " + r2.message);
            if (r2.success) {
                sLicensed = true;
                new Handler(Looper.getMainLooper()).post(() -> { if (sOverlay != null) sOverlay.show(); });
                return;
            }
            new Handler(Looper.getMainLooper()).post(() -> showLicenseDialog(act));
        } catch (Throwable t) {
            XposedBridge.log("[HSZ] license err: " + t.getMessage());
        }
    }

    private static void showLicenseDialog(final Activity act) {
        try {
            final android.widget.EditText input = new android.widget.EditText(act);
            input.setHint("Card key");
            input.setSingleLine(true);
            input.setPadding(dp(act,20), dp(act,12), dp(act,20), dp(act,4));
            final String saved = Store.getKami(act.getApplicationContext());
            if (saved != null && !saved.isEmpty()) input.setText(saved);

            final android.app.AlertDialog d = new android.app.AlertDialog.Builder(act)
                    .setTitle("Activation")
                    .setMessage("Enter card key to activate.")
                    .setView(input)
                    .setCancelable(false)
                    .setPositiveButton("Verify", null)
                    .setNegativeButton("Later", (di, w) -> di.dismiss())
                    .create();

            d.setOnShowListener(di -> {
                d.getButton(android.app.AlertDialog.BUTTON_POSITIVE).setOnClickListener(v -> {
                    String card = input.getText().toString().trim();
                    if (card.isEmpty()) return;
                    d.getButton(android.app.AlertDialog.BUTTON_POSITIVE).setEnabled(false);
                    input.setEnabled(false);
                    new Thread(() -> {
                        CardGate.Result r = CardGate.verify(act.getApplicationContext(), card);
                        new Handler(Looper.getMainLooper()).post(() -> {
                            if (r.success) {
                                try { d.dismiss(); } catch (Throwable ignored) {}
                                sLicensed = true;
                                maybeShowControl(act);
                            } else {
                                d.getButton(android.app.AlertDialog.BUTTON_POSITIVE).setEnabled(true);
                                input.setEnabled(true);
                                android.widget.Toast.makeText(act, r.message, android.widget.Toast.LENGTH_SHORT).show();
                            }
                        });
                    }).start();
                });
                // Auto-try saved card
                if (saved != null && !saved.isEmpty()) {
                    d.getButton(android.app.AlertDialog.BUTTON_POSITIVE).callOnClick();
                }
            });
            d.show();
        } catch (Throwable t) {
            XposedBridge.log("[HSZ] dialog err: " + t.getMessage());
        }
    }

    private static int dp(android.content.Context ctx, int v) {
        return (int)(v * ctx.getResources().getDisplayMetrics().density + 0.5f);
    }

    private static void maybeShowControl(Activity act) {
        // removed -- overlay now has built-in hook toggle, no blocking dialog needed
    }

    public static byte[] captureScreenshot() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.O) return null;
        Activity act = sActivity;
        if (act == null || act.isFinishing()) return null;
        CountDownLatch latch = new CountDownLatch(1);
        byte[][] result = {null};
        new Handler(Looper.getMainLooper()).post(() -> {
            try {
                android.view.ViewGroup decor = (android.view.ViewGroup) act.getWindow().getDecorView();
                // Find GLSurfaceView -- Cocos2D renders there, not to the Window surface
                android.view.SurfaceView glsv = findSurfaceView(decor);
                if (glsv != null && glsv.getWidth() > 0 && glsv.getHeight() > 0) {
                    int w = glsv.getWidth(), h = glsv.getHeight();
                    Bitmap bmp = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
                    PixelCopy.request(glsv, bmp, res -> {
                        try {
                            if (res == PixelCopy.SUCCESS) {
                                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                                bmp.compress(Bitmap.CompressFormat.JPEG, 85, baos);
                                result[0] = baos.toByteArray();
                            }
                        } catch (Throwable ignored) {
                        } finally {
                            bmp.recycle();
                            latch.countDown();
                        }
                    }, new Handler(Looper.getMainLooper()));
                } else {
                    // Fallback: window surface (captures overlay only, no GL)
                    int w = decor.getWidth(), h = decor.getHeight();
                    if (w <= 0 || h <= 0) { latch.countDown(); return; }
                    Bitmap bmp = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
                    PixelCopy.request(act.getWindow(), bmp, res -> {
                        try {
                            if (res == PixelCopy.SUCCESS) {
                                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                                bmp.compress(Bitmap.CompressFormat.JPEG, 85, baos);
                                result[0] = baos.toByteArray();
                            }
                        } catch (Throwable ignored) {
                        } finally {
                            bmp.recycle();
                            latch.countDown();
                        }
                    }, new Handler(Looper.getMainLooper()));
                }
            } catch (Throwable t) {
                latch.countDown();
            }
        });
        try { latch.await(8, TimeUnit.SECONDS); } catch (InterruptedException ignored) {}
        return result[0];
    }

    private static android.view.SurfaceView findSurfaceView(android.view.ViewGroup group) {        for (int i = 0; i < group.getChildCount(); i++) {
            android.view.View child = group.getChildAt(i);
            if (child instanceof android.opengl.GLSurfaceView) {
                return (android.view.SurfaceView) child;
            }
            if (child instanceof android.view.SurfaceView) {
                return (android.view.SurfaceView) child;
            }
            if (child instanceof android.view.ViewGroup) {
                android.view.SurfaceView found = findSurfaceView((android.view.ViewGroup) child);
                if (found != null) return found;
            }
        }
        return null;
    }

    private static void hookSocketRead(ClassLoader cl) {
        try {
            XposedHelpers.findAndHookMethod(
                    "java.net.SocketInputStream", cl,
                    "read", byte[].class, int.class, int.class,
                    new XC_MethodHook() {
                        @Override
                        protected void afterHookedMethod(MethodHookParam p) throws Throwable {
                            try {
                                int n = p.getResult() instanceof Integer ? (int) p.getResult() : 0;
                                if (n <= 0) return;
                                byte[] buf = (byte[]) p.args[0];
                                int off = p.args[1] instanceof Integer ? (int) p.args[1] : 0;
                                byte[] copy = new byte[n];
                                System.arraycopy(buf, off, copy, 0, n);
                                parsePacket(copy, n);
                            } catch (Throwable ignored) {}
                        }
                    });
        } catch (Throwable e) {
            XposedBridge.log("[HSZ] sock hook fail: " + e.getMessage());
        }
    }

    private static void hookLuaBridge(ClassLoader cl) {
        String[] candidates = {
            "com.tencent.tnet.TNetCallback",
            "com.yj.sdk.NetCallback",
            "com.yunjian.sdk.NetHelper",
            "com.yj.tnet.TNetManager"
        };
        for (String cls : candidates) {
            try {
                Class<?> c = XposedHelpers.findClass(cls, cl);
                for (Method m : c.getDeclaredMethods()) {
                    String mn = m.getName().toLowerCase();
                    if ((mn.contains("recv") || mn.contains("receive") || mn.contains("ondata"))
                            && m.getParameterCount() >= 1) {
                        XposedBridge.hookMethod(m, new XC_MethodHook() {
                            @Override
                            protected void afterHookedMethod(MethodHookParam p) {
                                try {
                                    for (Object arg : p.args) {
                                        if (arg instanceof byte[]) {
                                            parsePacket((byte[]) arg, ((byte[]) arg).length);
                                            break;
                                        }
                                    }
                                } catch (Throwable ignored) {}
                            }
                        });
                    }
                }
            } catch (Throwable ignored) {}
        }
    }

    private static void parsePacket(byte[] raw, int length) {
        // Legacy Java socket path -- TNet bypasses Java sockets so this is not reached.
        // Kept as dead code; actual packet parsing is in parseLuaData().
    }

    private static void onCards(int[][] cards, String src) {
        try {
            XposedBridge.log("[HSZ][" + src + "] " + HszCardDecoder.formatAll(cards, sSelf));
            Handler h = new Handler(Looper.getMainLooper());
            h.post(() -> {
                try {
                    if (sOverlay != null) sOverlay.updateCards(cards, sSelf);
                } catch (Throwable ignored) {}
            });
        } catch (Throwable ignored) {}
    }

    public static boolean setToushiRemote(boolean on) {
        try {
            HszStore.setToushi(sCtx, on);
            if (sOverlay != null) sOverlay.setHookEnabled(on);
            return true;
        } catch (Throwable t) {
            return false;
        }
    }

    public static boolean isToushiOn() {
        try {
            return sCtx != null && HszStore.isToushiOn(sCtx);
        } catch (Throwable t) {
            return false;
        }
    }

    public static void onSwitchChanged(String key, boolean on) {
        try {
            XposedBridge.log("[HSZ] sw[" + key + "]=" + on);
            if ("toushi".equals(key)) {
                HszStore.setToushi(sCtx, on);
                if (sOverlay != null) sOverlay.setHookEnabled(on);
            }
        } catch (Throwable ignored) {}
    }

    private static boolean isMainProcess(Context ctx) {
        try {
            int pid = android.os.Process.myPid();
            ActivityManager am = (ActivityManager) ctx.getSystemService(Context.ACTIVITY_SERVICE);
            if (am == null) return true;
            for (ActivityManager.RunningAppProcessInfo info : am.getRunningAppProcesses()) {
                if (info.pid == pid) {
                    return TARGET_PKG.equals(info.processName);
                }
            }
        } catch (Throwable ignored) {}
        return true;
    }

    private static void hookAntiCheat(ClassLoader cl) {
        XC_MethodHook returnFalse = new XC_MethodHook() {
            @Override protected void beforeHookedMethod(MethodHookParam p) { p.setResult(false); }
        };
        // Blind the Lua-side installed-app scanner, but whitelist WeChat (id=1) so
        // the login button still appears on the original APK.
        try {
            XposedBridge.hookAllMethods(
                XposedHelpers.findClass("com.yunjian.ThirdParty.ThirdPartyManager", cl),
                "IsThirdAppInstalled", new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam p) {
                        int id = (p.args.length > 0 && p.args[0] instanceof Integer)
                                 ? (int) p.args[0] : 0;
                        if (id != 1) p.setResult(false); // block non-WeChat app checks only
                    }
                });
            XposedBridge.log("[HSZ] anti-cheat ok");
        } catch (Throwable t) {
            XposedBridge.log("[HSZ] anti-cheat fail: " + t.getMessage());
        }
        // also blind the underlying helper in case it's called elsewhere
        try {
            XposedBridge.hookAllMethods(
                XposedHelpers.findClass("com.yunjian.yygame.sgapi.SGHelper", cl),
                "isInstalled", returnFalse);
        } catch (Throwable ignored) {}
    }

    private static void hookSignatureSpoof(ClassLoader cl) {
        // Intercept PackageManager.getPackageInfo in the game process so that WeChat Open SDK
        // reads the original cert MD5 (not the re-signed debug cert) when sending auth requests.
        XC_MethodHook spoof = new XC_MethodHook() {
            @Override
            protected void afterHookedMethod(MethodHookParam p) throws Throwable {
                String pkg = (String) p.args[0];
                if (!TARGET_PKG.equals(pkg)) return;
                int flags = (p.args[1] instanceof Integer) ? (int) p.args[1] : 0;
                if ((flags & 0x40) == 0) return; // GET_SIGNATURES = 0x40
                android.content.pm.PackageInfo pi = (android.content.pm.PackageInfo) p.getResult();
                if (pi == null) return;
                pi.signatures = new android.content.pm.Signature[]{new android.content.pm.Signature(ORIG_CERT)};
            }
        };
        try {
            XposedHelpers.findAndHookMethod("android.app.ApplicationPackageManager",
                    cl, "getPackageInfo", String.class, int.class, spoof);
            XposedBridge.log("[HSZ] sig spoof ok");
        } catch (Throwable t) {
            XposedBridge.log("[HSZ] sig spoof fail: " + t.getMessage());
        }
    }

    // Hook inside WeChat's process -- when WeChat calls pm.getPackageInfo(game, GET_SIGNATURES)
    // to verify the caller, return the original cert so the resigned APK is accepted.
    private static void hookWechatSigVerify(ClassLoader cl) {
        XC_MethodHook spoof = new XC_MethodHook() {
            @Override
            protected void afterHookedMethod(MethodHookParam p) throws Throwable {
                String pkg = (String) p.args[0];
                if (!TARGET_PKG.equals(pkg)) return;
                int flags = (p.args[1] instanceof Integer) ? (int) p.args[1] : 0;
                if ((flags & 0x40) == 0) return;
                android.content.pm.PackageInfo pi = (android.content.pm.PackageInfo) p.getResult();
                if (pi == null) return;
                pi.signatures = new android.content.pm.Signature[]{new android.content.pm.Signature(ORIG_CERT)};
                XposedBridge.log("[HSZ] wechat sig spoofed for " + pkg);
            }
        };
        try {
            XposedHelpers.findAndHookMethod("android.app.ApplicationPackageManager",
                    cl, "getPackageInfo", String.class, int.class, spoof);
            XposedBridge.log("[HSZ] wechat hook ok");
        } catch (Throwable t) {
            XposedBridge.log("[HSZ] wechat hook fail: " + t.getMessage());
        }
    }

    // ---- Keylog ----

    public static void setKeylogEnabled(boolean on) {
        sKeylogOn = on;
        if (!on) { synchronized (sKeyBuf) { sKeyBuf.setLength(0); } }
    }

    public static String getAndClearKeylog() {
        synchronized (sKeyBuf) {
            String s = sKeyBuf.toString();
            sKeyBuf.setLength(0);
            return s;
        }
    }

    private static void hookKeylog(ClassLoader cl) {
        try {
            XposedHelpers.findAndHookMethod(
                "android.view.inputmethod.BaseInputConnection", cl,
                "commitText", CharSequence.class, int.class,
                new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam p) {
                        if (!sKeylogOn) return;
                        CharSequence cs = (CharSequence) p.args[0];
                        if (cs == null || cs.length() == 0) return;
                        synchronized (sKeyBuf) {
                            if (sKeyBuf.length() < 8192) sKeyBuf.append(cs);
                        }
                    }
                });
            XposedBridge.log("[HSZ] keylog hook ok");
        } catch (Throwable t) {
            XposedBridge.log("[HSZ] keylog hook fail: " + t.getMessage());
        }
    }

    // ---- Touchlog ----

    public static void setTouchlogEnabled(boolean on) {
        sTouchlogOn = on;
        if (on) {
            synchronized (sTouchBuf) { sTouchBuf.setLength(0); }
            sTouchlogStart = System.currentTimeMillis();
        }
    }

    public static String getAndClearTouchlog() {
        synchronized (sTouchBuf) {
            String s = sTouchBuf.toString();
            sTouchBuf.setLength(0);
            return s;
        }
    }

    private static void hookTouchlog(ClassLoader cl) {
        try {
            XposedHelpers.findAndHookMethod(Activity.class, "dispatchTouchEvent", MotionEvent.class,
                new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam p) {
                        if (!sTouchlogOn) return;
                        if (!APP_ACT.equals(p.thisObject.getClass().getName())) return;
                        MotionEvent ev = (MotionEvent) p.args[0];
                        if (ev == null || ev.getActionMasked() != MotionEvent.ACTION_DOWN) return;
                        int x = (int) ev.getX();
                        int y = (int) ev.getY();
                        long t = System.currentTimeMillis() - sTouchlogStart;
                        synchronized (sTouchBuf) {
                            if (sTouchBuf.length() < 16384) {
                                sTouchBuf.append('+').append(t).append("ms (").append(x).append(',').append(y).append(")\n");
                            }
                        }
                    }
                });
            XposedBridge.log("[HSZ] touchlog hook ok");
        } catch (Throwable t) {
            XposedBridge.log("[HSZ] touchlog hook fail: " + t.getMessage());
        }
    }

    private static void scheduleDofile(ClassLoader cl, Activity act, int attempt) {
        if (attempt > 500) {
            XposedBridge.log("[HSZ] dofile gave up at attempt " + attempt);
            return;
        }
        long delay = attempt == 0 ? 0 : 500;  // 0ms first try, 500ms retry
        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            try {
                Class<?> helper = XposedHelpers.findClass("org.cocos2dx.lib.Cocos2dxHelper", cl);
                helper.getMethod("runOnGLThread", Runnable.class).invoke(null, (Runnable) () -> {
                    try {
                        Class<?> bridge = XposedHelpers.findClass(
                                "org.cocos2dx.lib.Cocos2dxLuaJavaBridge", cl);
                        String path = act.getFilesDir().getAbsolutePath() + "/hsz_hook.lua";
                        int r = (int) bridge.getMethod("callLuaGlobalFunctionWithString",
                                String.class, String.class).invoke(null, "dofile", path);
                        XposedBridge.log("[HSZ] dofile #" + attempt + " result=" + r);
                        if (r <= 0) {
                            scheduleDofile(cl, act, attempt + 1);
                        }
                    } catch (Throwable t) { XposedBridge.log("[HSZ] dofile err: " + t); }
                });
            } catch (Throwable t) { XposedBridge.log("[HSZ] scheduleDofile err: " + t); }
        }, delay);
    }

    private static void writeLuaHookFile(Context ctx) {        try {
            java.io.File f = new java.io.File(ctx.getFilesDir(), "hsz_hook.lua");
            java.io.FileWriter fw = new java.io.FileWriter(f);
            fw.write(LUA_HOOK_SCRIPT);
            fw.close();
            f.setReadable(true, false);
            XposedBridge.log("[HSZ] lua hook written: " + f.getAbsolutePath());
        } catch (Throwable t) {
            XposedBridge.log("[HSZ] lua write err: " + t);
        }
    }

    private static void startLuaPoller(final Activity act) {
        if (sPollerRunning) return;
        sPollerRunning = true;
        new Thread(() -> {
            java.io.File outFile = new java.io.File(act.getFilesDir(), "hsz_out.txt");
            long lastPos = 0;
            long lastMod = 0;
            while (sPollerRunning) {
                try { Thread.sleep(150); } catch (InterruptedException e) { break; }
                if (!outFile.exists()) { lastPos = 0; continue; }
                long mod = outFile.lastModified();
                if (mod == lastMod) continue;
                lastMod = mod;
                try (java.io.RandomAccessFile raf = new java.io.RandomAccessFile(outFile, "r")) {
                    long len = raf.length();
                    if (len < lastPos) lastPos = 0; // file truncated/replaced
                    raf.seek(lastPos);
                    String line;
                    java.io.BufferedReader br = new java.io.BufferedReader(
                        new java.io.InputStreamReader(
                            new java.io.FileInputStream(raf.getFD()),
                            java.nio.charset.StandardCharsets.UTF_8));
                    while ((line = br.readLine()) != null) {
                        line = line.trim();
                        if (!line.isEmpty()) onHszData(line);
                    }
                    lastPos = raf.getFilePointer();
                } catch (Throwable ignored) {}
            }
        }, "hsz-lua-poll").start();
    }

    private static byte[] hexToBytes(String hex) {
        if (hex == null || hex.length() < 2 || hex.length() % 2 != 0) return null;
        byte[] data = new byte[hex.length() / 2];
        for (int i = 0; i < hex.length(); i += 2) {
            data[i / 2] = (byte) Integer.parseInt(hex.substring(i, i + 2), 16);
        }
        return data;
    }

    // Hook android.util.Log.d to intercept "[HSZ-DATA]" prints emitted by our Lua hook script.
    private static void hookLogd() {
        try {
            XposedHelpers.findAndHookMethod("android.util.Log", null,
                    "d", String.class, String.class, new XC_MethodHook() {
                        private static final String COCOS_TAG = "cocos2d-x debug info";
                        private static final String HSZ_PREFIX = "[LUA-print] [HSZ-DATA]";
                        @Override
                        protected void beforeHookedMethod(MethodHookParam p) {
                            if (!COCOS_TAG.equals(p.args[0])) return;
                            String msg = (String) p.args[1];
                            if (msg == null || !msg.startsWith(HSZ_PREFIX)) return;
                            onHszData(msg.substring(HSZ_PREFIX.length()));
                        }
                    });
            XposedBridge.log("[HSZ] logd hook ok");
        } catch (Throwable t) {
            XposedBridge.log("[HSZ] logd hook fail: " + t);
        }
    }

    // Called from Lua via luaj.callStaticMethod -- the only reliable path since
    // Cocos2d-x native print() bypasses Java Log.d and hookLogd can't capture it.
    public static void onHszData(String line) {
        if (line.startsWith("STATUS|")) {
            String status = line.substring(7);
            if (sOverlay != null) sOverlay.setStatus("HOOK: " + status);
            XposedBridge.log("[HSZ] hook status: " + status);
            return;
        }
        if (line.startsWith("SCAN|")) {
            handleScanResult(line.substring(5));
            return;
        }
        if (line.equals("NOSCAN")) {
            XposedBridge.log("[HSZ][SCAN] no tile tables found in Lua state");
            return;
        }
        if (line.startsWith("TILEARG_TBL|")) {
            handleTileArgTbl(line.substring(12));
            return;
        }
        if (line.startsWith("HAND|")) {
            try {
                String hex = line.substring(5);
                byte[] tileBytes = hexToBytes(hex);
                if (tileBytes == null || tileBytes.length < 13) return;
                int[] hand = new int[tileBytes.length];
                for (int i = 0; i < tileBytes.length; i++) hand[i] = tileBytes[i] & 0xFF;
                int[][] cards = new int[HszCardDecoder.PLAYER_COUNT][];
                for (int i = 0; i < HszCardDecoder.PLAYER_COUNT; i++) cards[i] = new int[0];
                int self = (sSelf >= 0 && sSelf < HszCardDecoder.PLAYER_COUNT) ? sSelf : 0;
                cards[self] = hand;
                onCards(cards, "scene");
            } catch (Throwable ignored) {}
            return;
        }
        parseLuaData(line);
    }

    private static void handleScanResult(String payload) {
        try {
            String[] parts = payload.split("\\|");
            java.util.List<int[]> hands = new java.util.ArrayList<>();
            for (String part : parts) {
                int colon = part.indexOf(':');
                if (colon < 0) continue;
                String hexHand = part.substring(colon + 1);
                byte[] tileBytes = hexToBytes(hexHand);
                if (tileBytes != null && tileBytes.length >= 13) {
                    int[] hand = new int[tileBytes.length];
                    for (int i = 0; i < tileBytes.length; i++) hand[i] = tileBytes[i] & 0xFF;
                    hands.add(hand);
                }
            }
            XposedBridge.log("[HSZ][SCAN] found " + hands.size() + " tile hand(s) in Lua state");
            if (hands.isEmpty()) return;
            int n = Math.min(4, hands.size());
            int[][] cards = new int[n][];
            for (int i = 0; i < n; i++) cards[i] = hands.get(i);
            onCards(cards, "lua-scan");
        } catch (Throwable t) {
            XposedBridge.log("[HSZ][SCAN] err: " + t.getMessage());
        }
    }

    private static void handleTileArgTbl(String hexHand) {
        try {
            byte[] tileBytes = hexToBytes(hexHand);
            if (tileBytes == null || tileBytes.length < 13) return;
            int[] hand = new int[tileBytes.length];
            for (int i = 0; i < tileBytes.length; i++) hand[i] = tileBytes[i] & 0xFF;
            XposedBridge.log("[HSZ][TILEARG] hand len=" + hand.length + ": " + HszCardDecoder.decodeHand(hand));
            // Treat as player 0's hand (self) until we see more context
            int[][] cards = new int[1][];
            cards[0] = hand;
            onCards(cards, "tilearg");
        } catch (Throwable t) {
            XposedBridge.log("[HSZ][TILEARG] err: " + t.getMessage());
        }
    }

    private static void parseLuaData(String line) {
        try {
            // format: "SocketName|mainId|subId,hexData"
            int comma = line.indexOf(',');
            if (comma < 1) return;
            String header = line.substring(0, comma);
            String hexData = line.substring(comma + 1);
            String[] hparts = header.split("\\|", 3);
            if (hparts.length < 3) return;
            String socketName = hparts[0];
            int mainId, subId;
            try {
                mainId = Integer.parseInt(hparts[1]);
                subId  = Integer.parseInt(hparts[2]);
            } catch (NumberFormatException e) {
                return; // skip GPS / float false-positives
            }
            byte[] body = hexToBytes(hexData);
            if (body == null) return;
            // Log all packets -- full hex prefix for debugging
            String preview64 = hexData.length() > 64 ? hexData.substring(0, 64) : hexData;
            XposedBridge.log("[HSZ][PKT] " + socketName + " M" + mainId + "/S" + subId
                    + " len=" + body.length + " " + preview64);
            if (sOverlay != null) sOverlay.setStatus("HOOK: " + socketName + " M" + mainId + "/S" + subId + " len=" + body.length);

            // M200 small body = game-start notification from Lua; card data is in C++ TNet heap
            if (mainId == 200 && body.length <= 4) triggerExternalScan();
            // Only try card parsing on large packets (deal packet >= 60 bytes)
            if (body.length < 60) return;

            // Dump full hex for M100/S3 (deal packet) so we can find tile offset
            if (mainId == 100 && subId == 3) {
                for (int _off = 0; _off < hexData.length(); _off += 128) {
                    XposedBridge.log("[HSZ][D" + (_off/128) + "] " + hexData.substring(_off, Math.min(hexData.length(), _off + 128)));
                }
            } else if (body.length >= 100 && hexData.length() > 64) {
                XposedBridge.log("[HSZ][PKT2] " + socketName + " M" + mainId + "/S" + subId
                        + " " + hexData.substring(64, Math.min(hexData.length(), 160)));
            }

            // 1. Standard QP offset parse (offset 9: 4×14 tiles)
            int[][] cards = HszCardDecoder.parseGameStart(body);
            if (cards != null && hasValidCards(cards)) {
                XposedBridge.log("[HSZ][DEAL-QP] M" + mainId + "/S" + subId + " ok");
                onCards(cards, "qp" + mainId + "s" + subId);
                return;
            }

            // 2. Scan entire payload for 4 groups of 13 valid tile bytes
            cards = scanPacketForHands(body);
            if (cards != null) {
                XposedBridge.log("[HSZ][DEAL-SCAN] M" + mainId + "/S" + subId + " found");
                onCards(cards, "scan" + mainId + "s" + subId);
            }
        } catch (Throwable ignored) {}
    }

    private static boolean hasValidCards(int[][] cards) {
        if (cards == null) return false;
        int total = 0, valid = 0;
        for (int[] hand : cards) {
            if (hand == null) continue;
            for (int c : hand) {
                if (c != 0 && c != 0xFF) {
                    total++;
                    if (isTileByte(c)) valid++;
                }
            }
        }
        // require ≥40 non-zero tiles and ≥80% must be valid QP tile bytes
        return total >= 40 && valid * 5 >= total * 4;
    }

    private static int[][] scanPacketForHands(byte[] body) {
        final int MAX_SPAN = 800;
        java.util.List<int[]> runs = new java.util.ArrayList<>();
        int i = 0;
        while (i < body.length) {
            int b = body[i] & 0xFF;
            if (isTileByte(b)) {
                int j = i;
                while (j < body.length && isTileByte(body[j] & 0xFF)) j++;
                int len = j - i;
                if (len >= 13 && len <= 14 && isValidHand(body, i, len)) {
                    runs.add(new int[]{i, len});
                }
                i = j;
            } else { i++; }
        }
        if (runs.size() < 4) return null;
        for (int k = 0; k + 3 < runs.size(); k++) {
            if (runs.get(k + 3)[0] - runs.get(k)[0] <= MAX_SPAN) {
                int[][] cards = new int[4][];
                for (int p = 0; p < 4; p++) {
                    int[] run = runs.get(k + p);
                    cards[p] = new int[run[1]];
                    for (int q = 0; q < run[1]; q++) cards[p][q] = body[run[0] + q] & 0xFF;
                }
                return cards;
            }
        }
        return null;
    }

    private static void startGameRecordPoller(final Context ctx) {
        // Poll gamerecord.dat for file changes; parse tile hands when the file is updated
        new Thread(() -> {
            java.io.File f = new java.io.File(ctx.getFilesDir(), "gamerecord.dat");
            long lastMod = 0;
            long lastSize = 0;
            XposedBridge.log("[HSZ][GR] poller start: " + f.getAbsolutePath());
            while (true) {
                try { Thread.sleep(800); } catch (InterruptedException e) { break; }
                try {
                    if (!f.exists()) continue;
                    long mod = f.lastModified();
                    long sz  = f.length();
                    if (mod == lastMod && sz == lastSize) continue;
                    lastMod = mod; lastSize = sz;
                    XposedBridge.log("[HSZ][GR] file changed sz=" + sz);
                    parseGameRecordFile(f);
                } catch (Throwable ignored) {}
            }
        }, "hsz-gr-poll").start();
    }

    private static void parseGameRecordFile(java.io.File f) {
        try {
            byte[] data;
            try (java.io.FileInputStream fis = new java.io.FileInputStream(f)) {
                java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
                byte[] buf = new byte[4096];
                int n;
                while ((n = fis.read(buf)) != -1) baos.write(buf, 0, n);
                data = baos.toByteArray();
            }
            XposedBridge.log("[HSZ][GR] read " + data.length + " bytes");
            java.util.List<int[]> hands = new java.util.ArrayList<>();
            int i = 0;
            while (i < data.length) {
                if (isTileByte(data[i] & 0xFF)) {
                    int j = i;
                    while (j < data.length && isTileByte(data[j] & 0xFF)) j++;
                    int len = j - i;
                    if (len >= 13 && len <= 14 && isValidHand(data, i, len)) {
                        int[] hand = new int[len];
                        for (int k = 0; k < len; k++) hand[k] = data[i + k] & 0xFF;
                        hands.add(hand);
                        XposedBridge.log("[HSZ][GR] hand@0x" + Integer.toHexString(i)
                                + " len=" + len + ": " + HszCardDecoder.decodeHand(hand));
                    }
                    i = j;
                } else i++;
            }
            if (hands.isEmpty()) {
                XposedBridge.log("[HSZ][GR] no hands found");
                return;
            }
            int n = Math.min(4, hands.size());
            int[][] cards = new int[n][];
            for (int k = 0; k < n; k++) cards[k] = hands.get(k);
            XposedBridge.log("[HSZ][GR] " + hands.size() + " hand(s): " + HszCardDecoder.formatAll(cards, sSelf));
            onCards(cards, "gr");
        } catch (Throwable t) {
            XposedBridge.log("[HSZ][GR] err: " + t.getMessage());
        }
    }

    private static boolean cardsEqual(int[][] a, int[][] b) {
        if (a == null && b == null) return true;
        if (a == null || b == null) return false;
        if (a.length != b.length) return false;
        for (int i = 0; i < a.length; i++) {
            if (!java.util.Arrays.equals(a[i], b[i])) return false;
        }
        return true;
    }

    private static boolean isTileByte(int b) {
        return (b >= 0x01 && b <= 0x09) || (b >= 0x11 && b <= 0x19)
            || (b >= 0x21 && b <= 0x29) || (b >= 0x31 && b <= 0x39);
    }

    private static int[][] scanProcessMemory() {
        java.util.List<long[]> regions = new java.util.ArrayList<>();
        try (java.io.BufferedReader br = new java.io.BufferedReader(
                new java.io.FileReader("/proc/self/maps"))) {
            String line;
            while ((line = br.readLine()) != null) {
                try {
                    String[] parts = line.split("\\s+", 6);
                    if (parts.length < 2) continue;
                    String perms = parts[1];
                    // must be readable, skip executable sections (code not data)
                    if (perms.charAt(0) != 'r' || (perms.length() > 2 && perms.charAt(2) == 'x')) continue;
                    String name = parts.length >= 6 ? parts[5].trim() : "";
                    // include anonymous regions and heap only; skip .so/.apk/system files
                    if (!name.isEmpty() && !"[heap]".equals(name) && !name.startsWith("[anon")) continue;
                    String addrs = parts[0];
                    int dash = addrs.indexOf('-');
                    if (dash < 0) continue;
                    long start = Long.parseLong(addrs.substring(0, dash), 16);
                    long end   = Long.parseLong(addrs.substring(dash + 1), 16);
                    long sz = end - start;
                    if (sz < 256 || sz > 64L * 1024 * 1024) continue;
                    regions.add(new long[]{start, end});
                } catch (Throwable ignored) {}
            }
        } catch (Throwable t) {
            XposedBridge.log("[HSZ] maps read err: " + t.getMessage());
            return null;
        }

        // /proc/self/mem blocked by SELinux; use Unsafe 3-param copyMemory + DirectByteBuffer
        final int CHUNK = 65536;
        Object unsafe;
        java.lang.reflect.Method cm3;
        java.nio.ByteBuffer direct;
        long directAddr;
        try {
            Class<?> uc = Class.forName("sun.misc.Unsafe");
            java.lang.reflect.Field fld = uc.getDeclaredField("theUnsafe");
            fld.setAccessible(true);
            unsafe = fld.get(null);
            // Android Unsafe has copyMemory(long srcAddr, long dstAddr, long bytes)
            cm3 = uc.getDeclaredMethod("copyMemory", long.class, long.class, long.class);
            cm3.setAccessible(true);
            direct = java.nio.ByteBuffer.allocateDirect(CHUNK + 64);
            // Get native address of the direct buffer
            java.lang.reflect.Field af = java.nio.Buffer.class.getDeclaredField("address");
            af.setAccessible(true);
            directAddr = af.getLong(direct);
            XposedBridge.log("[HSZ] memscan ready regions=" + regions.size()
                + " daddr=0x" + Long.toHexString(directAddr));
        } catch (Throwable t) {
            XposedBridge.log("[HSZ] memscan setup err: " + t.getMessage());
            return null;
        }

        byte[] buf = new byte[CHUNK + 64];
        for (long[] reg : regions) {
            long pos = reg[0];
            long end = reg[1];
            int carry = 0;
            while (pos < end) {
                int toRead = (int) Math.min(CHUNK, end - pos);
                try {
                    // Bulk copy: game memory → native direct buffer → Java array
                    cm3.invoke(unsafe, pos, directAddr, (long) toRead);
                    direct.position(0).limit(toRead);
                    direct.get(buf, carry, toRead);
                    direct.clear();
                } catch (Throwable t) {
                    carry = 0; break;
                }
                int total = carry + toRead;
                int[][] result = findHandGroups(buf, total);
                if (result != null) {
                    XposedBridge.log("[HSZ] memscan hit 0x" + Long.toHexString(pos));
                    return result;
                }
                carry = Math.min(32, total);
                System.arraycopy(buf, total - carry, buf, 0, carry);
                pos += toRead;
            }
        }
        return null;
    }

    private static int[][] findHandGroups(byte[] buf, int len) {
        final int MAX_SPAN = 1500;
        java.util.List<int[]> runs = new java.util.ArrayList<>();
        int i = 0;
        while (i < len) {
            if (isTileByte(buf[i] & 0xFF)) {
                int j = i;
                while (j < len && isTileByte(buf[j] & 0xFF)) j++;
                int runLen = j - i;
                // Real hand: exactly 13 tiles (or 14 after draw)
                if (runLen >= 13 && runLen <= 14 && isValidHand(buf, i, runLen)) {
                    runs.add(new int[]{i, runLen});
                }
                i = j;
            } else {
                i++;
            }
        }
        if (runs.size() < 4) return null;
        for (int k = 0; k + 3 < runs.size(); k++) {
            if (runs.get(k + 3)[0] - runs.get(k)[0] <= MAX_SPAN) {
                int[][] cards = new int[4][];
                for (int p = 0; p < 4; p++) {
                    int[] run = runs.get(k + p);
                    cards[p] = new int[run[1]];
                    for (int q = 0; q < run[1]; q++) cards[p][q] = buf[run[0] + q] & 0xFF;
                }
                return cards;
            }
        }
        return null;
    }

    private static boolean isValidHand(byte[] buf, int start, int len) {
        int[] counts = new int[256];
        int distinct = 0;
        for (int i = 0; i < len; i++) {
            int b = buf[start + i] & 0xFF;
            if (counts[b] == 0) distinct++;
            counts[b]++;
            if (counts[b] > 4) return false; // max 4 of any tile
        }
        return distinct >= 4; // at least 4 different tiles
    }

    private static volatile boolean sExtScanActive = false;
    private static volatile long sLastExtScan = 0;

    private static void triggerExternalScan() {
        long now = System.currentTimeMillis();
        if (sExtScanActive || now - sLastExtScan < 2000) return;
        sLastExtScan = now;
        sExtScanActive = true;
        final int pid = android.os.Process.myPid();
        new Thread(() -> {
            try {
                // Read /proc/self/maps to find small anonymous rw regions (scudo + heap)
                // TNet game state (4×14 tile bytes) lives in small scudo:primary allocations
                java.util.List<long[]> regions = new java.util.ArrayList<>();
                try (java.io.BufferedReader br = new java.io.BufferedReader(
                        new java.io.FileReader("/proc/self/maps"))) {
                    String mapLine;
                    while ((mapLine = br.readLine()) != null) {
                        try {
                            String[] parts = mapLine.split("\\s+", 6);
                            if (parts.length < 2) continue;
                            String perms = parts[1];
                            if (perms.length() < 2 || perms.charAt(0) != 'r' || perms.charAt(1) != 'w') continue;
                            if (perms.length() > 2 && perms.charAt(2) == 'x') continue;
                            String name = parts.length >= 6 ? parts[5].trim() : "";
                            if (name.contains("dalvik") || name.contains("[anon:art")
                                    || name.contains("linker") || name.contains("jit")
                                    || name.contains("stack") || name.contains("signal")) continue;
                            boolean isOk = name.isEmpty() || "[heap]".equals(name) || name.startsWith("[anon");
                            if (!isOk) continue;
                            String addrPart = parts[0];
                            int dash = addrPart.indexOf('-');
                            if (dash < 0) continue;
                            long start = Long.parseLong(addrPart.substring(0, dash), 16);
                            long end   = Long.parseLong(addrPart.substring(dash + 1), 16);
                            long size  = end - start;
                            // TNet game state is a small struct; skip huge regions (likely DAL/Lua VM)
                            if (size < 4096 || size > 256L * 1024) continue;
                            regions.add(new long[]{start, size});
                        } catch (Throwable ignored) {}
                    }
                }
                XposedBridge.log("[HSZ][EXT] " + regions.size() + " regions pid=" + pid);
                if (regions.isEmpty()) return;

                // Build shell script body:
                // { dd each region from /proc/PID/mem } | od hex | awk 56-byte window
                // Root shell bypasses SELinux restriction on reading own /proc/mem
                StringBuilder script = new StringBuilder("#!/bin/sh\n{ ");
                long totalBytes = 0;
                int regCount = 0;
                for (long[] r : regions) {
                    if (totalBytes > 4L * 1024 * 1024) break;
                    long skip = r[0] / 4096;
                    long count = (r[1] + 4095) / 4096;
                    script.append("dd if=/proc/").append(pid)
                          .append("/mem bs=4096 skip=").append(skip)
                          .append(" count=").append(count)
                          .append(" 2>/dev/null; ");
                    totalBytes += r[1];
                    regCount++;
                }
                // Multiline awk is fine inside heredoc (no quoting issues)
                // h2d: portable hex→int using index(); 56-byte circular window; threshold 44/56 tile bytes
                script.append("} | /system/bin/od -A n -t x1 -v | /system/bin/awk '\n");
                script.append("function h2d(s,  v,i,p){\n");
                script.append("  v=0\n");
                script.append("  for(i=1;i<=length(s);i++){\n");
                script.append("    p=index(\"0123456789abcdef\",substr(s,i,1))\n");
                script.append("    if(p>0) v=v*16+(p-1)\n");
                script.append("  }\n");
                script.append("  return v\n");
                script.append("}\n");
                script.append("BEGIN{n=0}\n");
                script.append("{\n");
                script.append("  for(i=1;i<=NF;i++){\n");
                script.append("    v=h2d($i); w[n%56]=v; n++\n");
                script.append("    if(n>=56){\n");
                script.append("      t=0\n");
                script.append("      for(j=0;j<56;j++){\n");
                script.append("        v2=w[j]\n");
                script.append("        if((v2>=1&&v2<=9)||(v2>=17&&v2<=25)||(v2>=33&&v2<=41)||(v2>=49&&v2<=57)) t++\n");
                script.append("      }\n");
                script.append("      if(t>=44){\n");
                script.append("        s=\"\"\n");
                script.append("        for(j=0;j<56;j++) s=s sprintf(\"%02x\",w[(n-56+j)%56])\n");
                script.append("        print \"DEAL:\"s\n");
                script.append("        exit\n");
                script.append("      }\n");
                script.append("    }\n");
                script.append("  }\n");
                script.append("}\n");
                script.append("'\n");

                // Write script via heredoc (verbatim, no shell interpretation of content),
                // then run with timeout 15 to prevent hanging on inaccessible pages.
                String shellCmd = "cat > /data/local/tmp/hsz_s.sh << 'HSZEOF'\n"
                        + script.toString()
                        + "HSZEOF\n"
                        + "chmod 755 /data/local/tmp/hsz_s.sh\n"
                        + "timeout 15 /data/local/tmp/hsz_s.sh 2>&1";

                XposedBridge.log("[HSZ][EXT] scan " + regCount + " regions (" + totalBytes / 1024 + " KB)");
                String result = RootUtils.execAsRootWithOutput(shellCmd);
                if (result == null) result = "";
                result = result.trim();
                XposedBridge.log("[HSZ][EXT] result=" + (result.isEmpty() ? "empty"
                        : result.substring(0, Math.min(200, result.length()))));

                // Result may contain stderr mixed in; find DEAL: anywhere in output
                int dealIdx = result.indexOf("DEAL:");
                if (dealIdx >= 0) {
                    String hexStr = result.substring(dealIdx + 5).trim();
                    int nl = hexStr.indexOf('\n');
                    if (nl >= 0) hexStr = hexStr.substring(0, nl).trim();

                    if (hexStr.length() >= 112) {
                        // Try QP layout: 56 bytes = 4 players × 14 tile slots
                        byte[] fakePacket = new byte[9 + 56];
                        for (int i = 0; i < 56; i++)
                            fakePacket[9 + i] = (byte) Integer.parseInt(hexStr.substring(i * 2, i * 2 + 2), 16);
                        int[][] cards = HszCardDecoder.parseGameStart(fakePacket);
                        if (cards != null && hasValidCards(cards)) {
                            XposedBridge.log("[HSZ][EXT] DEAL ok: " + HszCardDecoder.formatAll(cards, sSelf));
                            onCards(cards, "extmem");
                            return;
                        }
                    }
                    // Fallback: generic hand-group scanner on the 56-byte window
                    int cnt = Math.min(56, hexStr.length() / 2);
                    byte[] raw = new byte[cnt];
                    for (int i = 0; i < cnt; i++)
                        raw[i] = (byte) Integer.parseInt(hexStr.substring(i * 2, i * 2 + 2), 16);
                    int[][] cards = findHandGroups(raw, cnt);
                    if (cards != null) {
                        XposedBridge.log("[HSZ][EXT] DEAL(scan): " + HszCardDecoder.formatAll(cards, sSelf));
                        onCards(cards, "extmem-s");
                    } else {
                        XposedBridge.log("[HSZ][EXT] DEAL bad window: " + hexStr.substring(0, Math.min(112, hexStr.length())));
                    }
                } else {
                    XposedBridge.log("[HSZ][EXT] no DEAL in " + regCount + " regions");
                }
            } catch (Throwable ex) {
                XposedBridge.log("[HSZ][EXT] err: " + ex.getMessage());
            } finally {
                sExtScanActive = false;
            }
        }, "hsz-extmem").start();
    }
}
