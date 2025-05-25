package com.umayoryo.skill.manager.persistence.skill.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "tool_skill")
@Data
public class ToolSkillEntity {

    /** 言語スキルID */
    private long toolSkillId;

    /** エンジニアスキルID */
    private long engineerSkillId;

    /** 言語ID */
    public long toolId;

    /** 経験年数 */
    public int level;
}
