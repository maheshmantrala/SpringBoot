package com.mahesh.React.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class UserRouter {
	@Autowired
	private UserHandler userHandler;
	@Bean
	RouterFunction<ServerResponse> routerFunction(){
		return RouterFunctions.route(RequestPredicates.POST("api/user/add"),userHandler::addUser)
				.andRoute(RequestPredicates.POST("api/user/update"),userHandler::UpdateUserByEmailId)
				.andRoute(RequestPredicates.POST("api/user/delete"),userHandler::deleteUsertByEmailId)
		        .andRoute(RequestPredicates.GET("api/user/all"), userHandler::getAllUsers);
	}

}