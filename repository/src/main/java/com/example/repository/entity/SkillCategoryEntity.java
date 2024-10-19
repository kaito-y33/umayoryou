package com.example.repository.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Data;

/**
 * スキルカテゴリを表すエンティティ.
 * 
 * 各スキルが属するカテゴリ情報を管理します.
 */
@Entity
@Table(name = "skill_category")
@Data
public class SkillCategoryEntity {

    /** スキルカテゴリID（主キー）. */
    @Id
    @Column(name = "skill_category_id")
    private int skillCategoryId;
}
