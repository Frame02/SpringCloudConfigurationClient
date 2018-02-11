package com.srikar.spring.cloud;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class SpringCloudConfigurationClientApplication {
    private static final Log logger = LogFactory.getLog(SpringCloudConfigurationClientApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudConfigurationClientApplication.class, args);
	}

    @Autowired
    public void getEnvironment(Environment env){
        logger.info(env.getProperty("configuration.projectName"));

    }
}


@RestController
@RefreshScope
class ProjectNameRestController{
    @Value("${configuration.projectName}")
    String projectName;

    @RequestMapping("/project-name")
    String projectName(){
        return projectName;
    }
}