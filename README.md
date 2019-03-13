# teamcityNotifier
1、添加构建好的notifierPlugin。重启teamcity后生效。

2、在My Settings&Tools处设置Notification Rules。

3、选择WeChat Notifier。配置需要通知的任务，可以选择在什么情况下发送通知。（目前支持了开始、未能成功开始、挂起、任务失败、任务成功时通知）

4、在需要通知的任务参数编辑面板处，添加通知人。通过env.NOTI_USER参数传递，目前支持touser（成员ID列表（消息接收者需对应账号，多个接收者用‘|’分隔，最多支持1000个）。特殊情况：指定为@all，则向该企业应用的全部成员发送）。






