package com.umayoryo.skill.manager.service.engineer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
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
     * @param engineerIds エンジニアID一覧
     * @return 技術者情報一覧
     */
    @Override
    public List<EngineerBean> findAllById(List<Long> engineerIds) {

        if (engineerIds == null || engineerIds.isEmpty()) {
            return Collections.emptyList();
        }
        // 条件に一致するエンジニア情報を取得
        List<EngineerEntity> entities = engineerRepository.findAllById(engineerIds);

        return entities.isEmpty() ? Collections.emptyList()
                : entities.stream().map(this::convert).collect(Collectors.toList());
    }

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

    /**
     * エンジニア名一覧を取得する.
     * 
     * @param engineerIds エンジニアID一覧
     * @return エンジニア名一覧
     */
    @Override
    public List<String> getEngineerNames(List<Long> engineerIds) {

        if (engineerIds == null || engineerIds.isEmpty()) {
            return Collections.emptyList();
        }

        return engineerRepository.findAllById(engineerIds)
                .stream()
                .map(EngineerEntity::getEngineerName)
                .collect(Collectors.toList());
    }

    /**
     * エンジニア一覧を取得する.
     * 
     * @param engineerIds エンジニアID一覧
     * @return エンジニア一覧
     */
    @Override
    public List<EngineerBean> getEngineers(List<Long> engineerIds) {

        if (engineerIds == null || engineerIds.isEmpty()) {
            return engineerRepository.findAll().stream().map(this::convert).collect(Collectors.toList());
        }

        return engineerRepository.findAllById(engineerIds)
                .stream().map(this::convert).collect(Collectors.toList());
    }

    /**
     * 全エンジニア一覧を取得する.
     * 
     * @return 全エンジニア一覧
     */
    @Override
    public List<EngineerBean> getAllEngineers() {

        return engineerRepository.findAll()
                .stream().map(this::convert).collect(Collectors.toList());
    }
}
