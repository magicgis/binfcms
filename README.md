# binf-cms系统


写这个系统的初衷是因为越来越感觉到wordpress不好用，想自己做一个blog系统。但是手头上有一个vps又觉得光上一个blog有点太亏了，索性就开发一个cms，想先从一个内容管理部分入手，把blog搞出来，再依次添加别像微信机器人，图床什么的。


## 关于架构
还没有创新的能力，代码主要以实用简单为主。原则是用更少的代码做更多的事，尽量多用第三方库，你所关心的是业务上的东西。

所以也就是j2ee的老一套东西了:

* IDE:Intellij IDEA
* 运行环境:jdk7,tomcat7,mysql5,redis。
* maven构架。
* 业务开发主要用到spring-mvc，spring，spring-jpa。
* 渲染直接弃掉jsp用freemarker。
* 自己写css太难看了，页面就用[bootstrap](http://www.bootcss.com/)。
* js框架用jquery，[jquery.dataTables](http://https://datatables.net/)做列表页，[jquery.validator](http://niceue.com/validator/)做表单验证。
* 当然还有其他的一些类库和jquery插件什么的。



## 项目运行

1. 运行/doc文件夹下的binf_cms_db.sql文件创建一个名为binf_cms_db数据库
2. 本地安装redis端口设置为:6379(默认)
3. 用maven把binf-admin模块打成war包启动tomcat
4. 登录目前需要手动在member表里面添加一条用户记录


##项目功能

###无限级分类:
![无限极分类1](http://ww1.sinaimg.cn/large/7403d840gw1elupcb5ltyj211k0hvabr.jpg)

![无限极分类2](http://ww3.sinaimg.cn/large/7403d840gw1eluphv0y0gj211v0hj0ua.jpg)


