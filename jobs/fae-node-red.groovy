pipelineJob('fae-node-red') {
    definition {
        cpsScm {
            scriptPath 'Jenkinsfile'
            scm {
                git {
                    remote {
                        github('Archi-Lab-FAE/fae-node-red')
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
