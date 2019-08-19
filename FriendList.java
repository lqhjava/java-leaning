package com.lqh.client.services;

import javax.swing.*;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class FriendList {
    private JPanel friendListPanel;
    private JScrollPane friendPanel;
    private JButton createGroupBtn;
    private JScrollPane groupPanel;

    private String myName;
    private ClientToService clientToService;
    private Set<String> names;

    private class DaemonTask implements Runnable{
        //好友上线提醒
        private Scanner scanner = new Scanner(clientToService.getInputStream());
        @Override
        public void run() {
            while(true){
                //一直等待接受服务器发来其他用户上线的通知
                if(scanner.hasNextLine()){
                    String newFriend = scanner.nextLine();
                    JOptionPane.showMessageDialog(null,
                            newFriend+"上线了!","上线提醒",
                            JOptionPane.INFORMATION_MESSAGE);
                    names.add(newFriend);
                    //刷新好友链表
                    reloadFriendList();
                }
            }

        }
    }


    public FriendList(String userName,ClientToService connectToServer, Set<String>  names){

        this.myName = userName;
        this.clientToService = connectToServer;
        this.names = names;

        JFrame frame = new JFrame(myName);
        frame.setContentPane(friendListPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        reloadFriendList();
        Thread daemonThread = new Thread(new DaemonTask());
        daemonThread.setDaemon(true);
        daemonThread.start();
    }

    public void reloadFriendList(){
        //加载好友列表
        JPanel friendLabelPanel = new JPanel();
        JLabel[] labels = new JLabel[names.size()];
        //遍历set集合
        Iterator<String> iterator= names.iterator();
        //设置标签为纵向对齐
        friendLabelPanel.setLayout(new BoxLayout(friendLabelPanel,
                BoxLayout.Y_AXIS));
       int i =0;
       while (iterator.hasNext()){
           String lableName = iterator.next();
           labels[i] = new JLabel(lableName);
           friendLabelPanel.add(labels[i]);
           i++;
       }
       this.friendPanel.setViewportView(friendLabelPanel);
       //设置滚动条为垂直
        this.friendPanel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        this.friendPanel.revalidate();
    }
}
