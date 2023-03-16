package com.demo.req.emv.validation.demo.requestor;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import com.demo.req.emv.validation.demo.requestor.filter.ExecLogFilter;
import com.demo.req.emv.validation.demo.requestor.http.HttpClientUtil;

@SpringBootApplication
public class DemoRequestorApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoRequestorApplication.class, args);
	}
	
	@Bean
    public FilterRegistrationBean<ExecLogFilter> execLogFilterRegistration() {
        FilterRegistrationBean<ExecLogFilter> registration = new FilterRegistrationBean<ExecLogFilter>();
        registration.setFilter(new ExecLogFilter());
        registration.addUrlPatterns("/", "/start", "/finish", "/query");
        registration.setName("execLogFilter");
        registration.setOrder(1);
        return registration;
    }
	
//	@Bean
//    public RestTemplate restTemplate(ClientHttpRequestFactory clientHttpRequestFactory) {
//        return new RestTemplate(clientHttpRequestFactory);
//    }
//	
//	@Bean
//    public ClientHttpRequestFactory clientHttpRequestFactory() {
//        int timeout = 30 * 1000;
//        RequestConfig config = RequestConfig.custom()
//                .setConnectTimeout(timeout)
//                .setConnectionRequestTimeout(timeout)
//                .setSocketTimeout(15 * 1000)
//                .build();
//        CloseableHttpClient client = HttpClientBuilder
//                .create()
//                .setDefaultRequestConfig(config)
//                .build();
//        HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory(client);
//        requestFactory.setConnectTimeout(timeout);
//        requestFactory.setReadTimeout(15 * 1000);
//        return requestFactory;
//    }
	
	@Bean
	  public RestTemplate httpsRestTemplate(HttpComponentsClientHttpRequestFactory httpsFactory) {
	    RestTemplate restTemplate = new RestTemplate(httpsFactory);
	    restTemplate.setErrorHandler(
	        new ResponseErrorHandler() {
	          @Override
	          public boolean hasError(ClientHttpResponse clientHttpResponse) {
	            return false;
	          }
	 
	          @Override
	          public void handleError(ClientHttpResponse clientHttpResponse) {
	            // 默认处理非200的返回，会抛异常
	          }
	        });
	    return restTemplate;
	  }
	 
	  @Bean(name = "httpsFactory")
	  public HttpComponentsClientHttpRequestFactory httpComponentsClientHttpRequestFactory()
	      throws Exception {
	    CloseableHttpClient httpClient = HttpClientUtil.acceptsUntrustedCertsHttpClient();
	    HttpComponentsClientHttpRequestFactory httpsFactory =
	        new HttpComponentsClientHttpRequestFactory(httpClient);
	    httpsFactory.setReadTimeout(40000);
	    httpsFactory.setConnectTimeout(40000);
	    return httpsFactory;
	  }

}
