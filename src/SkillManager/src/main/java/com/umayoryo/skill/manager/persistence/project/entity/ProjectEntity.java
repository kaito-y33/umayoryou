package com.umayoryo.skill.manager.persistence.project.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

import com.umayoryo.skill.manager.common.enums.ProjectStatus;
import com.umayoryo.skill.manager.persistence.engineer.entity.EngineerEntity;

import lombok.Data;

/**
 * プロジェクトEntity
 * 
 * @author YOSHIHASHI Kaito
 */
@Entity
@Table(name = "project")
@Data
public class ProjectEntity {

	/** プロジェクトID. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "project_id")
	private Long projectId;

	/** プロジェクト名. */
	@Column(name = "project_name")
	private String projectName;

	/** プロジェクトの説明. */
	@Column(name = "description")
	private String description;

	/** プロジェクト開始日. */
	@Column(name = "start_date")
	private LocalDate startDate;

	/** プロジェクト終了日. */
	@Column(name = "end_date")
	private LocalDate endDate;

	/** プロジェクトの状態(進行中, 完了, 中止など). */
	@Enumerated(EnumType.STRING)
	private ProjectStatus status;

	/** プロジェクトメンバー情報一覧. */
	@ManyToMany
	@JoinTable(name = "project_members", joinColumns = @JoinColumn(name = "project_id"), inverseJoinColumns = @JoinColumn(name = "engineer_id"))
	private List<EngineerEntity> members;
}
