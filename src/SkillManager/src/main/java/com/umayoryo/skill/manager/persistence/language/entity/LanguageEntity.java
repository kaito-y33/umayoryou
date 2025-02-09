package com.umayoryo.skill.manager.persistence.language.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "language")
@Data
public class LanguageEntity {

    /** 言語ID. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "language_id")
	private Long languageId;

    /** 言語名. */
	@Column(name = "language_name")
	private String languageName;
    
}
