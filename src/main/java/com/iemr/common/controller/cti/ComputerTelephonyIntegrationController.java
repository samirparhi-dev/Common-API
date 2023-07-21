/*
* AMRIT – Accessible Medical Records via Integrated Technology 
* Integrated EHR (Electronic Health Records) Solution 
*
* Copyright (C) "Piramal Swasthya Management and Research Institute" 
*
* This file is part of AMRIT.
*
* This program is free software: you can redistribute it and/or modify
* it under the terms of the GNU General Public License as published by
* the Free Software Foundation, either version 3 of the License, or
* (at your option) any later version.
*
* This program is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
* GNU General Public License for more details.
*
* You should have received a copy of the GNU General Public License
* along with this program.  If not, see https://www.gnu.org/licenses/.
*/
package com.iemr.common.controller.cti;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.MediaType;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iemr.common.data.cti.CustomerLanguage;
import com.iemr.common.service.cti.CTIService;
import com.iemr.common.utils.mapper.InputMapper;
import com.iemr.common.utils.response.OutputResponse;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping(value = "/cti")
public class ComputerTelephonyIntegrationController {
	InputMapper inputMapper = new InputMapper();
	final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	CTIService ctiService;

	@Autowired
	public void setCtiService(CTIService ctiService) {
		this.ctiService = ctiService;
	}

	@CrossOrigin()
	@ApiOperation(value = "Get campaign skills")
	@RequestMapping(value = "/getCampaignSkills", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON, headers = "Authorization")
	public String getCampaignSkills(
			@ApiParam("{\"campaign_name\":\"String: Name of the campaign\"}") @RequestBody String request,
			HttpServletRequest serverRequest) {
		OutputResponse response = new OutputResponse();
		logger.info("getCampaignSkills received a request " + request);
		try {
			String remoteAddress = serverRequest.getHeader("X-FORWARDED-FOR");
			if (remoteAddress == null || remoteAddress.trim().length() == 0) {
				remoteAddress = serverRequest.getRemoteAddr();
			}
			response = ctiService.getCampaignSkills(request, remoteAddress);
		} catch (Exception e) {
			logger.error("getCampaignSkills failed with error " + e.getMessage(), e);
			response.setError(e);
		}
		logger.info("getCampaignSkills sending response " + response);
		return response.toString();
	}

	@CrossOrigin()
	@ApiOperation(value = "Get agent state")
	@RequestMapping(value = "/getAgentState", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON, headers = "Authorization")
	public String getAgentState(@ApiParam("{\"agent_id\":\"String: agent id\"}") @RequestBody String request,
			HttpServletRequest serverRequest) {
		OutputResponse response = new OutputResponse();
		logger.info("getAgentState received a request " + request);
		try {
			String remoteAddress = serverRequest.getHeader("X-FORWARDED-FOR");
			if (remoteAddress == null || remoteAddress.trim().length() == 0) {
				remoteAddress = serverRequest.getRemoteAddr();
			}
			response = ctiService.getAgentState(request, remoteAddress);
		} catch (Exception e) {
			logger.error("getAgentState failed with error " + e.getMessage(), e);
			response.setError(e);
		}
		logger.info("getAgentState sending response " + response);
		return response.toString();
	}

	@CrossOrigin()
	@ApiOperation(value = "Get agent call stats")
	@RequestMapping(value = "/getAgentCallStats", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON, headers = "Authorization")
	public String getAgentCallStats(@ApiParam("{\"agent_id\":\"String: agent id\"}") @RequestBody String request,
			HttpServletRequest serverRequest) {
		OutputResponse response = new OutputResponse();
		logger.info("getAgentCallStats received a request " + request);
		try {
			String remoteAddress = serverRequest.getHeader("X-FORWARDED-FOR");
			if (remoteAddress == null || remoteAddress.trim().length() == 0) {
				remoteAddress = serverRequest.getRemoteAddr();
			}
			response = ctiService.getAgentCallStats(request, remoteAddress);
		} catch (Exception e) {
			logger.error("getAgentCallStats failed with error " + e.getMessage(), e);
			response.setError(e);
		}
		logger.info("getAgentCallStats sending response " + response);
		return response.toString();
	}

