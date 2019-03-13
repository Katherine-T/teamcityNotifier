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
import jetbrains.buildServer.users.NotificatorPropertyKey;
import jetbrains.buildServer.users.PropertyKey;
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
        doNotifications(srb,"Build " + srb.getFullName() + "#" + srb.getBuildNumber() + " failed!" ,users);
    }

    public void notifyBuildFailedToStart(SRunningBuild srb, Set<SUser> users) {
        LOG.debug("notifyBuildFailedToStart");
        doNotifications(srb,"Build " + srb.getFullName() + "#" + srb.getBuildNumber() + " failed to start!" ,users);
    }
    @Override
    public void notifyLabelingFailed(@NotNull Build build, @NotNull VcsRoot vcsRoot, @NotNull Throwable throwable, @NotNull Set<SUser> set) {

    }


    /* (non-Javadoc)
     * @see jetbrains.buildServer.notification.Notificator#notifyBuildFailing(jetbrains.buildServer.serverSide.SRunningBuild, java.util.Set)
     */
    public void notifyBuildFailing(SRunningBuild srb, Set<SUser> users) {
        LOG.debug("notifyBuildFailing");
        doNotifications(srb,"Build " + srb.getFullName() + " #" + srb.getBuildNumber() + " failing!" ,users);
    }

    /* (non-Javadoc)
     * @see jetbrains.buildServer.notification.Notificator#notifyBuildProbablyHanging(jetbrains.buildServer.serverSide.SRunningBuild, java.util.Set)
     */
    public void notifyBuildProbablyHanging(SRunningBuild srb, Set<SUser> users) {
        LOG.debug("notifyBuildProbablyHanging");
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
        doNotifications(srb,"Build " + srb.getFullName() + " #" + srb.getBuildNumber() + " started!" ,users);
    }

    /* (non-Javadoc)
     * @see jetbrains.buildServer.notification.Notificator#notifyBuildSuccessful(jetbrains.buildServer.serverSide.SRunningBuild, java.util.Set)
     */
    public void notifyBuildSuccessful(SRunningBuild srb, Set<SUser> users) {
        LOG.debug("notifyBuildSuccessful");
        doNotifications(srb,"Build " + srb.getFullName() + " #" + srb.getBuildNumber() + " success!" ,users);
    }



//调用微信通知部分
    public void doNotifications(Build build,String message, Set<SUser> users) {
        String noti_user = build.getBuildType().getBuildParameter("env.NOTI_USER");

//        String username; Set<SUser> users
        //       for(SUser user : users) {
        //           LOG.debug("触发用户: " + user.getUsername());
        //       }
        send_weChatMsg sw = new send_weChatMsg();
        try {
            Singleton singleton = Singleton.getInstance();
            Map<String, Object> map = singleton.getAccessTokenAndJsapiTicket(APPID,
                    APPSCREAT);
            String token = (String) map.get("access_token");
            String postdata = sw.createpostdata(noti_user, "text", APPLICATION_ID, "content", message);
            String resp = sw.post("utf-8", send_weChatMsg.CONTENT_TYPE, (new urlData()).getSendMessage_Url(), postdata, token);
            System.out.println(token);
            //       String a = sw.getDep(token);
            //       System.out.println(a);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}

