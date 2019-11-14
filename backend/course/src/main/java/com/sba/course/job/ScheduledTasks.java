package com.sba.course.job;


import com.sba.course.mapper.MentorMapper;
import com.sba.course.mapper.UserCourseMapper;
import com.sba.course.model.UserCourse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Component
@Configurable
@EnableScheduling
public class ScheduledTasks {


    @Autowired
    private UserCourseMapper usercoursemapper;
    @Autowired
    private MentorMapper mentorcoursemapper;
    //每1分钟执行一次
    @Scheduled(cron = "0 */1 *  * * * ")
    public void reportCurrentByCron() {
        System.out.println("Job Run ");

        List<UserCourse> usercourses = usercoursemapper.findCourse();
        for (int i = 0; i < usercourses.size(); i++) {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            if(usercourses.get(i).getEnabelTime()!=null){
                String enabelTime = formatter.format(usercourses.get(i).getEnabelTime());
                Date currentDate = new Date();
                String currentTime = formatter.format(usercourses.get(i).getEnabelTime());
                if(enabelTime.equals(currentTime)){
                    usercourses.get(i).setStatus("available");
                    mentorcoursemapper.updateCourse(usercourses.get(i).getStatus(),usercourses.get(i).getId());
                }
            }

        }

    }


}