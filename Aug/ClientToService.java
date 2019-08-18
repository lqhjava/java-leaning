package com.lqh.client.services;

import com.lqh.utils.Commutils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Properties;

//连接服务器
public class ClientToService {
    private static final Integer PORT;
    private static final String IP;
    private Socket  client;
    private InputStream inputStream;
    private OutputStream outputStream;

    static{
        Properties properties = Commutils.loadProperties("socket.properties");
        PORT = Integer.valueOf(properties.getProperty("PORT")) ;
        IP = properties.getProperty("IP");
    }

    public  ClientToService(){
        //在构造方法中连接
        try{
            client = new Socket(IP,PORT);
            this.inputStream = client.getInputStream();
            this.outputStream = client.getOutputStream();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public InputStream getInputStream() {
        return inputStream;
    }

    public OutputStream getOutputStream() {
        return outputStream;
    }
}
