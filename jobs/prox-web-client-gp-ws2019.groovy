pipelineJob('prox-web-client-gp-ws2019') {
    definition {
        cpsScm {
            scriptPath 'src/jenkins/Jenkinsfile'
            scm {
                git {
                    remote {
                        github('Archi-Lab/prox-web-client')
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
