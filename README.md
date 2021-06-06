# deep-in-springboot

## spring 的模式注解装配

  @Component 作为一种由 Spring 容器托管的通用模式组件，任何被 @Component 标准的组件均为组件扫描的候选对象。类
  似地，凡是被 @Component 元标注（meta-annotated）的注解，如 @Service ，当任何组件标注它时，也被视作组件扫
  描的候选对象
  * @componet
  * @service
  * @repository
  * @configuration
  * @controller
  
## Spring @Enable 模块装配

## spring 的条件装配
 * @ConditionalOnProperty : 主要是去判断spring上下文中配置是否存在或者匹配 ,主要是基于编程的方式来实现条件化的装配
## spring boot 的自动装配
  
  ##底层技术
    * spring framework的模式注解
    * spring @Enable模块装配
    * spring condition的条件装配
    * 以及spring的工厂加载机制 （springFactoryLoader 类）
    
    实现配置的自动化加载


## 深度理解SpringApplication 
    
    ## springApplication 的准备阶段
        配置 spring boot bean源   
            1、被spring 模式注解标注的类， 
            2、从xmL 上下文配置文件集合
            通常被spring boot beandefinitionLoader读取，(prepareContext()方法中)并将配置源解析加载为bean 定义 
        推断web应用类型和mainapplication 类
        加载应用上下文初始器和应用事件监听器
        
    ## springApplication 的运行阶段
            
 
 
 

  