<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%--<script src="http://user.qzone.qq.com/775155797/infocenter"></script>--%>
    <title>Title</title>
    <script src="/static/bootstrap-3.3.7-dist/jquery-3.1.0.js"></script>
</head>
<body>
<button onclick="getRequest()">getRequest</button>
<button onclick="createXmlHttp()">createXmlHttp</button>
<button onclick="getHtml()">getHtml</button>
<button onclick="getACookie()">getACookie</button>
<button onclick="writeToFrame()">writeToFrame</button>

<a href="http://www.qq.com" target="iframe">QQ</a>
<div id="qzone" style="width:500px;height:500px;background-color: #2aabd2"></div>
<iframe id="iframe" name="iframe" style="width: 500px;height: 500px; border-style: solid;border-color: #0f0f0f;">
</iframe>
<script>

    function writeToFrame() {
        var result = $('#iframe').prop('contentWindow').document;
        console.log(result);
        /*var frame = window.frames['iframe'];
        var arr,reg=new RegExp("(^| )"+"uin"+"=([^;]*)(;|$)");
        if(arr=frame.document.cookie.match(reg))
            alert(unescape(arr[2]));*/
        //frame.document.write("0000")
    }


    /* 用XMLHTTPRequest来进行ajax异步数据交交互*/
    //1.创建XMLHTTPRequest对象
    var xmlhttp;
    //最复杂的一步
    function getACookie(){
        //var username = document.getElementById('username').value;
        if (window.XMLHttpRequest) {
            // code for IE7+, Firefox, Chrome, Opera, Safari
            xmlhttp = new XMLHttpRequest;

            //针对某些特定版本的mozillar浏览器的bug进行修正。
            if (xmlhttp.overrideMimeType) {
                xmlhttp.overrideMimeType('text/xml');
            };

        } else if (window.ActiveXObject){
            // code for IE6, IE5
            xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
        };

        //2.注册回调函数
        //onreadystatechange是每次 readyState 属性改变的时候调用的事件句柄函数。
        xmlhttp.onreadystatechange = callback;

        //3.设置连接信息
        //初始化HTTP请求参数，但是并不发送请求。
        //第一个参数连接方式，第二是url地址,第三个true是异步连接，默认是异步
        xmlhttp.open("GET","http://www.qq.com",true);
        //使用P3P协议
        xmlhttp.setRequestHeader( "P3P" , 'CP="CURa ADMa DEVa PSAo PSDo OUR BUS UNI PUR INT DEM STA PRE COM NAV OTC NOI DSP COR"' );
        /*******************************************/
        /*如果是xmlhttp.open("GET","xhr.php",true);*/
        /*    xmlhttp.send('name=' +username);     */
        /*    不行的                               */
        /*******************************************/

        //使用post方式发送数据
        //xmlhttp.open("POST","xhr.php",true);
        //post需要自己设置http的请求头
        //xmlhttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded");

        //4，发送数据，开始和服务器进行交互
        //发送 HTTP 请求，使用传递给 open() 方法的参数，以及传递给该方法的可选请求体。
        //中如果true, send这句话会立即执行
        //如果是false（同步），send会在服务器数据回来才执行
        xmlhttp.send(null);
        //因为是get所以send中不需要内容
        //xmlhttp.send('name=' +username);

    }

    //5回调函数,不同相应状态进行处理
    function callback(){
        //alert(xmlhttp.readyState);
        //判断对象状态是交互完成，接收服务器返回的数据
        if (xmlhttp.readyState==4 && xmlhttp.status==200)
        {
            //["dada","xiaoyin","liujie"]
            //纯文本的数据
            var responseText = xmlhttp.responseText;
            var divNode = document.getElementById('box');
            //6.将服务器的数据显示在客户端
            console.log(responseText);
            divNode.innerHTML = responseText;
        }
    }





    
    /*function getACookie() {
        console.log("getACookie");

    }*/

    function getHtml() {
        $.ajax({
            url:"http://xui.ptlogin2.qq.com/cgi-bin/xlogin?daid=5&&hide_title_bar=1&low_login=0&qlogin_auto_login=1&no_verifyimg=1&link_target=blank&appid=549000912&style=22&target=self&s_url=http%3A//www.qq.com/contract20141204.htm",
            type:"post",
            dataType:"html",
            contentType: "application/text",
            success:function (data) {
                console.log(data)
            }
        })
    }



    /*$(function () {
        $('script').each(function(){console.log(this.text)});
    })*/

    function getRequest(){
       // $("#qzone").load("/getRequest");
        /*beforeSend: function (xhr) {
            xhr.setRequestHeader("Origin", "http://user.qzone.qq.com");
        },*/

       $.ajax({
            url:"http://www.qq.com",
            type:"post",
            crossDomain:true,
            contentType: "application/json",
            dataType:'jsonp',
            headers:{
              "Origin":"http://user.qzone.qq.com"
            },
           xhrFields:{
               withCredentials:true
           },

            success:function (state) {
                console.log("status:  "+state);
            },
            error:function (data) {
                alert("error");
                alert("json:   "+JSON.stringify(data));
            },
        })
    }

    function check(){
        alert('00');
    }


    function createXmlHttp(){
        $("#qzone").load("http://www.qq.com");
        //location.href=;
    }
</script>

</body>
</html>
