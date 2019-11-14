package com.sba.course.apicontroller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sba.course.mapper.UserCourseMapper;
import com.sba.course.model.UserCourse;
import com.sba.course.rspmodel.RspModel;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/v1/user")
@Api(description = "SBA Mentor Interface")
public class SbaUserCourseApi {
	
	@Autowired
	private UserCourseMapper usercoursemapper;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET, produces = "application/json")
	@ApiOperation(value = "SBA User Course List")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "ok"), @ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 401, message = "No Authroization"), @ApiResponse(code = 403, message = "No Permission"),
			@ApiResponse(code = 404, message = "No Mentors Found"),
			@ApiResponse(code = 500, message = "Internal Error") })
	public ResponseEntity<RspModel> finUserCourses(@ApiParam(name = "username", required = true) @RequestParam String username,
			@ApiParam(name = "progress", required = true) @RequestParam Integer progress) {

		try {

			List<UserCourse> usercourses = usercoursemapper.findUserCourse(username, progress);
		
			if (usercourses.size() > 0) {
				
				RspModel rsp = new RspModel();
				rsp.setCode(200);
				rsp.setMessage("Found Courses");
				rsp.setData(usercourses);
				return new ResponseEntity<RspModel>(rsp, HttpStatus.OK);
				
			} else {
				RspModel rsp = new RspModel();
				rsp.setCode(404);
				rsp.setMessage("No Found Courses");
				return new ResponseEntity<RspModel>(rsp, HttpStatus.OK);
			}


		} catch (Exception ex) {
			RspModel rsp = new RspModel();
			rsp.setCode(500);
			rsp.setMessage(ex.getMessage());
			return new ResponseEntity<RspModel>(rsp, HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}



	@RequestMapping(value = "/updatecourse1", method = RequestMethod.GET, produces = "application/json")
	@ApiOperation(value = "SBA User Course List")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "ok"), @ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 401, message = "No Authroization"), @ApiResponse(code = 403, message = "No Permission"),
			@ApiResponse(code = 404, message = "No Mentors Found"),
			@ApiResponse(code = 500, message = "Internal Error") })
	public ResponseEntity<RspModel> updateCourses1(@ApiParam(name = "days", required = true) @RequestParam String days,
												   @ApiParam(name = "id", required = true) @RequestParam String id) {

		int i = Integer.valueOf(days);
		Date enabelTime = getFetureDate(i);
		usercoursemapper.updateCourse(enabelTime, Integer.valueOf(id));

		RspModel rsp = new RspModel();
		rsp.setCode(200);
		rsp.setMessage("Found Courses");
		return new ResponseEntity<RspModel>(rsp, HttpStatus.OK);
	}

	public static Date getFetureDate(int past) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) + past);
		Date today = calendar.getTime();


		return today;
	}


}
