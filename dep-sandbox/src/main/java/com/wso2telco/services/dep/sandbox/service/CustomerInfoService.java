/*******************************************************************************
 * Copyright  (c) 2015-2016, WSO2.Telco Inc. (http://www.wso2telco.com) All Rights Reserved.
 * 
 * WSO2.Telco Inc. licences this file to you under  the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
package com.wso2telco.services.dep.sandbox.service;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import com.wso2telco.services.dep.sandbox.exception.SandboxException.SandboxErrorType;
import com.wso2telco.services.dep.sandbox.servicefactory.RequestBuilderFactory;
import com.wso2telco.services.dep.sandbox.servicefactory.RequestHandleable;
import com.wso2telco.services.dep.sandbox.servicefactory.Returnable;
import com.wso2telco.services.dep.sandbox.servicefactory.customerinfo.GetProfileRequestWrapper;
import com.wso2telco.services.dep.sandbox.util.RequestType;

@Path("customer/{v1}")
@Produces({ MediaType.APPLICATION_JSON })
@Api(value = "customer/{v1}", description = "Rest Service for Customer info API")
public class CustomerInfoService {

    Log LOG = LogFactory.getLog(CustomerInfoService.class);

    @GET
    @Path("/profile")
    @ApiOperation(value = "getProfile", notes = "getProfile", response = Response.class)
    public Response getProfile(@ApiParam(value = "msisdn", required = false) @QueryParam("msisdn") String msisdn,
	    @ApiParam(value = "imsi", required = false) @QueryParam("imsi") String imsi,
	    @ApiParam(value = "mcc", required = false) @QueryParam("mcc") String mcc,
	    @ApiParam(value = "mnc", required = false) @QueryParam("mnc") String mnc,
	    @Context HttpServletRequest request) {
	LOG.debug("/profile invoked");

	GetProfileRequestWrapper requestDTO = new GetProfileRequestWrapper();
	requestDTO.setRequestType(RequestType.CUSTOMERINFO);
	requestDTO.setHttpRequest(request);
	requestDTO.setMsisdn(msisdn);
	requestDTO.setImsi(imsi);
	requestDTO.setMcc(mcc);
	requestDTO.setMnc(mnc);

	RequestHandleable handler = RequestBuilderFactory.getInstance(requestDTO);
	Returnable returnable = null;

	try {
	    returnable = handler.execute(requestDTO);
	    Response response = Response.status(returnable.getHttpStatus()).entity(returnable.getResponse()).build();
	    LOG.debug("GET PROFILE SERVICE RESPONSE : " + response);
	    return response;
	} catch (Exception ex) {
	    LOG.error("###CUSTOMERINFO### Error in getprofile service", ex);
	    return Response.status(Response.Status.BAD_REQUEST).entity(
		    SandboxErrorType.SERVICE_ERROR.getCode() + " " + SandboxErrorType.SERVICE_ERROR.getMessage())
		    .build();
	}

    }

}