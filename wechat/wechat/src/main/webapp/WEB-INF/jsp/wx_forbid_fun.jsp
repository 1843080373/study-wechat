<%@ page language="java" contentType="text/html; charset=utf-8"	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <link rel="icon" type="image/x-icon" href="/static/favicon.ico">
<title>禁用微信分享按钮&模板消息</title>
<script src="https://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>
<script type="text/javascript" src="js/jquery-2.0.0.min.js"></script>
<!-- 禁用微信分享按钮 1,解决了一个坑：IOS页面回退后再次出现分享按钮 -->
<script>
    $(function(){  
    	    wx.hideMenuItems({
	        menuList: ["menuItem:share:timeline", "menuItem:copyUrl", "menuItem:share:appMessage", "menuItem:share:qq", "menuItem:share:weiboApp", "menuItem:favorite", "menuItem:share:facebook", "menuItem:share:QZone", "menuItem:editTag", "menuItem:delete", "menuItem:copyUrl", "menuItem:originPage", "menuItem:readMode", "menuItem:openWithQQBrowser", "menuItem:openWithSafari", "menuItem:share:email", "menuItem:share:brand"] // 要隐藏的菜单项，只能隐藏“传播类”和“保护类”按钮
	    });
     }); 

    
     function closePage(){
     	WeixinJSBridge.invoke('closeWindow', {}, function (res) { alert(1)});
      }

     function sendTemplateMsg(){
    	 $.ajax({
             type: "POST",
             url: "/sendTemplateMsg",
             data: {
            	 
             },
             success: function(data){
            	 var msg=data.msg;
            	 alert(msg);
              }
          });
     }
</script>
</head>
<body>
<a href="javascript:sendTemplateMsg();" >微信发送模板消息</a><br/>
<a href="/wx_login" >登录授权</a><br/>
<br>
<br>
<a href="javascript:closePage();" >关闭页面</a><br/>
</body>
</html>