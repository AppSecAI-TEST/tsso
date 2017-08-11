package com.tinet.tsso.auth.model;

/**
 * @date 2017-08-10
 * @author lizy
 */

public class PermissionParam {

	
	private Integer id;//权限id
	
	private Integer key; //权限标识
	
	private Integer applicationId;//应用id;
	
	private Integer roleId;//角色id
	
	private Integer start;//分页的起始位置
	
	private Integer limit;//分页大小

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getKey() {
		return key;
	}

	public void setKey(Integer key) {
		this.key = key;
	}

	public Integer getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(Integer applicationId) {
		this.applicationId = applicationId;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public Integer getStart() {
		return start;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

	public Integer getLimit() {
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}
	
	
}