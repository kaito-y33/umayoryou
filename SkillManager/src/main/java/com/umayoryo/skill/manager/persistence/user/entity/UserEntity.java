package com.umayoryo.skill.manager.persistence.user.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Data;

/**
 * ユーザー情報を表すエンティティ.
 * 
 * ユーザーの基本情報（IDと名前）を管理します.
 */
@Entity
@Table(name = "user")
@Data
public class UserEntity {

    /** ユーザーID（主キー）. */
    @Id
    @Column(name = "user_id")
    private int userId;
    
    /** ユーザー名. */
    @Column(name = "user_name")
    private String userName;
}
