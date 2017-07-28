package com.spider.microcommercial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;

@SpringBootApplication
@EnableCaching
public class MicroCommercialApplication {

  @Bean
  public EmbeddedServletContainerCustomizer containerCustomizer() {

    return (container -> {
      ErrorPage error404Page = new ErrorPage(HttpStatus.NOT_FOUND, "/");
      container.addErrorPages(error404Page);
    });
  }

	public static void main(String[] args) {
		SpringApplication.run(MicroCommercialApplication.class, args);
	}
}
