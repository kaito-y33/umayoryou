package com.umayoryo.skill.manager.service.engineer;

import java.util.List;

public interface EngineerService {

	/**
	 * 検索条件に基づいて技術者一覧を取得する.
	 * 
	 * @param name 技術者名
	 * @return 条件に一致する技術者一覧
	 */
	List<EngineerBean> searchEngineers(String name);
}
