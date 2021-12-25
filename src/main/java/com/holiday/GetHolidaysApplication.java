package com.holiday;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class GetHolidaysApplication {

    //日期格式分隔符，格式如20220101或2022-01-01，""/"-"
    private  static String SEPARATOR = "";
    private static int YEAR = 2022;
    static SimpleDateFormat yyyyMMddFMT = new SimpleDateFormat("yyyyMMdd") ;
    /**
     * 全年假期集合 = [查询全年的双休周末] + [得到所有的法定节假日] - [所有的调休日])
     * 插入数据库时，先看数据库是否已存在，已存在则不重复插入
     */
    public static void main(String[] args) {

        System.out.println("正在处理的年份是--------"+YEAR);
        Set<String> allHolidays = new HashSet<>();

        //查询全年的双休周末
        Set<String> yearDoubleWeekend = getWeekDayList(YEAR);

        allHolidays.addAll(yearDoubleWeekend);
        // [+]
        Set<String> legalHolidays = new DateServiceFactory().getDateByYear(YEAR).getLegalHoliday();
        allHolidays.addAll(legalHolidays);
        //得到所有的法定节假日
        // [-]
        //得到所有的调休为上班的日期
        Set<String> adjustRestWorkDays =  new DateServiceFactory().getDateByYear(YEAR).getAdjustRestWorkDays();
        //修复之前没有把调休日去掉的问题
        allHolidays = allHolidays.stream().filter(x->!adjustRestWorkDays.contains(x)).collect(Collectors.toSet());

        // [-]
        //查询数据库已经存在的假期集合，
        List<LinkedHashMap<String, Object>> existDBHolidaysMap = DBConfig.getListSql(" select *  from no_work_day;");
        Set<String> existDBHolidaysSet = new HashSet<>();
        existDBHolidaysMap.forEach(x->{
            existDBHolidaysSet.add(x.get("day").toString());
        });
        allHolidays = allHolidays.stream().filter(x->!existDBHolidaysSet.contains(x)).collect(Collectors.toSet());

        //排序
        List<Integer> allHolidaysInt = allHolidays.stream().map(x -> Integer.valueOf(x)).collect(Collectors.toList());
        allHolidaysInt.sort(Comparator.naturalOrder());

        int allHolidaysSize = allHolidaysInt==null || allHolidaysInt.size()==0 ? 0 : allHolidaysInt.size();
        System.out.println("当前插入新的数据allHolidaysInt.size=" + allHolidaysSize +" 条\n"+allHolidaysInt);
        //插入所有假期数据到假期表中
        batchInsertHolidaysToDB(allHolidaysInt);
        System.out.println("插入"+YEAR+"年所有假期成功");

    }

    private static void batchInsertHolidaysToDB(List<Integer> allHolidaysInt) {
        List<LinkedHashMap<String, String>> list =new ArrayList<>();
        try {
            allHolidaysInt.forEach(day->{
                LinkedHashMap<String, String> map = new LinkedHashMap<>();
                map.put("day",day+"");
                list.add(map);
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        String sql= "insert into no_work_day (day) values(?);";
        DBConfig.batchInsert(list,sql);
    }

    /** test，unused
     * 获取补班日、节假日
     */
    @org.junit.Test
    @Deprecated
    public void get2020AllSpecialDays() {
        DateTimeFormatter yyMMddFMT = DateTimeFormat.forPattern("yyyy-MM-dd");

        String days = "{\"code\":0,\"holiday\":{\"01-01\":{\"holiday\":true,\"name\":\"元旦\",\"wage\":3,\"date\":\"2020-01-01\"},\"01-19\":{\"holiday\":false,\"name\":\"春节前调休\",\"after\":false,\"wage\":1,\"target\":\"春节\",\"date\":\"2020-01-19\"},\"01-24\":{\"holiday\":true,\"name\":\"除夕\",\"wage\":2,\"date\":\"2020-01-24\"},\"01-25\":{\"holiday\":true,\"name\":\"初一\",\"wage\":3,\"date\":\"2020-01-25\"},\"01-26\":{\"holiday\":true,\"name\":\"初二\",\"wage\":3,\"date\":\"2020-01-26\"},\"01-27\":{\"holiday\":true,\"name\":\"初三\",\"wage\":3,\"date\":\"2020-01-27\"},\"01-28\":{\"holiday\":true,\"name\":\"初四\",\"wage\":2,\"date\":\"2020-01-28\"},\"01-29\":{\"holiday\":true,\"name\":\"初五\",\"wage\":2,\"date\":\"2020-01-29\"},\"01-30\":{\"holiday\":true,\"name\":\"初六\",\"wage\":2,\"date\":\"2020-01-30\"},\"02-01\":{\"holiday\":false,\"name\":\"春节后补休\",\"after\":true,\"wage\":1,\"target\":\"春节\",\"date\":\"2020-02-01\"},\"04-04\":{\"holiday\":true,\"name\":\"清明节\",\"wage\":3,\"date\":\"2020-04-04\"},\"04-05\":{\"holiday\":true,\"name\":\"清明节\",\"wage\":2,\"date\":\"2020-04-05\"},\"04-06\":{\"holiday\":true,\"name\":\"清明节\",\"wage\":2,\"date\":\"2020-04-06\"},\"04-26\":{\"holiday\":false,\"name\":\"劳动节前调休\",\"after\":false,\"wage\":1,\"target\":\"劳动节\",\"date\":\"2020-04-26\"},\"05-01\":{\"holiday\":true,\"name\":\"劳动节\",\"wage\":3,\"date\":\"2020-05-01\"},\"05-02\":{\"holiday\":true,\"name\":\"劳动节\",\"wage\":2,\"date\":\"2020-05-02\"},\"05-03\":{\"holiday\":true,\"name\":\"劳动节\",\"wage\":2,\"date\":\"2020-05-03\"},\"05-04\":{\"holiday\":true,\"name\":\"劳动节\",\"wage\":2,\"date\":\"2020-05-04\"},\"05-05\":{\"holiday\":true,\"name\":\"劳动节\",\"wage\":2,\"date\":\"2020-05-05\"},\"05-09\":{\"holiday\":false,\"name\":\"劳动节后调休\",\"after\":true,\"wage\":1,\"target\":\"劳动节\",\"date\":\"2020-05-09\"},\"06-25\":{\"holiday\":true,\"name\":\"端午节\",\"wage\":3,\"date\":\"2020-06-25\"},\"06-26\":{\"holiday\":true,\"name\":\"端午节\",\"wage\":2,\"date\":\"2020-06-26\"},\"06-27\":{\"holiday\":true,\"name\":\"端午节\",\"wage\":2,\"date\":\"2020-06-27\"},\"06-28\":{\"holiday\":false,\"after\":true,\"name\":\"端午节后调休\",\"wage\":1,\"target\":\"端午节\",\"date\":\"2020-06-28\"},\"09-27\":{\"holiday\":false,\"after\":false,\"name\":\"国庆节前调休\",\"wage\":1,\"target\":\"国庆节\",\"date\":\"2020-09-27\"},\"10-01\":{\"holiday\":true,\"name\":\"中秋节\",\"wage\":3,\"date\":\"2020-10-01\"},\"10-02\":{\"holiday\":true,\"name\":\"国庆节\",\"wage\":3,\"date\":\"2020-10-02\"},\"10-03\":{\"holiday\":true,\"name\":\"国庆节\",\"wage\":3,\"date\":\"2020-10-03\"},\"10-04\":{\"holiday\":true,\"name\":\"国庆节\",\"wage\":2,\"date\":\"2020-10-04\"},\"10-05\":{\"holiday\":true,\"name\":\"国庆节\",\"wage\":2,\"date\":\"2020-10-05\"},\"10-06\":{\"holiday\":true,\"name\":\"国庆节\",\"wage\":2,\"date\":\"2020-10-06\"},\"10-07\":{\"holiday\":true,\"name\":\"国庆节\",\"wage\":2,\"date\":\"2020-10-07\"},\"10-08\":{\"holiday\":true,\"name\":\"国庆节\",\"wage\":2,\"date\":\"2020-10-08\"},\"10-10\":{\"holiday\":false,\"name\":\"国庆节后调休\",\"after\":true,\"wage\":1,\"target\":\"国庆节\",\"date\":\"2020-10-10\"}}}";
        JSONObject obj = JSON.parseObject(days);

        Map<String, Object> map = new HashMap<>();
        Iterator it = obj.entrySet().iterator();

        ArrayList<Integer> workDays = new ArrayList<>();
        ArrayList<Integer> holidays = new ArrayList<>();

        while (it.hasNext()) {
            Map.Entry<String, Object> entry = (Map.Entry<String, Object>) it.next();
            map.put(entry.getKey(), entry.getValue());
            if(entry.getKey().contains("holiday")){
                Map<String,Object> holidaysMap =(Map)entry.getValue();
                holidaysMap.forEach((k,v)->{
                    String dayLine = "2020-" + k;
                    String day = DateTime.parse(dayLine, yyMMddFMT).toString("yyyyMMdd");
                    if((Boolean) ((JSONObject) v).get("holiday")==false){
                        workDays.add(Integer.valueOf(day));
                    }
                    if((Boolean) ((JSONObject) v).get("holiday")==true){
                        holidays.add(Integer.valueOf(day));
                    }
                });
            }
        }
        System.out.println("补班日-------->");
        Collections.sort(workDays);
        workDays.forEach(x->{
            System.out.println(x);
        });
        System.out.println("节假日-------->");
        Collections.sort(holidays);
        holidays.forEach(x->{
            System.out.println(x);
        });

    }

    public static Set<String> getWeekDayList(int year) {
        Set<String> listDate = new HashSet<>();
        int i = 1;
        Calendar calendar = new GregorianCalendar(year, 0, 1);

        while (calendar.get(Calendar.YEAR) < year + 1) {
            calendar.set(Calendar.WEEK_OF_YEAR, i++);

            calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
            if (calendar.get(Calendar.YEAR) == year) {
                listDate.add(yyyyMMddFMT.format(calendar.getTime()));
            }
            calendar.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
            if (calendar.get(Calendar.YEAR) == year) {
                listDate.add(yyyyMMddFMT.format(calendar.getTime()));
            }
        }
        return listDate;
    }


}
