pipelineJob('prox-service-discovery-ip-ws2019') {
    definition {
        cpsScm {
            scriptPath 'src/main/jenkins/Jenkinsfile'
            scm {
                git {
                    remote {
                        github('Archi-Lab/prox-service-discovery')
                        credentials('archilab-github-jenkins')
                    }
                    branches('ip-ws2019')
                }
            }
            lightweight(true)
        }
    }
    triggers {
        githubPush()
    }
}
