package com.notifierDomain.teamcity.notifierPlugin;

import jetbrains.buildServer.Build;
import jetbrains.buildServer.notification.NotificatorRegistry;
import jetbrains.buildServer.notification.Notificator;
import jetbrains.buildServer.responsibility.ResponsibilityEntry;
import jetbrains.buildServer.responsibility.TestNameResponsibilityEntry;
import jetbrains.buildServer.serverSide.*;
import jetbrains.buildServer.serverSide.mute.MuteInfo;
import jetbrains.buildServer.serverSide.problems.BuildProblemInfo;
import jetbrains.buildServer.tests.TestName;
import jetbrains.buildServer.users.SUser;


import java.io.IOException;
import java.util.*;

import com.intellij.openapi.diagnostic.Logger;
import jetbrains.buildServer.vcs.VcsRoot;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
//import com.intellij.openapi.vcs.VcsRoot;

public class WeChatNotifier implements Notificator {
    private static final String APPID = "ww1cfe92ce0552bbe8";
    private static final String APPSCREAT = "qa4SGISCYLq8x2qZcwBqRhTom9quWbrWI_OclGXLM3U";
    private static final int APPLICATION_ID =1000045;
    private static final String TYPE = "WeChatlNotifier";

    private static final Logger LOG = Logger.getInstance(WeChatNotifier.class.getName());
//    private ArrayList<UserPropertyInfo> userProps;
    private String username;

    public WeChatNotifier() {

    }


