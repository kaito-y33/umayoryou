package com.umayoryo.skill.manager.service.language;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.umayoryo.skill.manager.persistence.language.LanguageRepository;
import com.umayoryo.skill.manager.persistence.language.entity.LanguageEntity;

@Service
public class LanguageServiceImpl implements LanguageService{

    @Autowired
    private LanguageRepository languageRepository;

    public List<LanguageBean> findAll(){
		return languageRepository.findAll().stream().map(this :: convert).collect(Collectors.toList());
    }

    /**
	 * プロジェクト情報をEntityからBeanに変換.
	 * 
	 * @param entity LanguageEntity
	 * @return LanguageBean
	 */
	private LanguageBean convert(LanguageEntity entity) {
		
		return LanguageBean.builder().
				languageId(entity.getLanguageId()).
				languageName(entity.getLanguageName()).
				build();

	}
    
}
