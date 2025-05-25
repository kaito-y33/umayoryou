package com.umayoryo.skill.manager.persistence.skill;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.umayoryo.skill.manager.persistence.skill.entity.LanguageEntity;

/**
 * 
 * 
 */
@Repository
public interface LanguageRepository
                extends JpaRepository<LanguageEntity, Integer>, JpaSpecificationExecutor<LanguageEntity> {

}
