import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class GetHolidays {

    //日期格式分隔符，格式如20190101或2019-01-01，""/"-"
    private  static String SEPARATOR = "";
    private static int YEAR = 2020;
    static SimpleDateFormat yyyyMMddFMT = new SimpleDateFormat("yyyyMMdd") ;



    /**
     *         全年假期集合 = [查询全年的双休周末] + [得到所有的法定节假日] - [得到所有的调休日] - [查询数据库已经存在的假期集合]
     * @param args
     */
    public static void main(String[] args) {

        Set<String> allHolidays = new HashSet<>();

        //查询全年的双休周末
        Set<String> yearDoubleWeekend = getWeekDayList(YEAR);

        allHolidays.addAll(yearDoubleWeekend);
        // [+]
        Set<String> legalHolidays = getLegalHoliday(YEAR);
        allHolidays.addAll(legalHolidays);
        //得到所有的法定节假日
        // [-]
        //得到所有的调休为上班的日期
        Set<String> adjustRestWorkDays = getAdjustRestWorkDays(YEAR);
        allHolidays.stream().filter(x->adjustRestWorkDays.contains(x)).collect(Collectors.toSet());

        // [-]
        //查询数据库已经存在的假期集合，
        List<LinkedHashMap<String, Object>> existDBHolidaysMap = DBhepler.getListSql(" select *  from no_work_day;");
        Set<String> existDBHolidaysSet = new HashSet<>();
        existDBHolidaysMap.forEach(x->{
            existDBHolidaysSet.add(x.get("day").toString());
        });
        allHolidays = allHolidays.stream().filter(x->!existDBHolidaysSet.contains(x)).collect(Collectors.toSet());

        //排序
        List<Integer> allHolidaysInt = allHolidays.stream().map(x -> Integer.valueOf(x)).collect(Collectors.toList());
        allHolidaysInt.sort(Comparator.naturalOrder());

        int allHolidaysSize = allHolidaysInt==null || allHolidaysInt.size()==0 ? 0 : allHolidaysInt.size();
        System.out.println("当前插入新的数据allHolidaysInt.size=" + allHolidaysSize +":"+allHolidaysInt);
        //插入所有假期数据到假期表中
        batchInsertHolidaysToDB(allHolidaysInt);
        System.out.println("插入"+YEAR+"年所有假期成功");
    }

    /**
     * 手动维护2020年的法定节假日
     * @param year
     * @return
     */
    public static Set<String> getLegalHoliday(int year){
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
     * @param year
     * @return
     */
    public static Set<String> getAdjustRestWorkDays(int year) {
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
        DBhepler.batchInsert(list,sql);
    }

    /***
     * 得到一年内所有日期
     * @param year
     * @return
     */
    public static List<String> getAllDaysByYear(int year) {
        return getAllDays(year+"-01-01", year+"-12-31");
    }

    /***
     * 得到指定区间内的所有日期
     * @param startTime
     * @param endTime
     * @return
     */
    public static List<String> getAllDays(String startTime, String endTime) {
        /**
         * 获取两个日期之间的所有日期
         *
         * @param startTime
         *            开始日期
         * @param endTime
         *            结束日期
         * @return
         */
            // 返回的日期集合
            List<String> days = new ArrayList<String>();

            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            try {
                Date start = dateFormat.parse(startTime);
                Date end = dateFormat.parse(endTime);

                Calendar tempStart = Calendar.getInstance();
                tempStart.setTime(start);

                Calendar tempEnd = Calendar.getInstance();
                tempEnd.setTime(end);
                tempEnd.add(Calendar.DATE, +1);// 日期加1(包含结束)
                while (tempStart.before(tempEnd)) {
                    String formatLineDay = dateFormat.format(tempStart.getTime());
                    String formatDat = formatLineDay.replaceAll("-","");
                    days.add(formatDat);
                    tempStart.add(Calendar.DAY_OF_YEAR, 1);
                }

            } catch (ParseException e) {
                e.printStackTrace();
            }

            return days;
    }

    /**
     * 获取一年内所有的双休日,这个方法有问题，[20190832, 20191131]竟然有这两个非法日期
     * @param year
     * @return
     */
    @Deprecated
    public static Set<String> getYearDoubleWeekend(int year){
        Set<String> listDates = new HashSet<String>();
        Calendar calendar=Calendar.getInstance();//当前日期
        calendar.set(year, 6, 1);
        Calendar nowyear=Calendar.getInstance();
        Calendar nexty=Calendar.getInstance();
        nowyear.set(year, 0, 1);//2010-1-1
        nexty.set(year+1, 0, 1);//2011-1-1
        calendar.add(Calendar.DAY_OF_MONTH, -calendar.get(Calendar.DAY_OF_WEEK));//周六
        Calendar c=(Calendar) calendar.clone();
        for(;calendar.before(nexty)&&calendar.after(nowyear);calendar.add(Calendar.DAY_OF_YEAR, -7)){
            listDates.add(calendar.get(Calendar.YEAR) + SEPARATOR + getDoubleMonthStr((1+calendar.get(Calendar.MONTH))) + SEPARATOR + getDoubleMonthStr(calendar.get(Calendar.DATE)));
            listDates.add(calendar.get(Calendar.YEAR) + SEPARATOR + getDoubleMonthStr(1+calendar.get(Calendar.MONTH)) + SEPARATOR + getDoubleMonthStr(1+calendar.get(Calendar.DATE)));
        }
        for(;c.before(nexty)&&c.after(nowyear);c.add(Calendar.DAY_OF_YEAR, 7)){
            listDates.add(c.get(Calendar.YEAR) + SEPARATOR + getDoubleMonthStr(1+c.get(Calendar.MONTH)) + SEPARATOR + getDoubleMonthStr(c.get(Calendar.DATE)));
            listDates.add(c.get(Calendar.YEAR) + SEPARATOR + getDoubleMonthStr(1+c.get(Calendar.MONTH)) + SEPARATOR + getDoubleMonthStr(1+c.get(Calendar.DATE)));
        }
        return listDates;
    }
    private static String getDoubleMonthStr(int monthInt){
        String monthStr = monthInt+"";
        String doublemonth = monthStr.length()==1? "0"+ monthStr : monthStr ;
        return doublemonth;
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


    /**
     * 获取节假日和调休日
     */
    @org.junit.Test
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
                    String day = DateTime.parse(dayLine, yyMMddFMT).toString("yyyyMMddFMT");
                    if((Boolean) ((JSONObject) v).get("holiday")==false){
                        workDays.add(Integer.valueOf(day));
                    }
                    if((Boolean) ((JSONObject) v).get("holiday")==true){
                        holidays.add(Integer.valueOf(day));
                    }
                });
            }
        }
        System.out.println("工作日-------->");
        Collections.sort(workDays);
        workDays.forEach(x->{
            System.out.println(x);
        });
        System.out.println("假期-------->");
        Collections.sort(holidays);
        holidays.forEach(x->{
            System.out.println(x);
        });

    }

}
