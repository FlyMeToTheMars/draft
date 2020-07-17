package com.hugh.draft.time;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;

import java.text.ParseException;
import java.util.Date;

/**
 * @Author Fly.Hugh
 * @Date 2020/7/16 5:12 下午
 * @Version 1.0
 * @Desc 按天分页
 **/
public class DayUtils {
    public static final int Month = 1;

    public static void main(String[] args) {

        Date startTime=null;
        Date endTime = null;

        try {
            startTime = dateGenerate("2020-04-01 11:40:11");
            endTime = DateUtils.addDays(startTime, 7);
        }catch (Exception e){
            e.printStackTrace();
        }

        System.out.println(startTime);
        System.out.println(endTime);

        String startTimeStr = DateFormatUtils.format(startTime, "yyyy-MM-dd 00:00:00");
        String endTimeStr = DateFormatUtils.format(endTime, "yyyy-MM-dd 00:00:00");

        System.out.println(startTimeStr);
        System.out.println(endTimeStr);

        Date dividedStartTime = null;
        Date dividedEndTime = null;
        dividedStartTime = date2DateBegin(startTime);;

        for(int i = 0; i < 4 * Month ; i++){
            dividedEndTime = DateUtils.addDays(dividedStartTime, 7);

            System.out.println(dividedStartTime);
            System.out.println(dividedEndTime);
            System.out.println("===================");

            dividedStartTime = dividedEndTime;
        }
    }

    public static Date dateGenerate(String timeStr)  {
        Date date = null;
        try {
            date = DateUtils.parseDateStrictly(timeStr, "yyyy-MM-dd HH:mm:ss");
            return date;
        }catch (Exception e){
            e.printStackTrace();
        }
        return date;
    }

    public static Date date2DateBegin(Date d){
        Date date = null;
        try{
            String dateStr= DateFormatUtils.format(d, "yyyy-MM-dd 00:00:00");
            date = dateGenerate(dateStr);
        }catch (Exception e){
            e.printStackTrace();
        }
        return date;
    }


}
