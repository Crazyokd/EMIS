# EMIS
21年7月软件实训 
一周多的时间总算把整个项目给拖出来了。。。
项目的数据库部分就没有弄过来了，有时间的话写个关于数据库的txt。
另外，一些资源路径（如图片地址等）的配置目前也没有给出，甚至在做的时候连相关接口都没有设计。
整个项目也才几千行代码，有问题依着异常给的StackTrace一步步找，改动几个小地方应该问题不大。
后续有时间可以设计一下相关配置接口（用我会的最蠢的办法）。。。
push的时候有考虑IDE的差别，所以有进行git.ignore，所以平台应该不会构成什么问题。
有帅哥如果能看看我的代码顺便写写注释就好了。。。
--------------------------------------------------------------21.7.7


关于系统功能
本系统可以任意注册用户，但是注册管理员需要管理员密码。
管理员密码就随意定义在Frame包中的RegisterOption类中，而且还是以一个常量的形式存在。。。默认为123456
建议使用属性定义该变量，方便操作。
用户名不能重复，注册成功后，就可以使用注册的用户名和密码进行登录。
在登录进入系统的那一刻，权限级别已经在程序内部被限定了。
限定依据是登录的用户名，程序会查找该用户名的权限类别，因为该系统功能简陋，所以目前只设置了两种权限级别。
统计功能没有操作性，仅限于统计字段的浏览。
插入员工信息的约束条件非常多，其目的也是想尽可能借助程序保证数据库中的数据完整性、正确性。而且插入员工信息时极有可能会影响其他员工。
查删改算是本系统的核心，可以实现修改、删除、限制查询、全表查询。
而且进入该界面时程序会对图片文件进行缓存，缓存位置可以手动配置，位于entity包中的Photo类属性
其中值得一提的是全表查询，全表查询也可以作为一个刷新按钮来使用。若是同时进行了插入操作，可以通过刷新获取和展示最新数据。
当关闭主界面时，程序视为退出程序，会断开与数据库的连接，并对图片缓存进行清理。好处是不会产生多余垃圾，缺点是影响效率以及更耗流量，该功能可以设置关闭。
enmm。。。功能差不多就这点.....
------------------------------------------------------------21.7.9
