/**
 * Created by linquan on 2017/10/25.
 */
var  RegExpUtil=function ()
{
    
};
/**
 * 是否为邮箱
 * @param str
 */
RegExpUtil.prototype.isEmail=function(str){
    var reg = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/;
    return reg.test(str);
}
/**
 * 校验用户姓名：只能输入1-30个以字母开头的字串
 * @param s
 * @returns {boolean}
 */
RegExpUtil.prototype.isTrueName=function(str){
    var reg=/^[a-zA-Z]{1,30}$/;
    return reg.test(str)
}
/**
 * 校验密码：只能输入6-20个字母、数字、下划线
 * @param s
 * @returns {boolean}
 */
RegExpUtil.prototype.isPasswd=function(str)
{
    var reg=/^(\w){6,20}$/;
    return reg.test(str);
}
/**
 * 验证URL
 * @param str
 * @returns {boolean}
 */
RegExpUtil.prototype.isURL=function(str){
    var strRegex = '^((https|http|ftp|rtsp|mms)?://)'
        + '?(([0-9a-z_!~*\'().&=+$%-]+: )?[0-9a-z_!~*\'().&=+$%-]+@)?' //ftp的user@
        + '(([0-9]{1,3}.){3}[0-9]{1,3}' // IP形式的URL- 199.194.52.184
        + '|' // 允许IP和DOMAIN（域名）
        + '([0-9a-z_!~*\'()-]+.)*' // 域名- www.
        + '([0-9a-z][0-9a-z-]{0,61})?[0-9a-z].' // 二级域名
        + '[a-z]{2,6})' // first level domain- .com or .museum
        + '(:[0-9]{1,4})?' // 端口- :80
        + '((/?)|' // a slash isn't required if there is no file name
        + '(/[0-9a-z_!~*\'().;?:@&=+$,%#-]+)+/?)$';
    var re=new RegExp(strRegex);
    //re.test()
    if (re.test(str_url)) {
        return (true);
    } else {
        return (false);
    }
}
