/*
 * Copyright (c) 2020 牧星仓库管理系统 All rights reserved.
 *
 * http://www.mushiny.com
 *
 * 版权所有，侵权必究！
 */

package com.mushiny.workbin.web;

import com.mushiny.workbin.interceptor.ResponseResultInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

/**
 * Web配置
 *
 * @author Elen elen.shen@mushiny.comn
 * @since 2.1.0
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

	@Autowired
	private ResponseResultInterceptor responseResultInterceptor;

	@Bean
	public LocaleResolver localeResolver() {
		return new CookieLocaleResolver();
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(responseResultInterceptor);
	}

}
