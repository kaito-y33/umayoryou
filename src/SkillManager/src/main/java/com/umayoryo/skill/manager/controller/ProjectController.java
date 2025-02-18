package com.umayoryo.skill.manager.controller;

import java.util.List;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.umayoryo.skill.manager.common.enums.ProjectStatus;
import com.umayoryo.skill.manager.common.form.ProjectForm;
import com.umayoryo.skill.manager.common.form.ProjectSearchForm;
import com.umayoryo.skill.manager.constants.ViewNames;
import com.umayoryo.skill.manager.service.engineer.EngineerBean;
import com.umayoryo.skill.manager.service.engineer.EngineerService;
import com.umayoryo.skill.manager.service.project.ProjectBean;
import com.umayoryo.skill.manager.service.project.ProjectService;

@Controller
@RequestMapping("/project")
@SessionAttributes("projectSearchForm")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private EngineerService engineerService;

    /**
     * プロジェクト検索フォームの初期化.
     */
    @ModelAttribute("projectSearchForm")
    public ProjectSearchForm initProjectSearchForm() {
        return new ProjectSearchForm();
    }

    /**
     * プロジェクト一覧画面 初期表示.
     * 
     * @param model model
     * @return プロジェクト一覧画面
     */
    @GetMapping
    public String index(@ModelAttribute("projectSearchForm") ProjectSearchForm projectSearchForm, HttpSession session,
            Model model) {

        // 検索実施済み判定
        Boolean searched = (Boolean) session.getAttribute("searched");
        if (Boolean.TRUE.equals(searched)) {
            // 検索実施
            List<ProjectBean> projects = projectService.searchProjects(projectSearchForm.getName());
            model.addAttribute("projects", projects);
        }

        return ViewNames.PROJECT_LIST_VIEW;
    }

    /**
     * プロジェクト一覧画面 検索ボタン押下時処理
     * 
     * @param name  プロジェクト名
     * @param model model
     * @return プロジェクト一覧画面
     */
    @PostMapping("/search")
    public String search(@ModelAttribute("projectSearchForm") ProjectSearchForm projectSearchForm, HttpSession session,
            Model model) {

        // 検索実行フラグON
        session.setAttribute("searched", true);

        // 検索実施
        List<ProjectBean> projects = projectService.searchProjects(projectSearchForm.getName());
        model.addAttribute("projects", projects);

        return ViewNames.PROJECT_LIST_VIEW;
    }

    /**
     * プロジェクト一覧画面 詳細ボタン押下時処理.
     * 
     * @param projectId プロジェクトID
     * @param model     model
     * @return プロジェクト詳細画面
     */
    @GetMapping("/detail")
    public String detail(@RequestParam(value = "id", required = true) Long projectId, Model model) {

        // 該当のプロジェクト情報を取得する
        ProjectForm form = ProjectForm.convert(projectService.getProject(projectId));
        model.addAttribute("projectForm", form);

        return ViewNames.PROJECT_DETAIL_VIEW;
    }

    /**
     * プロジェクト一覧画面 新規登録ボタン押下時処理.
     * 
     * @param model model
     * @return プロジェクト登録新規画面
     */
    @GetMapping("/register")
    public String register(Model model) {

        // メンバー追加用にエンジニア一覧を取得
        List<EngineerBean> engineers = engineerService.getAllEngineers();

        model.addAttribute("projectForm", new ProjectForm());
        model.addAttribute("statusList", ProjectStatus.values());
        model.addAttribute("engineers", engineers);

        return ViewNames.PROJECT_REGISTER_VIEW;
    }

    /**
     * プロジェクト詳細画面 編集ボタン押下時処理.
     * 
     * @param projectForm
     * @param model
     * @return
     */
    @PostMapping("/edit")
    public String edit(@ModelAttribute ProjectForm projectForm, Model model) {

        // メンバー追加用にエンジニア一覧を取得
        List<EngineerBean> engineers = engineerService.getAllEngineers();

        model.addAttribute("projectForm", projectForm);
        model.addAttribute("statusList", ProjectStatus.values());
        model.addAttribute("engineers", engineers);

        return ViewNames.PROJECT_EDIT_VIEW;
    }

    /**
     * 保存ボタン押下時処理
     * 
     * @param projectForm プロジェクトForm
     * @param model       Model
     * @return プロジェクト一覧画面
     */
    @PostMapping("/store")
    public String store(@ModelAttribute ProjectForm projectForm, Model model) {

        // プロジェクト情報の保存処理
        projectService.registerProject(ProjectForm.convert(projectForm));

        return "redirect:/project";
    }
}
