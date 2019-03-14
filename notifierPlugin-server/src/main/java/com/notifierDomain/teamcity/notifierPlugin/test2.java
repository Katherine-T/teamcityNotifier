package com.notifierDomain.teamcity.notifierPlugin;

import java.util.*;

import static java.lang.System.out;

public class test2 {
    public static void main(String[] args) {

        WeChatAPI ap = new WeChatAPI();
        List<WeChatDepartment> list = ap.getDepartments();
        out.print(list.size());
        for (int i = 0; i < list.size(); i++) {
            out.println(list.get(i));
        }
        Map<String, List<WeChatUser>> user = ap.getAllUsers(list);
        for (String key : user.keySet()) {
            List<WeChatUser> value = user.get(key);
            for (int i = 0; i < value.size(); i++) {
                out.println("id:" + value.get(i).getId() + ",name:" + value.get(i).getName());
            }
        }
/*
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

/*        List<WeChatUser> value;
        Map<String, String> myMap = new HashMap<String, String>();

        WeChatAPI ap = new WeChatAPI();
        List<WeChatDepartment> list = ap.getDepartments();
        Map<String, List<WeChatUser>> user = ap.getAllUsers(list);
        for (String key : user.keySet()) {
            value = user.get(key);
            for (int i = 0; i < value.size(); i++) {
                myMap.put(value.get(i).getName(), value.get(i).getId());
            }
        }
        Set set=myMap.entrySet();
        Iterator it=set.iterator();
        while(it.hasNext()) {
            Map.Entry entry=(Map.Entry)it.next();
            if(entry.getKey().equals("Katherine-唐滢")) {
                System.out.println(entry.getValue());
            }
        }
        String s = "Katherine-唐滢，spruce-许云珊";
        String temp = "";
        String nu="";
        String a[] = s.split("，");
        for (int i = 0; i < a.length; i++) {
            Set set1=myMap.entrySet();
            Iterator it1=set1.iterator();
            while(it1.hasNext()) {
                Map.Entry entry=(Map.Entry)it1.next();
                if(entry.getKey().equals(a[i])) {
                    temp= (String) entry.getValue();
                }
            }
            nu = nu + temp +"|";
        }
        System.out.println(nu);
    }
    */
    }
}
