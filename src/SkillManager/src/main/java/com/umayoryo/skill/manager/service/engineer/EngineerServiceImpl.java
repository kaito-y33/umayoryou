package com.umayoryo.skill.manager.service.engineer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import jakarta.persistence.criteria.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.umayoryo.skill.manager.persistence.engineer.EngineerRepository;
import com.umayoryo.skill.manager.persistence.engineer.entity.EngineerEntity;

@Service
public class EngineerServiceImpl implements EngineerService {

    @Autowired
    private EngineerRepository engineerRepository;

    /**
    * 技術者情報一覧を取得.
    * 
    * @param name 技術者名
    * @return 技術者情報一覧
    */
    @Override
    public List<EngineerBean> searchEngineers(String name) {
        List<EngineerEntity> entities = engineerRepository.findAll((root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (StringUtils.hasText(name)) {
                predicates.add(criteriaBuilder.like(root.get("engineerName"), "%" + name + "%"));
            }
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        });

        return entities.stream().map(this::convert).collect(Collectors.toList());
    }

    /**
     * EngineerEntityをEngineerBeanに変換.
     * 
     * @param entity EngineerEntity
     * @return EngineerBean
     */
    private EngineerBean convert(EngineerEntity entity) {

        EngineerBean bean = new EngineerBean();
        bean.setEngineerId(entity.getEngineerId());
        bean.setEngineerName(entity.getEngineerName());

        return bean;
    }
}
