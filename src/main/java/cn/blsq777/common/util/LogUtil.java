package cn.blsq777.common.util;

import org.apache.log4j.Logger;

import java.util.Map;

/**
 * log4j日志工具类
 * @author sea
 * @version 1.1.0
 */
public class LogUtil
{
	/**
	 * 初始化log4j
	 */
	public static Logger log    = Logger.getLogger("file");
	/**
	 * 初始化sql_file
	 */
	public static Logger sql    = Logger.getLogger("sql_file");
	/**
	 * 初始化result_file
	 */
	public static Logger result = Logger.getLogger("result_file");
	/**
	 * 初始化error_file
	 */
	public static Logger error  = Logger.getLogger("error_file");
	
	/**
	 * -----------------------------
	 */
	public static String X ="-----------------------------";
	/**
	 * =============================
	 */
	public static String XX ="=============================";

	
	/**
	 * 获取类名、方法名、行号等打印信息
	 * @return
	 */
	public static String p() {
		int count=Thread.currentThread().getStackTrace().length;
		int index=count-1;
		// 获得当前类名
		String fileName = Thread.currentThread().getStackTrace()[index].getFileName();
		// 获得当前方法名
		String methodName = Thread.currentThread().getStackTrace()[index].getMethodName();
		//行号
		int lineNumber=Thread.currentThread().getStackTrace()[index].getLineNumber();
		
		return methodName+"("+fileName+":"+lineNumber+")";
	}	
	
	/**
	 * 参数拼接字符串
	 * @param objects
	 * @return
	 */
	public static String getParam(Object... objects) {
		StringBuffer sb=new StringBuffer();		
		if(objects!=null && objects.length>0){
			for (int i = 0; i < objects.length; i++) {
				Object object=objects[i];
				sb.append(initParam(object));
				if(i!=objects.length-1){
					sb.append("##");
				}
			}
		}
		
		return sb.toString();
	}
	
	/**
	 * 初始化参数
	 * @param object
	 * @return
	 */
	private static String initParam(Object object) {
		String valueString="";
		if(object!=null){
			if(object instanceof Object[]){
				valueString="[";
				Object[] newObjects=(Object[])object;
				if(newObjects!=null && newObjects.length>0){
					for (int j = 0; j < newObjects.length; j++) {
						valueString+=String.valueOf(newObjects[j]);
						if(j!=newObjects.length-1){
							valueString+=",";
						}
					}	
				}
				valueString+="]";
			}else if(object instanceof Map<?, ?>){
				valueString="[";
				Map<?, ?> map=(Map<?, ?>)object;
				if(map!=null && map.size()>0){
					int j=0;
					for (Map.Entry<?, ?> entry : map.entrySet()) {
						valueString+=String.valueOf(entry.getValue());
						if(j!=map.size()-1){
							valueString+=",";
						}
						j++;
					}
				}
				valueString+="]";
			}else{
				valueString=String.valueOf(object);
			}
		}
		
		return valueString;
	}
	
	public static void main(String[] args) {
		System.out.println(LogUtil.p());
	}
}
