package com.umayoryo.skill.manager.constants;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.umayoryo.skill.manager.service.language.LanguageBean;
import com.umayoryo.skill.manager.service.language.LanguageService;
import com.umayoryo.skill.manager.service.tool.ToolBean;
import com.umayoryo.skill.manager.service.tool.ToolService;

@Controller
public class PullDowns {

    @Autowired
    private LanguageService languageService;
    @Autowired
    private ToolService toolservice;

    public List<LanguageBean> getLanguages(){
        return languageService.findAll();
    }

    public List<ToolBean> getTools(){
        return toolservice.findAll();
    }

}
