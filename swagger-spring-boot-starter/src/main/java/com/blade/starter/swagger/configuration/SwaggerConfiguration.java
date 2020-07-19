package com.blade.starter.swagger.configuration;

import io.swagger.annotations.Api;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.ApiSelectorBuilder;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * TODO:
 * 单机redisson
 *
 * @author Blade
 * @date 2020/4/29 10:32
 */
@Configuration
@EnableSwagger2
@EnableConfigurationProperties(SwaggerProperties.class)
public class SwaggerConfiguration {

    @Autowired
    private SwaggerProperties swaggerProperties;

    @Bean
    public Docket createRestApi() {

        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .enable(this.swaggerProperties.getEnable())
                .apiInfo(apiInfo());

        ApiSelectorBuilder builder = docket.select();
        if (StringUtils.isBlank(this.swaggerProperties.getBasePackage())) {
            builder.apis(RequestHandlerSelectors.any());
        } else {
            // 扫描包路径
            builder.apis(RequestHandlerSelectors.basePackage(this.swaggerProperties.getBasePackage()));
        }

        if (StringUtils.isBlank(this.swaggerProperties.getBasePath())) {
            builder.paths(PathSelectors.any());
        } else {
            // 扫描路径
            builder.paths(PathSelectors.ant(this.swaggerProperties.getBasePath()));
        }

        return builder.build();
    }

    private ApiInfo apiInfo() {

        Contact contact = new Contact(this.swaggerProperties.getContactName(),
                this.swaggerProperties.getContactUrl(), this.swaggerProperties.getContactEmail());

        ApiInfoBuilder builder = new ApiInfoBuilder();

        builder.title(this.swaggerProperties.getTitle())
                .description(this.swaggerProperties.getDescription())
                .license(this.swaggerProperties.getLicense())
                .licenseUrl(this.swaggerProperties.getLicenseUrl())
                .version(this.swaggerProperties.getVersion())
                .termsOfServiceUrl(this.swaggerProperties.getTermsOfServiceUrl())
                .contact(contact);

        return builder.build();
    }
}