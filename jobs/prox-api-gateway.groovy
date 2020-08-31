pipelineJob('prox-api-gateway') {
    definition {
        cpsScm {
            scriptPath 'src/main/jenkins/Jenkinsfile'
            scm {
                git {
                    remote {
                        github('innovation-hub-bergisches-rheinland/prox-api-gateway')
                        credentials('archilab-github-jenkins')
                    }
                    branches('master')
                }
            }
            lightweight(true)
        }
    }
    triggers {
        githubPush()
    }
}