	@CrossOrigin()
	@ApiOperation(value = "Get campaign names")
	@RequestMapping(value = "/getCampaignNames", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON, headers = "Authorization")
	public String getCampaignNames(
			@ApiParam("{\"serviceName\":\"String: service name\", "
					+ "\"type\":\"String - inbound, outbound\"}") @RequestBody String request,
			HttpServletRequest serverRequest) {
		OutputResponse response = new OutputResponse();
		logger.info("getCampaignNames received a request " + request);
		try {
			String remoteAddress = serverRequest.getHeader("X-FORWARDED-FOR");
			if (remoteAddress == null || remoteAddress.trim().length() == 0) {
				remoteAddress = serverRequest.getRemoteAddr();
			}
			response = ctiService.getCampaignNames(request, remoteAddress);
		} catch (Exception e) {
			logger.error("getCampaignNames failed with error " + e.getMessage(), e);
			response.setError(e);
		}
		logger.info("getCampaignNames sending response " + response);
		return response.toString();
	}

	@CrossOrigin()
	@ApiOperation(value = "Get login key")
	@RequestMapping(value = "/getLoginKey", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON, headers = "Authorization")
	public String getLoginKey(
			@ApiParam("{\"username\":\"String: user name\", \"password\":\"String: password\"}") @RequestBody String request,
			HttpServletRequest serverRequest) {
		OutputResponse response = new OutputResponse();
		logger.info("getLoginKey received a request " + request);
		try {
			String remoteAddress = serverRequest.getHeader("X-FORWARDED-FOR");
			if (remoteAddress == null || remoteAddress.trim().length() == 0) {
				remoteAddress = serverRequest.getRemoteAddr();
			}
			response = ctiService.getLoginKey(request, remoteAddress);
		} catch (Exception e) {
			logger.error("getLoginKey failed with error " + e.getMessage(), e);
			response.setError(e);
		}
		logger.info("getLoginKey sending response " + response);
		return response.toString();
	}

	@CrossOrigin()
	@ApiOperation(value = "Do agent logout")
	@RequestMapping(value = "/doAgentLogout", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON)
	public String doAgentLogout(@ApiParam("{\"agent_id\":\"String: agent id\"}") @RequestBody String request,
			HttpServletRequest serverRequest) {
		OutputResponse response = new OutputResponse();
		logger.info("agentLogout received a request " + request);
		try {
			String remoteAddress = serverRequest.getHeader("X-FORWARDED-FOR");
			if (remoteAddress == null || remoteAddress.trim().length() == 0) {
				remoteAddress = serverRequest.getRemoteAddr();
			}
			response = ctiService.agentLogout(request, remoteAddress);
		} catch (Exception e) {
			logger.error("agentLogout failed with error " + e.getMessage(), e);
			response.setError(e);
		}
		logger.info("agentLogout sending response " + response);
		return response.toString();
	}

	@CrossOrigin()
	@ApiOperation(value = "Get online agents")
	@RequestMapping(value = "/getOnlineAgents", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON, headers = "Authorization")
	public String getOnlineAgents(@ApiParam("{\"agent_id\":\"String: agent id\"}") @RequestBody String request,
			HttpServletRequest serverRequest) {
		OutputResponse response = new OutputResponse();
		logger.info("getOnlineAgents received a request " + request);
		try {
			String ipPattern = "^([0-9]{1,3}\\.){3}[0-9]{1,3}$";
			String remoteAddress = serverRequest.getHeader("X-FORWARDED-FOR");
			if (Pattern.matches(ipPattern, serverRequest.getHeader("X-FORWARDED-FOR"))){

			if (remoteAddress == null || remoteAddress.trim().length() == 0) {
				remoteAddress = serverRequest.getRemoteAddr();
			}
		}
			response = ctiService.getOnlineAgents(request, remoteAddress);
		} catch (Exception e) {
			logger.error("getOnlineAgents failed with error " + e.getMessage(), e);
			response.setError(e);
		}
		logger.info("getOnlineAgents sending response " + response);
		return response.toString();
	}

