package com.notifierDomain.teamcity.notifierPlugin;

import javax.servlet.http.HttpServletRequest;
import jetbrains.buildServer.web.openapi.SimplePageExtension;
import jetbrains.buildServer.web.openapi.PagePlaces;
import jetbrains.buildServer.web.openapi.PlaceId;

public class WeChatPageExtension extends SimplePageExtension {

    public WeChatPageExtension(PagePlaces pagePlaces) {
        super(pagePlaces);
        setIncludeUrl("WechatNotifierSetting.jsp");
        setPlaceId(PlaceId.NOTIFIER_SETTINGS_FRAGMENT);
        setPluginName("notifierPlugin");
        register();
    }

    public boolean isAvailable(HttpServletRequest request) {
        return super.isAvailable(request);
    }
}