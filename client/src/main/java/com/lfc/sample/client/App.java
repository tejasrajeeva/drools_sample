package com.lfc.sample.client;

import java.util.ArrayList;
import java.util.List;

import org.kie.api.KieServices;
import org.kie.api.command.BatchExecutionCommand;
import org.kie.api.command.Command;
import org.kie.api.command.KieCommands;
import org.kie.api.runtime.ExecutionResults;
import org.kie.server.api.marshalling.MarshallingFormat;
import org.kie.server.api.model.ServiceResponse;
import org.kie.server.client.KieServicesClient;
import org.kie.server.client.KieServicesConfiguration;
import org.kie.server.client.KieServicesFactory;
import org.kie.server.client.RuleServicesClient;

import com.lfc.sample.model.application.Application;
import com.lfc.sample.model.result.ResultCreditApproval;


public class App 
{
	private static final String URL = "http://172.17.0.3:8080/kie-server/services/rest/server";
	private static final String USER = "admin";
	private static final String PASSWORD ="admin";
    private static final String CONTAINER_ID = "LFC_CREDIT_POLICY1_1.0.0-SNAPSHOT";
    private static final String APPLICATION_FACT_ID = "application1";
    private static final String RESULT_FACT_ID = "resultBean";
	
    public static void main( String[] args )
    {
    	//INIT the kie-services and client config
    	RuleServicesClient ruleClient = initKieServiceClient();
        
        //Built the kie-commands to be executed
        BatchExecutionCommand executionCommand = buildCommands();
        
        //Execute the commands and verify the results
        ServiceResponse<ExecutionResults> results = ruleClient.executeCommandsWithResults(CONTAINER_ID, executionCommand);
        ExecutionResults resultData = results.getResult();
        ResultCreditApproval resultBean = (ResultCreditApproval) resultData.getValue("resultBean");
        System.out.println("ResultCreditApproval [description=" + resultBean.getDescription() + ", approval=" + resultBean.getApproval() + "]");
    }

	private static BatchExecutionCommand buildCommands() {
		KieCommands commandsFactory = KieServices.Factory.get().getCommands(); 
        List<Command<?>> commands = new ArrayList<Command<?>>();
        commands.add(commandsFactory.newInsert(getApplicationSample() , APPLICATION_FACT_ID));
        commands.add(commandsFactory.newInsert(new ResultCreditApproval(), RESULT_FACT_ID));
        commands.add(commandsFactory.newFireAllRules());
        BatchExecutionCommand executionCommand = commandsFactory.newBatchExecution(commands);
		return executionCommand;
	}

	private static RuleServicesClient initKieServiceClient() {
		KieServicesConfiguration conf = KieServicesFactory.newRestConfiguration(URL, USER, PASSWORD);
        conf.setMarshallingFormat(MarshallingFormat.JSON);
        KieServicesClient client = KieServicesFactory.newKieServicesClient(conf);
        RuleServicesClient ruleClient = client.getServicesClient(RuleServicesClient.class);
		return ruleClient;
	}

	private static Application getApplicationSample() {
		Application sample = new Application();
		sample.setAge(10);
		sample.setName("SampleCLient");
		return sample;
	}
}
