pipelineJob('prox-web-client') {
    definition {
        cpsScm {
            scriptPath 'Jenkinsfile'
            scm {
                git {
                    remote {
                        github('innovation-hub-bergisches-rheinland/prox-web-client')
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
