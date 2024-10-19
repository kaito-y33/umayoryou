package com.example.repository.dao;

import jakarta.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.repository.entity.EngineerEntity;

/**
 * エンジニア情報を管理するリポジトリインターフェース.
 * 
 * このインターフェースは、Spring Data JPAを使用してエンジニアのデータベース操作を行います.
 * JpaRepositoryを継承し、標準的なCRUD（作成、読み取り、更新、削除）操作を提供します.
 */
@Repository
@Transactional
public interface EngineerRepository extends JpaRepository<EngineerEntity, Integer> {

}
