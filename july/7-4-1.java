package com.lqh.MoreThread;


import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

//客户端
/*
读取客户端信息的线程
 */
class ReadFromServertThread implements Runnable{
    private Socket client;

    public ReadFromServertThread(Socket client) {
        this.client = client;
    }

    public void run() {
        //获取客户端的输入流
        try {
            Scanner in = new Scanner(client.getInputStream());
            while(true){
                if(in.hasNextLine()){
                    System.out.println("从服务端发来的信息为："+in.nextLine());
                }
                //客户端退出
                if(client.isClosed()){
                    System.out.println("此客户端退出");
                    break;
                }
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

/*
将信息发送到服务端的线程
 */
class SendMsgToServerThread implements Runnable{
    private Socket client;

    public SendMsgToServerThread(Socket client) {
        this.client = client;
    }

    public void run() {

        try {
            //获取用户输入
            Scanner scanner = new Scanner(System.in);
            scanner.useDelimiter("\n");
            //获取客户端输出流
            PrintStream out = new PrintStream(client.getOutputStream());
            while(true){
                System.out.println("请输入要发送的信息;");
                String strToServer;
                if(scanner.hasNextLine()){
                    strToServer = scanner.nextLine().trim();
                    out.println(strToServer);
                    //客户端退出
                    if(strToServer.contains("byebye")){
                        System.out.println("关闭客户端");
                        scanner.close();
                        out.close();
                        client.close();
                        break;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
//客户端
public class MoreThreadClient {
    public static void main(String[] args) {

        try {
            Socket client = null;
            client = new Socket("127.0.0.1",6666);
            //读取服务器消息线程
            Thread readFromServer = new Thread(new ReadFromServertThread(client));
            Thread sengToServer = new Thread(new SendMsgToServerThread(client));
            readFromServer.start();
            sengToServer.start();;
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
