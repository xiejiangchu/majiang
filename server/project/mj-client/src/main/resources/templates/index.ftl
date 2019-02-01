<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <title>${title}</title>
    <meta charset="UTF-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="viewport"
          content="user-scalable=no, initial-scale=1, maximum-scale=1, minimum-scale=1, width=device-width">
    <meta http-equiv="Cache-Control" content="no-transform">
    <meta content="麻将,${title},约麻将" name="keywords">
    <meta content="${title}" name="description">
    <meta content="${title}" name="author">
    <meta content="2014-2016 bjmajiang.com Inc." name="copyright">
    <meta content="${title}" name="application-name">
    <meta content="${title}" name="msapplication-tooltip">
    <meta name='full-screen' content='true'/>
    <meta content="name=${title};action-uri=http://www.bjmajiang.com;icon-uri=http://www.bjmajiang.com/favicon.ico"
          name="msapplication-task">
    <meta name='laya' logoimg='icon/144.png' logobkcolor='#ffffff' screenorientation='landscape' cacheid='fffffffff'/>

    <meta name="apple-mobile-web-app-title" content="${title}">
    <!-- 添加到主屏后的标题（iOS 6 新增） -->
    <meta name="apple-mobile-web-app-capable" content="yes"/>
    <!-- 是否启用 WebApp 全屏模式，删除苹果默认的工具栏和菜单栏 -->
    <meta name="apple-mobile-web-app-status-bar-style" content="black"/>
    <!-- 设置苹果工具栏颜色 -->

    <!-- 针对手持设备优化，主要是针对一些老的不识别viewport的浏览器，比如黑莓 -->
    <meta name="HandheldFriendly" content="true">
    <!-- 微软的老式浏览器 -->
    <meta name="MobileOptimized" content="320">
    <!-- uc强制竖屏 -->
    <meta name="screen-orientation" content="landscape">
    <!-- QQ强制竖屏 -->
    <meta name="x5-orientation" content="landscape">
    <!-- UC强制全屏 -->
    <meta name="full-screen" content="yes">
    <!-- QQ强制全屏 -->
    <meta name="x5-fullscreen" content="true">
    <!-- UC应用模式 -->
    <meta name="browsermode" content="application">
    <!-- QQ应用模式 -->
    <meta name="x5-page-mode" content="app">
    <!-- windows phone 点击无高光 -->
    <meta name="msapplication-tap-highlight" content="no">

    <link rel="shortcut icon" href="/icon/favicon.ico" type="image/x-icon">
    <link rel="icon" href="/icon/60.png" type="image/png">

    <link rel="apple-touch-icon" href="/icon/57.png"/>
    <link rel="apple-touch-icon" sizes="72x72" href="/icon/72.png"/>
    <link rel="apple-touch-icon" sizes="114x114" href="/icon/114.png"/>
    <link rel="apple-touch-icon" sizes="144x144" href="/icon/144.png"/>
</head>
<body style='margin:0;overflow:hidden;overflow-x:hidden;overflow-y:hidden;background-color: #000;'>
<script>
    window.gameInit = function (obj, initCallback) {
        window.$initCallback = initCallback.bind(obj);
    }
    window.serverUrl="${serverUrl}";
</script>
抵制不良游戏，拒绝盗版游戏。注意自我保护，谨防上当受骗。
适度游戏益脑，沉迷游戏伤身。合理安排时间，享受健康生活。
<script src='myLaya.max.js' loader='laya'></script>
<script>
    <#--Laya.URL.customFormat = function (url, basePath) {-->
        <#--if (url == null) {-->
            <#--return null;-->
        <#--}-->
        <#--if (url.indexOf("$v") > -1) {-->
            <#--return url;-->
        <#--}-->
        <#--return url + "?$v=${version}";-->
    <#--};-->

    if (window.$initCallback) {
        window.$initCallback();
    }
</script>
</body>
</html>
