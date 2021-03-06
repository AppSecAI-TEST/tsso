package com.tinet.tsso.auth.dao;

import java.util.List;

import com.tinet.tsso.auth.entity.User;
import com.tinet.tsso.auth.model.UserParam;

public interface UserMapper extends BaseMapper<User, Integer>{

    int insert(User record);

    User selectByPrimaryKey(Integer id);
	/**
	 * @param params 查询符合条件的所有数据的个数，即该出没有start和limit限制分页
	 * @return
	 */
	Integer selectCountByParams(UserParam params);

	/**
	 * @param params 返回符合条件的数据列表
	 * @return
	 */
	List<User> selectByParams(UserParam params);

	/**
	 * 
	 * @param params 为指定id的User添加权限roleId
	 */
	void addRole(UserParam params);

}