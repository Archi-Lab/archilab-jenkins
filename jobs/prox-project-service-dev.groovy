pipelineJob('prox-project-service-dev') {
    definition {
        cpsScm {
            scriptPath 'src/main/jenkins/Jenkinsfile'
            scm {
                git {
                    remote {
                        github('innovation-hub-bergisches-rheinland/prox-project-service')
                        credentials('archilab-github-jenkins')
                    }
                    branches('dev')
                }
            }
            lightweight(true)
        }
    }
    triggers {
        githubPush()
    }
}
