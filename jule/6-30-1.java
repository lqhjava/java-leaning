package com.lqh.MoreThread;


import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


//服务端
public class MoreThreadServer {
    //保存每个用户的信息
    private static Map<String, Socket> clientMap =
            new ConcurrentHashMap<String, Socket>();
    //处理与每个客户端通信的
    private static class ExecuClient implements Runnable{
        private Socket client;

        public ExecuClient(Socket client) {
            this.client = client;
        }

        public void run() {
            //从客户端获取输入流 客户输入的信息
            try {
                Scanner in = new Scanner(client.getInputStream());
                String strClient;
                //处理用户的信息
                while(true){
                    if(in.hasNextLine()){
                        strClient = in.nextLine();
                        //用户发来的是只注册信息
                        if(strClient.startsWith("R:")){
                            //注册
                            //获取用户名
                            String useName = strClient.split(":")[1];
                            //注册
                            useReg(useName,client);
                            continue;
                        }
                        //用户发来的是私聊
                        if(strClient.startsWith("P:")){
                            //获取用户名
                            String useName = strClient.split(":")[1].split("-")[0];
                            //获取私聊信息
                            String msg = strClient.split(":")[1].split("-")[1];
                            //私聊
                            privateChat(useName,msg);
                        }
                        //用户发来的是群聊
                        if(strClient.startsWith("G:")){
                            //获取群聊信息
                            String msg = strClient.split(":")[1];
                            //发送群聊信息
                            groupMsg(msg);
                        }
                    }
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        private void useReg(String useName,Socket client){
            //注册流程
            //将用户信息保存到用户表中
            System.out.println("用户姓名为: "+useName);
            System.out.println("用户"+useName+"上线了！");
            System.out.println("当前群聊人数为: "+(clientMap.size()+1)+"人");
            clientMap.put(useName,client);
            //提醒用户注册成功
            try {
                PrintStream out = new PrintStream(client.getOutputStream(),true,"UTF-8");
                out.println("注册成功");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private void privateChat(String useName,String msg){
            //获取用户名的端口号
            Socket socket = clientMap.get(useName);
            //获取该用户的输出流
            try {
                PrintStream out = new PrintStream(socket.getOutputStream(),true,"utf-8");
                //发送信息
                out.println("私聊信息为："+msg);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private void groupMsg(String msg) {
            //群聊流程
            //取得每个用户的选口号
            Set<Map.Entry<String, Socket>> clientSet = clientMap.entrySet();
            //给每个客户发送群聊信息

            for (Map.Entry<String, Socket> entry : clientSet) {
                try {
                    Socket socket = entry.getValue();
                    //取得每个客户的输出流
                    PrintStream out = null;
                        out = new PrintStream(socket.getOutputStream(), true, "UTF-8");
                    //发送信息
                        out.println("群聊信息为：" + msg);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

    public static void main(String[] args) throws IOException {
        ExecutorService executorService = Executors.newFixedThreadPool(20);
        //建立基站
        ServerSocket serverSocket = new ServerSocket(6666);
        //处理
        for (int i = 0; i < 20; i++) {
            System.out.println("等待用户连接");
            Socket client = serverSocket.accept();
            System.out.println("有新的客户端连接，端口号为："+client.getPort());
            executorService.submit(new ExecuClient(client));

        }
        //关闭
        executorService.shutdown();
        serverSocket.close();
    }
    }
