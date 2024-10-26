package com.umayoryo.skill.manager.service.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.umayoryo.skill.manager.persistence.user.UserRepository;
import com.umayoryo.skill.manager.persistence.user.entity.UserEntity;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	/**
	 * ユーザーリストを取得.
	 * 
	 * @return UserBeanリスト
	 */
	public List<UserBean> getUserList() {
		// UserEntityのリストを取得
		List<UserEntity> userList = repository.findAll();
		// UserEntityリストをUserBeanリストに変換して返す
		return convertUserBeanList(userList);
	}

	/**
	 * UserEntityのリストをUserBeanのリストに変換.
	 * 
	 * @param list UserEntityのリスト.
	 * @return UserBeanのリスト.
	 */
	public List<UserBean> convertUserBeanList(List<UserEntity> list) {
		List<UserBean> beanList = new ArrayList<>();

		for (UserEntity entity : list) {
			beanList.add(convert(entity));
		}
		return beanList;
	}

	/**
	 * UserEntityをUserBeanに変換.
	 * 
	 * @param entity 変換対象のUserEntity
	 * @return 変換後のUserBean
	 */
	private UserBean convert(UserEntity entity) {
		UserBean bean = new UserBean();
		bean.setUserId(entity.getUserId());
		bean.setUserName(entity.getUserName());
		return bean;
	}
}
