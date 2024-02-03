package com.jun.toyproject.invite.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


//@OpenAPIDefinition(
//        info = @Info(title = "초대장 API 명세서",
//        description = "invite API 명세서",
//        version = "V1")
//)
@Configuration
public class SwaggerConfig {
    @Bean
    public GroupedOpenApi customApi() {


        return GroupedOpenApi.builder()
                .group("초대장 API V1")
                .pathsToMatch("/api/**")
                .build();
    }
}
