package com.notifierDomain.teamcity.notifierPlugin;

import java.util.Map;

public class Test {
    private static final String APPID = "ww1cfe92ce0552bbe8";
    private static final String APPSCREAT = "qa4SGISCYLq8x2qZcwBqRhTom9quWbrWI_OclGXLM3U";
    private static final int APPLICATION_ID =1000045;
    public static void main(String[] args) {

        send_weChatMsg sw = new send_weChatMsg();
        try {
            Singleton singleton = Singleton.getInstance();
            Map<String, Object> map = singleton.getAccessTokenAndJsapiTicket(APPID,
                    APPSCREAT);
            String token = (String) map.get("access_token");
            String postdata = sw.createpostdata("Katherine", "text", APPLICATION_ID, "content","success");
            String resp = sw.post("utf-8", send_weChatMsg.CONTENT_TYPE,(new urlData()).getSendMessage_Url(), postdata, token);
            System.out.println(token);
     //       String a = sw.getDep(token);
     //       System.out.println(a);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
