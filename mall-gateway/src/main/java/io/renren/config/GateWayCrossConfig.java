package io.renren.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

@Configuration
public class GateWayCrossConfig {
    @Bean
    public CorsWebFilter corsWebFilter(){
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

        CorsConfiguration corsConfiguration = new CorsConfiguration();

        //1、配置跨域
        corsConfiguration.addAllowedHeader("*");
        corsConfiguration.addAllowedMethod("*");//支持的请求方式
//        corsConfiguration.addAllowedOriginPattern("*");//支持的来源 新版本里面用该api 来版本里面用addAllowedOrigin
        corsConfiguration.addAllowedOriginPattern("*");
        corsConfiguration.setAllowCredentials(true);//跨域请求可以携带cookie


        //该gateway 最开始使用的是 cloud 2020  boot  2.5 报错DeferringLoadBalancerExchangeFilterFunction始终找不到
        //但是包里面能正常使用， 查询资料没找到解决方案，没办法就降级到boot的2.3版本 ，cound H9就可以解决该问题

        source.registerCorsConfiguration("/**",corsConfiguration);
        return new CorsWebFilter(source);
    }
}
