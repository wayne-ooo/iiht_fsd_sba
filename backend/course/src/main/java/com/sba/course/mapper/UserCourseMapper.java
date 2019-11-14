package com.sba.course.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.sba.course.model.UserCourse;
import org.apache.ibatis.annotations.Update;


@Mapper
public interface UserCourseMapper {

	@Select("SELECT id,skill,name,description,startDate,endDate,mentorName,progress FROM  course where progress=#{progress} and userName=#{username}")
	List<UserCourse> findUserCourse(@Param("username") String username, @Param("progress") Integer progress);

	@Select("SELECT id,skill,name,description,startDate,endDate,mentorName,progress,enabelTime FROM  course ")
	List<UserCourse> findCourse();

	@Update("update course set status='un',enabelTime=#{enabelTime} where id = #{id}")
	void updateCourse( @Param("enabelTime") Date enabelTime, @Param("id") Integer id);
}
