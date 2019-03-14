package com.notifierDomain.teamcity.notifierPlugin;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import static java.lang.System.out;
import static sun.net.NetProperties.get;

public class WeChatAPI {
    private static final Logger LOGGER = Logger.getLogger(WeChatAPI.class.getName());
    private static final String GET = "GET";
    private static final String POST = "POST";
    private static final String APPID = "ww1cfe92ce0552bbe8";
    private static final String APPSCREAT = "qa4SGISCYLq8x2qZcwBqRhTom9quWbrWI_OclGXLM3U";
    private static final int APPLICATION_ID =1000045;
    private static final String TYPE = "WeChatlNotifier";
    //获取token
    private static final String ACCESS_TOKEN_URL = "https://qyapi.weixin.qq.com/cgi-bin/gettoken?corpid=%s&corpsecret=%s";
    //推送消息
    private static final String SEND_URL = "https://qyapi.weixin.qq.com/cgi-bin/message/send?access_token=%s";
    //获取部门
    private static final String GET_DEPARTMENT_URL = "https://qyapi.weixin.qq.com/cgi-bin/department/list?access_token=%s";// + "&id=%s";
    //获取部门成员
    private static final String GET_USER_BY_DEPARTMENT = "https://qyapi.weixin.qq.com/cgi-bin/user/simplelist?access_token=%s&department_id=%s&fetch_child=%d";
    //获取标签
    private static final String GET_TAGS_URL = "https://qyapi.weixin.qq.com/cgi-bin/tag/list?access_token=%s";
    //创建群聊
    private static final String CREATE_CHAT = "https://qyapi.weixin.qq.com/cgi-bin/appchat/create?access_token=%s";
    //推送群聊消息
    private static final String SEND_CHAT = "https://qyapi.weixin.qq.com/cgi-bin/appchat/send?access_token=%s";
    //获取群聊信息
    private static final String GET_CHAT = "https://qyapi.weixin.qq.com/cgi-bin/appchat/get?access_token=%s&chatid=%s";
    //更新群聊信息
    private static final String UPDATE_CHAT= "https://qyapi.weixin.qq.com/cgi-bin/appchat/update?access_token=%s";


    /**
     * 获取部门
     *
     */
    public static List<WeChatDepartment> getDepartments() {
        List<WeChatDepartment> list = new ArrayList<>();
        try {
            Singleton singleton = Singleton.getInstance();
            Map<String, Object> map2 = singleton.getAccessTokenAndJsapiTicket(APPID,
                    APPSCREAT);
            String token = (String) map2.get("access_token");
            String query = String.format(GET_DEPARTMENT_URL, token);
            String resp = get(query);
            JSONObject obj = JSONObject.fromObject(resp);
            if (obj.getInt("errcode") == 0) {
                JSONArray departments = obj.getJSONArray("department");
                int size = departments.size();
                for (int i = 0; i < size; i++) {
                    JSONObject department = departments.getJSONObject(i);
                    String id = department.getString("id");
                    String name = department.getString("name");
                    String pid = department.getString("parentid");
                    WeChatDepartment model = new WeChatDepartment();
                    model.setId(id);
                    model.setName(name);
                    model.setParentId(pid);
                    list.add(model);
                }
            }
            return list;
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "error in get dep req", e);
        }
        return null;
    }
    /**
     * 获取所有成员
     *
     */
    public static Map<String, List<WeChatUser>> getAllUsers(List<WeChatDepartment> departments) {
        List<WeChatDepartment> rootDepartments = Utils.getRootDepartments(departments);
        Map<String,List<WeChatUser>> map1 = new HashMap<>();

        try {
            Singleton singleton = Singleton.getInstance();
            Map<String, Object> map2 = singleton.getAccessTokenAndJsapiTicket(APPID,
                    APPSCREAT);
            String token = (String) map2.get("access_token");
            for (WeChatDepartment department : rootDepartments) {
                String query = String.format(GET_USER_BY_DEPARTMENT, token, department.getId(), 1);
                String resp = get(query);
                JSONObject obj = JSONObject.fromObject(resp);
                if (obj.getInt("errcode") == 0) {
                    JSONArray userList = obj.getJSONArray("userlist");
                    int size = userList.size();
                    for (int i = 0; i < size; i++) {
                        JSONObject user = userList.getJSONObject(i);
                        String userId = user.getString("userid");
                        String name = user.getString("name");
                        JSONArray dep = user.optJSONArray("department");

                        WeChatUser u = new WeChatUser();
                        u.setId(userId);
                        u.setName(name);

                        for (int j = 0, n = dep.size(); j < n; j++) {
                            addToDepartment(map1, dep.optString(j), u);
                        }
                    }
                }
            }
            return map1;
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "error in get user req", e);
        }
        return null;
    }
    private static void addToDepartment(Map<String,List<WeChatUser>> map, String depId, WeChatUser user) {
        List<WeChatUser> userList = map.get(depId);
        if (userList == null) {
            userList = new ArrayList<>();
            map.put(depId, userList);
        }
        userList.add(user);
    }
    private static String get(String path) {
        try {
//            System.out.println(path);
            URL url = new URL(path);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setConnectTimeout(10 * 1000);
            connection.setReadTimeout(10 * 1000);
            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                InputStream inputStream = connection.getInputStream();
                return IOUtils.toString(inputStream);
            }
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "error in req " + path, e);
        }
        return "";
    }
 /*   List<WeChatUser> value;
    public String test(){
        WeChatAPI ap = new WeChatAPI();
        List<WeChatDepartment> list =ap.getDepartments();
        out.print(list.size());
        for(int i = 0;i < list.size();i++){
            out.println(list.get(i));
        }
        Map<String, List<WeChatUser>> user =ap.getAllUsers(list);
        for(String key : user.keySet()){
            value = user.get(key);
            for(int i = 0;i < value.size();i++){
                out.println("id:" + value.get(i).getId() +",name:" +value.get(i).getName());
            }
        }
        return "success";
    }
    */
     public static List<WeChatUser> getUserList() {
         List<WeChatUser> value;
         List<WeChatUser> userList = new ArrayList<WeChatUser>();
         WeChatAPI ap = new WeChatAPI();
       List<WeChatDepartment> list = ap.getDepartments();
       Map<String, List<WeChatUser>> user = ap.getAllUsers(list);
       for (String key : user.keySet()) {
          value = user.get(key);
           for (int i = 0; i < value.size(); i++) {
               String tn[] =value.get(i).getName().split("-");
               value.get(i).setName(tn[0]);
               userList.add(value.get(i));
          }
      }
      return userList;


     }
}