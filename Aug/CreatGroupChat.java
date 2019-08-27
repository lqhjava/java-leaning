package com.lqh.client.services;

import com.lqh.utils.Commutils;
import com.lqh.vo.MessageVO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class CreatGroupChat {
    private JPanel createGroupPanel;
    private JPanel friendListPanel;
    private JTextField groupNameText;
    private JButton conGroupBtn;

    private String myName;
    private Set<String> friends;
    private ClientToService clientToService;
    private FriendList friendList;
    private JPanel creatGroupPanel;

    public CreatGroupChat(String myName,
                          Set<String> friends,
                          ClientToService clientToService,
                          FriendList friendList){
        this.myName = myName;
        this.friends = friends;
        this.clientToService = clientToService;
        this.friendList = friendList;

        JFrame frame = new JFrame();
        frame.setContentPane(createGroupPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        //将在线好友以checkbox展示到界面中
        friendListPanel.setLayout(new BoxLayout(friendListPanel,BoxLayout.Y_AXIS));
        Iterator<String> iterator = friends.iterator();
        while (iterator.hasNext()){
            String lableName = iterator.next();
            JCheckBox checkBox = new JCheckBox(lableName);
            friendListPanel.add(checkBox);
        }

        //点击提交按钮 创建群聊
        conGroupBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //判断哪些好友被选择了
                Set<String> selectFriends = new HashSet<>();
                Component[] components = friendListPanel.getComponents();
                for (Component com:components){
                    JCheckBox checkBox = (JCheckBox) com;
                    if(checkBox.isSelected()){
                        String lableName = checkBox.getText();
                        selectFriends.add(lableName);
                    }
                }
                //加上自己
                selectFriends.add(myName);
                //获取群名
                String groupName = groupNameText.getText();
                //将信息发送到服务端
                MessageVO messageVO = new MessageVO();
                messageVO.setType(3);
                messageVO.setMsg(groupName);
                messageVO.setTo(Commutils.objToJson(selectFriends));
                try {
                    PrintStream out = new PrintStream(clientToService.getOutputStream(),
                            true,"UTF-8");
                    out.println(Commutils.objToJson(messageVO));
                } catch (UnsupportedEncodingException ex) {
                    ex.printStackTrace();
                }
                //将当前页面隐藏
                frame.setVisible(false);
                friendList.addGroup(groupName,selectFriends);
                friendList.reloadGroupList();

            }
        });
    }
}
