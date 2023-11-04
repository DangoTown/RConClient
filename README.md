# RConClient

> 一个在命令行使用的RCon客户端软件

# 使用

> 使用`java -jar RCC.jar --pwd xxxx [--host 0.0.0.0] [--port 25575]` 以运行

> 你也可以使用`GraalVM` 的 `native-image`来生成一个本地的可执行文件

```cmd
@echo off
```

# 注意事项

> 仅支持密码不为空的情况下使用, 如果服务器未配置密码则无法使用本程序

> 自行编译请注意: ***编译出来的产物默认是没有主属性清单的(主属性清单内没有指定主类, 需要手动添加)***
> 添加 `Main-Class: cn.rtast.rcc.RConClientKt` 主类属性到 `MANIFEST.MF`并保存
