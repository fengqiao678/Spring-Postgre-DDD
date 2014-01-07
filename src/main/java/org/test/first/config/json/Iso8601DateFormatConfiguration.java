package org.test.first.config.json;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperFactoryBean;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.joda.JodaModule;

@Configuration
public class Iso8601DateFormatConfiguration extends WebMvcConfigurerAdapter {
	
	private static final String ISO8601_DATE_FORMAT_STRING = "yyyy-MM-dd'T'HH:mm:ss.SSSZ"; 
	
    private ObjectMapper objectMapper() {
        Jackson2ObjectMapperFactoryBean bean = new Jackson2ObjectMapperFactoryBean();
        bean.setIndentOutput(true);
        bean.setSimpleDateFormat(ISO8601_DATE_FORMAT_STRING);
        bean.afterPropertiesSet();
        ObjectMapper objectMapper = bean.getObject();
        objectMapper.registerModule(new JodaModule());
        return objectMapper;
    }

    private MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setObjectMapper(objectMapper());
        return converter;
    }
    
	@Override
	public void configureMessageConverters(
			List<HttpMessageConverter<?>> converters) {
		converters.add(mappingJackson2HttpMessageConverter());
	}
}
