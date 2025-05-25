package com.umayoryo.skill.manager.service.skill;

import lombok.Data;

@Data
public class ToolSkillBean {

    /** ツールスキルID */
    private long toolSkillId;

    /** エンジニアスキルID */
    private long engineerSkillId;

    /** ツールID */
    public long toolId;

    /** 経験年数 */
    public int level;
}
