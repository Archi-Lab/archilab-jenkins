pipelineJob('prox-api-gateway-pp-ss2019') {
    definition {
        cpsScm {
            scriptPath 'src/main/jenkins/Jenkinsfile'
            scm {
                git {
                    remote {
                        github('Archi-Lab/prox-api-gateway')
                        credentials('archilab-github-jenkins')
                    }
                    branches('pp-ss2019')
                }
            }
            lightweight(true)
        }
    }
    triggers {
        githubPush()
    }
}
