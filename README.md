# ArchiLab Jenkins-Infrastruktur

Dieses Repository beinhaltet alles was für die Installation, Einrichtung und den
Betrieb des Jenkin-Servers benötigt wird.

## Docker secrets anlegen

Als erstes müssen alle Secrets angelegt werden. Welche Secrets benötigt werden
um den Jenkins für ArchiLab voll konfiguriert zu starten, findet man in der
`docker-compose.yml`.

Ohne in den Docker Swarm-Modus zu wechseln, müssen die Secrets ein wenig anders
angelegt werden. Deswegen unterscheiden sich die Anleitungen für die zwei
Umgebungen ein wenig:

- Anleitung für [Docker Swarm Umgebung](#docker-swarm)
- Anleitung für [Docker Desktop Umgebung](#docker-desktop)

### Docker Swarm

Um die benötigten Docker Secrets anzulegen existiert ein Skript, dass die Secrets
aus Textdateien im Ordner `secrets` generiert. Dieser Ordner darf aus
Sicherheitsgründen natürlich nicht in das öffentliche Repository gepusht werden
und muss deshalb von Hand angelegt werden mit allen Secrets angelegt werden.
Danach können die Secrets mithilfe des Skripts angelegt werden:

```bash
./create-secrets.sh
```

Danach kann mit mithilfe des Run-Skripts das Docker-Image für den Jenkins-Server
gebaut und gestartet werden:

```bash
./run.sh
```

### Docker Desktop

Da Docker Desktop - ohne in den Swarm Modus zu schalten - kein Docker secret
unterstützt, gibt es die `docker-compose.local.yml`. In dieser Datei werden die
Quellen der Secrets überschrieben und auf Dateinamen gelegt.

Das heißt ganz konkret, dass alle Benutzernamen/Passwörter/RSA-Schlüssel etc.
als Inhalt von einzelnen Dateien in dem Verzeichnis `secrets` abgelegt werden
müssen. Dabei wurden die Secret-Namen direkt auch als Dateinamen benutzt.

Welche Dateinamen es genau sind, findet man in der `docker-compose.local.yml`.

Wenn die Dateien mit den jeweiligen Inhalten (Benutzernamen/Passwörter und
privaten Schlüssel) angelegt sind, dann kann man Jenkins über den nachfolgenden
Befehl einfach starten:

```bash
docker-compose -f docker-compose.yml -f docker-compose.local.yml up
```

## Neue Pipeline anlegen
- In dem Ordner /casc-Ordner die neue Pipeline in die Datei jobs.yml hinzufügen (am besten indem ein bestehender "- script >"-Skript kopiert wird)
- Anschließend das Skript `./run.sh` auf dem archilab-build ausführen

## Zugriff auf laufenden Container

```bash
docker exec -it jenkins bash
```

## Hinweise für die Projekte

Damit man mit Maven über das Docker-Plugin das Docker-Image zu unserem
Docker-Repository pushen kann, benötigt man Credentials. Diese kann man über
`withCredentials()` als Umgebungsvariablen bekommen und diese dann ganz einfach
im Skript benutzen.

Scripted Pipeline

```javascript
node {
   stage("..") {
      withCredentials([usernamePassword(credentialsId: 'archilab-nexus-jenkins', usernameVariable: 'NEXUS_USERNAME', passwordVariable: 'NEXUS_PASSWORD')]) {
         sh "mvn -B -s settings.xml -Ddockerfile.username=\"$NEXUS_USERNAME\" -Ddockerfile.password=\"$NEXUS_PASSWORD\" -Drevision=${revision} clean deploy"
      }
   }
}
```

**Hinweis:** Wenn es Fehler beim Herunterladen/Installieren der Jenkins-Plugins
gibt, dann ggf. in der plugins.txt die Zeilenumbrüche überprüfen. [1]

---

### Quellen

[1] https://github.com/jenkinsci/docker/issues/516
