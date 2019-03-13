package com.notifierDomain.teamcity.notifierPlugin;


import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Utils {
    public static List<WeChatDepartment> getRootDepartments(List<WeChatDepartment> departments) {
        Set<String> all = new HashSet<>();
        for (WeChatDepartment department : departments) {
            all.add(department.getId());
        }
        List<WeChatDepartment> root = new ArrayList<>();
        for (WeChatDepartment department : departments) {
            if (!all.contains(department.getParentId())) {
                root.add(department);
            }
        }
        return root;
    }

    public static List<String> getUsersFromReq(JSONObject form) {
        List<String> list = new ArrayList<>();
        Object users = form.opt("users");
        if (users == null) {
            return list;
        }
        if (users instanceof JSONObject) {
            applyUserId((JSONObject) users,list);
        } else if (users instanceof JSONArray) {
            JSONArray array = (JSONArray) users;
            for (int i = 0; i < array.size(); i++) {
                applyUserId(array.optJSONObject(i),list);
            }
        }

        return list;
    }

    private static void applyUserId(JSONObject user,List<String> users) {
        if (user == null) {
            return;
        }
        String uid = user.optString("user");
        if(!StringUtils.isBlank(uid) && !StringUtils.equals(uid, "-1") && !users.contains(uid)) {
            users.add(uid);
        }
    }



}

