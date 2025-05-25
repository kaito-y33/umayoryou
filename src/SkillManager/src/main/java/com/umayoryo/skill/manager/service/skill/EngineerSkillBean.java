package com.umayoryo.skill.manager.service.skill;

import lombok.Data;

@Data
public class EngineerSkillBean {

    /** エンジニアスキルID */
    public long engineerSkillId;

    /** エンジニアID */
    private long engineerId;
}
