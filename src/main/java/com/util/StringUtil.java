package com.util;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {

    /*
     * 下划线
     */
    private static final String SEPARATOR = "_";

    public static final String EMPTY = "";
    /**
     * 返回用"','"号分隔的sql in条件字符串
     *
     * @param str 用,号分隔的字符串，如1,2,5
     * @return 返回用"','"号分隔的字符串 例：'1','2','5'
     */
    public static String getSqlInClauseFromQuoteString(String str) {
        String retString = "";
        if (null == str) {
            return "";
        }
        String[] arrStrings = str.split(",");
        for (int i = 0; i < arrStrings.length; i++) {
            if (i > 0) {
                retString += ",";
            }
            retString += "'" + arrStrings[i] + "'";
        }
        return retString;
    }

    /**
     * 返回用"','"号分隔的sql in条件字符串
     *
     * @param str 用,号分隔的字符串，如1,2,5
     * @return 返回用"','"号分隔的字符串 例：'1','2','5'
     */
    public static String getSqlInQuote(String str) {
        return getSqlInClauseFromQuoteString(str);
    }

    /**
     * 去掉字符串中重复的字符 返回用','号分隔的字符串
     *
     * @param str       用','号分隔的字符串
     * @param isAddSign 是否带上［］符号 true 是 false 否
     * @return 返回用','号分隔带［］的字符串 例：[字段1],[字段2],[字段3]
     */
    public static String GetStringUnique(String str, boolean isAddSign) {
        String strTemp = "";
        StringBuilder oSB = new StringBuilder();
        List al = new ArrayList();
        String[] strArray = str.replace(")", "").replace("[", "").replace("]", "").split(",");
        for (int k = 0; k < strArray.length; k++) {
            strTemp = strArray[k].toUpperCase();

            // 特殊情况：convert(bigint,流水号) 的处理
            if (strTemp.contains("CONVERT")) {
                continue;
            }

            // 遍历每个字符是否在字符串中
            if (!al.contains(strTemp)) {
                al.add(strArray[k].toUpperCase());
                if (isAddSign) {
                    oSB.append(",[" + strArray[k] + "]");
                } else {
                    oSB.append("," + strArray[k]);
                }
            }
        }
        return (oSB.length() > 0) ? oSB.substring(1) : "";
    }

    /**
     * 判断是否为空或为null
     *
     * @param inputString String
     * @return boolean
     */
    public static boolean isNotNullOrEmpty(String inputString) {
        return !(inputString == null || "".equals(inputString) || "null".equals(inputString)
                || "undefined".equals(inputString));
    }

    /**
     * 判断是否为空或为null
     *
     * @param inputString String
     * @return boolean
     */
    public static boolean isNullOrEmpty(String inputString) {
        return !StringUtil.isNotNullOrEmpty(inputString);
    }

    /**
     * 取得真实值,如果为null,'null','NULL'则返回空""
     *
     * @param obj Object
     * @return String
     */
    public static String getObjectRealValue(Object obj) {
        if (obj == null) {
            return "";
        }
        String inputString = obj.toString();
        if ("null".equals(inputString) || "NULL".equals(inputString)) {
            return "";
        }
        return inputString;
    }

    /**
     * 取得真实值,如果为null,'null','NULL'则返回空""
     *
     * @param inputString String
     * @return String
     */
    public static String getRealValue(String inputString) {
        if (inputString == null || "null".equals(inputString) || "NULL".equals(inputString))
            return "";
        return inputString;
    }

    /**
     * 取得真实值并将">","<"符号转换为"&lt;","&gt;"。如果为null,'null','NULL'则返回空""
     *
     * @param inputString String
     * @return String
     */
    public static String convertHTMLSymbol(String inputString) {
        if (inputString == null || "null".equals(inputString) || "NULL".equals(inputString))
            return "";
        inputString = inputString.replaceAll("<", "&lt;");
        inputString = inputString.replaceAll(">", "&gt;");
        return inputString;
    }

    /**
     * 将毫秒格式化为指定格式的数据返回，如38050120毫秒格式化后为：1.0时3.0分21.0秒12.0毫秒
     *
     * @param minSecond Long
     * @param format    String
     * @return String
     */
    public static String spiltMinsecond2HMS(Long minSecond, String format) {
        if (minSecond < 1)
            return minSecond.toString();
        try {
            double totalSec = minSecond / 1000;
            double leftMinsec = minSecond % 1000;
            double hh = minSecond.doubleValue() / 3600000;
            double hhd = Math.floor(hh);
            double min = (minSecond.doubleValue() % 3600000) / 60000;
            double mind = Math.floor(min);
            double sec = (360081) % 60;
            double secd = Math.floor(sec);
            return hhd + "时" + mind + "分" + secd + "秒" + leftMinsec + "毫秒";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return minSecond.toString();
    }

    public static String addSpace(int count) {
        String space = "";
        if (count < 1)
            return space;
        for (int index = 1; index <= count; index++) {
            space += " ";
        }
        return space;
    }

    /**
     * 返回不为null的字符串
     *
     * @param str String
     * @return String
     */
    public static String getNotNullStr(String str) {
        if (isNullOrEmpty(str)) {
            str = "";
        }
        return str;
    }

    /**
     * Object类型转换为String
     *
     * @param obj Object
     * @return String
     */
    public static String objToStr(Object obj) {
        String str = "";
        if (null != obj) {
            str = String.valueOf(obj);
        }
        return str;
    }

    /**
     * 下划线格式转驼峰格式，例:PROJECT_STATE --> projectState
     */
    public static String underLineToCamel(String param) {
        if (isNullOrEmpty(param)) {
            return "";
        }

        StringBuilder sb = new StringBuilder(param.toLowerCase());
        Matcher mc = Pattern.compile(SEPARATOR).matcher(param);
        int i = 0;
        while (mc.find()) {
            int position = mc.end() - (i++);
            if (param.length() < position + 1) {
                break;
            }
            sb.replace(position - 1, position + 1, sb.substring(position, position + 1).toUpperCase());
        }
        return sb.toString();
    }

    /**
     * 驼峰格式转下划线格式，例:projectState --> PROJECT_STATE
     */
    public static String camelTounderLine(String param) {
        if (isNullOrEmpty(param)) {
            return "";
        }

        int length = param.length();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            char c = param.charAt(i);
            if (Character.isUpperCase(c)) {
                sb.append(SEPARATOR);
                sb.append(Character.toUpperCase(c));
            } else {
                sb.append(Character.toUpperCase(c));
            }
        }
        return sb.toString();
    }

    /**
     * 补位
     *
     * @param length 补位位数
     * @param number 数字
     * @param flag   补位符号
     */
    public static String complement(int length, BigDecimal number, String flag) {
        String result = "";
        if (number == null || length <= 0) {
            return result;
        }
        result = String.format("%" + String.valueOf(length) + "s", StringUtil.objToStr(number)).replace(" ", flag);
        return result;
    }

    /**
     * 格式转换
     * 将：a,b,c格式数据转换为：'a','b','c'
     *
     * @param str String
     * @return String
     */
    public static String transStr2InCondition(String str) {
        StringBuilder result = new StringBuilder("");
        if (isNullOrEmpty(str) || isNullOrEmpty(str.replace(",", "").trim())) {
            return result.toString();
        }
        String[] strArr = str.split(",");
        for (String string : strArr) {
            result.append("'").append(string).append("'").append(",");
        }
        return result.deleteCharAt(result.length() - 1).toString();
    }


    /**
     * 过滤掉表情
     *
     * @param s
     * @return
     */
    public static String filterEmoticon(String s) {
        if (StringUtil.isNullOrEmpty(s)) {
            return "";
        }
        String newStr = s.replaceAll("[\\ud800\\udc00-\\udbff\\udfff\\ud800-\\udfff]", "");
        if (StringUtil.isNullOrEmpty(newStr)) {
            return "";
        }
        return newStr;
    }

    /**
     * 经纬度校验
     *
     * @param value
     * @param isLon 是否经度
     * @return
     */
    public static boolean matchLonLanPattern(Double value,boolean isLon) {
        if(value==null){
            return false;
        }
        String str = value.toString();
        String lon ="^(\\-|\\+)?(((\\d|[1-9]\\d|1[0-7]\\d|0{1,3})\\.\\d{0,6})|(\\d|[1-9]\\d|1[0-7]\\d|0{1,3})|180\\.0{0,6}|180)$";
        String lan ="^(\\-|\\+)?([0-8]?\\d{1}\\.\\d{0,6}|90\\.0{0,6}|[0-8]?\\d{1}|90)$";
        String regEx = isLon ? lon:lan;
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }
    /**
     * Convert byte[] to hex string.这里我们可以将byte转换成int，然后利用Integer.toHexString(int)来转换成16进制字符串。
     *
     * @param src byte[] data
     * @return hex string
     */
    public static String bytesToHexString(byte[] src) {
        StringBuilder stringBuilder = new StringBuilder("");
        if (src == null || src.length <= 0) {
            return null;
        }
        for (int i = 0; i < src.length; i++) {
            int v = src[i] & 0xFF;
            String hv = Integer.toHexString(v);
            if (hv.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(hv);
        }
        return stringBuilder.toString();
    }

    /**
     * Convert hex string to byte[]
     *
     * @param hexString the hex string
     * @return byte[]
     */
    public static byte[] hexStringToBytes(String hexString) {
        if (hexString == null || hexString.equals("")) {
            return null;
        }
        hexString = hexString.toUpperCase();
        int length = hexString.length() / 2;
        char[] hexChars = hexString.toCharArray();
        byte[] d = new byte[length];
        for (int i = 0; i < length; i++) {
            int pos = i * 2;
            d[i] = (byte) (charToByte(hexChars[pos]) << 4 | charToByte(hexChars[pos + 1]));
        }
        return d;
    }

    /**
     * Convert char to byte
     *
     * @param c char
     * @return byte
     */
    private static byte charToByte(char c) {
        return (byte) "0123456789ABCDEF".indexOf(c);
    }
}
