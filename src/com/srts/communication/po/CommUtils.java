package com.srts.communication.po;
/**
* 类描述：工具类
* 创建人：vector   
* 创建时间：2014-7-6 下午08:27:29   
* 备注：每页的记录数定义  
 */
public class CommUtils {
	/**
	 * 根据记录总数数和每页的记录数 计算页数
	 * 返回总页数
	 */
	public static int getAllPageNum(int allRowCount){
		int pageNum=0;
		if(allRowCount%recordsOnePage==0){
			pageNum=allRowCount/recordsOnePage;
		}else{
			pageNum=allRowCount/recordsOnePage+1;
		}
		return pageNum;
	}
	/**
	 * 每页显示的记录数
	 */
	public static int recordsOnePage=10;
	 /**
     * 全角空格为12288，半角空格为32
     * 其他字符半角(33-126)与全角(65281-65374)的对应关系是：均相差65248
     * 
     * 将字符串中的全角字符转为半角
     * @param src 要转换的包含全角的任意字符串
     * @return  转换之后的字符串
     */
    public static String toSemiangle(String src) {
        char[] c = src.toCharArray();
        for (int index = 0; index < c.length; index++) {
            if (c[index] == 12288) {// 全角空格
                c[index] = (char) 32;
            } else if (c[index] > 65280 && c[index] < 65375) {// 其他全角字符
                c[index] = (char) (c[index] - 65248);
            }
        }
        return String.valueOf(c);
    }
    /**
	 * 功能：根据数据长度返回显示时等长的字符串
	 * 返回类型：int
	 */
	public static String subString(String str){
		if(str.length()>15){
			str=str.substring(0, 10);
			str+=".....";
		}
		return str;
	}
}
