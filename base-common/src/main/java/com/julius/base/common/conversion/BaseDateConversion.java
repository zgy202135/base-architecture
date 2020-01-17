package com.julius.base.common.conversion;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @Package: com.julius.base.common.conversion
 * @ClassName: BaseDateConversion
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
public abstract class BaseDateConversion {

    private static final Logger log = LoggerFactory.getLogger(BaseDateConversion.class);

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


}
