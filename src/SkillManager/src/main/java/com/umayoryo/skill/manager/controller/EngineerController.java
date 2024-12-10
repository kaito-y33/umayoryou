package com.umayoryo.skill.manager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.umayoryo.skill.manager.constants.ViewNames;
import com.umayoryo.skill.manager.service.engineer.EngineerBean;
import com.umayoryo.skill.manager.service.engineer.EngineerService;

@Controller
@RequestMapping("engineer")
public class EngineerController {

    @Autowired
    private EngineerService engineerService;

    /**
     * 技術者一覧 初期表示.
     * 
     * @param model
     * @return 技術者一覧画面
     */
    @GetMapping
    public String index(Model model) {

        return ViewNames.ENGINEER_LIST_VIEW;
    }

    /**
     * 技術者一覧 検索機能.
     * 
     * @return 技術者一覧画面
     */
    @PostMapping("/search")
    public String search(@RequestParam(name = "name", required = false) String name, Model model) {

        // DBからエンジニアのリストを取得
        List<EngineerBean> engineers = engineerService.searchEngineers(name);

        // 取得したエンジニアリストをモデルに追加
        model.addAttribute("engineers", engineers);

        return ViewNames.ENGINEER_LIST_VIEW;
    }

    /**
     * エンジニア登録画面への遷移処理.
     * 
     * @return エンジニア登録画面の表示
     */
    @GetMapping("/register")
    public ModelAndView register() {
        // エンジニア登録画面のビュー設定
        ModelAndView mav = new ModelAndView();
        mav.setViewName("engineerRegister");
        return mav;
    }

    /**
     * エンジニア情報の登録処理 (仮メソッド).
     * 
     * @return 登録結果の画面
     */
    @PostMapping("/insert")
    public ModelAndView insert() {
        // 登録処理を行う予定のメソッド
        ModelAndView mav = new ModelAndView();
        // 仮のビュー設定（後で修正予定）
        mav.setViewName("insertResult");
        return mav;
    }

    /**
     * 登録内容の確認処理 (仮メソッド).
     * 
     * @return 登録確認画面
     */
    @PostMapping("/confirm")
    public ModelAndView confirm() {
        // 確認処理を行う予定のメソッド
        ModelAndView mav = new ModelAndView();
        // 仮のビュー設定（後で修正予定）
        mav.setViewName("confirm");
        return mav;
    }

    /**
     * 登録完了処理 (仮メソッド).
     * 
     * @return 完了画面
     */
    @GetMapping("/complete")
    public ModelAndView complete() {
        // 完了処理を行う予定のメソッド
        ModelAndView mav = new ModelAndView();
        // 仮のビュー設定（後で修正予定）
        mav.setViewName("complete");
        return mav;
    }
}