	@CrossOrigin()
	@ApiOperation(value = "Call beneficiary")
	@RequestMapping(value = "/callBeneficiary", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON, headers = "Authorization")
	public String callBeneficiary(
			@ApiParam("{\"agent_id\":\"String: agent_id\", \"phone_num\":\"String - phone number\"}") @RequestBody String request,
			HttpServletRequest serverRequest) {
		OutputResponse response = new OutputResponse();
		logger.info("callBeneficiary received a request " + request);
		try {
			String remoteAddress = serverRequest.getHeader("X-FORWARDED-FOR");
			if (remoteAddress == null || remoteAddress.trim().length() == 0) {
				remoteAddress = serverRequest.getRemoteAddr();
			}
			response = ctiService.callBeneficiary(request, remoteAddress);
		} catch (Exception e) {
			logger.error("callBeneficiary failed with error " + e.getMessage(), e);
			response.setError(e);
		}
		logger.info("callBeneficiary sending response " + response);
		return response.toString();
	}

	@CrossOrigin()
	@ApiOperation(value = "Add update user data")
	@RequestMapping(value = "/addUpdateUserData", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON, headers = "Authorization")
	public String addUpdateUserData(
			@ApiParam("{\"username\":\"String: username\", \"password\":\"String - password\", "
					+ "\"firstname\":\"String - firstname\", \"lastname\":\"String - lastname\", "
					+ "\"phone\":\"String - phone\", \"email\":\"String - email\", \"role\":\"String - role\""
					+ ", \"designation\":\"String - designation\"}") @RequestBody String request,
			HttpServletRequest serverRequest) {
		OutputResponse response = new OutputResponse();
		logger.info("updateUserData received a request " + request);
		try {
			String remoteAddress = serverRequest.getHeader("X-FORWARDED-FOR");
			if (remoteAddress == null || remoteAddress.trim().length() == 0) {
				remoteAddress = serverRequest.getRemoteAddr();
			}
			response = ctiService.addUpdateUserData(request, remoteAddress);
		} catch (Exception e) {
			logger.error("updateUserData failed with error " + e.getMessage(), e);
			response.setError(e);
		}
		logger.info("updateUserData sending response " + response);
		return response.toString();
	}

	@CrossOrigin()
	@ApiOperation(value = "Get transfer campaigns")
	@RequestMapping(value = "/getTransferCampaigns", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON, headers = "Authorization")
	public String getTransferCampaigns(@ApiParam("{\"agent_id\":\"String: agentID\"}") @RequestBody String request,
			HttpServletRequest serverRequest) {
		OutputResponse response = new OutputResponse();
		logger.info("getTransferCampaigns received a request " + request);
		try {
			String remoteAddress = serverRequest.getHeader("X-FORWARDED-FOR");
			if (remoteAddress == null || remoteAddress.trim().length() == 0) {
				remoteAddress = serverRequest.getRemoteAddr();
			}
			response = ctiService.getTransferCampaigns(request, remoteAddress);
		} catch (Exception e) {
			logger.error("getTransferCampaigns failed with error " + e.getMessage(), e);
			response.setError(e);
		}
		logger.info("getTransferCampaigns sending response " + response);
		return response.toString();
	}

	@CrossOrigin()
	@ApiOperation(value = "Get campaign roles")
	@RequestMapping(value = "/getCampaignRoles", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON, headers = "Authorization")
	public String getCampaignRoles(@ApiParam("{\"campaign\":\"String: campaign name\"}") @RequestBody String request,
			HttpServletRequest serverRequest) {
		OutputResponse response = new OutputResponse();
		logger.info("getCampaignRoles received a request " + request);
		try {
			String remoteAddress = serverRequest.getHeader("X-FORWARDED-FOR");
			if (remoteAddress == null || remoteAddress.trim().length() == 0) {
				remoteAddress = serverRequest.getRemoteAddr();
			}
			response = ctiService.getCampaignRoles(request, remoteAddress);
		} catch (Exception e) {
			logger.error("getCampaignRoles failed with error " + e.getMessage(), e);
			response.setError(e);
		}
		logger.info("getCampaignRoles sending response " + response);
		return response.toString();
	}

