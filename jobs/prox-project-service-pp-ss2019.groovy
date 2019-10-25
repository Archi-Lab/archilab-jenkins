pipelineJob('prox-project-service-pp-ss2019') {
    definition {
        cpsScm {
            scriptPath 'src/main/jenkins/Jenkinsfile'
            scm {
                git {
                    remote {
                        github('Archi-Lab/prox-project-service')
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