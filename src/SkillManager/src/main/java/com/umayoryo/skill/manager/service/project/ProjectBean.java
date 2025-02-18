package com.umayoryo.skill.manager.service.project;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import com.umayoryo.skill.manager.common.enums.ProjectStatus;
import com.umayoryo.skill.manager.persistence.engineer.entity.EngineerEntity;
import com.umayoryo.skill.manager.persistence.project.entity.ProjectEntity;

import lombok.Data;

@Data
public class ProjectBean {

    private Long projectId;

    private String projectName;

    private String description;

    private LocalDate startDate;

    private LocalDate endDate;

    private LocalTime workingStartTime;

    private LocalTime workingEndTime;

    private ProjectStatus status;

    private List<Long> members;

    private List<String> memberNames;

    public static ProjectEntity convert(ProjectBean bean, List<EngineerEntity> engineers) {

        ProjectEntity entity = new ProjectEntity();

        entity.setProjectId(bean.getProjectId());
        entity.setProjectName(bean.getProjectName());
        entity.setDescription(bean.getDescription());
        entity.setStartDate(bean.getStartDate());
        entity.setEndDate(bean.getEndDate());
        entity.setWorkingStartTime(bean.getWorkingStartTime());
        entity.setWorkingEndTime(bean.getWorkingEndTime());
        entity.setStatus(bean.getStatus());
        entity.setMembers(engineers);

        return entity;
    }

    public static ProjectBean convert(ProjectEntity entity) {

        ProjectBean bean = new ProjectBean();

        bean.setProjectId(entity.getProjectId());
        bean.setProjectName(entity.getProjectName());
        bean.setDescription(entity.getDescription());
        bean.setStartDate(entity.getStartDate());
        bean.setEndDate(entity.getEndDate());
        bean.setWorkingStartTime(entity.getWorkingStartTime());
        bean.setWorkingEndTime(entity.getWorkingEndTime());
        bean.setStatus(entity.getStatus());

        return bean;
    }
}
