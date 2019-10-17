pipelineJob('prox-web-client-pp-ss2019') {
    definition {
        cpsScm {
            scriptPath 'src/jenkins/Jenkinsfile'
            scm {
                git {
                    remote {
                        github('Archi-Lab/prox-web-client')
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
