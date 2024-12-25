package com.umayoryo.skill.manager.service.project;

import java.util.List;

public interface ProjectService {

	public List<ProjectBean> searchProjects(ProjectSearchCriteria criteria);
	
	public void registerProject(ProjectBean bean);
}
