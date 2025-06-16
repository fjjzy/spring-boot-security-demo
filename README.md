# Spring Boot Security Demo

这是一个使用Spring Boot 3.2.0和Spring Security实现的Demo项目。

## 项目特点

- 基于Spring Boot 3.2.0
- 集成Spring Security进行认证和授权
- 提供需要认证的HelloWorld API
- 实现用户名密码登录功能

## 项目结构

```
src/main/java/com/example/demo
├── DemoApplication.java          # 应用程序入口
├── config
│   └── SecurityConfig.java       # Spring Security配置
└── controller
    ├── AuthController.java       # 认证相关控制器
    └── HelloController.java      # Hello World API控制器
```

## 如何运行

1. 确保已安装Java 17或更高版本
2. 使用Maven构建项目：`mvn clean package`
3. 运行应用：`java -jar target/demo-0.0.1-SNAPSHOT.jar`
4. 或者直接使用Maven运行：`mvn spring-boot:run`

## API说明

### 1. Hello World API

- URL: `/hello`
- 方法: GET
- 需要认证: 是
- 返回: 字符串 "Hello World"

### 2. 登录API

- URL: `/login`
- 方法: POST
- 需要认证: 否
- 参数:
  - username: test
  - password: 123456

### 3. 认证状态API

- URL: `/auth/status`
- 方法: GET
- 需要认证: 是
- 返回: 包含认证状态的JSON对象

## 测试方法

1. 使用curl测试登录:

```bash
curl -X POST -d "username=test&password=123456" -c cookies.txt http://localhost:8080/login
```

2. 使用保存的cookie测试Hello API:

```bash
curl -b cookies.txt http://localhost:8080/hello
```

3. 检查认证状态:

```bash
curl -b cookies.txt http://localhost:8080/auth/status
```