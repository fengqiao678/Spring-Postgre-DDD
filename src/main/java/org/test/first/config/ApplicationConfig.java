package org.test.first.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.test.first.config.json.Iso8601DateFormatConfiguration;

@Configuration
@ComponentScan("org.test.first")
@EnableWebMvc
@Import({ HibernateConfiguration.class, Iso8601DateFormatConfiguration.class })
public class ApplicationConfig {
}
