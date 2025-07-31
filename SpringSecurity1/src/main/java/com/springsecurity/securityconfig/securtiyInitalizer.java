package com.springsecurity.securityconfig;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

//this will Register the Spring Security Filter.......

//By Default Spring will have one spring Security Layer --> that login Page
//If we are trying to send request to any of the URL -->login Page will ask Authorization then only it will allow the other End Points Else No
public class securtiyInitalizer extends AbstractSecurityWebApplicationInitializer{

}
