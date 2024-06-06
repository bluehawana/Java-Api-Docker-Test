# Vecka 5: Notes API - VG

## Beskrivning

Detta projekt handlar om att skapa en RESTful API med Spring Boot för att hantera anteckningar baserat på
tillhandahållna `controllers` samt `dtos`. Målet är att skapa ett API som kan hantera CRUD-operationer för att skapa,
läsa, uppdatera och radera anteckningar. Projektet ska också innehålla en dokumentation med Swagger för att beskriva
API:ets
funktionalitet. API:et vara säkert genom att använda autentisering med JWT och till sist ska API:et vara dockeriserat.

## Tekniker som ska användas

- Spring Boot
- Maven
- Autentisering med JWT
- Swagger för dokumentation
- MySQL
- Docker och Docker Compose

## Mål

- Skapa en RESTful API med Spring Boot för att hantera anteckningar.
- Implementera autentisering med JWT för att skydda API:et.
- Använda Swagger för att skapa dokumentation för API:et.
- Använda MySQL för att lagra anteckningar och användare.
- Dockerisera API:et för att underlätta distribution och skalning.
- Följa Clean Code-principer.

## Förkunskaper

- Grundläggande kunskaper i Spring Boot.
- Grundläggande kunskaper i Maven.
- Grundläggande kunskaper i Docker och containerisering.
- Grundläggande kunskaper i MySQL.
- Grundläggande kunskaper i autentisering med JWT.

## Färdigheter som utvecklas

- Förmågan att skapa och hantera Docker-images.
- Förståelse för multi-stage builds i Docker.
- Implementering av Clean Code-principer.
- Automatisering av byggprocessen med Docker.
- Dokumentation av bygg- och körprocessen med Docker.
- Förmågan att skapa en säker API med autentisering.

## Förutsättningar

1. Få applikationen att fungera lokalt mot en MySQL-databas.
2. Verifiera med `generated-requests.http`, Swagger och/eller Postman att API:et fungerar som det ska.
3. Använda Docker för att skapa en Docker-image och köra applikationen i en container. (Glöm inte att stänga av andra
   applikationer som använder port 8080 samt port 3306 innan ni kör Docker eller Docker Compose).
4. Verifiera att API:et fungerar korrekt i Docker med `generated-requests.http`, Swagger och/eller Postman.

### Lokalt

- Ni har fått förutbestämda **controllers** och samtliga grundläggande **dtos** till projektet.
- Metod deklarationerna som finns definierade får inte ändras, så som `controllers`!
- Några **dtos** har oanvända import-satser, dessa är för att underlätta för att skriva valideringar.
- De **oanvända importer** som finns i filerna, finns där för att underlätta.
- Ni ska använda **MySQL** för att lagra anteckningar och användare.
- Ni ska använda **Swagger** för att skapa dokumentation för API:et.
- Ni ska använda **JWT** för att autentisera användare.
- Det finns en omfattande **pom.xml** som innehåller alla nödvändiga beroenden från lektionerna, ni kan lägga till mer
  om ni vill det.
- Det finns en `generated-requests.http`-fil som innehåller de anrop till API:et som skall fungera (och inte fungera).
- Det finns en `application.properties`-fil samt en `.env`-fil som innehåller nödvändiga inställningar för att köra
  projektet.
- Det finns färdiga tester som ni kan använda för att testa projektet, dessa är inte obligatoriska att använda samt
  **får absolut inte ändras**. Dessa tester, testar enbart era `controllers` samt har en extra test som stänger av
  säkerheten i applikationen för att kunna testa API:et enklare. 
- _För att testerna ska fungera så måste tillräckligt av koden vara skriven, fram tills dess så fungerar inte testerna._
- Samma tester körs online i CI/CD-pipeline, så funkar det inte lokalt så funkar det inte online heller (med undantag
  för om det kanske är något märkligt med er miljö).

### Docker specifikt

- Det finns en mapp som heter `helpers` i `rooten` av projektet, `DataSourceConfigLocal.java`
  samt `DataSourceConfigDocker.java`. Kopiera innehållet från den som är relevant att använda när ni kör lokalt eller i
  Docker. `DataSourceConfigDocker.java` gör så att Docker hämtar `.env` variabler från `.env`-filen och gör dem
  tillgängliga för Spring Boot projektet. (Detta är en möjlig lösning vi Dockeriseringen, ni kan välja att inte använda
  denna lösningen.)
- Det finns en `Dockerfile` som är tom, ni ska fylla i den.
- Det finns en `docker-compose.yml` som är tom, ni ska fylla i den.
- Inget ska behöva ändras i `application.properties`-filen, `.env`-filen innehåller två `DATABASE_URL` som ni switchar
  mellan beroende på om ni kör lokalt eller i Docker.

## Steg-för-Steg Instruktioner

1. **TODO:** Gå igenom alla `TODO`-kommentarer i projektet och implementera de funktioner som saknas.
2. **Verifiera:** Verifiera att API:et fungerar korrekt med `generated-requests.http`, Swagger och/eller Postman.
3. **Docker:** Skapa en Dockerfile och en docker-compose.yml för att bygga och köra applikationen i en Docker-container.
4. **Dokumentation:** Fyll i `personal-reflection.md`-filen med dina reflektioner och lärdomar från projektet.

## Ni ska leverera

- Fungerande källkod som klarar testerna i test mappen.
- En `Dockerfile` som beskriver hur applikationen ska byggas och köras i en Docker-container.
- En `docker-compose.yml`-fil som beskriver hur applikationen ska byggas och köras i en Docker-container.
- Ifylld `personal-reflection.md`-fil.

## Bedömningskriterier

- **Funktionalitet:** Applikationen ska fungera korrekt och klara testerna i test mappen.
- **Kodkvalitet:** Koden skall vara lättförståelig.
- **Testning:** Manuell kontroll att applikationen fungerar korrekt i Docker med `generated-requests.http`.
- **Docker-implementation:** Effektiv och korrekt användning av multi-stage builds i Docker.
- **Dokumentation:** Tydlig och informativ dokumentation i `personal-reflection.md`.

## Kursmål som testas

- Den studerande kan bygga, publicera och dokumentera en webbtjänst med säkerhetslösning som klienter kan anropa (API).
- Den studerande kan förklara sitt val av säkerhetslösning och tjänsten är väldokumenterad

## Tips

Allt som behövs för att klara av uppgiften finns i tidigare lektioner:

- Lektion 5
- Lektion 7
- Lektion 10

Lycka till och ha kul!
