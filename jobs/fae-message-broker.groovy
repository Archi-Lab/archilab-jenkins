pipelineJob('fae-message-broker') {
    definition {
        cpsScm {
            scriptPath 'Jenkinsfile'
            scm {
                git {
                    remote {
                        github('Archi-Lab-FAE/fae-message-broker')
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
