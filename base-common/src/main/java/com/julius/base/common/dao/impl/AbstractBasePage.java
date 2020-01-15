package com.julius.base.common.dao.impl;
import com.julius.base.common.conversion.DoAndDTOConversion;
import com.julius.base.common.page.ResponsePage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Map;

/**
 * @Package: com.julius.base.common.dao.impl
 * @ClassName: AbstractBasePage
 * @Author: Julius
 * @Description: 分页查询
 * @Date: 2020/1/15 16:51
 * @Version: 1.0
 */
public abstract class AbstractBasePage<K,V> extends AbstractBaseDao<V>{

    @Autowired
    private DoAndDTOConversion doAndDTOConversion;

    /**
     * @Description 按照条件分页查询
     * @param jpql
     * @param parameterMap
     * @param pageable
     * @param k
     * @return
     */
    public ResponsePage<K> findByConditionPage(String jpql, Map<String,Object> parameterMap, Pageable pageable,K k){
        //解析Pageable
        Assert.notNull(pageable,"Page info must not be null");
        Sort sort = pageable.getSort();
        Integer maxResults = pageable.getPageSize();
        List<V> list = super.findByConditionPage(pageable.getPageNumber()*maxResults,maxResults,jpql,parameterMap,sort);
        long totalSize = super.countByCondition(jpql,parameterMap);
        ResponsePage<K> result = new ResponsePage<>();
        result.setCurrentPage(pageable.getPageNumber());
        result.setPageSize(pageable.getPageSize());
        result.setTotalSize(totalSize);
        result.setTotalPage((int) (totalSize/pageable.getPageSize()));
        result.setList(doAndDTOConversion.patchObjectConversion(list,k));
        return result;
    }

    /**
     * @Description 不分页按照条件查询
     * @param k
     * @param jpql
     * @param parameterMap
     * @param sort
     * @return
     */
    public List<K> findByCondition(K k ,String jpql,Map<String,Object> parameterMap,Sort sort){
        List<V> list = super.findByConditions(jpql,parameterMap,sort);
        return doAndDTOConversion.patchObjectConversion(list,k);
    }
}
