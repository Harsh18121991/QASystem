package com.apar.qa.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apar.qa.dao.MasterValuesDAO;
import com.apar.qa.models.MasterValuesEntity;

@Service
public class MasterValueService {
	
	@Autowired
	private MasterValuesDAO masterValuesDAO;
	
	public Map<String, Map<String, String>> getAllMasterValues()
	{
		List<MasterValuesEntity> listMasterValues = masterValuesDAO.findByStatus("ACTIVE");
		Map<String,Map<String, String>> groupWiseMasterValues = new HashMap<String, Map<String, String>>();
		Map<String, String> contentMap = new HashMap<>();
		Map<String, String> requestTypeMap = new HashMap<>();
		Map<String, String> priorityMap = new HashMap<>();
		for(MasterValuesEntity mve:listMasterValues)
		{
			if(null!=mve.getGroupId() && null!=mve.getGroupId().getGroupName() && "CONTENT".equalsIgnoreCase(mve.getGroupId().getGroupName()))
			{
				contentMap.put(mve.getId(), mve.getValue());
			}
			else if(null!=mve.getGroupId() && null!=mve.getGroupId().getGroupName() && "REQUESTTYPE".equalsIgnoreCase(mve.getGroupId().getGroupName()))
			{
				requestTypeMap.put(mve.getId(), mve.getValue());
			}
			else if(null!=mve.getGroupId() && null!=mve.getGroupId().getGroupName() && "PRIORITY".equalsIgnoreCase(mve.getGroupId().getGroupName()))
			{
				priorityMap.put(mve.getId(), mve.getValue());
			}
		}
		groupWiseMasterValues.put("content", contentMap);
		groupWiseMasterValues.put("requestType", requestTypeMap);
		groupWiseMasterValues.put("priority", priorityMap);
		return groupWiseMasterValues;
	}
	
	public Map<String, String> getAllMasterStatus()
	{
		List<Object[]> listStatus = masterValuesDAO.findByGroupName("STATUS");
		Map<String, String> mapStatus = convertListObjectToMap(listStatus);
		return mapStatus;
	}
	
	public Map<String, String> convertListObjectToMap(List<Object[]> listObject)
	{
		Map<String, String> mapMasterValue = new HashMap<>();
		for(Object[] obj:listObject)
		{
			mapMasterValue.put((String)obj[0], (String)obj[1]);
		}
		return mapMasterValue;
	}
	
	
}
