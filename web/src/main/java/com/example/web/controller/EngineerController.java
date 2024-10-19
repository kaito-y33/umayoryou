package com.example.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.umayoryou.business.bean.EngineerBean;
import com.umayoryou.business.service.EngineerService;

@Controller
public class EngineerController {

    @Autowired
    private EngineerService engineerService;

    /**
     * エンジニア検索画面の表示とエンジニアリストの取得.
     * 
     * @return エンジニアリストの表示ページ
     */
    @GetMapping("/search")
    public ModelAndView search() {

        // DBからエンジニアのリストを取得
        List<EngineerBean> engineerList = engineerService.getEngineerList();
        
        // ModelAndViewの初期化
        ModelAndView mav = new ModelAndView();
        
        // 取得したエンジニアリストをモデルに追加
        mav.addObject("engineerList", engineerList);
        
        // 表示するビューの名前を設定
        mav.setViewName("engineerList");

        return mav;
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
