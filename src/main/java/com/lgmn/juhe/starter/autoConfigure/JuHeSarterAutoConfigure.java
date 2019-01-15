package com.lgmn.juhe.starter.autoConfigure;


import com.lgmn.juhe.starter.properties.JuHeSarterServiceProperties;
import com.lgmn.juhe.starter.service.JuHe_IdCardQuery_SarterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * AutoConfigure
 */
@Configuration
@EnableConfigurationProperties(JuHeSarterServiceProperties.class)
@ConditionalOnClass(JuHe_IdCardQuery_SarterService.class)
@ConditionalOnProperty(prefix = "juhe.service", value = "enabled", matchIfMissing = true)
public class JuHeSarterAutoConfigure {

    @Autowired
    JuHeSarterServiceProperties juHeSarterServiceProperties;

    @Bean
    @ConditionalOnMissingBean(JuHe_IdCardQuery_SarterService.class)
    JuHe_IdCardQuery_SarterService juHe_idCardQuery_sarterService () {
        return new JuHe_IdCardQuery_SarterService(juHeSarterServiceProperties.getKey());
    }

}
