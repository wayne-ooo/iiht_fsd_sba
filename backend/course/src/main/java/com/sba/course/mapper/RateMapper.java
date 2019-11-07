package com.sba.course.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectKey;

import com.sba.course.model.Rate;

@Mapper
public interface RateMapper {

	@Insert("insert into rate(mentorId,rating) values(#{mentorId},#{rating})")
	@SelectKey(statement = "select LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = int.class)
	void addRate(Rate rate);
}
