package com.umayoryou.business.bean;

import lombok.Data;

/**
 * エンジニア情報を保持するBean.
 */
@Data
public class EngineerBean {
    
    /** エンジニアID. */
    private int engineerId;
    
    /**エンジニア名. */
    private String engineerName;
    
    /** エンジニアスキル名. */
    private String skillName;
}
