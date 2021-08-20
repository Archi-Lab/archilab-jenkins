multibranchPipelineJob('prox-job-service') {
    branchSources {
        branchSources {
            branchSource {
                source {
                    github {
                        apiUri('https://api.github.com')
                        configuredByUrl(true)
                        credentialsId('archilab-github-jenkins-token-username-password')
                        repoOwner('innovation-hub-bergisches-rheinland')
                        repository('prox-job-service')
                        repositoryUrl('https://github.com/innovation-hub-bergisches-rheinland/prox-job-service')
                        traits {
                            gitHubBranchDiscovery {
                                strategyId(1)
                            }
                            headWildcardFilter {
                                includes('dev main')
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