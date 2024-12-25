package com.umayoryo.skill.manager.service.project;

import java.sql.Time;
import java.util.Date;

import com.umayoryo.skill.manager.common.enums.ProjectStatus;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProjectBean {

	private Long projectId;
	
	private String projectName;
	
	private String description;
	
	private Date startDate;
	
	private Date endDate;
	
	private Time workingStartTime;
	
	private Time workingEndTime;
	
	private ProjectStatus status;
	
//	private EngineerEntity projectManager;
//	
//	private List<EngineerEntity> members;
}
