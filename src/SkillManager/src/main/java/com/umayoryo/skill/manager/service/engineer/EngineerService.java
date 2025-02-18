package com.umayoryo.skill.manager.service.engineer;

import java.util.List;

public interface EngineerService {

    /**
     * 技術者情報一覧を取得する.
     * 
     * @param engineerIds エンジニアID一覧
     * @return エンジニア情報一覧
     */
    List<EngineerBean> findAllById(List<Long> engineerIds);

    /**
     * 検索条件に基づいて技術者一覧を取得する.
     * 
     * @param name 技術者名
     * @return 条件に一致する技術者一覧
     */
    List<EngineerBean> searchEngineers(String name);

    /**
     * エンジニア名一覧を取得する.
     * 
     * @param engineerIds エンジニアID一覧
     * @return エンジニア名一覧
     */
    public List<String> getEngineerNames(List<Long> engineerIds);

    /**
     * エンジニア一覧を取得する.
     * 
     * @param engineerIds エンジニアID一覧
     * @return エンジニア一覧
     */
    public List<EngineerBean> getEngineers(List<Long> engineerIds);

    /**
     * 全エンジニア一覧を取得する.
     * 
     * @param engineerIds エンジニアID一覧
     * @return エンジニア一覧
     */
    public List<EngineerBean> getAllEngineers();
}
