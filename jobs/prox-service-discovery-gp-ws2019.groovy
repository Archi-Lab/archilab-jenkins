pipelineJob('prox-service-discovery-gp-ws2019') {
    definition {
        cpsScm {
            scriptPath 'src/main/jenkins/Jenkinsfile'
            scm {
                git {
                    remote {
                        github('Archi-Lab/prox-service-discovery')
                        credentials('archilab-github-jenkins')
                    }
                    branches('gp-ws2019')
                }
            }
            lightweight(true)
        }
    }
    triggers {
        githubPush()
    }
}
