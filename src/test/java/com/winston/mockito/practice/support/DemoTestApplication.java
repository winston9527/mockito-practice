package com.winston.mockito.practice.support;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Service;

@SpringBootApplication
@ComponentScan(
  basePackages = {"com.winston.mockito.practice"},
  excludeFilters = {
    @ComponentScan.Filter(type = FilterType.ANNOTATION,
      classes = {Service.class}
    )
  }
)
public class DemoTestApplication {

}
