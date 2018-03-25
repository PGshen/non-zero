# 基于Spring Boot + Spring Security开发信息管理平台
## 一. 项目简介
### 1. 项目简介
&ensp;&ensp;&ensp;&ensp;本项目采用**Restful API** 设计,即前后端分离,这也是当前比较流行的做法,在项目开发过程中,事先约定好API接口以及对应数据格式,使前后端之间可以最大限度减少对方的"依赖",提高开发效率.
&ensp;&ensp;&ensp;&ensp;后端是基于**Spring Boot**框架搭建的信息管理系统,并整合**Spring Security**进行授权认证管理,数据访问层则采用**Mybatis**进行持久化,该项目使用**maven**进行项目工程管理.
&ensp;&ensp;&ensp;&ensp;前端方面采用的**vue.js** + **Element UI**框架,由于本人主要做后端开发,在前端方面能力较渣,所以前端直接使用了由[花裤衩][1]开发的模板,在此基础上结合自己项目的业务进行修改,这位大大还写了一个非常详细的[文档][2],非常值得学习.

## 二. 环境
###1. 开发工具
* 操作系统: Deepin
* IDE: IntelliJ IDEA / WebStorm
> **Deepin** 深度操作系统是基于Ubuntu开发一款国产Linux操作系统,底层是Linux系统,同时基于DeepinWine技术，可以运行大量的Windows平台软件,像微信、QQ、TIM等都可以运行,这是其他Linux操作系统所没有的,界面也非常好看,用起来还是很顺心的,本项目是在Deepin系统上开发的.
> **IntelliJ IDEA** 个人角色比eclipse好用,比较坑的是这东西很占内存

###2. 开发环境
* Java
* Mysql
* maven
* node.js
* redis


  [1]: https://github.com/PanJiaChen/vue-element-admin
  [2]: https://panjiachen.github.io/vue-element-admin-site/#/
