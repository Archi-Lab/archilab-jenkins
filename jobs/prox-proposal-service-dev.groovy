pipelineJob('prox-proposal-service-dev') {
    definition {
        cpsScm {
            scriptPath 'src/main/jenkins/Jenkinsfile'
            scm {
                git {
                    remote {
                        github('Archi-Lab/prox-proposal-service')
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
