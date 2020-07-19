package com.blade.starter.swagger.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * TODO:
 *
 * @author Blade
 * @date 2020/4/29 15:21
 */
@ConfigurationProperties(prefix = "spring.swagger")
public class SwaggerProperties {

    /**
     * 是否启用
     */
    private boolean enable;

    /**
     * 标题
     */
    private String title;

    /**
     * 描述
     */
    private String description;

    /**
     * 版本
     */
    private String version;

    /**
     * 许可证
     */
    private String license;

    /**
     * 许可证URL
     */
    private String licenseUrl;

    /**
     * 服务条款URL
     */
    private String termsOfServiceUrl;

    /**
     * 维护人
     */
    private String contactName;

    /**
     * 维护人URL
     */
    private String contactUrl;

    /**
     * 维护人邮件
     */
    private String contactEmail;

    /**
     * swagger 扫描的基础包， 默认: 全扫描
     */
    private String basePackage;

    /**
     * 需要处理的基础URL规则， 默认: /**
     */
    private String basePath = "/**";

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public String getLicenseUrl() {
        return licenseUrl;
    }

    public void setLicenseUrl(String licenseUrl) {
        this.licenseUrl = licenseUrl;
    }

    public String getTermsOfServiceUrl() {
        return termsOfServiceUrl;
    }

    public void setTermsOfServiceUrl(String termsOfServiceUrl) {
        this.termsOfServiceUrl = termsOfServiceUrl;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactUrl() {
        return contactUrl;
    }

    public void setContactUrl(String contactUrl) {
        this.contactUrl = contactUrl;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getBasePackage() {
        return basePackage;
    }

    public void setBasePackage(String basePackage) {
        this.basePackage = basePackage;
    }

    public String getBasePath() {
        return basePath;
    }

    public void setBasePath(String basePath) {
        this.basePath = basePath;
    }

    public boolean getEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }
}
