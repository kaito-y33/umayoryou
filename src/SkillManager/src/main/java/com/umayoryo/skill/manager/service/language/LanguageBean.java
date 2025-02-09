package com.umayoryo.skill.manager.service.language;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LanguageBean {

    private Long languageId;
    private String languageName;

}
