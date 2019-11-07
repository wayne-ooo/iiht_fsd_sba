package com.sba.course.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.sba.course.model.UserCourse;


@Mapper
public interface UserCourseMapper {

	@Select("SELECT id,skill,name,description,startDate,endDate,mentorName,progress FROM  course where progress=#{progress} and userName=#{username}")
	List<UserCourse> findUserCourse(@Param("username") String username, @Param("progress") Integer progress);
}
