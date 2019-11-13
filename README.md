# ArchiLab Jenkins

This repository contains scripts to setup [Jenkins](https://jenkins.io/).

## Handling secrets

Since the configuration of Jenkins requires sensitive information like credentials and certificates JCasc allows for the usage of [Hashicorp Vault](https://www.vaultproject.io/) to retrieve those. The only sensitive information that is required for JCasc to pull the other secrets out of Vault have to be defined in a file `secrets/jcasc_vault`:

```text
CASC_VAULT_APPROLE=<ROLE_ID>
CASC_VAULT_APPROLE_SECRET=<SECRET_ID>
CASC_VAULT_PATHS=secret/archilab/jenkins
CASC_VAULT_URL=https://vault.archi-lab.io
```

All secrets defined at the specified Vault path are then accessible by JCasc and can be referenced like regular environment variables.

## Create jobs

- Create a pipeline file in the `jobs` folder
- Add a job with a reference to the new pipeline file in the file `casc/jobs.yml`
- Execute the `run.sh` script on the archilab-build server

## Advice for pipeline files

In order to push the built Docker images via the Maven plugin it requires credentials. Those are accessible as environment variables via `withCredentials()` inside a pipeline script.

```groovy
node {
   stage("..") {
      withCredentials([usernamePassword(credentialsId: 'archilab-nexus-jenkins',
                    usernameVariable: 'NEXUS_USERNAME', passwordVariable: 'NEXUS_PASSWORD')]) {
                sh "mvn -B -s settings.xml \
                    -Ddockerfile.username=\"$NEXUS_USERNAME\" \
                    -Ddockerfile.password=\"$NEXUS_PASSWORD\" \
                    -Dchangelist=${changelist} \
                    clean deploy"
            }
   }
}
```

**Note:** On errors while installing Jenkins plugins check the line endings of `plugins.txt`. [1]

---

### References

[1] https://github.com/jenkinsci/docker/issues/516
