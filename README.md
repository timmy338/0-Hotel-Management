# 项目相关

## ATTENTION

jdbc.properties已被移除版本库管理，请自行编写

在main/resources下写下

```
jdbc.driver=com.mysql.cj.jdbc.Driver
jdbc.url=jdbc:mysql://localhost:3306/数据库名字?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=serverTimezone=GMT%2B8
jdbc.user=root
jdbc.password=你的密码
jdbc.connTimeout=10000
```

应该是要移除出数据库，在项目根目录下打开gitbash 输入 git rm --cached src/main/resources/jdbc.properties,使git不再跟踪该文件

## git

**所有修改在dev上进行，master仅用于发布**

# 编码规约

1. 变量全部private

2. mapper层命名为dao层

3. mapper文件放在resources/mapper下，与dao层接口同名

4. ```java
   缩进为
   if(a==b){
       
   }
   即使只有一行，也要写大括号
   if(a==b){
       a=c;
   }
   ```

4. .jsp文件放在jsp下

5. service接口与实现分离，命名为 接口名+Impl

6. mysql语句关键词全部小写

7. 接口必须提供注释 例如：

   ```java
   /**
    * 增加部门信息
    * @param dept 部门信息
    * @return 改变影响数
    */
   int addDept(Dept dept);
   ```

8. 方法声明之间空一行，变量声明之间不空行，变量与方法声明之间空一行
9. ....（待补充）

~~没有遵守的给我买瓶可乐~~:sweat_smile:

家人们自觉遵守嗷:family: