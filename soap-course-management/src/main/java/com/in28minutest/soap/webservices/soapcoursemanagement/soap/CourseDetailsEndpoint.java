package com.in28minutest.soap.webservices.soapcoursemanagement.soap;

import com.in28minutest.courses.*;
import com.in28minutest.soap.webservices.soapcoursemanagement.soap.bean.Course;
import com.in28minutest.soap.webservices.soapcoursemanagement.soap.service.CourseDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.List;

@Endpoint
public class CourseDetailsEndpoint {

    @Autowired
    CourseDetailsService service;
    // method
    // input - GetCourseDetailsRequest
    // output -GetCourseDetailsResponse

    @PayloadRoot(namespace = "http://in28minutest.com/courses",
            localPart = "GetCourseDetailsRequest")
    @ResponsePayload
    public GetCourseDetailsResponse processCourseDetailsRequest(
            @RequestPayload GetCourseDetailsRequest request) {
        GetCourseDetailsResponse response = new GetCourseDetailsResponse();
        Course course = service.findById(request.getId());
        response.setCourseDetails(mapCourseDetails(course));
        return response;
    }

    @PayloadRoot(namespace = "http://in28minutest.com/courses",
            localPart = "GetAllCourseDetailsRequest")
    @ResponsePayload
    public GetAllCourseDetailsResponse processCourseDetailsRequest(
            @RequestPayload GetAllCourseDetailsRequest request) {
        GetAllCourseDetailsResponse allCourseDetailsResponse = new GetAllCourseDetailsResponse();
        List<Course> courses = service.findAll();
        List<CourseDetails> courseDetails = allCourseDetailsResponse.getCourseDetails();

        courses.stream()
                .map(this::mapCourseDetails)
                .forEach(courseDetails::add);

        return allCourseDetailsResponse;
    }

    @PayloadRoot(namespace = "http://in28minutest.com/courses",
            localPart = "DeleteCourseDetailsRequest")
    @ResponsePayload
    public DeleteCourseDetailsResponse processCourseDetailsRequest(
            @RequestPayload DeleteCourseDetailsRequest request) {

        int status = service.deleteById(request.getId());
        DeleteCourseDetailsResponse response = new DeleteCourseDetailsResponse();
        response.setStatus(status);
        return response;
    }

    private CourseDetails mapCourseDetails(Course course) {
        CourseDetails details = new CourseDetails();
        details.setId(course.getId());
        details.setName(course.getName());
        details.setDescription(course.getDescription());
        return details;
    }
}
