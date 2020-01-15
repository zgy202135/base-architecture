# base-architecture
基于SpringCloud的基本框架开发（学习中）
# DIY SPRINGCLOUD SERVER  （base-architecture）
```
前期：致力于基础架构，远离业务逻辑
后期：可基于基础架构做业务服务
KEY:基础服务，组件化，可复用，高可用，监控，可运维

注：一个方法的代码要控制在30行左右，最坏的情况是在50行以下，在编码过程中要不断重构

https://www.processon.com/view/link/597ffa52e4b06a973c4d86ba
```

## 项目架构
- JDK1.8 ------------java开发环境
- Spring Boot ------------基础架构
- Spring Data JPA , Mybatis  ------------持久层框架
- Kafka , RocketMQ , RabbitMQ ------------消息队列
- ZooKeeper   ------------分布式应用程序协调服务
- Mysql       ------------数据库系统
- Redis       ------------缓存
- Nacos，consul（优先）      ------------服务注册中心(需要斟酌使用哪一种服务注册中心)
- Quartz      ------------定时任务调度
- Canal       ------------阿里数据同步（主从复制原理）
- Swagger2    ------------接口文档工具
- flyway      ------------数据库版本管理工具（自动升级）
- Vue         ------------前端基础架构
- **...**

## 开发工具
- IDEA
- Navicat
- Xcode
- CRT
- **...**


## 服务
```
服务端口：19500（网关）开始，依次加1
```
- 公共服务(base-common)
- 基础服务(base-basics)
- 基于本地的文件管理服务(base-file-management)
- 基于Quartz的定时任务调度(base-quartz)
- 基于Zuul的网关(base-gateway)
- 基于Kafka的消息总线(base-mc)
- 基于Canal的容灾数据仓库(base-canal)
- 

#### 进度

---``
1. 公共服务
- [x] 响应基础
- [x] 分页基础
- [x] EntityManager 查询基础

```
基于接口编程：
1、批量新增
2、复杂查询 --完成
3、关联查询 
4、分页查询 --完成
```

- [ ] 日期转换基础
- [ ] http连接基础

---
2. 基础服务
- 人员信息服务
- 组织架构服务
- 角色权限服务
- 任务调度服务
3. 网关服务
4. 消息总线
5. 文件管理服务