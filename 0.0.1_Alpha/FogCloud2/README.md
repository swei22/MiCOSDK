##Description: MiCOSDK开发指南

##**概述**

想通过APP远程控制一个智能设备，您需要FAE的支持，如果WIFI模块（硬件）已经准备就绪，那么您只需要完成以下几步

1、通过Fogcloud平台注册一个APP，得到appid，因为下面需要用到

2、对于一个新用户而言，首先需要注册用户，获取验证码、验证验证码、注册登录等，这些都在[MiCOUser](#MiCOUser)部分

3、注册完成后，我还没有一个可以控制的设备，我需要绑定一个设备，绑定之前需要先让设备连上WIFI路由器，让设备连上路由器(EasyLink)，连上以后找到这个设备的IP(SearchDevice)，并绑定她，这些都在[MiCODevice](#MiCODevice)部分

<br/>
<br/>
##**MiCOUser**<div id="MiCOUser"></div>用户管理

* [getPhoneSMSCode](#getPhoneSMSCode) 获取验证码

* [verifyPhoneSMSCode](#verifyPhoneSMSCode) 验证验证码

* [register](#register) 用户注册

* [login](#login) 用户登录

* [refreshToken](#refreshToken) 刷新token

* [verifyToken](#verifyToken) 验证token

##**MiCODevice**<div id="MiCODevice"></div> 设备管理

__EasyLink__ 配网部分

* [getSSID](#getSSID) 获取ssid

* [startEasyLink](#startEasyLink) 发送配网数据包

* [stopEasyLink](#stopEasyLink) 停止发送配网数据包

__SearchDevice__

* [startSearchDevices](#startSearchDevices)

* [stopSearchDevices](#stopSearchDevices)

__BindDevice__

* [bindDevice](#bindDevice)

* [unBindDevice](#unBindDevice)

__ShareDevice__

* [getShareVerCode](#getShareVerCode)

* [creatQrCode](#creatQrCode)

* [addDeviceByVerCode](#addDeviceByVerCode)

__ControlRemoteDevice__

* [startListenDevice](#startListenDevice)

* [sendCommand](#sendCommand)

* [addDeviceListener](#addDeviceListener)

* [removeDeviceListener](#removeDeviceListener)

* [stopListenDevice](#stopListenDevice)

__ControlLocalDevice__

* [connectLocalDevice](#connectLocalDevice)

* [sendLocalCommand](#sendLocalCommand)

* [disconnectLocalDevice](#disconnectLocalDevice)


#**openDebug**<div id="1"></div>

    打开chrome调试HTML5页面的开关。

    openDebug(callback(ret))

##callback(ret)

ret：

- 类型：JSON对象

内部字段：

```js
{
    result:"success"     //是否成功，布尔类型
    code : 1000 //打开成功
}
```

##示例代码

```js
var chromeDebug = api.require('chromeDebug');
chromeDebug.openDebug(function(ret, err) {
    if (212 == ret.code) {
        alert(JSON.stringify(ret));
    } else {
        console.log(ret);
    }
});
```

##补充说明

    无

##可用性

    Android系统

    可提供的1.0.0及更高版本


#**closeDebug**<div id="2"></div>

    关闭chrome调试HTML5页面的开关，虽然一般也用不到。

    closeDebug(callback(ret))

##callback(ret)

ret：

- 类型：JSON对象

内部字段：

```js
{
    result:"success"     //是否成功，布尔类型
    code : 1000 //打开成功
}
```

##示例代码

```js
var chromeDebug = api.require('chromeDebug');
chromeDebug.closeDebug(function(ret, err) {
    if (212 == ret.code) {
        alert(JSON.stringify(ret));
    } else {
        console.log(ret);
    }
});
```

##补充说明

    无

##可用性

    Android系统

    可提供的1.0.0及更高版本



#**错误码**<div id="3"></div>

1. 1000 请求成功

2. 212 手机的Android版本低于4.4，不支持此功能