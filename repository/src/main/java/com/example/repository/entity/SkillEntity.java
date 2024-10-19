package com.example.repository.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Data;

/**
 * スキル情報を表すエンティティ.
 * 
 * エンジニアが持つ特定のスキルに関する情報を管理します。
 */
@Entity
@Table(name="skill")
@Data
public class SkillEntity {

    /** スキルID（主キー）. */
    @Id
    @Column(name = "skill_id")
    private int skillId;
    
    /** スキルカテゴリID. */
    @Column(name = "skill_category_id")
    private int skillCategoryId;
    
    /** スキル名. */
    @Column(name = "skill_name")
    private String skillName;
}
