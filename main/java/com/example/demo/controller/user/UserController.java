package com.example.demo.controller.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.service.user.UserService;
import com.example.demo.service.user.bean.UserBean;

/**
 * 技術者検索のコントローラークラス
 * 画面上へ表示する情報を設定する
 * @author TKD
 * @version 1.0
 */

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/search")
    public ModelAndView search() {
		
		//DBからデータ取得
		List<UserBean> userList = userService.getUserList();
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("userList",userList);
		mav.setViewName("user/userList");
		
		return mav;
		
	}
	
	//技術者登録画面への遷移
	//一旦仮メソッド
	@RequestMapping("/register")
    public ModelAndView register() {
		ModelAndView mav = new ModelAndView();
		//mav.setViewName("engineerRegister");
		return mav;
	}
	
	//一旦仮メソッド
	@RequestMapping("/insert")
	public ModelAndView insert() {
		ModelAndView mav = new ModelAndView();
		return mav;
	}
	
	//一旦仮メソッド
	@RequestMapping("/confirm")
	public ModelAndView confirm() {
		ModelAndView mav = new ModelAndView();
		return mav;
	}
	
	//一旦仮メソッド
	@RequestMapping("/complete")
	public ModelAndView complete() {
		ModelAndView mav = new ModelAndView();
		return mav;
	}

}
