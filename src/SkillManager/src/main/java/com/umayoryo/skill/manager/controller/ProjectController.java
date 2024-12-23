package com.umayoryo.skill.manager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.umayoryo.skill.manager.constants.ViewNames;
import com.umayoryo.skill.manager.service.project.ProjectBean;
import com.umayoryo.skill.manager.service.project.ProjectSearchCriteria;
import com.umayoryo.skill.manager.service.project.ProjectService;

@Controller
@RequestMapping("/project")
public class ProjectController {

	@Autowired
	private ProjectService projectService;
	
	@GetMapping
	public String index(Model model) {
		
		return ViewNames.PROJECT_LIST_VIEW;
	}
	
	@PostMapping("/search")
	public String search(@RequestParam(value = "name", required = false) String name, Model model) {
		
		// 検索条件設定
		ProjectSearchCriteria criteria = ProjectSearchCriteria.builder().projectName(name).build();
		
		// 検索実施
		List<ProjectBean> projects = projectService.searchProjects(criteria);
		
		model.addAttribute("projects", projects);
		
		return ViewNames.PROJECT_LIST_VIEW;
	}
	
	/**
	 * プロジェクト新規登録画面 初期表示
	 * @param model model
	 * @return プロジェクト登録新規画面
	 */
	@GetMapping("/regist")
	public String regist(Model model) {
	    
	    return ViewNames.PROJECT_REGIST_VIEW;
	}
}
