package com.umayoryou.business.bean;

import lombok.Data;

/**
 * ユーザー情報を保持するBean.
 * 
 *  */
@Data
public class UserBean {
    
    /** ユーザーID. */
    private int userId;
    
    /** ユーザー名. */
    private String userName;
}
