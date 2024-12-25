package com.umayoryo.skill.manager.service.project;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import jakarta.persistence.criteria.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.umayoryo.skill.manager.persistence.project.ProjectRepository;
import com.umayoryo.skill.manager.persistence.project.entity.ProjectEntity;

import io.micrometer.common.util.StringUtils;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public List<ProjectBean> searchProjects(ProjectSearchCriteria criteria) {

        // 検索条件を追加
        Specification<ProjectEntity> spec = (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (StringUtils.isNotBlank(criteria.getProjectName())) {
                // プロジェクト名が入力されている場合
                predicates.add(criteriaBuilder.like(root.get("name"), "%" + criteria.getProjectName() + "%"));
            }
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };

        // プロジェクト情報一覧を返却
        return projectRepository.findAll(spec).stream().map(this::convert).collect(Collectors.toList());
    }

    /**
     * プロジェクト情報を登録する.
     * 
     * @param bean プロジェクトBean
     */
    public void registerProject(ProjectBean bean) {

        // Entity生成
        ProjectEntity entity = convert(bean);

        // プロジェクト情報登録
        projectRepository.save(entity);
    }

    /**
     * プロジェクト情報をEntityからBeanに変換.
     * 
     * @param entity ProjectEntity
     * @return ProjectBean
     */
    private ProjectBean convert(ProjectEntity entity) {

        return ProjectBean.builder().projectId(entity.getProjectId()).projectName(entity.getProjectName())
                .description(entity.getDescription()).startDate(entity.getStartDate()).endDate(entity.getEndDate())
                .status(entity.getStatus())
                .build();
    }

    /**
     * プロジェクト情報をBeanからEntityに変換.
     * @param bean プロジェクトBean
     * @return プロジェクトEntity
     */
    private ProjectEntity convert(ProjectBean bean) {

        ProjectEntity entity = new ProjectEntity();

        entity.setProjectName(bean.getProjectName());
        entity.setDescription(bean.getDescription());
        entity.setStartDate(bean.getStartDate());
        entity.setEndDate(bean.getEndDate());
        entity.setWorkingStartTime(bean.getWorkingStartTime());
        entity.setWorkingEndTime(bean.getWorkingEndTime());
        entity.setStatus(bean.getStatus());

        return entity;
    }

}
