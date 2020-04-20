/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domrade.rest.config;

import javax.ws.rs.core.Application;

/**
 *
 * @author David
 */
//@ApplicationPath("rest")
public class RestConfig extends Application {
	/*
	 * @Bean public FilterRegistrationBean corsFilter() {
	 * UrlBasedCorsConfigurationSource source = new
	 * UrlBasedCorsConfigurationSource(); CorsConfiguration config = new
	 * CorsConfiguration(); config.setAllowCredentials(true);
	 * //config.addAllowedOrigin("http://localhost:8081");
	 * config.addAllowedOrigin("*"); config.setAllowedMethods(Arrays.asList("POST",
	 * "OPTIONS", "GET", "DELETE", "PUT"));
	 * config.setAllowedHeaders(Arrays.asList("X-Requested-With", "Origin",
	 * "Content-Type", "Accept", "Authorization"));
	 * source.registerCorsConfiguration("/**", config); FilterRegistrationBean bean
	 * = new FilterRegistrationBean(new CorsFilter(source));
	 * bean.setOrder(Ordered.HIGHEST_PRECEDENCE); return bean; }
	 * 
	 * @Bean public Server rsServer(Bus bus, RestData service) {
	 * JAXRSServerFactoryBean endpoint = new JAXRSServerFactoryBean();
	 * endpoint.setBus(bus); endpoint.setAddress("/");
	 * endpoint.setServiceBean(service);
	 * endpoint.setTransportId(SseHttpTransportFactory.TRANSPORT_ID);
	 * endpoint.setProvider(new JacksonJsonProvider()); return endpoint.create(); }
	 * 
	 * @Bean public WebMvcConfigurer corsConfigurer() { return new
	 * WebMvcConfigurer() {
	 * 
	 * @Override public void addCorsMappings(CorsRegistry registry) {
	 * registry.addMapping("/services/**").allowedOrigins("*"); } }; }
	 * 
	 * @Override public void addResourceHandlers(ResourceHandlerRegistry registry) {
	 * registry .addResourceHandler("/services/**")
	 * .addResourceLocations("classpath:/web-ui/"); }
	 */
}
