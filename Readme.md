###juhe-spring-boot-starter 自定义聚合数据Starter
####使用教程：下载编译：juhe-spring-boot-starter 
#####1）下载：juhe-spring-boot-starter 
#####2）编译打包：mvn clean install
####引入项目如下：
    <dependency>
        <groupId>com.lgmn.starter</groupId>
        <artifactId>juhe-spring-boot-starter</artifactId>
        <version>0.0.1</version>
    </dependency>
####配置yml/properties
    #yml 配置方式如下
    juhe:
      service:
        key: 申请的key
    #properties 配置方式如下
    juhe.service.key: 申请的key
####使用方式：注入需要使用的Service，如使用聚合数据实名认证：
     @Autowired
     private JuHe_IdCardQuery_SarterService juHe_idCardQuery_sarterService;
####注入Service 后，根据方法传入参数，即可使用Service定义的全部方法
    