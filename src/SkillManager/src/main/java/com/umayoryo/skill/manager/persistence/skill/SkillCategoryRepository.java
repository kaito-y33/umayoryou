package com.umayoryo.skill.manager.persistence.skill;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.umayoryo.skill.manager.persistence.skill.entity.SkillCategoryEntity;

/**
 * スキル情報を管理するリポジトリインターフェース.
 * 
 * このインターフェースは、Spring Data JPAを使用してスキル情報のデータベース操作を行います.
 * JpaRepositoryを継承し、スキルエンティティに対する標準的なCRUD（作成、読み取り、更新、削除）操作を提供します.
 */
@Repository
public interface SkillCategoryRepository
        extends JpaRepository<SkillCategoryEntity, Integer>, JpaSpecificationExecutor<SkillCategoryEntity> {

}
