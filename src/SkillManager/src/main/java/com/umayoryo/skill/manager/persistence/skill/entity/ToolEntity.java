package com.umayoryo.skill.manager.persistence.skill.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "tool")
@Data
public class ToolEntity {

    /** スキルID（主キー）. */
    @Id
    @Column(name = "tool_id")
    private long toolId;

    /** スキル名. */
    @Column(name = "tool_name")
    private String toolName;
}