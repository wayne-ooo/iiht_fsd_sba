package com.sba.course.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectKey;

import com.sba.course.model.Course;


@Mapper
public interface CourseMapper {

	@Insert("insert into  course(name,description,skill,startDate,endDate,mentorName,fee) values(#{name},#{description},#{skill},#{startDate},#{endDate},#{mentorName},#{fee})")
	@SelectKey(statement = "select LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = int.class)
	void addCourse(Course course);
}
