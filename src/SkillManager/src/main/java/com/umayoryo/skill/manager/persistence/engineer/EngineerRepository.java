package com.umayoryo.skill.manager.persistence.engineer;

import jakarta.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.umayoryo.skill.manager.persistence.engineer.entity.EngineerEntity;

/**
 * エンジニア情報を管理するリポジトリインターフェース.
 * 
 * このインターフェースは、Spring Data JPAを使用してエンジニアのデータベース操作を行います.
 * JpaRepositoryを継承し、標準的なCRUD（作成、読み取り、更新、削除）操作を提供します.
 */
@Repository
@Transactional
public interface EngineerRepository
        extends JpaRepository<EngineerEntity, Integer>, JpaSpecificationExecutor<EngineerEntity> {

}
