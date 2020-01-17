package com.julius.base.common.conversion;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @Package: com.julius.base.common.conversion
 * @ClassName: AbstractBaseDateConversion
 * @Author: Julius
 * @Description: 基础日期转换
 * 主要包括以下几种日期格式的互相转换
 * 1、Java8之后的日期格式 <----> Java8之前的日志格式
 * 2、Java8之后的日期格式 <----> Timestamp 时间戳
 * 3、Java8之前的日志格式 <----> Timestamp 时间戳
 * 4、以上日期格式        <----> String + 格式
 *
 * 注：Java8之前的日期是线程不安全的，Java8之后的日期因为是不可变的，所以线程安全
 * @Date: 2020/1/17 14:24
 * @Version: 1.0
 */
public abstract class AbstractBaseDateConversion {

    private static final Logger log = LoggerFactory.getLogger(AbstractBaseDateConversion.class);

    /**
     * @Description Date after 8 to String by custom pattern
     * @param date
     * @param pattern
     * @return
     */
    public String DateAfterEigthToString(LocalDate date,String pattern){
        Assert.notNull(date,"localDate must not be null");
        Assert.notNull(pattern,"pattern must not be null");
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(pattern);
        return date.format(dateTimeFormatter);
    }

    /**
     * @Description DateTime after 8 to String by custom pattern
     * @param dateTime
     * @param pattern
     * @return
     */
    public String DateTimeAfterEightToString(LocalDateTime dateTime,String pattern){
        Assert.notNull(dateTime,"localDateTime must not be null");
        Assert.notNull(pattern,"pattern must not be null");
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(pattern);
        return dateTime.format(dateTimeFormatter);
    }

    /**
     * @Description String to date after 8 by custom pattern
     * @param parameter
     * @param pattern
     * @return
     */
    public LocalDate StringToDateAfterEight(String parameter,String pattern){
        Assert.notNull(parameter,"date string must not be null");
        Assert.notNull(pattern,"pattern must not be null");
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(pattern);
        return LocalDate.parse(parameter,dateTimeFormatter);
    }

    /**
     * @Description String to dateTime after 8 by custom pattern
     * @param parameter
     * @param pattern
     * @return
     */
    public LocalDateTime StringToDateTimeAfterEight(String parameter,String pattern){
        Assert.notNull(parameter,"dateTime string must not be null");
        Assert.notNull(pattern,"pattern must not be null");
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(pattern);
        return LocalDateTime.parse(parameter,dateTimeFormatter);
    }


    /**
     * @Description Date before 8 to string by custom pattern
     * @param date
     * @param pattern
     * @return
     */
    public String DateBeforeEightToStirng(Date date,String pattern){
        Assert.notNull(date,"date must not be null");
        Assert.notNull(pattern,"pattern must not be null");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        return simpleDateFormat.format(date);
    }

    /**
     * @Description String to date before 8 by custom pattern
     * @param parameter
     * @param pattern
     * @return
     */
    public Date StringToDateBeforeEight(String parameter,String pattern){
        Assert.notNull(parameter,"date string must not be null");
        Assert.notNull(pattern,"pattern must not be null");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        Date date = null;
        try {
            date = simpleDateFormat.parse(parameter);
        } catch (ParseException e) {
            log.info("string to data is failed ,please the pattern");
            e.printStackTrace();
        }
        return date;
    }


    /**
     * @Description LocalTime转为Date
     * @param localTime
     * @param pattern
     * @return
     */
    public Date LocalTimeToDate(LocalTime localTime,String pattern){
        Assert.notNull(localTime,"localDate must not be null");
        Assert.notNull(pattern,"pattern must not be null");
        SimpleDateFormat df = new SimpleDateFormat(pattern);
        LocalDateTime localDateTime = LocalDateTime.of(LocalDate.now(),localTime);
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = localDateTime.atZone(zone).toInstant();
        Date date = Date.from(instant);
        try {
            date = df.parse(df.format(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * @Description LocalDateTime转为Date
     * @param localDateTime
     * @param pattern
     * @return
     */
    public Date LocalDateTimeToDate(LocalDateTime localDateTime,String pattern){
        Assert.notNull(localDateTime,"localDateTime must not be null");
        Assert.notNull(pattern,"pattern must not be null");
        SimpleDateFormat df = new SimpleDateFormat(pattern);
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = localDateTime.atZone(zone).toInstant();
        Date date = Date.from(instant);
        try {
            date = df.parse(df.format(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * @Description LocalDate -> Date
     * @param localDate
     * @return
     */
    public Date LocalDateToDate(LocalDate localDate,String pattern){
        Assert.notNull(localDate,"localDateTime must not be null");
        Assert.notNull(pattern,"pattern must not be null");
        SimpleDateFormat df = new SimpleDateFormat(pattern);
        LocalDateTime localDateTime = LocalDateTime.of(localDate,LocalTime.now());
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = localDateTime.atZone(zone).toInstant();
        Date date = Date.from(instant);
        try {
            date = df.parse(df.format(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * @Description date -> localDate
     * @param date
     * @return
     */
    public LocalDate DateToLocalDate(Date date){
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        LocalDate localDate = instant.atZone(zoneId).toLocalDate();
        return localDate;
    }

    /**
     * @Description Date转为LocalTime
     * @param time
     * @return
     */
    public LocalTime DateToLocalTime(Date time){
        Instant instant = time.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        LocalTime localTime = instant.atZone(zoneId).toLocalTime();
        return localTime;
    }


    /**
     * Date转换为LocalDateTime
     * @param date
     */
    public LocalDateTime dateToLocalDateTime(Date date){
        Instant instant = date.toInstant();//An instantaneous point on the time-line.(时间线上的一个瞬时点。)
        ZoneId zoneId = ZoneId.systemDefault();//A time-zone ID, such as {@code Europe/Paris}.(时区)
        LocalDateTime localDateTime = instant.atZone(zoneId).toLocalDateTime();
        return localDateTime;
    }




    /**
     * @Description 计算日期相差天数
     * @param startDate
     * @param endDate
     * @return
     */
    public long dateInterval(LocalDate startDate,LocalDate endDate) throws Exception {
        if(startDate == null || endDate == null){
            throw new Exception("startDate and endDate must not be null ");
        }
        long days = Math.abs(startDate.toEpochDay()-endDate.toEpochDay())+1;
        return days;
    }



}