    public String getName(){

        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public WeChatNotifier(NotificatorRegistry notificatorRegistry) throws IOException {

        ArrayList<UserPropertyInfo> userProps = new ArrayList();

        notificatorRegistry.register(this, userProps);
    }

    public void notifyBuildFailed(SRunningBuild srb, Set<SUser> users) {
        LOG.debug("notifyBuildFailed");
        doGroupNotifications(srb,"Build " + srb.getFullName() + "#" + srb.getBuildNumber() +"  Triggered By: "+ srb.getTriggeredBy().getUser().getName()+ " failed!" + " Path: https://ci.finedevelop.com/viewLog.html?buildId="+ srb.getBuildId()+"&buildTypeId="+ srb.getBuildTypeExternalId(),users);
        doNotifications(srb,"Build " + srb.getFullName() + "#" + srb.getBuildNumber() +"  Triggered By: "+ srb.getTriggeredBy().getUser().getName()+ " failed!" + " Path: https://ci.finedevelop.com/viewLog.html?buildId="+ srb.getBuildId()+"&buildTypeId="+ srb.getBuildTypeExternalId(),users);

    }

    public void notifyBuildFailedToStart(SRunningBuild srb, Set<SUser> users) {
        LOG.debug("notifyBuildFailedToStart");
        doGroupNotifications(srb,"Build " + srb.getFullName() + "#" + srb.getBuildNumber() +"  Triggered By: "+ srb.getTriggeredBy().getUser().getName()+ " failed to start!" + " Path: https://ci.finedevelop.com/viewLog.html?buildId="+ srb.getBuildId()+"&buildTypeId="+ srb.getBuildTypeExternalId(),users);
        doNotifications(srb,"Build " + srb.getFullName() + "#" + srb.getBuildNumber() +"  Triggered By: "+ srb.getTriggeredBy().getUser().getName()+ " failed to start!" + " Path: https://ci.finedevelop.com/viewLog.html?buildId="+ srb.getBuildId()+"&buildTypeId="+ srb.getBuildTypeExternalId(),users);
    }
    @Override
    public void notifyLabelingFailed(@NotNull Build build, @NotNull VcsRoot vcsRoot, @NotNull Throwable throwable, @NotNull Set<SUser> set) {

    }


    /* (non-Javadoc)
     * @see jetbrains.buildServer.notification.Notificator#notifyBuildFailing(jetbrains.buildServer.serverSide.SRunningBuild, java.util.Set)
     */
    public void notifyBuildFailing(SRunningBuild srb, Set<SUser> users) {
        LOG.debug("notifyBuildFailing");
        doGroupNotifications(srb,"Build " + srb.getFullName() + " #" + srb.getBuildNumber() +"  Triggered By: "+ srb.getTriggeredBy().getUser().getName()+ " is failing!" + " Path: https://ci.finedevelop.com/viewLog.html?buildId="+ srb.getBuildId()+"&buildTypeId="+ srb.getBuildTypeExternalId(),users);
        doNotifications(srb,"Build " + srb.getFullName() + " #" + srb.getBuildNumber() +"  Triggered By: "+ srb.getTriggeredBy().getUser().getName()+ " is failing!" + " Path: https://ci.finedevelop.com/viewLog.html?buildId="+ srb.getBuildId()+"&buildTypeId="+ srb.getBuildTypeExternalId(),users);
    }

    /* (non-Javadoc)
     * @see jetbrains.buildServer.notification.Notificator#notifyBuildProbablyHanging(jetbrains.buildServer.serverSide.SRunningBuild, java.util.Set)
     */
    public void notifyBuildProbablyHanging(SRunningBuild srb, Set<SUser> users) {
        LOG.debug("notifyBuildProbablyHanging");
        doGroupNotifications(srb,"Build " + srb.getFullName() + " #" + srb.getBuildNumber() + " probably hanging!" ,users);
        doNotifications(srb,"Build " + srb.getFullName() + " #" + srb.getBuildNumber() + " probably hanging!" ,users);
    }

    @Override
    public void notifyResponsibleChanged(@NotNull SBuildType sBuildType, @NotNull Set<SUser> set) {

    }

    @Override
    public void notifyResponsibleAssigned(@NotNull SBuildType sBuildType, @NotNull Set<SUser> set) {

    }

    @Override
    public void notifyResponsibleChanged(@Nullable TestNameResponsibilityEntry testNameResponsibilityEntry, @NotNull TestNameResponsibilityEntry testNameResponsibilityEntry1, @NotNull SProject sProject, @NotNull Set<SUser> set) {

    }

    @Override
    public void notifyResponsibleAssigned(@Nullable TestNameResponsibilityEntry testNameResponsibilityEntry, @NotNull TestNameResponsibilityEntry testNameResponsibilityEntry1, @NotNull SProject sProject, @NotNull Set<SUser> set) {

    }

    @Override
    public void notifyResponsibleChanged(@NotNull Collection<TestName> collection, @NotNull ResponsibilityEntry responsibilityEntry, @NotNull SProject sProject, @NotNull Set<SUser> set) {

    }

    @Override
    public void notifyResponsibleAssigned(@NotNull Collection<TestName> collection, @NotNull ResponsibilityEntry responsibilityEntry, @NotNull SProject sProject, @NotNull Set<SUser> set) {

    }

    @Override
    public void notifyBuildProblemResponsibleAssigned(@NotNull Collection<BuildProblemInfo> collection, @NotNull ResponsibilityEntry responsibilityEntry, @NotNull SProject sProject, @NotNull Set<SUser> set) {

    }

    @Override
    public void notifyBuildProblemResponsibleChanged(@NotNull Collection<BuildProblemInfo> collection, @NotNull ResponsibilityEntry responsibilityEntry, @NotNull SProject sProject, @NotNull Set<SUser> set) {

    }

    @Override
    public void notifyTestsMuted(@NotNull Collection<STest> collection, @NotNull MuteInfo muteInfo, @NotNull Set<SUser> set) {

    }

    @Override
    public void notifyTestsUnmuted(@NotNull Collection<STest> collection, @NotNull MuteInfo muteInfo, @Nullable SUser sUser, @NotNull Set<SUser> set) {

    }

    @Override
    public void notifyBuildProblemsMuted(@NotNull Collection<BuildProblemInfo> collection, @NotNull MuteInfo muteInfo, @NotNull Set<SUser> set) {

    }

    @Override
    public void notifyBuildProblemsUnmuted(@NotNull Collection<BuildProblemInfo> collection, @NotNull MuteInfo muteInfo, @Nullable SUser sUser, @NotNull Set<SUser> set) {

    }

    @NotNull
    @Override
    public String getNotificatorType() {
        return TYPE;
    }

    @NotNull
    @Override
    public String getDisplayName() {
        return "Wechat Notifier";
    }

    /* (non-Javadoc)
     * @see jetbrains.buildServer.notification.Notificator#notifyBuildStarted(jetbrains.buildServer.serverSide.SRunningBuild, java.util.Set)
     */
    public void notifyBuildStarted(SRunningBuild srb, Set<SUser> users) {
        LOG.debug("notifyBuildStarted");
        doGroupNotifications(srb,"Build " + srb.getFullName() + " #" + srb.getBuildNumber() + " started!" +"  Triggered By: "+ srb.getTriggeredBy().getUser().getName(),users);
        doNotifications(srb,"Build " + srb.getFullName() + " #" + srb.getBuildNumber() + " started!" +"  Triggered By: "+ srb.getTriggeredBy().getUser().getName(),users);
    }

    /* (non-Javadoc)
     * @see jetbrains.buildServer.notification.Notificator#notifyBuildSuccessful(jetbrains.buildServer.serverSide.SRunningBuild, java.util.Set)
     */
    public void notifyBuildSuccessful(SRunningBuild srb, Set<SUser> users) {
        LOG.debug("notifyBuildSuccessful");
        doGroupNotifications(srb,"Build " + srb.getFullName() + " #" + srb.getBuildNumber() + " success!" + " Path: https://ci.finedevelop.com/viewLog.html?buildId="+ srb.getBuildId()+"&buildTypeId="+ srb.getBuildTypeExternalId(),users);
        doNotifications(srb,"Build " + srb.getFullName() + " #" + srb.getBuildNumber() + " success!" + " Path: https://ci.finedevelop.com/viewLog.html?buildId="+ srb.getBuildId()+"&buildTypeId="+srb.getBuildTypeExternalId(),users);
    }
    private String userids;

    public String getIDs() {
        return userids;
    }
    public void setIDs(String userids) {
        this.userids = userids;
    }


    //调用微信通知部分
    public void doNotifications(Build build,String message, Set<SUser> users) {
        String noti_user = noti_user = build.getBuildType().getBuildParameter("env.NOTI_USER");
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
        String s = noti_user;
        String temp = "";
        String nu="";
        String a[] = s.split(",");
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
            String postdata = sw.createpostdata(nu, "text", APPLICATION_ID, "content",message);
            String resp = sw.post("utf-8", send_weChatMsg.CONTENT_TYPE,(new urlData()).getSendMessage_Url(), postdata, token);
            System.out.println(token);

            //       System.out.println(a);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void doGroupNotifications(Build build,String message, Set<SUser> users) {
        String chat_id = build.getBuildType().getBuildParameter("env.CHAT_ID");
        List<WeChatUser> value;
        Map<String, String> myMap = new HashMap<String, String>();
        send_weChatMsg swgroup = new send_weChatMsg();
        try {
            Singleton singleton = Singleton.getInstance();
            Map<String, Object> map = singleton.getAccessTokenAndJsapiTicket(APPID,
                    APPSCREAT);
            String token = (String) map.get("access_token");

            String postdata2 = swgroup.creategrouppostdata(chat_id, "text", "content",message);
            String resp2 = swgroup.post("utf-8", send_weChatMsg.CONTENT_TYPE,(new urlData()).getGroupSendMessage_Url(), postdata2, token);
            System.out.println(token);
            //       String a = sw.getDep(token);
            //       System.out.println(a);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

