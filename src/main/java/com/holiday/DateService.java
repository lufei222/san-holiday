package com.holiday;

import java.util.Set;

public interface DateService {
     Set<String> getLegalHoliday(int year);
     Set<String> getAdjustRestWorkDays(int year);

}