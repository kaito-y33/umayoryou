package com.umayoryo.skill.manager.common.form;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.umayoryo.skill.manager.common.enums.ProjectStatus;
import com.umayoryo.skill.manager.service.project.ProjectBean;

import lombok.Data;

@Data
public class ProjectForm {

    /** プロジェクトID. */
    private Long projectId;

    /** プロジェクト名. */
    private String projectName;

    /** 説明. */
    private String description;

    /** プロジェクト開始日. */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;

    /** プロジェクト終了日. */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;

    /** プロジェクト勤務開始時間. */
    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime workingStartTime;

    /** プロジェクト勤務終了時間. */
    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime workingEndTime;

    /** プロジェクト稼働ステータス. */
    private ProjectStatus status;

    /** プロジェクトメンバー. */
    private List<Long> members;

    /** プロジェクトメンバー名一覧 */
    private List<String> memberNames;

    public static ProjectBean convert(ProjectForm form) {

        ProjectBean bean = new ProjectBean();

        bean.setProjectId(form.getProjectId());
        bean.setProjectName(form.getProjectName());
        bean.setDescription(form.getDescription());
        bean.setStartDate(form.getStartDate());
        bean.setEndDate(form.getEndDate());
        bean.setWorkingEndTime(form.getWorkingEndTime());
        bean.setWorkingStartTime(form.getWorkingStartTime());
        bean.setStatus(form.getStatus());
        bean.setMembers(form.getMembers());

        return bean;
    }

    public static ProjectForm convert(ProjectBean bean) {

        ProjectForm form = new ProjectForm();

        form.setProjectId(bean.getProjectId());
        form.setProjectName(bean.getProjectName());
        form.setDescription(bean.getDescription());
        form.setStartDate(bean.getStartDate());
        form.setEndDate(bean.getEndDate());
        form.setWorkingStartTime(bean.getWorkingStartTime());
        form.setWorkingEndTime(bean.getWorkingEndTime());
        form.setStatus(bean.getStatus());
        form.setMembers(bean.getMembers());
        form.setMemberNames(bean.getMemberNames());

        return form;
    }
}
