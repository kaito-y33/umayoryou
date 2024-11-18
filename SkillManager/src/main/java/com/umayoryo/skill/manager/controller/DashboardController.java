package com.umayoryo.skill.manager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.umayoryo.skill.manager.constants.ViewNames;

/**
 * ダッシュボードController.
 */
@Controller
public class DashboardController {

    /**
     * 初期表示.
     * 
     * @return ダッシュボード画面.
     */
    @GetMapping("/dashboard")
    public String dashboard(Model model) {

        return ViewNames.DASHBOARD_VIEW;
    }
}
