package com.umayoryo.skill.manager.persistence.tool.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "tool")
@Data
public class ToolEntity {

    /** ツールID（主キー）. */
    @Id
    @Column(name = "tool_id")
    private Long toolId;

    /** ツール名 */
    @Column(name = "tool_name")
    private String toolName;

}
