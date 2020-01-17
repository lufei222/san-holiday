## 说明文档
#### 获取全年的节假日，非工作日
1.修改DBhelper数据库配置文件  
2.执行db.sql文件  
3.配置getHolidays方法中的法定节假日和调休日期  
4.运行getHolidays main方法

日期格式自定义getHolidays的SEPARATOR参数内容，用20190101或2019-01-01








#### 另一种方法
 #####  调用api查询
http://timor.tech/api/holiday/year/2020
返回结果-> {"code":0,"holiday":{"01-01":{"holiday":true,"name":"元旦","wage":3,"date":"2020-01-01"},"01-19":{"holiday":false,"name":"春节前调休","after":false,"wage":1,"target":"春节","date":"2020-01-19"},"01-24":{"holiday":true,"name":"除夕","wage":2,"date":"2020-01-24"},"01-25":{"holiday":true,"name":"初一","wage":3,"date":"2020-01-25"},"01-26":{"holiday":true,"name":"初二","wage":3,"date":"2020-01-26"},"01-27":{"holiday":true,"name":"初三","wage":3,"date":"2020-01-27"},"01-28":{"holiday":true,"name":"初四","wage":2,"date":"2020-01-28"},"01-29":{"holiday":true,"name":"初五","wage":2,"date":"2020-01-29"},"01-30":{"holiday":true,"name":"初六","wage":2,"date":"2020-01-30"},"02-01":{"holiday":false,"name":"春节后补休","after":true,"wage":1,"target":"春节","date":"2020-02-01"},"04-04":{"holiday":true,"name":"清明节","wage":3,"date":"2020-04-04"},"04-05":{"holiday":true,"name":"清明节","wage":2,"date":"2020-04-05"},"04-06":{"holiday":true,"name":"清明节","wage":2,"date":"2020-04-06"},"04-26":{"holiday":false,"name":"劳动节前调休","after":false,"wage":1,"target":"劳动节","date":"2020-04-26"},"05-01":{"holiday":true,"name":"劳动节","wage":3,"date":"2020-05-01"},"05-02":{"holiday":true,"name":"劳动节","wage":2,"date":"2020-05-02"},"05-03":{"holiday":true,"name":"劳动节","wage":2,"date":"2020-05-03"},"05-04":{"holiday":true,"name":"劳动节","wage":2,"date":"2020-05-04"},"05-05":{"holiday":true,"name":"劳动节","wage":2,"date":"2020-05-05"},"05-09":{"holiday":false,"name":"劳动节后调休","after":true,"wage":1,"target":"劳动节","date":"2020-05-09"},"06-25":{"holiday":true,"name":"端午节","wage":3,"date":"2020-06-25"},"06-26":{"holiday":true,"name":"端午节","wage":2,"date":"2020-06-26"},"06-27":{"holiday":true,"name":"端午节","wage":2,"date":"2020-06-27"},"06-28":{"holiday":false,"after":true,"name":"端午节后调休","wage":1,"target":"端午节","date":"2020-06-28"},"09-27":{"holiday":false,"after":false,"name":"国庆节前调休","wage":1,"target":"国庆节","date":"2020-09-27"},"10-01":{"holiday":true,"name":"中秋节","wage":3,"date":"2020-10-01"},"10-02":{"holiday":true,"name":"国庆节","wage":3,"date":"2020-10-02"},"10-03":{"holiday":true,"name":"国庆节","wage":3,"date":"2020-10-03"},"10-04":{"holiday":true,"name":"国庆节","wage":2,"date":"2020-10-04"},"10-05":{"holiday":true,"name":"国庆节","wage":2,"date":"2020-10-05"},"10-06":{"holiday":true,"name":"国庆节","wage":2,"date":"2020-10-06"},"10-07":{"holiday":true,"name":"国庆节","wage":2,"date":"2020-10-07"},"10-08":{"holiday":true,"name":"国庆节","wage":2,"date":"2020-10-08"},"10-10":{"holiday":false,"name":"国庆节后调休","after":true,"wage":1,"target":"国庆节","date":"2020-10-10"}}}
demo格式如：

{
  "code": 0,              // 0服务正常。-1服务出错
  "holiday": {
    "holiday": true,      // 该字段一定为true
    "name": "国庆节",      // 节假日的中文名。
    "wage": 3,            // 薪资倍数，3表示是3倍工资
    "date": "2018-10-01"  // 节假日的日期
  },
  "workday": {             // 如果节假日前没调休，则此字段为null
    "holiday": false,      // 此字段一定为false
    "name": "国庆前调休",   // 调休的中文名
    "wage": 1,            // 薪资倍数，3表示是3倍工资
    "after": false,       // true表示放完假后调休，false表示先调休再放假
    "target": '国庆节',    // 表示调休的节假日
    "date": "2018-09-29"  // 表示要调休的日期
  }
}

api来源：http://timor.tech/api/holiday