pipelineJob('fae-documentation-server') {
    definition {
        cpsScm {
            scriptPath 'Jenkinsfile'
            scm {
                git {
                    remote {
                        github('Archi-Lab-FAE/fae-documentation-server')
                        credentials('archilab-github-jenkins')
                    }
                    remote {
                        github('Archi-Lab-FAE/fae-team-1-documentation')
                        credentials('archilab-github-jenkins')
                    }
                    remote {
                        github('Archi-Lab-FAE/fae-team-2-documentation')
                        credentials('archilab-github-jenkins')
                    }
                    remote {
                        github('Archi-Lab-FAE/fae-team-3-documentation')
                        credentials('archilab-github-jenkins')
                    }
                    remote {
                        github('Archi-Lab-FAE/fae-team-4-documentation')
                        credentials('archilab-github-jenkins')
                    }
                    remote {
                        github('Archi-Lab-FAE/fae-global-documentation')
                        credentials('archilab-github-jenkins')
                    }
                    branches('master')
                }
            }
            lightweight(false)
        }
    }
    triggers {
        githubPush()
    }
}
