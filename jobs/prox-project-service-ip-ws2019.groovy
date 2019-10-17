pipelineJob('prox-project-service-ip-ws2019') {
    definition {
        cpsScm {
            scriptPath 'src/main/jenkins/Jenkinsfile'
            scm {
                git {
                    remote {
                        github('Archi-Lab/prox-project-service')
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
