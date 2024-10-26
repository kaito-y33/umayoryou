package com.umayoryo.skill.manager.service.engineer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.umayoryo.skill.manager.persistence.engineer.EngineerRepository;
import com.umayoryo.skill.manager.persistence.engineer.entity.EngineerEntity;

/**
 * Engineerサービス
 * 
 */
@Service
public class EngineerService {

	@Autowired
	private EngineerRepository repository;

	/**
	 * エンジニアリストを取得.
	 * 
	 * @return EngineerBeanのリスト
	 */
	public List<EngineerBean> getEngineerList() {
		List<EngineerEntity> engineerList = repository.findAll();
		return convertEngineerBeanList(engineerList);
	}

	/**
	 * EngineerEntityリストをEngineerBeanリストに変換.
	 * 
	 * @param list EngineerEntityのリスト
	 * @return EngineerBeanのリスト
	 */
	public List<EngineerBean> convertEngineerBeanList(List<EngineerEntity> list) {
		List<EngineerBean> beanList = new ArrayList<>();

		for (EngineerEntity entity : list) {
			beanList.add(convert(entity));
		}
		return beanList;
	}

	/**
	 * EngineerEntityをEngineerBeanに変換.
	 * 
	 * @param entity EngineerEntity
	 * @return EngineerBean
	 */
	private EngineerBean convert(EngineerEntity entity) {
		EngineerBean bean = new EngineerBean();
		bean.setEngineerId(entity.getEngineerId());
		bean.setEngineerName(entity.getEngineerName());

		for (int i = 0; i < entity.getEngineerSkillList().size(); i++) {
			bean.setSkillName(entity.getEngineerSkillList().get(i).getSkill().getSkillName());
		}

		return bean;
	}
}
