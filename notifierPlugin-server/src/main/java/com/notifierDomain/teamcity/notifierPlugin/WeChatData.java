package com.notifierDomain.teamcity.notifierPlugin;

public class WeChatData {
    String touser;
    String msgtype;
    int agentid;
    Object text;//实际接收Map类型数据
    String chatid;

    public Object getText() {
        return text;
    }
    public void setText(Object text) {
        this.text = text;
    }
    public String getMsgtype() {
        return msgtype;
    }
    public void setMsgtype(String msgtype) {
        this.msgtype = msgtype;
    }
    public int getAgentid() {
        return agentid;
    }
    public void setAgentid(int agentid) {
        this.agentid = agentid;
    }
    public String getTouser() {
        return touser;
    }
    public void setTouser(String touser) {
        this.touser = touser;
    }
    public String getTochat() {
        return chatid;
    }
    public void setTochat(String chatid) {
        this.chatid =chatid;
    }
}
