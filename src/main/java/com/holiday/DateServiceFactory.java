package com.holiday;

public class DateServiceFactory {

    public  DateService getDateByYear(int year) {

        switch (year) {
            case 2025: {
                //todo ;
            }
            case 2024: {
                return new Date2024();
            }
            case 2023: {
                return new Date2023();
            }
            case 2022: {
                return new Date2022();
            }
            case 2021: {
                return new Date2021();
            }
            case 2020: {
                return new Date2020();
            }
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
