/**
 * Created by linquan on 2017/9/29.
 */
$(function (){
    if(cookie.get("loginName")!=null){
        var loginName=cookie.get("loginName");//设置为7天过期
        var loginPwd=cookie.get("loginPwd");//设置为7天过期
        $("#inputEmail").val(loginName);
        $("#inputPassword").val(loginPwd);
    }

    $("#login").click(function ()
    {
       var loginName=$("#inputEmail").val();
       var password=$("#inputPassword").val();
        if(loginName==""){
            alert("账号不能为空！");
            return false;
        }
        if(password==""){
            alert("密码不能为空！")
            return false;
        }
       var isCheck=false;
        debugger
       if($("#remeberPassWord").is(":checked")){
           isCheck=true;
        }
        login(loginName,password,isCheck);
    })

})




//登录
function  login(userName,passWord,isSave)
{
    var user=new Object();
    user.userName=userName;
    user.passWord=passWord;
    $.ajax({
        type:"POST",
      //  dataType:"json",
        url:"/page/login.do",
        data:user,
        beforeSend : function(XMLHttpRequest) {
        },
        success: function(data) {
            window.location.href="/page/home.do";
            if(isSave){
                //保存cookie
                cookie.set("loginName",uName,30);//设置为7天过期
                cookie.set("loginPwd",pWord,30);//设置为7天过期
            }else{
                //删除cookie
                cookie.deletedCookies("loginName");
                cookie.deletedCookies("loginPwd");
            }
        },
        error : function(XMLHttpRequest, textStatus, errorThrown) {
            alert("Error");
        }
    })
}

var cookie={
    set:function(key,val,time){//设置cookie方法
        var date=new Date(); //获取当前时间
        var expiresDays=time;  //将date设置为n天以后的时间
        date.setTime(date.getTime()+expiresDays*24*3600*1000); //格式化为cookie识别的时间
        document.cookie=key + "=" + val +";expires="+date.toGMTString();  //设置cookie
    },
    get:function(key){//获取cookie方法
        /*获取cookie参数*/
        var getCookie = document.cookie.replace(/[ ]/g,"");  //获取cookie，并且将获得的cookie格式化，去掉空格字符
        var arrCookie = getCookie.split(";");//将获得的cookie以"分号"为标识 将cookie保存到arrCookie的数组中
        var tips;  //声明变量tips
        for(var i=0;i<arrCookie.length;i++){//使用for循环查找cookie中的tips变量
            var arr=arrCookie[i].split("=");//将单条cookie用"等号"为标识，将单条cookie保存为arr数组
            if(key==arr[0]){//匹配变量名称，其中arr[0]是指的cookie名称，如果该条变量为tips则执行判断语句中的赋值操作
                tips=arr[1];//将cookie的值赋给变量tips
                break;//终止for循环遍历
            }
        }
        return tips;
    },
    deletedCookies:function(key){ //删除cookie方法
        var date = new Date(); //获取当前时间
        date.setTime(date.getTime()-10000); //将date设置为过去的时间
        document.cookie = key + "=v; expires =" +date.toGMTString();//设置cookie
    }
};