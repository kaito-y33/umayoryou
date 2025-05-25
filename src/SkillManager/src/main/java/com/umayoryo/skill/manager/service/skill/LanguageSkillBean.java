package com.umayoryo.skill.manager.service.skill;

import lombok.Data;

@Data
public class LanguageSkillBean {

    /** 言語スキルID */
    private long languageSkillId;

    /** エンジニアスキルID */
    private long engineerSkillId;

    /** 言語ID */
    public long languageId;

    /** 経験年数 */
    public int level;
}
