package com.javatechie.spring.soap.api.config;

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

@Configuration
@EnableWs
public class SoapWSConfig {

  @Bean
  public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(ApplicationContext context) {
    MessageDispatcherServlet servlet = new MessageDispatcherServlet();
    servlet.setApplicationContext(context); // enable that servlet can obtain other spring beans
    servlet.setTransformWsdlLocations(true);
    return new ServletRegistrationBean<>(servlet, "/ws/*");
  }

  @Bean(name = "loanEligibility") // wsdl name will be the same as bean-name
  public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema schema) {
    DefaultWsdl11Definition defaultWsdl11Definition = new DefaultWsdl11Definition();
    defaultWsdl11Definition.setPortTypeName("LoanEligibilityindicator");
    defaultWsdl11Definition.setLocationUri("/ws");
    // matches the targetNamespace in xsd
    defaultWsdl11Definition.setTargetNamespace("http://www.javatechie.com/spring/soap/api/loanEligibility");
    defaultWsdl11Definition.setSchema(schema);
    return defaultWsdl11Definition;
  }

  @Bean
  public XsdSchema schema() {
    return new SimpleXsdSchema(new ClassPathResource("xsd/loaneligibility.xsd"));
  }

}