	@CrossOrigin()
	@ApiOperation(value = "Set call disposition")
	@RequestMapping(value = "/setCallDisposition", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON, headers = "Authorization")
	public String setCallDisposition(
			@ApiParam("{\"agent_id\":\"String: agentID\", \"cust_disp\":\"String - call subtype\", "
					+ "\"category\":\"String: call type\", \"session_id\":\"String: unique call id from c-zentrix\"}") @RequestBody String request,
			HttpServletRequest serverRequest) {
		OutputResponse response = new OutputResponse();
		logger.info("setCallDisposition received a request " + request);
		try {
			String remoteAddress = serverRequest.getHeader("X-FORWARDED-FOR");
			if (remoteAddress == null || remoteAddress.trim().length() == 0) {
				remoteAddress = serverRequest.getRemoteAddr();
			}
			response = ctiService.setCallDisposition(request, remoteAddress);
		} catch (Exception e) {
			logger.error("setCallDisposition failed with error " + e.getMessage(), e);
			response.setError(e);
		}
		logger.info("setCallDisposition sending response " + response);
		return response.toString();
	}

	@CrossOrigin()
	@ApiOperation(value = "Create voice file")
	@RequestMapping(value = "/createVoiceFile", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON, headers = "Authorization")
	public String createVoiceFile(
			@ApiParam("{\"agent_id\":\"String: agentID\", "
					+ "\"session_id\":\"String: unique call id from c-zentrix\"}") @RequestBody String request,
			HttpServletRequest serverRequest) {
		OutputResponse response = new OutputResponse();
		logger.info("createVoiceFile received a request " + request);
		try {
			String remoteAddress = serverRequest.getHeader("X-FORWARDED-FOR");
			if (remoteAddress == null || remoteAddress.trim().length() == 0) {
				remoteAddress = serverRequest.getRemoteAddr();
			}
			response = ctiService.createVoiceFile(request, remoteAddress);
		} catch (Exception e) {
			logger.error("createVoiceFile failed with error " + e.getMessage(), e);
			response.setError(e);
		}
		logger.info("createVoiceFile sending response " + response);
		return response.toString();
	}

	@CrossOrigin()
	@ApiOperation(value = "Get voice file")
	@RequestMapping(value = "/getVoiceFile", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON, headers = "Authorization")
	public String getVoiceFile(
			@ApiParam("{\"agent_id\":\"String: agentID\", "
					+ "\"session_id\":\"String: unique call id from c-zentrix\"}") @RequestBody String request,
			HttpServletRequest serverRequest) {
		OutputResponse response = new OutputResponse();
		logger.info("getVoiceFile received a request " + request);
		try {
			String remoteAddress = serverRequest.getHeader("X-FORWARDED-FOR");
			if (remoteAddress == null || remoteAddress.trim().length() == 0) {
				remoteAddress = serverRequest.getRemoteAddr();
			}
			response = ctiService.getVoiceFile(request, remoteAddress);
		} catch (Exception e) {
			logger.error("getVoiceFile failed with error " + e.getMessage(), e);
			response.setError(e);
		}
		logger.info("getVoiceFile sending response " + response);
		return response.toString();
	}

	@CrossOrigin()
	@ApiOperation(value = "Disconnect call")
	@RequestMapping(value = "/disconnectCall", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON, headers = "Authorization")
	public String disconnectCall(@ApiParam("{\"agent_id\":\"String: agentID\"}") @RequestBody String request,
			HttpServletRequest serverRequest) {
		OutputResponse response = new OutputResponse();
		logger.info("disconnectCall received a request " + request);
		try {
			String remoteAddress = serverRequest.getHeader("X-FORWARDED-FOR");
			if (remoteAddress == null || remoteAddress.trim().length() == 0) {
				remoteAddress = serverRequest.getRemoteAddr();
			}
			response = ctiService.disconnectCall(request, remoteAddress);
		} catch (Exception e) {
			logger.error("disconnectCall failed with error " + e.getMessage(), e);
			response.setError(e);
		}
		logger.info("disconnectCall sending response " + response);
		return response.toString();
	}

