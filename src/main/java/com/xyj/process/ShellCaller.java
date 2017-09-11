package com.xyj.process;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ShellCaller {

    public static void process(String path) {
        try {
            Process ps = Runtime.getRuntime().exec(path);
            ps.waitFor();

            BufferedReader br = new BufferedReader(new InputStreamReader(ps.getInputStream()));
            StringBuilder builder = new StringBuilder();

            String line;
            while ((line = br.readLine()) != null) {
                builder.append(line).append("\n");
            }

            String result = builder.toString();
            System.out.println("执行完毕:\n" + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String path = args[0];
        process(path);
    }
}
