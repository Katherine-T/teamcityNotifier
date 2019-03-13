package com.notifierDomain.teamcity.notifierPlugin;


import jetbrains.buildServer.serverSide.ProjectManager;
import jetbrains.buildServer.serverSide.SBuildType;
import jetbrains.buildServer.users.SUser;
import jetbrains.buildServer.web.openapi.PluginDescriptor;
import jetbrains.buildServer.web.openapi.WebControllerManager;
import jetbrains.buildServer.web.openapi.buildType.BuildTypeTab;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public class WeChatNotifierSettingPage extends BuildTypeTab {
    public WeChatNotifierSettingPage(
                                     @NotNull WebControllerManager manager,
                                     @NotNull ProjectManager projectManager) {
        super("notifierPlugin","NotifierSetting",manager,projectManager);

//        setPluginName("notifierPlugin");
        setIncludeUrl("WeChatNotifierSettingPage.jsp");
//        setTabTitle("NotifierSetting");
        register();
    }

    @Override
    protected void fillModel(@NotNull Map<String, Object> map, @NotNull HttpServletRequest httpServletRequest, @NotNull SBuildType sBuildType, @Nullable SUser sUser) {

    }
}