	@CrossOrigin()
	@ApiOperation(value = "Switch to inbound")
	@RequestMapping(value = "/switchToInbound", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON, headers = "Authorization")
	public String switchToInbound(@ApiParam("{\"agent_id\":\"String: agentID\"}") @RequestBody String request,
			HttpServletRequest serverRequest) {
		OutputResponse response = new OutputResponse();
		logger.info("disconnectCall received a request " + request);
		try {
			String remoteAddress = serverRequest.getHeader("X-FORWARDED-FOR");
			if (remoteAddress == null || remoteAddress.trim().length() == 0) {
				remoteAddress = serverRequest.getRemoteAddr();
			}
			response = ctiService.switchToInbound(request, remoteAddress);
		} catch (Exception e) {
			logger.error("disconnectCall failed with error " + e.getMessage(), e);
			response.setError(e);
		}
		logger.info("disconnectCall sending response " + response);
		return response.toString();
	}

	@CrossOrigin()
	@ApiOperation(value = "Switch to outbound")
	@RequestMapping(value = "/switchToOutbound", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON, headers = "Authorization")
	public String switchToOutbound(@ApiParam("{\"agent_id\":\"String: agentID\"}") @RequestBody String request,
			HttpServletRequest serverRequest) {
		OutputResponse response = new OutputResponse();
		logger.info("disconnectCall received a request " + request);
		try {
			String remoteAddress = serverRequest.getHeader("X-FORWARDED-FOR");
			if (remoteAddress == null || remoteAddress.trim().length() == 0) {
				remoteAddress = serverRequest.getRemoteAddr();
			}
			response = ctiService.switchToOutbound(request, remoteAddress);
		} catch (Exception e) {
			logger.error("disconnectCall failed with error " + e.getMessage(), e);
			response.setError(e);
		}
		logger.info("disconnectCall sending response " + response);
		return response.toString();
	}

	@CrossOrigin()
	@ApiOperation(value = "Get agent IP address")
	@RequestMapping(value = "/getAgentIPAddress", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON, headers = "Authorization")
	public String getAgentIPAddress(@ApiParam("{\"agent_id\":\"String: agentID\"}") @RequestBody String request,
			HttpServletRequest serverRequest) {
		OutputResponse response = new OutputResponse();
		logger.info("getAgentIPAddress received a request " + request);
		try {
			String remoteAddress = serverRequest.getHeader("X-FORWARDED-FOR");
			if (remoteAddress == null || remoteAddress.trim().length() == 0) {
				remoteAddress = serverRequest.getRemoteAddr();
			}
			response = ctiService.getAgentIPAddress(request, remoteAddress);
		} catch (Exception e) {
			logger.error("getAgentIPAddress failed with error " + e.getMessage(), e);
			response.setError(e);
		}
		logger.info("getAgentIPAddress sending response " + response);
		return response.toString();
	}

	@CrossOrigin()
	@ApiOperation(value = "Get available agent skills")
	@RequestMapping(value = "/getAvailableAgentSkills", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON, headers = "Authorization")
	public String getAvailableAgentSkills(
			@ApiParam("{\"campaignName\":\"String: campaign name\", "
					+ "\"skill\":\"String: skill name\"}") @RequestBody String request,
			HttpServletRequest serverRequest) {
		OutputResponse response = new OutputResponse();
		logger.info("getAvailableAgentSkills received a request " + request);
		try {
			String remoteAddress = serverRequest.getHeader("X-FORWARDED-FOR");
			if (remoteAddress == null || remoteAddress.trim().length() == 0) {
				remoteAddress = serverRequest.getRemoteAddr();
			}
			response = ctiService.getAvailableAgentSkills(request, remoteAddress);
		} catch (Exception e) {
			logger.error("getAvailableAgentSkills failed with error " + e.getMessage(), e);
			response.setError(e);
		}
		logger.info("getAvailableAgentSkills sending response " + response);
		return response.toString();
	}

