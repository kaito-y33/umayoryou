package com.umayoryo.skill.manager.common.form;

import java.sql.Date;

import com.umayoryo.skill.manager.common.enums.ProjectStatus;

import lombok.Data;

@Data
public class ProjectForm {

    /** プロジェクト名. */
    private String projectName;

    /** 説明. */
    private String description;

    /** プロジェクト開始日. */
    private Date startDate;

    /** プロジェクト終了日. */
    private Date endDate;

    /** プロジェクト勤務開始時間. */
    private String workingStartTime;

    /** プロジェクト勤務終了時間. */
    private String workingEndTime;

    /** プロジェクト稼働ステータス. */
    private ProjectStatus status;
}
