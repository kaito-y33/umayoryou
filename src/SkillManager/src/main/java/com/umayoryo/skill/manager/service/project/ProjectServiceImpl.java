package com.umayoryo.skill.manager.service.project;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import jakarta.persistence.criteria.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.umayoryo.skill.manager.persistence.engineer.EngineerRepository;
import com.umayoryo.skill.manager.persistence.engineer.entity.EngineerEntity;
import com.umayoryo.skill.manager.persistence.project.ProjectRepository;
import com.umayoryo.skill.manager.persistence.project.entity.ProjectEntity;

import io.micrometer.common.util.StringUtils;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private EngineerRepository engineerRepository;

    /**
     * プロジェクト情報を検索する.
     * 
     * @param projectName プロジェクト名
     * @return プロジェクト情報一覧
     */
    @Override
    public List<ProjectBean> searchProjects(String projectName) {

        // 検索条件を追加
        Specification<ProjectEntity> spec = (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (StringUtils.isNotBlank(projectName)) {
                // プロジェクト名が入力されている場合
                predicates.add(criteriaBuilder.like(root.get("projectName"), "%" + projectName + "%"));
            }
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };

        // プロジェクト情報一覧を返却
        return projectRepository.findAll(spec).stream().map(ProjectBean::convert).collect(Collectors.toList());
    }

    /**
     * プロジェクト情報を取得する.
     * 
     * @param projectId プロジェクトID
     * @return プロジェクト情報
     */
    @Override
    public ProjectBean getProject(Long projectId) {

        return projectRepository.findById(projectId)
                .map(e -> {
                    ProjectBean convertBean = ProjectBean.convert(e);

                    // membersの取得
                    List<Long> memberIds = e.getMembers()
                            .stream()
                            .map(EngineerEntity::getEngineerId)
                            .collect(Collectors.toList());

                    List<String> memberNames = e.getMembers()
                            .stream()
                            .map(EngineerEntity::getEngineerName)
                            .collect(Collectors.toList());

                    // beanにセット
                    convertBean.setMembers(memberIds);
                    convertBean.setMemberNames(memberNames);
                    return convertBean;
                }).orElseThrow();
    }

    /**
     * プロジェクト情報を登録する.
     * 
     * @param bean プロジェクトBean
     */
    public void registerProject(ProjectBean bean) {

        // 紐づくエンジニア情報一覧を取得
        List<EngineerEntity> engineers = engineerRepository.findAllById(bean.getMembers());

        // Entity生成
        ProjectEntity entity = ProjectBean.convert(bean, engineers);

        // プロジェクト情報登録
        projectRepository.save(entity);
    }
}
