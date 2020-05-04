package com.julius.base.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @Title: base-architecture
 * @Package com.julius.base.common.utils
 * @Author Julius Zhou
 * @Date 2020-05-03 21:56
 * @Description:
 */
@Component
public class UuidUtil {
    private static final Logger log = LoggerFactory.getLogger(UuidUtil.class);

    /**
     * 起始的时间戳
     */
    private final static long START_STMP = 1480166465631L;

    /**
     * 序列号占用的位数
     */
    private final static long SEQUENCE_BIT = 17;

    /**
     * 序列号的最大值
     */
    private final static long MAX_SEQUENCE = -1L ^ (-1L << SEQUENCE_BIT);
    /**
     * 时间戳向左的位移
     */
    private final static long TIMESTAMP_LEFT = SEQUENCE_BIT+5;
    private long sequence = 0L; //序列号
    private long lastTimestamp = -1L;//上一次时间戳
    /**
     * @Description 生成下一个id
     * @return
     */
    private synchronized long nextId() {
        long currTimestamp = getTimestamp();
        if (currTimestamp < lastTimestamp) {
            throw new RuntimeException("Clock moved backwards.  Refusing to generate id currTimestamp:"+currTimestamp);
        }
        if (currTimestamp == lastTimestamp) {
            //相同毫秒内，序列号自增
            sequence = (sequence + 1) & MAX_SEQUENCE;
            //同一毫秒的序列数已经达到最大
            if (sequence == 0L) {
                currTimestamp = getNextMill();
            }
        } else {
            //不同毫秒内，序列号置为0
            sequence = 0L;
        }
        lastTimestamp = currTimestamp;
        return (currTimestamp - START_STMP) << TIMESTAMP_LEFT //时间戳部分
                | sequence;                            //序列号部分
    }

    /**
     * @Description 获取下一毫秒数
     * @return
     */
    private long getNextMill() {
        long mill = getTimestamp();
        while (mill <= lastTimestamp) {
            mill = getTimestamp();
        }
        return mill;
    }

    /**
     * @Description 当前时间戳（毫秒）
     * @return
     */
    private long getTimestamp() {
        long dateMillisecond = System.currentTimeMillis();
        return dateMillisecond;
    }

    /**
     * @Description 获取唯一标识（对外）
     * @return
     */
    public String getUUID(){
        return String.valueOf(nextId());
    }


}
