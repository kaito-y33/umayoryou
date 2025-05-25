package com.umayoryo.skill.manager.controller;

import java.sql.Time;
import java.util.ArrayList;
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

import com.umayoryo.skill.manager.service.skill.SkillService;

import com.umayoryo.skill.manager.service.skill.EngineerSkillBean;
import com.umayoryo.skill.manager.service.skill.LanguageBean;
import com.umayoryo.skill.manager.service.skill.LanguageSkillBean;
import com.umayoryo.skill.manager.service.skill.ToolBean;
import com.umayoryo.skill.manager.service.skill.ToolSkillBean;

@Controller
@RequestMapping("/skill")
public class SkillController {

    public class SkillView {
        public String type; // 種別（言語／ツール）
        public String name; // 名前
        public int level; // 経験年数
    };

    @Autowired
    private SkillService skillService;

    @GetMapping
    public String index(Model model) {

        // DBからエンジニアスキルのリストを取得
        // TODO:ユーザIDどうやってとるの、ろぐいんがない
        EngineerSkillBean engineersSkill = skillService.searchEngineerSkill(1);

        // // エンジニアスキルから、言語／ツールスキルリストを取得
        List<LanguageSkillBean> languageSkillList = skillService
                .searchLanguageSkill(engineersSkill.getEngineerSkillId());
        List<ToolSkillBean> toolSkillList = skillService.searchToolSkill(engineersSkill.getEngineerSkillId());

        List<LanguageBean> languageList = skillService.getLanguage();
        List<ToolBean> toolList = skillService.getTool();

        // 取得した言語／ツールスキルリストを、画面表示用に成形
        List<SkillView> skillViewList = new ArrayList<SkillView>();
        // 言語スキルリストの、データごとの処理
        for (LanguageSkillBean languageSkill : languageSkillList) {
            SkillView skillView = new SkillView();

            for (LanguageBean language : languageList) {
                if (language.languageId == languageSkill.languageId) {
                    skillView.type = "language";
                    skillView.name = language.languageName;
                    skillView.level = languageSkill.level;
                    break;
                }
            }

            skillViewList.add(skillView);
        }
        // ツールスキルリストの、データごとの処理
        for (ToolSkillBean toolSkill : toolSkillList) {
            SkillView skillView = new SkillView();

            for (ToolBean tool : toolList) {
                if (tool.toolId == toolSkill.toolId) {
                    skillView.type = "tool";
                    skillView.name = tool.toolName;
                    skillView.level = toolSkill.level;
                    break;
                }
            }

            skillViewList.add(skillView);
        }

        // 取得した言語／ツールスキルリストをモデルに追加
        model.addAttribute("skillList", skillViewList);

        return ViewNames.SKILL_LIST_VIEW;
    }

}
