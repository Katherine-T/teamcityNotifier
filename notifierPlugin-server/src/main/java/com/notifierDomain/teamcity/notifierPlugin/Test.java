package com.notifierDomain.teamcity.notifierPlugin;

import java.util.*;

public class Test {
    private static final String APPID = "ww1cfe92ce0552bbe8";
    private static final String APPSCREAT = "qa4SGISCYLq8x2qZcwBqRhTom9quWbrWI_OclGXLM3U";
    private static final int APPLICATION_ID =1000045;
    public static void main(String[] args) {
        List<WeChatUser> value;
        Map<String, String> myMap = new HashMap<String, String>();

        WeChatAPI ap = new WeChatAPI();
        List<WeChatDepartment> list = WeChatAPI.getDepartments();
        Map<String, List<WeChatUser>> user = WeChatAPI.getAllUsers(list);
        for (String key : user.keySet()) {
            value = user.get(key);
            for (int i = 0; i < value.size(); i++) {
                String tn[] =value.get(i).getName().split("-");
                myMap.put(tn[0], value.get(i).getId());
            }
        }
        String s = "Katherine，spruce";
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
        send_weChatMsg sw = new send_weChatMsg();
        try {
            Singleton singleton = Singleton.getInstance();
            Map<String, Object> map = singleton.getAccessTokenAndJsapiTicket(APPID,
                    APPSCREAT);
            String token = (String) map.get("access_token");
            String postdata = sw.createpostdata(nu, "text", APPLICATION_ID, "content","success");
            String resp = sw.post("utf-8", send_weChatMsg.CONTENT_TYPE,(new urlData()).getSendMessage_Url(), postdata, token);
            System.out.println(token);
     //       String a = sw.getDep(token);
     //       System.out.println(a);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
