package com.umayoryo.skill.manager.persistence.language;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.umayoryo.skill.manager.persistence.language.entity.LanguageEntity;

public interface LanguageRepository extends JpaRepository<LanguageEntity, Long>, JpaSpecificationExecutor<LanguageEntity>{
    
}