	@CrossOrigin()
	@ApiOperation(value = "Transfer call")
	@RequestMapping(value = "/transferCall", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON, headers = "Authorization")
	public String transferCall(@ApiParam("{\"transfer_from\":\"String - agent id who is transferring call\", "
			+ "\"transfer_to\":\"String - agent ID who would be receiving call\", "
			+ "\"transfer_campaign_info\": \"String - name of the campaign to which call will be transferred\", "
			+ "\"skill_transfer_flag\":\"Integer - 0 for no skill or 1 for skill based\", "
			+ "\"skill\":\"String - skill name\",\"benCallID\":\"Integer - callID as in CRM\", \"agentIPAddress\":\"Optional String - agent IP address\","
			+ "\"callTypeID\" : \"Integer\"}. transfer_to will be having higher precedence to all "
			+ "3 remaining inputs") @RequestBody String request, HttpServletRequest serverRequest) {
		OutputResponse response = new OutputResponse();
		logger.info("transferCall received a request " + request);
		try {
			String remoteAddress = serverRequest.getHeader("X-FORWARDED-FOR");
			if (remoteAddress == null || remoteAddress.trim().length() == 0) {
				remoteAddress = serverRequest.getRemoteAddr();
			}
			response = ctiService.transferCall(request, remoteAddress);
		} catch (Exception e) {
			logger.error("transferCall failed with error " + e.getMessage(), e);
			response.setError(e);
		}
		logger.info("transferCall sending response " + response);
		return response.toString();
	}

	@CrossOrigin()
	@ApiOperation(value = "Customer preferred language")
	@RequestMapping(value = "/customerPreferredLanguage", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON, headers = "Authorization")
	public String customerPreferredLanguage(
			@ApiParam("{\"cust_ph_no\":\"phone number of customer\", "
					+ "\"campaign_name\":\"campaign name for provider from provider service mapping\", "
					+ "\"language\": \"String - language name selected by user\", "
					+ "\"action\":\"String - select or update\"}") @RequestBody String request,
			HttpServletRequest serverRequest) {
		OutputResponse response = new OutputResponse();
		logger.info("customerPreferredLanguage received a request " + request);
		try {
			String remoteAddress = serverRequest.getHeader("X-FORWARDED-FOR");
			if (remoteAddress == null || remoteAddress.trim().length() == 0) {
				remoteAddress = serverRequest.getRemoteAddr();
			}
			CustomerLanguage custLang = InputMapper.gson().fromJson(request, CustomerLanguage.class);
			response = ctiService.customerPreferredLanguage(custLang, remoteAddress);
		} catch (Exception e) {
			logger.error("customerPreferredLanguage failed with error " + e.getMessage(), e);
			response.setError(e);
		}
		logger.info("customerPreferredLanguage sending response " + response);
		return response.toString();
	}

	@CrossOrigin()
	@ApiOperation(value = "Get IVRS path details")
	@RequestMapping(value = "/getIVRSPathDetails", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON, headers = "Authorization")
	public String getIVRSPathDetails(@ApiParam("{\"agent_id\":\"Integer\"}") @RequestBody String request,
			HttpServletRequest serverRequest) {
		OutputResponse response = new OutputResponse();
		logger.info("getIVRSPathDetails received a request " + request);
		try {

			String remoteAddress = serverRequest.getHeader("X-FORWARDED-FOR");
			if (remoteAddress == null || remoteAddress.trim().length() == 0) {
				remoteAddress = serverRequest.getRemoteAddr();
			}
			response = ctiService.getIVRSPathDetails(request, remoteAddress);
		} catch (Exception e) {
			logger.error("getIVRSPathDetails failed with error " + e.getMessage(), e);
			response.setError(e);
		}
		logger.info("getIVRSPathDetails sending response " + response);
		return response.toString();
	}
}
