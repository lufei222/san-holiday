package com.holiday;

import java.util.HashSet;
import java.util.Set;

/***国务院办公厅关于2023年
  **部分节假日安排的通知
  **国办发明电〔2022〕16号
 * http://www.gov.cn/zhengce/content/2022-12/08/content_5730844.htm
 */
public class Date2023 implements DateService{

    /**
     * 手动维护2023年的法定节假日
     * @return
     */
    @Override
    public Set<String> getLegalHoliday(){
        Set<String> holidays = new HashSet<String>();
        //元旦,2022年12月31日至2023年1月2日放假调休，共3天
        //holidays.add("20221231");
        holidays.add("20230101");
        holidays.add("20230102");

        //春节,1月21日至27日放假调休，共7天。1月28日（星期六）、1月29日（星期日）上班。
        holidays.add("20230121");
        holidays.add("20230122");
        holidays.add("20230123");
        holidays.add("20230124");
        holidays.add("20230125");
        holidays.add("20230126");
        holidays.add("20230127");
        //清明节,4月5日放假，共1天。
        holidays.add("20230405");
        //劳动节，4月29日至5月3日放假调休，共5天。4月23日（星期日）、5月6日（星期六）上班。
        holidays.add("20230429");
        holidays.add("20230430");
        holidays.add("20230501");
        holidays.add("20230502");
        holidays.add("20230503");
        //端午节，6月22日至24日放假调休，共3天。6月25日（星期日）上班。
        holidays.add("20230622");
        holidays.add("20230623");
        holidays.add("20230624");
        //中秋节、国庆节，9月29日至10月6日放假调休，共8天。10月7日（星期六）、10月8日（星期日）上班。
        holidays.add("20230929");
        holidays.add("20230930");
        holidays.add("20231001");
        holidays.add("20231002");
        holidays.add("20231003");
        holidays.add("20231004");
        holidays.add("20231005");
        holidays.add("20231006");
       return holidays;
    }

    /**
     * 手动维护2023年的法定节假日的调休上班工作日
     * @return
     */
    @Override
    public Set<String> getAdjustRestWorkDays() {
        Set<String> restDays = new HashSet<String>();
        //元旦
        //春节，1月28日（星期六）、1月29日（星期日）上班。
        restDays.add("20230128");
        restDays.add("20230129");
        //清明节
        //劳动节，4月23日（星期日）、5月6日（星期六）上班。
        restDays.add("20230423");
        restDays.add("20230506");
        //端午节，6月25日（星期日）上班。
        restDays.add("20230625");
        //中秋节
        //国庆节，10月7日（星期六）、10月8日（星期日）上班。
        restDays.add("20231007");
        restDays.add("20231008");

        return restDays;
    }


}
