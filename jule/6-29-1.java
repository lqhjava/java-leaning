package com.lqh.MoreThread;


import java.io.IOException;
import java.net.Socket;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.SocketHandler;

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
                        }
                        //用户发来的是私聊
                        if(strClient.startsWith("P:")){

                        }
                        //用户发来的是群聊
                        if(strClient.startsWith("G:")){
                            //获取群聊信息
                            String msg = strClient.split(":")[1];
                            //发送群聊信息
                            groupMsg("群聊信息为："+msg);
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
            clientMap.put(useName,client);
            System.out.println("用户"+useName+"上线了");
        }

        private void groupMsg(String msg){
            //群聊流程
            //取得每个用户的选口号
            Set<Map.Entry<String,Socket>> clientSet = clientMap.entrySet();
            //
        }
    }
}
