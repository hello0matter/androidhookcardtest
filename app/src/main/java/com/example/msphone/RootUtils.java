package com.example.msphone;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
public class RootUtils {
    public static boolean executeAsRoot(String command) {
        try {
            Process process = Runtime.getRuntime().exec("su");
            DataOutputStream os = new DataOutputStream(process.getOutputStream());
            os.writeBytes(command + "\n");
            os.writeBytes("exit\n");
            os.flush();
            os.close();
            return process.waitFor() == 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}