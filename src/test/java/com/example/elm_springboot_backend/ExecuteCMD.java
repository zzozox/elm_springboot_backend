//package com.example.elm_springboot_backend;
//
//import org.junit.jupiter.api.Test;
//
//import java.io.BufferedReader;
//import java.io.File;
//import java.io.IOException;
//import java.io.InputStreamReader;
//
//public class ExecuteCMD {
//    @Test
//    public static void main(String[] args) {
//        try {
//            // 设置工作目录
//            String workingDirectory = "D:\\Java\\redis-7.0.14\\bin";
//            File directory = new File(workingDirectory);
//
//            // 构建命令
//            ProcessBuilder processBuilder = new ProcessBuilder("cmd", "/c", "redis-server");
//
//            // 将错误流重定向到输出流
//            processBuilder.redirectErrorStream(true);
//
//            // 设置工作目录
//            processBuilder.directory(directory);
//
//            // 启动进程
//            Process process = processBuilder.start();
//
//            // 获取命令执行的输出流
//            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
//            String line;
//
//            // 读取输出流并打印
//            while ((line = reader.readLine()) != null) {
//                System.out.println(line);
//            }
//
//            // 等待命令执行完毕
//            int exitCode = process.waitFor();
//            System.out.println("Exit Code: " + exitCode);
//
//        } catch (IOException | InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//}
