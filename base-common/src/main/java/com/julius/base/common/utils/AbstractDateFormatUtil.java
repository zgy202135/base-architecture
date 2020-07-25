package com.julius.base.common.utils;

import com.julius.base.common.constants.BaseConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @Title: base-architecture
 * @Package com.julius.base.common.utils
 * @Author Julius Zhou
 * @Date 2020-07-25 20:38
 * @Description: 时间格式工具类
 */
public abstract class AbstractDateFormatUtil {

    /**
     * Date of java8 to date before java 8 according to the specified format
     * @param localDate
     * @param localTime
     * @param pattern
     * @return
     */
    public Date dateToLocalDate(LocalDate localDate , LocalTime localTime ,String pattern) throws ParseException {
        Assert.notNull(pattern,"date format must not be null");
        Date date = new Date();
        //由于该时间格式类是线程不安全的，所以不可在全局属性中定义该时间格式
        SimpleDateFormat sf = new SimpleDateFormat(pattern);

        if(BaseConstant.DATE_FORMAT.equals(pattern)){
            String dateString = localDate.format(DateTimeFormatter.ofPattern(pattern));
            date = sf.parse(dateString);
        }

        if(BaseConstant.TIME_FORMAT.equals(pattern)){
            String timeString = localTime.format(DateTimeFormatter.ofPattern(pattern));
            date = sf.parse(timeString);
        }

        if(BaseConstant.DATE_TIME_FORMAT.equals(pattern)){
            LocalDateTime localDateTime = LocalDateTime.of(localDate,localTime);
            String dateTimeString = localDateTime.format(DateTimeFormatter.ofPattern(pattern));
            date = sf.parse(dateTimeString);
        }
        return date;
    }

}
