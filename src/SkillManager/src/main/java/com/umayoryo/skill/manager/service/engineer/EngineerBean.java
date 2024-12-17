package com.umayoryo.skill.manager.service.engineer;

import lombok.Data;

/**
 * エンジニア情報を保持するBean.
 */
@Data
public class EngineerBean {

    /** エンジニアID. */
    private long engineerId;

    /**エンジニア名. */
    private String engineerName;

    /** エンジニアスキル名. */
    private String skillName;
}
