package com.ghunteranderson.examples;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;


@ApplicationPath("/")
@ApplicationScoped
public class JaxrsApplication extends Application {}
