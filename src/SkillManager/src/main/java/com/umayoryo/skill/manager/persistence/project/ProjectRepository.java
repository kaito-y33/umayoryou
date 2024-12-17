package com.umayoryo.skill.manager.persistence.project;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.umayoryo.skill.manager.persistence.project.entity.ProjectEntity;

/**
 * プロジェクトRepository.
 * 
 * @author YOSHIHASHI Kaito
 */
@Repository
public interface ProjectRepository extends JpaRepository<ProjectEntity, Long>, JpaSpecificationExecutor<ProjectEntity> {
}
