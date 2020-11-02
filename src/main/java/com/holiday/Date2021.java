package com.holiday;

import java.util.HashSet;
import java.util.Set;

public class Date2021 implements DateService{

    /**
     * 手动维护2021年的法定节假日
     * @return
     */
    @Override
    public Set<String> getLegalHoliday(){
        Set<String> holidays = new HashSet<String>();
        //元旦
        holidays.add("20210101");
        holidays.add("20210102");
        holidays.add("20210103");

        //春节
        holidays.add("20210211");
        holidays.add("20210212");
        holidays.add("20210213");
        holidays.add("20210214");
        holidays.add("20210215");
        holidays.add("20210216");
        holidays.add("20210217");
        //清明节
        holidays.add("20210403");
        holidays.add("20210404");
        holidays.add("20210405");
        //劳动节
        holidays.add("20210501");
        holidays.add("20210502");
        holidays.add("20210503");

        //端午节
        holidays.add("20210612");
        holidays.add("20210613");
        holidays.add("20210614");
        //中秋节
        holidays.add("20210921");
        //国庆节
        holidays.add("20211001");
        holidays.add("20211002");
        holidays.add("20211003");
        holidays.add("20211004");
        holidays.add("20211005");
        holidays.add("20211006");
        holidays.add("20211007");
        return holidays;
    }

    /**
     * 手动维护2021年的法定节假日的调休上班工作日
     * @return
     */
    @Override
    public Set<String> getAdjustRestWorkDays() {
        Set<String> restDays = new HashSet<String>();
        //元旦
        //春节
        restDays.add("20210218");
        //清明节
        //劳动节
        restDays.add("20210508");
        //端午节
        //中秋节
        //国庆节
        restDays.add("20211009");
        restDays.add("20211010");

        return restDays;
    }


}
