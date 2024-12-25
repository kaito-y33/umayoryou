package com.umayoryo.skill.manager.controller;

import java.sql.Time;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.umayoryo.skill.manager.common.enums.ProjectStatus;
import com.umayoryo.skill.manager.common.form.ProjectForm;
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
     * プロジェクト一覧画面 新規登録ボタン押下時処理
     * 
     * @param model model
     * @return プロジェクト登録新規画面
     */
    @GetMapping("/register")
    public String register(Model model) {

        model.addAttribute("projectForm", new ProjectForm());
        model.addAttribute("statusList", ProjectStatus.values());
        return ViewNames.PROJECT_REGISTER_VIEW;
    }

    /**
     * プロジェクト新規登録画面 入力内容確認ボタン押下時処理
     * 
     * @param projectForm プロジェクト情報入力Form
     * @param model       model
     * @return プロジェクト入力内容確認画面
     */
    @PostMapping("/confirm")
    public String confirm(@ModelAttribute ProjectForm projectForm, Model model) {

        model.addAttribute("projectForm", projectForm);
        return ViewNames.PROJECT_CONFIRM_VIEW;
    }

    /**
     * プロジェクト入力内容確認画面 保存ボタン押下時処理
     */
    @PostMapping("/store")
    public String store(@ModelAttribute ProjectForm projectForm, Model model) {

        // Bean生成
        ProjectBean bean = ProjectBean.builder()
                .projectName(projectForm.getProjectName())
                .description(projectForm.getDescription())
                .startDate(projectForm.getStartDate())
                .endDate(projectForm.getEndDate())
                .workingStartTime(Time.valueOf(projectForm.getWorkingStartTime() + ":00"))
                .workingEndTime(Time.valueOf(projectForm.getWorkingEndTime() + ":00"))
                .status(projectForm.getStatus())
                .build();

        // プロジェクト情報の保存処理
        projectService.registerProject(bean);

        return "redirect:/project";
    }
}
