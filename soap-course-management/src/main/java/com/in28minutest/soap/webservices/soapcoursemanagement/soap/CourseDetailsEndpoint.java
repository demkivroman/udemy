package com.in28minutest.soap.webservices.soapcoursemanagement.soap;

import com.in28minutest.courses.CourseDetails;
import com.in28minutest.courses.GetCourseDetailsRequest;
import com.in28minutest.courses.GetCourseDetailsResponse;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class CourseDetailsEndpoint {
    // method
    // input - GetCourseDetailsRequest
    // output -GetCourseDetailsResponse

    @PayloadRoot(namespace = "http://in28minutest.com/courses",
            localPart = "GetCourseDetailsRequest")
    @ResponsePayload
    public GetCourseDetailsResponse processCourseDetailsRequest(
            @RequestPayload GetCourseDetailsRequest request) {
        GetCourseDetailsResponse response = new GetCourseDetailsResponse();
        CourseDetails details = new CourseDetails();
        details.setId(request.getId());
        details.setName("Microservices course");
        details.setDescription("Course to Roman Demkiv");
        response.setCourseDetails(details);
        return response;
    }
}
