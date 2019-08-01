# ArchiLab Jenkins-Infrastruktur
Dieses Repository beinhaltet alles was für die Installation, Einrichtung und den Betrieb des Jenkin-Servers benötigt wird.


## ArchiLab-Image bauen

``` posh
docker build -t archilab-jenkins .
```

**Hinweis:** Wenn es Fehler beim Herunterladen/Installieren der Plugin gibt, dann ggf. in der plugins.txt die Zeilenunbrüche überprüfen. [1]

## ArchiLab-Jenkins starten
``` posh
docker run --name jenkins -u root -p 8080:8080 --env-file env.list -v /var/run/docker.sock:/var/run/docker.sock archilab-jenkins
```

Die `env.list` ist eine Datei, die die benötigten Umgebungsvariablen in der Form `VARNAME=wert` beinhaltet. Welche Umgebungsvariablen benötigt werden, ist in der [env.list](https://github.com/rudolfgrauberger/archilab-jenkins-infrastructure/blob/master/env.list) definiert.

Der Parameter `-u root` gibt an, dass Docker die Befehle mit dem Benutzer `root` ausführen soll. Das ist notwendig, da wir sonst keine Berechtigung haben den Unix-Socket `/var/run/docker.sock` zu öffnen und darüber zu kommunizieren.

Zugriff auf Container
``` posh
docker exec -it jenkins bash
```

## Hinweise für die Projekte
Damit man mit maven über das Docker-Plugin das Docker Image zu unserem Docker-Repository pushen kann, benötigt man Credentials. Das kann man über `withCredentials()` in Umgebungsvariablen bekommen und diese dann ganz einfach im Skript benutzen.

Scripted Pipeline
``` json
node {
   stage("..") {
      withCredentials([usernamePassword(credentialsId: 'archilab-nexus-jenkins', usernameVariable: 'NEXUS_USERNAME', passwordVariable: 'NEXUS_PASSWORD')]) {
         sh "mvn -B -s settings.xml -Ddockerfile.username=\"$NEXUS_USERNAME\" -Ddockerfile.password=\"$NEXUS_PASSWORD\" -Drevision=${revision} clean deploy"
      }
   }
}
```

---
### Quellen

[1] https://github.com/jenkinsci/docker/issues/516
