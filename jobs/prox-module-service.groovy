pipelineJob('prox-module-service') {
    definition {
        cpsScm {
            scriptPath 'src/main/jenkins/Jenkinsfile'
            scm {
                git {
                    remote {
                        github('innovation-hub-bergisches-rheinland/prox-module-service')
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
