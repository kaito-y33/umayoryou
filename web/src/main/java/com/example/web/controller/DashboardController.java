package com.example.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

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
    public ModelAndView dashboard() {
        // ModelAndViewオブジェクトを作成
        ModelAndView mav = new ModelAndView();
        mav.setViewName("dashboard");
        
        return mav;
    }
}
