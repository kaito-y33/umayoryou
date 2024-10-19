package com.example.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.umayoryou.business.bean.UserBean;
import com.umayoryou.business.service.UserService;

/**
 * ユーザーController.
 * 
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * ユーザー検索.
     * 
     * @return ModelAndView
     */
    @GetMapping("/search")
    public ModelAndView search() {

        // DBからユーザーデータを取得
        List<UserBean> userList = userService.getUserList();
        ModelAndView mav = new ModelAndView();

        // 取得したユーザーデータをModelに追加
        mav.addObject("userList", userList);
        mav.setViewName("userList");

        return mav;
    }

    /**
     * ユーザー登録画面への遷移
     * 
     * @return ModelAndView
     */
    @GetMapping("/register")
    public ModelAndView register() {
        ModelAndView mav = new ModelAndView();
        // 画面名を設定 (将来的に正しい画面名に変更する必要あり)
        mav.setViewName("userRegister"); // "engineerRegister" から修正
        return mav;
    }

    /**
     * ユーザー情報をデータベースに挿入
     * 
     * 仮のメソッド。実際のデータ登録処理は未実装。
     * 
     * @return 挿入処理後の画面 (仮のModelAndView)
     */
    @PostMapping("/insert")
    public ModelAndView insert() {
        ModelAndView mav = new ModelAndView();
        // ユーザー情報の挿入処理を追加予定
        return mav;
    }

    /**
     * ユーザー登録確認処理
     * 
     * 仮のメソッド。実際の確認処理は未実装。
     * 
     * @return 確認画面のModelAndViewオブジェクト
     */
    @PostMapping("/confirm")
    public ModelAndView confirm() {
        ModelAndView mav = new ModelAndView();
        // ユーザー情報確認処理を追加予定
        return mav;
    }

    /**
     * ユーザー登録完了処理
     * 
     * 仮のメソッド。実際の完了処理は未実装。
     * 
     * @return 登録完了画面のModelAndViewオブジェクト
     */
    @PostMapping("/complete")
    public ModelAndView complete() {
        ModelAndView mav = new ModelAndView();
        // ユーザー登録完了処理を追加予定
        return mav;
    }
}
