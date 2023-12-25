package com.holiday;

import java.util.HashSet;
import java.util.Set;

/***国务院办公厅关于2024年
  **部分节假日安排的通知
  **国办发明电〔2022〕16号
 * http://www.gov.cn/zhengce/content/2022-12/08/content_5730844.htm
 */
public class Date2024 implements DateService{

    /**
     * 手动维护2024年的法定节假日
     * @return
     */
    @Override
    public Set<String> getLegalHoliday(){
        Set<String> holidays = new HashSet<String>();
        //元旦,1月1日放假，与周末连休。
        holidays.add("20240101");
        //春节2月10日至17日放假调休，共8天。2月4日（星期日）、2月18日（星期日）上班。鼓励各单位结合带薪年休假等制度落实，安排职工在除夕（2月9日）休息。
        holidays.add("20240210");
        holidays.add("20240211");
        holidays.add("20240212");
        holidays.add("20240213");
        holidays.add("20240214");
        holidays.add("20240215");
        holidays.add("20240216");
        holidays.add("20240217");
        //清明节，4月4日至6日放假调休，共3天。4月7日（星期日）上班。
        holidays.add("20240404");
        holidays.add("20240405");
        holidays.add("20240406");
        //劳动节，5月1日至5日放假调休，共5天。4月28日（星期日）、5月11日（星期六）上班。
        holidays.add("20240501");
        holidays.add("20240502");
        holidays.add("20240503");
        holidays.add("20240504");
        holidays.add("20240505");
        //端午节，6月10日放假，与周末连休
        holidays.add("20240610");
        //中秋节、9月15日至17日放假调休，共3天。9月14日（星期六）上班。
        holidays.add("20240915");
        holidays.add("20240916");
        holidays.add("20240917");
        //国庆节、10月1日至7日放假调休，共7天。9月29日（星期日）、10月12日（星期六）上班。
        holidays.add("20241001");
        holidays.add("20241002");
        holidays.add("20241003");
        holidays.add("20241004");
        holidays.add("20241005");
        holidays.add("20241006");
        holidays.add("20241007");
        return holidays;
    }

    /**
     * 手动维护2024年的法定节假日的调休上班工作日
     * @return
     */
    @Override
    public Set<String> getAdjustRestWorkDays() {
        Set<String> restDays = new HashSet<String>();
        //元旦
        //春节，2月4日（星期日）、2月18日（星期日）上班
        restDays.add("20240204");
        restDays.add("20240218");
        //清明节 4月7日（星期日）上班。
        restDays.add("20240407");
        //劳动节，4月28日（星期日）、5月11日（星期六）上班。
        restDays.add("20240428");
        restDays.add("20240511");
        //端午节
        //中秋节 9月14日（星期六）上班。
        restDays.add("20240914");
        //国庆节，10月7日（星期六）、10月8日（星期日）上班。
        restDays.add("20240929");
        restDays.add("20241012");

        return restDays;
    }


}
