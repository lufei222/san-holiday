package com.holiday;

public class DateServiceFactory {

    public  DateService getDateByYear(int year) {

        //对消息类型分类处理
        switch (year) {
            //客户端心跳报文 -0
            case 2020: {
                return new Date2020();
            }
            //1
            case 2019: {
                return new Date2019();
            }


            default:
                //省略
                break;
        }

        return null;
    }
}