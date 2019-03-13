package com.notifierDomain.teamcity.notifierPlugin;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.lang.System.out;

public class test2 {
    public static void main(String[] args) {

 /*       WeChatAPI ap = new WeChatAPI();
        List<WeChatDepartment> list =ap.getDepartments();
        out.print(list.size());
        for(int i = 0;i < list.size();i++){
            out.println(list.get(i));
        }
        Map<String, List<WeChatUser>> user =ap.getAllUsers(list);
        for(String key : user.keySet()){
            List<WeChatUser> value = user.get(key);
            for(int i = 0;i < value.size();i++){
                out.println("id:" + value.get(i).getId() +",name:" +value.get(i).getName());
            }
        }
    */
        List<WeChatUser> value;
        List<WeChatUser> userList =new ArrayList<WeChatUser>();
        WeChatAPI ap = new WeChatAPI();
        List<WeChatDepartment> list = ap.getDepartments();
        Map<String, List<WeChatUser>> user = ap.getAllUsers(list);
        for(String key : user.keySet()){
            value=user.get(key);
            for(int i = 0;i < value.size();i++){
                userList.add(value.get(i));
            }
        }
        for(int i = 0;i < userList.size();i++){
            out.println(userList.get(i).getName()+ userList.get(i).getId());
        }
    }
}
