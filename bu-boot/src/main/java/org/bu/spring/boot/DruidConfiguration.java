package org.bu.spring.boot;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.bu.spring.boot.druid.DruidStatFilter;
import org.bu.spring.boot.druid.DruidStatViewServlet;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.pool.DruidDataSource;

@Configuration
@SuppressWarnings("deprecation")
public class DruidConfiguration {

	@Bean
	public ServletRegistrationBean druidServlet() {
		return new ServletRegistrationBean(new DruidStatViewServlet(), "/druid2/*");
	}

	@Bean
	public DataSource druidDataSource(//
			@Value("${spring.datasource.driverClassName}") String driver, //
			@Value("${spring.datasource.url}") String url, //
			@Value("${spring.datasource.username}") String username, //
			@Value("${spring.datasource.password}") String password) {//
		DruidDataSource druidDataSource = new DruidDataSource();
		druidDataSource.setDriverClassName(driver);
		druidDataSource.setUrl(url);
		druidDataSource.setUsername(username);
		druidDataSource.setPassword(password);
		try {
			druidDataSource.setFilters("stat, wall");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return druidDataSource;
	}

	@Bean
	public FilterRegistrationBean filterRegistrationBean() {
		FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
		filterRegistrationBean.setFilter(new DruidStatFilter());
		filterRegistrationBean.addUrlPatterns("/*");
		filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid2/*");
		return filterRegistrationBean;
	}
}