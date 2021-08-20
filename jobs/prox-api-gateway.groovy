multibranchPipelineJob('prox-api-gateway') {
    branchSources {
        branchSources {
            branchSource {
                source {
                    github {
                        apiUri('https://api.github.com')
                        configuredByUrl(true)
                        credentialsId('archilab-github-jenkins-token-username-password')
                        repoOwner('innovation-hub-bergisches-rheinland')
                        repository('prox-api-gateway')
                        repositoryUrl('https://github.com/innovation-hub-bergisches-rheinland/prox-api-gateway')
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