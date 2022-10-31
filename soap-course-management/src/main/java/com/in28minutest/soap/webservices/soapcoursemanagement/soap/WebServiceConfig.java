package com.in28minutest.soap.webservices.soapcoursemanagement.soap;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

// Enable Spring Web Services
@EnableWs
// Spring Configuration
@Configuration
public class WebServiceConfig {
    @Bean
    public ServletRegistrationBean messageDispatcherServlet(ApplicationContext context) {
        MessageDispatcherServlet messageDispatcherServlet = new MessageDispatcherServlet();
        messageDispatcherServlet.setApplicationContext(context);
        messageDispatcherServlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean<>(messageDispatcherServlet, "/ws/*");
    }

    // /ws/courses.wsdl
    // course-details.xsd
    // PortType - CoursePort
    // Namespace - http://in28minutest.com/courses

    @Bean(name = "courses")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema schema) {
        DefaultWsdl11Definition definition = new DefaultWsdl11Definition();
        definition.setPortTypeName("CoursePort");
        definition.setTargetNamespace("http://in28minutest.com/courses");
        definition.setLocationUri("/ws");
        definition.setSchema(schema);
        return definition;
    }

    @Bean
    public XsdSchema coursesSchema() {
        return new SimpleXsdSchema(new ClassPathResource("exemple-files/course-details.xsd"));
    }
}
