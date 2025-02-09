package com.umayoryo.skill.manager.service.tool;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.umayoryo.skill.manager.persistence.tool.ToolRepository;
import com.umayoryo.skill.manager.persistence.tool.entity.ToolEntity;

@Service
public class ToolServiceImpl implements ToolService{

    @Autowired
    private ToolRepository toolRepository;

    public List<ToolBean> findAll(){
		return toolRepository.findAll().stream().map(this :: convert).collect(Collectors.toList());
    }

    /**
	 * プロジェクト情報をEntityからBeanに変換.
	 * 
	 * @param entity ToolEntity
	 * @return ToolBean
	 */
	private ToolBean convert(ToolEntity entity) {
		
		return ToolBean.builder().
				toolId(entity.getToolId()).
				toolName(entity.getToolName()).
				build();

	}
    
}
