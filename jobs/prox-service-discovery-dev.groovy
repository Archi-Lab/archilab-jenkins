pipelineJob('prox-service-discovery-dev') {
    definition {
        cpsScm {
            scriptPath 'src/main/jenkins/Jenkinsfile'
            scm {
                git {
                    remote {
                        github('Archi-Lab/prox-service-discovery')
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
