package com.umayoryo.skill.manager.persistence.tool;

import org.springframework.data.jpa.repository.JpaRepository;

import com.umayoryo.skill.manager.persistence.tool.entity.ToolEntity;

public interface ToolRepository extends JpaRepository<ToolEntity, Long>{
    
}
