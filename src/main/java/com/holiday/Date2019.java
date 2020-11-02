package com.holiday;

import java.util.HashSet;
import java.util.Set;

public class Date2019 implements DateService{
    /**
     * 手动维护2019年的法定节假日
     * @return
     */
    @Override
    public Set<String> getLegalHoliday(){
        Set<String> holidays = new HashSet<String>();
        //元旦
        holidays.add("20190101");
        //春节
        holidays.add("20190202");
        holidays.add("20190203");
        holidays.add("20190204");
        holidays.add("20190205");
        holidays.add("20190206");
        holidays.add("20190207");
        holidays.add("20190208");
        holidays.add("20190209");
        holidays.add("20190210");
        holidays.add("20190211");
        holidays.add("20190212");
        holidays.add("20190213");
        //清明节
        holidays.add("20190405");
        holidays.add("20190406");
        holidays.add("20190407");
        //劳动节
        holidays.add("20190501");
        //端午节
        holidays.add("20190607");
        holidays.add("20190608");
        holidays.add("20190609");
        //中秋节
        holidays.add("20190913");
        holidays.add("20190914");
        holidays.add("20190915");
        //国庆节
        holidays.add("20191001");
        holidays.add("20191002");
        holidays.add("20191003");
        holidays.add("20191004");
        holidays.add("20191005");
        holidays.add("20191006");
        holidays.add("20191007");
        return holidays;
    }

    /**
     * 手动维护2019年的法定节假日的调休上班工作日
     * @return
     */
    @Override
    public Set<String> getAdjustRestWorkDays() {
        Set<String> restDays = new HashSet<String>();
        //元旦
        //春节
        //清明节
        //劳动节
        //端午节
        //中秋节
        //国庆节
        restDays.add("20190929");
        restDays.add("20191012");

        return restDays;
    }


}
