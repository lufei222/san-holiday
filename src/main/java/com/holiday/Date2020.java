package com.holiday;

import java.util.HashSet;
import java.util.Set;

public class Date2020 implements DateService{

    /**
     * 手动维护2020年的法定节假日
     * @return
     */
    @Override
    public Set<String> getLegalHoliday(){
        Set<String> holidays = new HashSet<String>();
        //元旦
        holidays.add("20200101");
        //春节
        holidays.add("20200124");
        holidays.add("20200125");
        holidays.add("20200126");
        holidays.add("20200127");
        holidays.add("20200128");
        holidays.add("20200129");
        holidays.add("20200130");
        //清明节
        holidays.add("20200404");
        holidays.add("20200405");
        holidays.add("20200406");
        //劳动节
        holidays.add("20200501");
        holidays.add("20200502");
        holidays.add("20200503");
        holidays.add("20200504");
        holidays.add("20200505");
        //端午节
        holidays.add("20200625");
        holidays.add("20200626");
        holidays.add("20200627");
        //中秋节
        //国庆节
        holidays.add("20201001");
        holidays.add("20201002");
        holidays.add("20201003");
        holidays.add("20201004");
        holidays.add("20201005");
        holidays.add("20201006");
        holidays.add("20201007");
        holidays.add("20201008");
        return holidays;
    }

    /**
     * 手动维护2020年的法定节假日的调休上班工作日
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
        restDays.add("20200119");
        restDays.add("20200201");
        restDays.add("20200426");
        restDays.add("20200509");
        restDays.add("20200628");
        restDays.add("20200927");
        restDays.add("20201010");
        return restDays;
    }


}
