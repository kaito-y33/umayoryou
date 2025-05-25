package com.umayoryo.skill.manager.persistence.skill.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "language")
@Data
public class LanguageEntity {

    /** スキルID（主キー）. */
    @Id
    @Column(name = "language_id")
    private long languageId;

    /** スキル名. */
    @Column(name = "language_name")
    private String languageName;
}