pipelineJob('prox-module-service-pp-ss2019') {
    definition {
        cpsScm {
            scriptPath 'src/main/jenkins/Jenkinsfile'
            scm {
                git {
                    remote {
                        github('Archi-Lab/prox-module-service')
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
