package com.umayoryo.skill.manager.service.project;

import java.util.List;

public interface ProjectService {

    /**
     * プロジェクト情報を検索する.
     * 
     * @param projectName プロジェクト名
     * @return プロジェクト情報一覧
     */
    public List<ProjectBean> searchProjects(String projectName);

    /**
     * プロジェクト情報を取得する.
     * 
     * @param projectId プロジェクトID
     * @return プロジェクト情報
     */
    public ProjectBean getProject(Long projectId);

    /**
     * プロジェクト情報を登録する.
     * 
     * @param bean プロジェクトBean
     */
    public void registerProject(ProjectBean bean);

    /**
     * プロジェクト情報を削除する.
     * 
     * @param projectId プロジェクトID
     */
    public void deleteProject(Long projectId);
}
