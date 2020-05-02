# drools_sample
Sample project for getting workbench up and running

## Start workbench showcase in persistent manner:
docker run -p 8080:8080 -p 8001:8001 -v /home/tejas/lfc/wb_ws/gitrepo:/opt/jboss/wildfly/bin/.niogit:Z  -v /home/tejas/lfc/wb_ws/m2_repo:/opt/jboss/.m2/repository -d --name jbpm-workbench jboss/jbpm-workbench-showcase:latest
ACCESS: http://localhost:8080/business-central/kie-wb.jsp

## To start the kie-server and link to workbench
docker run -p 8180:8080 -d --name kie-server --link jbpm-workbench:kie-wb jboss/kie-server-showcase:lates

## Information on projects
Model project is sample project which should be built and its jar should be uploaded as artifact to Droold workbench.
Client is REST client used to connect to kie-execution-server and fire rules for fact checking.
Workbench backup folder contains the contents of "wb_ws/gitrepo" mentioned in the docker command above.
