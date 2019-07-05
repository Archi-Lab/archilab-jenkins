# ArchiLab Jenkins-Infrastruktur
Dieses Repository beinhaltet alles was für die Installation, Einrichtung und den Betrieb des Jenkin-Servers benötigt wird.


ArchiLab-Image bauen

``` posh
docker build -t archilab-jenkins .
```

**Hinweis:** Wenn es Fehler beim Herunterladen/Installieren der Plugin gibt, dann ggf. in der plugins.txt die Zeilenunbrüche überprüfen. [1]

#### Maven
Damit nicht jedes Projekt immer alle maven-Dependencies erneut herunterladen und sich Gedanken um die Zugangsdaten zu unserer Docker-Registry machen muss, stellen wir ein eigenes Volumen zur Verfügung. Das wird dann von den jeweiligen Docker Agents verwendet...

``` bash
docker run --rm  -v ${PWD}/config/maven:/source -v maven-data:/root/.m2 -w /source alpine cp ./settings.xml /root/.m2
```

(vgl. https://github.com/moby/moby/issues/25245#issuecomment-367742567)


ArchiLab-Jenkins starten
``` posh
docker run --name jenkins -u root -p 8080:8080 --env-file env.list -v /var/run/docker.sock:/var/run/docker.sock archilab-jenkins
```

Die `env.list` ist eine Datei, die die benötigten Umgebungsvariablen in der Form `VARNAME=wert` beinhaltet. Welche Umgebungsvariablen benötigt werden, ist in der [env.list](https://github.com/rudolfgrauberger/archilab-jenkins-infrastructure/blob/master/env.list) definiert.

Der Parameter `-u root` gibt an, dass Docker die Befehle mit dem Benutzer `root` ausführen soll. Das ist notwendig, da wir sonst keine Berechtigung haben den Unix-Socket `/var/run/docker.sock` zu öffnen und darüber zu kommunizieren.

Zugriff auf Container
``` posh
docker exec -it jenkins bash
```

---
### Quellen

[1] https://github.com/jenkinsci/docker/issues/516
