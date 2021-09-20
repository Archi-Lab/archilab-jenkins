folder('prox-security')

pipelineJob('prox-security/prox-security-releases') {
    definition {
        cpsScm {
            scm {
                git {
                    browser {
                        githubWeb {
                            repoUrl('https://github.com/innovation-hub-bergisches-rheinland/prox-security')
                        }
                    }
                    remote {
                        credentials('archilab-github-jenkins-token-username-password')
                        url('https://github.com/innovation-hub-bergisches-rheinland/prox-security')
                        refspec('+refs/tags/*:refs/remotes/origin/tags/*')
                    }
                    branches('*/tags/*')
                }
            }
            scriptPath('src/main/jenkins/Jenkinsfile')
        }
    }
    properties {
        githubProjectUrl('https://github.com/innovation-hub-bergisches-rheinland/prox-security')
        githubProjectProperty {
            projectUrlStr('https://github.com/innovation-hub-bergisches-rheinland/prox-security')
        }
        pipelineTriggers {
            triggers {
                githubPush()
            }
        }
    }
}

pipelineJob('prox-security/prox-security-snapshots') {
    definition {
        cpsScm {
            scm {
                git {
                    browser {
                        githubWeb {
                            repoUrl('https://github.com/innovation-hub-bergisches-rheinland/prox-security')
                        }
                    }
                    remote {
                        credentials('archilab-github-jenkins-token-username-password')
                        url('https://github.com/innovation-hub-bergisches-rheinland/prox-security')
                        refspec('+refs/heads/main:refs/remotes/origin/main')
                    }
                    branches('*/main')
                }
            }
            scriptPath('src/main/jenkins/Jenkinsfile')
        }
    }
    properties {
        githubProjectUrl('https://github.com/innovation-hub-bergisches-rheinland/prox-security')
        githubProjectProperty {
            projectUrlStr('https://github.com/innovation-hub-bergisches-rheinland/prox-security')
        }
        pipelineTriggers {
            triggers {
                githubPush()
            }
        }
    }
}