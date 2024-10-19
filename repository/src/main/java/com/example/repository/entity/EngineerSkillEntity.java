package com.example.repository.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import lombok.Data;

/**
 * エンジニアとスキルの関係を表すエンティティ.
 * 
 * エンジニアと関連するスキルを管理します.
 */
@Entity
@Table(name = "engineer_skill")
@Data
public class EngineerSkillEntity {

    /** エンジニアID（主キー）. */
    @Id
    @Column(name = "engineer_id")
    private int engineerId;
    
    /** スキルID. */
    @Column(name = "skill_id")
    private int skillId;
    
    /** 関連スキルのエンティティ. */
    @OneToOne
    @JoinColumn(name = "skill_id", insertable = false, updatable = false)
    private SkillEntity skill;
}
