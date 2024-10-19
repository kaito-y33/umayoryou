package com.example.repository.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import lombok.Data;

/**
 * エンジニア情報を表すエンティティ.
 * 
 * エンジニアの基本情報と、関連するスキル情報を保持します.
 */
@Entity
@Table(name = "engineer")
@Data
public class EngineerEntity {

    /** エンジニアID（主キー）. */
    @Id
    @Column(name = "engineer_id")
    private int engineerId;
    
    /** エンジニア名.  */
    @Column(name = "engineer_name")
    private String engineerName;
    
    /** エンジニア関連スキルのリスト. */
    @OneToMany
    @JoinColumn(name = "engineer_id")
    private List<EngineerSkillEntity> engineerSkillList;
}
