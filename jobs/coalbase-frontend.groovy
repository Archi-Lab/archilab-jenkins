pipelineJob('coalbase-frontend') {
    definition {
        cpsScm {
            scriptPath 'Jenkinsfile'
            scm {
                git {
                    remote {
                        github('Archi-Lab/coalbase-frontend')
                        credentials('archilab-github-jenkins')
                    }
                    branches('master')
                }
            }
            lightweight(true)
        }
    }
    triggers {
        githubPush()
    }
}
