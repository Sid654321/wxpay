package com.sst.mapper;

import java.util.List;
import java.util.Map;

import com.sst.entity.User;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {

	@Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")
	public int create(User user);

	public int delete(Integer id);

	public int update(User user);

	public int updateSelective(User user);

	public List<User> query(User user);


	public User detail(Integer id);

	public int count(User user);

	@Select("select * from user where openid = #{openid}")
	public User findByOpenId(String openid);

}