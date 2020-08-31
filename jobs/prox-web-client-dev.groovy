pipelineJob('prox-web-client-dev') {
    definition {
        cpsScm {
            scriptPath 'Jenkinsfile'
            scm {
                git {
                    remote {
                        github('innovation-hub-bergisches-rheinland/prox-web-client')
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
