package com.umayoryo.skill.manager.common.form;

import lombok.Data;

/**
 * プロジェクト一覧画面 検索条件form
 * 
 */
@Data
public class ProjectSearchForm {

    /** 検索条件 プロジェクト名. */
    private String name;

    /**
     * 検索条件が格納されているか
     * 
     * @return 格納されている場合はtrue
     */
    public boolean hasSearchCriteria() {
        return (name != null);
    }
}
