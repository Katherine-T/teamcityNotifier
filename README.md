# teamcityNotifier
1、添加构建好的notifierPlugin。重启teamcity后生效。

2、在My Settings&Tools处设置Notification Rules。

3、选择WeChat Notifier。配置需要通知的任务，可以选择在什么情况下发送通知。（目前支持了开始、未能成功开始、挂起、任务失败、任务成功时通知）

4、在需要通知的任务参数编辑面板处，添加通知人。通过env.NOTI_USER参数传递，改进了一下，做了用户映射，现在消息通知人的值为用户名“-”之前的英文名，多个用户用英文逗号（,）连接。



需要改进部分：目前在构建设置界面添加了notifierSetting页签，但还未在上面实现2.0用户设置界面，预期和Jenkins一样做下拉框选择。具体实现需要一个选择的控件，控件的值是java类函数获得的用户map或List。选择了的值用一个数组保存，回显在页面上作为提示，同时作为参数传到后端，将数组转化为String（XX|XX|XX）的形式作为通知函数的参数。



