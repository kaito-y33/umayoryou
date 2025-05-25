package com.umayoryo.skill.manager.persistence.skill.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "language_skill")
@Data
public class LanguageSkillEntity {

    /** 言語スキルID */
    @Id
    @Column(name = "language_skill_id")
    private long languageSkillId;

    /** エンジニアスキルID */
    @Column(name = "engineer_skill_id")
    private long engineerSkillId;

    /** 言語ID */
    @Column(name = "language_id")
    public long languageId;

    /** 経験年数 */
    @Column(name = "level")
    private int level;
}