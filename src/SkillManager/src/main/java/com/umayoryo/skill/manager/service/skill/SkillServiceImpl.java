package com.umayoryo.skill.manager.service.skill;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.umayoryo.skill.manager.persistence.engineer.entity.EngineerSkillEntity;
import com.umayoryo.skill.manager.persistence.engineer.EngineerSkillRepository;
import com.umayoryo.skill.manager.persistence.skill.LanguageRepository;
import com.umayoryo.skill.manager.persistence.skill.LanguageSkillRepository;
import com.umayoryo.skill.manager.persistence.skill.ToolRepository;
import com.umayoryo.skill.manager.persistence.skill.ToolSkillRepository;
import com.umayoryo.skill.manager.persistence.skill.SkillRepository;
import com.umayoryo.skill.manager.persistence.skill.entity.LanguageEntity;
import com.umayoryo.skill.manager.persistence.skill.entity.LanguageSkillEntity;
import com.umayoryo.skill.manager.persistence.skill.entity.ToolEntity;
import com.umayoryo.skill.manager.persistence.skill.entity.ToolSkillEntity;

import jakarta.persistence.criteria.Predicate;

@Service
public class SkillServiceImpl implements SkillService {

    @Autowired
    private EngineerSkillRepository engineerSkillRepository;
    private SkillRepository skillRepository;
    private LanguageRepository languageRepository;
    private LanguageSkillRepository languageSkillRepository;
    private ToolRepository toolRepository;
    private ToolSkillRepository toolSkillRepository;

    @Override
    public EngineerSkillBean searchEngineerSkill(long id) {

        List<EngineerSkillEntity> entities = engineerSkillRepository.findAll((root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            predicates.add(criteriaBuilder.equal(root.get("engineerId"), id));

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        });

        return (EngineerSkillBean) entities.stream().map(this::EngineerSkillConvert).collect(Collectors.toList());
    };

    @Override
    public List<LanguageSkillBean> searchLanguageSkill(long id) {
        List<LanguageSkillEntity> entities = languageSkillRepository.findAll((root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            predicates.add(criteriaBuilder.equal(root.get("engineerId"), id));

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        });

        return (List<LanguageSkillBean>) entities.stream().map(this::LanguageSkillConvert).collect(Collectors.toList());
    };

    public List<LanguageBean> getLanguage() {
        List<LanguageEntity> entities = languageRepository.findAll();
        return entities.stream().map(this::LanguageConvert).collect(Collectors.toList());
    };

    public List<ToolSkillBean> searchToolSkill(long id) {
        List<ToolSkillEntity> entities = toolSkillRepository.findAll((root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            predicates.add(criteriaBuilder.equal(root.get("engineerId"), id));

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        });

        return (List<ToolSkillBean>) entities.stream().map(this::ToolSkillConvert).collect(Collectors.toList());
    };

    public List<ToolBean> getTool() {
        List<ToolEntity> entities = toolRepository.findAll();
        return entities.stream().map(this::ToolConvert).collect(Collectors.toList());
    };

    /**
     * EngineerSkillEntityをEngineerSkillBeanに変換.
     * 
     * @param entity EngineerSkillEntity
     * @return EngineerSkillBean
     */
    private EngineerSkillBean EngineerSkillConvert(EngineerSkillEntity entity) {

        EngineerSkillBean bean = new EngineerSkillBean();
        bean.setEngineerSkillId(entity.getEngineerSkillId());
        bean.setEngineerId(entity.getEngineerId());

        return bean;
    }

    /**
     * LanguageSkillEntityをLanguageSkillBeanに変換.
     * 
     * @param entity LanguageSkillEntity
     * @return LanguageSkillBean
     */
    private LanguageSkillBean LanguageSkillConvert(LanguageSkillEntity entity) {

        LanguageSkillBean bean = new LanguageSkillBean();
        bean.setLanguageSkillId(entity.getLanguageSkillId());
        bean.setEngineerSkillId(entity.getEngineerSkillId());
        bean.setLanguageId(entity.getLanguageId());
        bean.setLevel(entity.getLevel());

        return bean;
    }

    /**
     * LanguageEntityをLanguageBeanに変換.
     * 
     * @param entity LanguageEntity
     * @return LanguageBean
     */
    private LanguageBean LanguageConvert(LanguageEntity entity) {

        LanguageBean bean = new LanguageBean();
        bean.setLanguageId(entity.getLanguageId());
        bean.setLanguageName(entity.getLanguageName());

        return bean;
    }

    /**
     * ToolSkillEntityをToolSkillBeanに変換.
     * 
     * @param entity ToolSkillEntity
     * @return ToolSkillBean
     */
    private ToolSkillBean ToolSkillConvert(ToolSkillEntity entity) {

        ToolSkillBean bean = new ToolSkillBean();
        bean.setToolSkillId(entity.getToolSkillId());
        bean.setEngineerSkillId(entity.getEngineerSkillId());
        bean.setToolId(entity.getToolId());
        bean.setLevel(entity.getLevel());

        return bean;
    }

    /**
     * ToolEntityをToolBeanに変換.
     * 
     * @param entity ToolEntity
     * @return ToolBean
     */
    private ToolBean ToolConvert(ToolEntity entity) {

        ToolBean bean = new ToolBean();
        bean.setToolId(entity.getToolId());
        bean.setToolName(entity.getToolName());

        return bean;
    }
}
