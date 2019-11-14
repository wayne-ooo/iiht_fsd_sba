package com.sba.course.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.sba.course.model.MentorCourse;

@Mapper
public interface MentorMapper {
	
	@Select("SELECT a.id,a.name,a.mentorName,a.skill,a.startDate,a.endDate,a.fee, coalesce(b.rating, 0) as rate, a.description FROM course a  left join (SELECT courseId, round(avg(rating)) as rating FROM rate group by courseId) b on a.id =b.courseid where a.status='available'")
	List<MentorCourse> findMentors();
	
	@Select("SELECT a.id,a.name,a.mentorName,a.skill,a.startDate,a.endDate,a.fee, a.description, a.userName FROM course a ")
	List<MentorCourse> searchMentors();
	
	@Update("update course set userName=#{username},progress=1 where id = #{id}")
	void bookCourse(@Param("username") String username, @Param("id") Integer id);

	@Update("update course set status=#{status} where id = #{id}")
	void updateCourse(@Param("status") String status, @Param("id") Integer id);

}