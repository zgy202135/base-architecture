package com.julius.base.organization.dao.dynamic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Title: base-architecture
 * @Package com.julius.base.organization.dao.dynamic
 * @Author Julius Zhou
 * @Date 2020-07-26 15:56
 * @Description: 用户信息动态查询
 */
@Component
public class UserDynamicQuery<T>  implements Specification<T> {

    private static final Logger log = LoggerFactory.getLogger(UserDynamicQuery.class);

    //条件集合
    private Map<String,Object> map;

    public Specification<T> where(Map<String,Object> map){
        this.map = map;
        return this::toPredicate;
    }

    @Override
    public Predicate toPredicate(Root<T> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>(1<<4);
        if(this.map != null){
            for(Map.Entry<String,Object> entry : this.map.entrySet()){
                 if("name".equals(entry.getKey().trim())){
                     Predicate predicate = criteriaBuilder.like(root.get(entry.getKey().trim()),"%"+entry.getValue()+"%");
                     predicates.add(predicate);
                 }

                 if("sex".equals(entry.getKey().trim())){
                     Predicate predicate = criteriaBuilder.equal(root.get(entry.getKey().trim()),entry.getValue());
                     predicates.add(predicate);
                 }

            }
        }
        return criteriaQuery.where(predicates.toArray(new Predicate[predicates.size()])).getRestriction();
    }
}
