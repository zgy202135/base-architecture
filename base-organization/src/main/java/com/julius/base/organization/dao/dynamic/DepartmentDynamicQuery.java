package com.julius.base.organization.dao.dynamic;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Package: com.julius.base.organization.dao.dynamic
 * @ClassName: DepartmentDynamicQuery
 * @Author: Julius
 * @Description: 部门信息动态查询
 * @Date: 2020/8/6 18:39
 * @Version: 1.0
 */
@Component
public class DepartmentDynamicQuery<T> implements Specification<T> {
    private Map<String,Object> map;

    /**
     * openApi
     * @param map
     * @return
     */
    public Specification<T> where(Map<String,Object> map){
        this.map = map;
        return this::toPredicate;
    }


    /**
     * 条件拼接
     * @param root
     * @param criteriaQuery
     * @param criteriaBuilder
     * @return
     */
    @Override
    public Predicate toPredicate(Root<T> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicateList = new ArrayList<>(1<<4);
        if(ObjectUtils.isEmpty(map)){
            return criteriaQuery.where(predicateList.toArray(new Predicate[predicateList.size()])).getRestriction();
        }
        for(Map.Entry<String,Object> entry : this.map.entrySet()){
            //按照名称模糊查询
            if("name".equals(entry.getKey())){
                Predicate predicate = criteriaBuilder.like(root.get(entry.getKey()),"%"+entry.getValue()+"%");
                predicateList.add(predicate);
            }
        }
        return criteriaQuery.where(predicateList.toArray(new Predicate[predicateList.size()])).getRestriction();
    }
}
