pipelineJob('prox-api-gateway-ip-ws2019') {
    definition {
        cpsScm {
            scriptPath 'src/main/jenkins/Jenkinsfile'
            scm {
                git {
                    remote {
                        github('Archi-Lab/prox-api-gateway')
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
