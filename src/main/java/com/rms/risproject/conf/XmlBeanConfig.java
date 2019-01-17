package com.rms.risproject.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource(locations={"classpath:spring/spring-*.xml"})
public class XmlBeanConfig {

}

