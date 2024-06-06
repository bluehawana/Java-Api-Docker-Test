# Docker instruktioner

## Dockerfile

### Bygg docker image

For att bygga docker image kör följande kommando i terminalen:

```bash
docker build -t notes-app .
```

### Kör docker image

För att köra docker image kör följande kommando i terminalen:

```bash
docker run -p 8080:8080 notes-app
```

## Docker-compose

### Bygg och kör docker-compose

För att bygga och köra docker-compose kör följande kommando i terminalen:

```bash
docker-compose up --build
```
