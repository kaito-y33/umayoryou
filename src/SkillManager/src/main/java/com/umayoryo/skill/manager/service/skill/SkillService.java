package com.umayoryo.skill.manager.service.skill;

import java.util.List;

import com.umayoryo.skill.manager.service.skill.EngineerSkillBean;
import com.umayoryo.skill.manager.service.skill.LanguageSkillBean;
import com.umayoryo.skill.manager.service.skill.LanguageBean;
import com.umayoryo.skill.manager.service.skill.ToolSkillBean;
import com.umayoryo.skill.manager.service.skill.ToolBean;

public interface SkillService {

    public EngineerSkillBean searchEngineerSkill(long id);

    public List<LanguageSkillBean> searchLanguageSkill(long id);

    public List<LanguageBean> getLanguage();

    public List<ToolSkillBean> searchToolSkill(long id);

    public List<ToolBean> getTool();
}