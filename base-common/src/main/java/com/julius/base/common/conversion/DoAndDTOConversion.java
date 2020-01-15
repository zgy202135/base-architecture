package com.julius.base.common.conversion;

import com.julius.base.common.test.dto.StaffDTO;
import com.julius.base.common.test.entity.Staff;
import org.springframework.beans.BeanUtils;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

/**
 * @Package: com.julius.base.common.conversion
 * @ClassName: DoAndDTOConversion
 * @Author: Julius
 * @Description: 对象转换
 * @Date: 2020/1/15 15:45
 * @Version: 1.0
 */
public class DoAndDTOConversion {


    /**
     * @Descritpion 单一对象转换
     * @param source 源对象
     * @param target 目标对象
     * @param <K>
     * @param <V>
     * @return 目标对象
     */
    public <K,V> V singleObjectConversion(K source,V target){
        Assert.notNull(source,"source must not be null");
        Assert.notNull(target,"target must not be null");
        BeanUtils.copyProperties(source,target);
        return target;
    }

    /**
     * @Description 批量对象转换
     * @param source 源对象
     * @param t      目标对象类型
     * @param <K>
     * @param <T>
     * @return      目标对象
     */
    public <K,T> List<T> patchObjectConversion(List<K> source,T t){
        Assert.notNull(source,"source must not be null");
        Assert.notNull(t,"target must not be null");
        List<T> result = new ArrayList<>();
        for (K k : source) {
            result.add(singleObjectConversion(k,t));
        }
        return result;
    }

}
