pipelineJob('prox-user-profile-service-ip-ws2019') {
    definition {
        cpsScm {
            scriptPath 'src/main/jenkins/Jenkinsfile'
            scm {
                git {
                    remote {
                        github('Archi-Lab/prox-user-profile-service')
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
