package com.apar.qa.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apar.qa.dao.TagMasterDAO;
import com.apar.qa.models.TagMasterEntity;

@Service
public class TagService {
	
	@Autowired
	private TagMasterDAO tagMasterDAO;
	
	public String getAllTagIdsByName(String tagName)
	{
		String tags = "";
		tagName = tagName.toLowerCase();
		String tagArray[] = tagName.split(",");
		List<String> tagList = new ArrayList<>();
		for(int i=0; i<tagArray.length; i++)
		{
			tagList.add(tagArray[i].trim());
		}
		System.out.println("request tags:::::: "+tagList);
		
		try {
			List<String> existingTags = tagMasterDAO.findAllByTagIds(tagList);
			if(existingTags.size()>0)
			{
				tags = String.join(", ", existingTags);
				System.out.println("existing tags::::::: "+tags);
				tagList.removeAll(existingTags);
				System.out.println("request tags after removing existing:::::: "+tagList);
			}
			if(tagList.size()>0)
			{
				List<TagMasterEntity> tagMasterList = new ArrayList<>();
				for(String tag:tagList)
				{
					TagMasterEntity tagMaster = new TagMasterEntity();
					tagMaster.setTagId(tag);
					tagMaster.setTagName(tag);
					tagMaster.setCreatedBy("System");
					tagMaster.setCreatedAt(new Date());
					tagMasterList.add(tagMaster);
				}
				tagMasterDAO.save(tagMasterList);
				if(!tags.equals(""))
					tags = tags + ", ";
				tags = tags + String.join(", ", tagList);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tags;
	}
	
	
}
 