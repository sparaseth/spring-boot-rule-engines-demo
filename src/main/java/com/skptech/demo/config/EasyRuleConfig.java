package com.skptech.demo.config;

import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.api.RulesEngine;
import org.jeasy.rules.core.DefaultRulesEngine;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EasyRuleConfig {

    @Bean
    public Rules rule() {
        return new Rules();
    }

    @Bean
    public RulesEngine rulesEngine() {
        return new DefaultRulesEngine();
    }

    @Bean
    public Facts facts(){
        return new Facts();
    }

}
