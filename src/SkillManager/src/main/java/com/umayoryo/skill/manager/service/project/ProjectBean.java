package com.umayoryo.skill.manager.service.project;

import java.time.LocalDate;

import com.umayoryo.skill.manager.common.enums.ProjectStatus;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProjectBean {

	private Long projectId;
	
	private String projectName;
	
	private String projectDescription;
	
	private LocalDate projectStartDate;
	
	private LocalDate projectEndDate;
	
	private ProjectStatus projectStatus;
	
//	private EngineerEntity projectManager;
//	
//	private List<EngineerEntity> members;
}
