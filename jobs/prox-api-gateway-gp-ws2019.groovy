pipelineJob('prox-api-gateway-gp-ws2019') {
    definition {
        cpsScm {
            scriptPath 'src/main/jenkins/Jenkinsfile'
            scm {
                git {
                    remote {
                        github('Archi-Lab/prox-api-gateway')
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
