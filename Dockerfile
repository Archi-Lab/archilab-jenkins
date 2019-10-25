FROM jenkins/jenkins:lts-alpine

USER root
RUN apk -U add docker

USER jenkins
COPY plugins.txt /usr/share/jenkins/ref/plugins.txt
RUN /usr/local/bin/install-plugins.sh < /usr/share/jenkins/ref/plugins.txt
COPY casc /var/jenkins_home/casc
COPY jobs /var/jenkins_home/jobdsl
COPY init /var/jenkins_home/init.groovy.d
COPY config/jenkins/scriptApproval.xml /var/jenkins_home/scriptApproval.xml
# Skip initial setup
ENV JAVA_OPTS -Djenkins.install.runSetupWizard=false
