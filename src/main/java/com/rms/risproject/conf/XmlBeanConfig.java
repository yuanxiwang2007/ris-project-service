package com.rms.risproject.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource(locations={"classpath:dubbo.xml"})
public class XmlBeanConfig {

}

