package com.tinet.tsso.auth.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tinet.tsso.auth.dao.ApplicationMapper;
import com.tinet.tsso.auth.entity.Application;
import com.tinet.tsso.auth.service.ApplicationService;
import com.tinet.tsso.auth.util.Page;

/**
 * @date 2017-08-08
 * @author lizy
 */
@Service
public class ApplicationServiceImpl extends BaseServiceImp<Application, Integer> implements ApplicationService {

	@Autowired
	private ApplicationMapper applicationMapper;

	
	/**
	 * 查询应用的分页信息
	 */
	@Override
	public Page<Application> getAll() {

		Integer totalSize = applicationMapper.selectCount();

		List<Application> pageData = applicationMapper.selectAll();

		return new Page<Application>(totalSize, pageData);
	}
}
