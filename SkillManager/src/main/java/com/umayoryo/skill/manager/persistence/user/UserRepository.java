package com.umayoryo.skill.manager.persistence.user;

import jakarta.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.umayoryo.skill.manager.persistence.user.entity.UserEntity;

/**
 * ユーザー情報を管理するリポジトリインターフェース.
 * 
 * このインターフェースは、Spring Data JPAを使用してユーザーのデータベース操作を行います.
 * JpaRepositoryを継承し、ユーザーエンティティに対する標準的なCRUD（作成、読み取り、更新、削除）操作を提供します.
 */
@Repository
@Transactional
public interface UserRepository extends JpaRepository<UserEntity, Integer> {

}
