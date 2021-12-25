package com.holiday;

import java.util.HashSet;
import java.util.Set;

/***国务院办公厅关于2022年
  **部分节假日安排的通知
  **国办发明电〔2022〕11号
 * http://www.gov.cn/zhengce/content/2021-10/25/content_5644835.htm
 */
public class Date2022 implements DateService{

    /**
     * 手动维护2022年的法定节假日
     * @return
     */
    @Override
    public Set<String> getLegalHoliday(){
        Set<String> holidays = new HashSet<String>();
        //元旦,2022年1月1日至3日放假，共3天。
        holidays.add("20220101");
        holidays.add("20220102");
        holidays.add("20220103");

        //春节,1月31日至2月6日放假调休，共7天
        holidays.add("20220131");
        holidays.add("20220201");
        holidays.add("20220202");
        holidays.add("20220203");
        holidays.add("20220204");
        holidays.add("20220205");
        holidays.add("20220206");
        //清明节,4月3日至5日放假调休，共3天
        holidays.add("20220403");
        holidays.add("20220404");
        holidays.add("20220405");
        //劳动节，4月30日至5月4日放假调休，共5天
        holidays.add("20220430");
        holidays.add("20220501");
        holidays.add("20220502");
        holidays.add("20220503");
        holidays.add("20220504");


        //端午节，6月3日至5日放假，共3天。
        holidays.add("20220603");
        holidays.add("20220604");
        holidays.add("20220605");
        //中秋节，9月10日至12日放假，共3天
        holidays.add("20220910");
        holidays.add("20220911");
        holidays.add("20220912");
        //国庆节，10月1日至7日放假调休，共7天。
        holidays.add("20221001");
        holidays.add("20221002");
        holidays.add("20221003");
        holidays.add("20221004");
        holidays.add("20221005");
        holidays.add("20221006");
        holidays.add("20221007");
        return holidays;
    }

    /**
     * 手动维护2022年的法定节假日的调休上班工作日
     * @return
     */
    @Override
    public Set<String> getAdjustRestWorkDays() {
        Set<String> restDays = new HashSet<String>();
        //元旦
        //春节，1月29日（星期六）、1月30日（星期日）上班。
        restDays.add("20220129");
        restDays.add("20220130");
        //清明节，4月2日（星期六）上班。
        restDays.add("20220402");
        //劳动节，4月24日（星期日）、5月7日（星期六）上班。
        restDays.add("20220424");
        restDays.add("20220507");
        //端午节
        //中秋节
        //国庆节，10月8日（星期六）、10月9日（星期日）上班。
        restDays.add("20221008");
        restDays.add("20221009");

        return restDays;
    }


}
