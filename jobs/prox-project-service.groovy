multibranchPipelineJob('prox-project-service') {
    branchSources {
        branchSources {
            branchSource {
                source {
                    github {
                        apiUri('https://api.github.com')
                        configuredByUrl(true)
                        credentialsId('archilab-github-jenkins-token-username-password')
                        repoOwner('innovation-hub-bergisches-rheinland')
                        repository('prox-project-service')
                        repositoryUrl('https://github.com/innovation-hub-bergisches-rheinland/prox-project-service')
                        traits {
                            gitHubBranchDiscovery {
                                strategyId(1)
                            }
                            headWildcardFilter {
                                includes('dev master')
                                excludes('')
                            }
                        }
                    }
                }
            }
        }
    }
    factory {
        workflowBranchProjectFactory {
            scriptPath('src/main/jenkins/Jenkinsfile')
        }
    }
}