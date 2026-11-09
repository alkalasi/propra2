# Thesis is coming!

Webanwendung, mit der Studierende passende Betreuer:innen und Themen
für ihre Abschlussarbeit finden. Projekt im Programmierpraktikum 2.

## Technik

- Java 25, Spring Boot 4 (Spring Web MVC, Thymeleaf, Bean Validation)
- Onion-Architektur, abgesichert mit ArchUnit
- Code-Stil: [Google Java Style](https://google.github.io/styleguide/javaguide.html),
  geprüft mit Checkstyle (`config/checkstyle/google_checks.xml`)

## Paketstruktur

| Paket | Inhalt |
|---|---|
| `domain.model` | Aggregate, Entitäten, Wertobjekte (ohne Spring) |
| `domain.service` | fachliche Logik über mehrere Aggregate (z. B. Matching) |
| `application.service` | Anwendungsfälle |
| `application.port` | Schnittstellen für Speicherung und Infrastruktur |
| `adapter.*` | Web, Persistenz, Dateien, Markdown |

## Bauen und prüfen

```bash
./gradlew bootJar     # ausführbares JAR bauen
./gradlew build       # kompilieren, testen, Checkstyle, SpotBugs, JaCoCo
./gradlew pitest      # Mutationstests
```

Reports liegen danach unter `build/reports/`
(`tests`, `jacoco`, `checkstyle`, `spotbugs`, `pitest`).

## Konfiguration

Personenbezogene Daten und Secrets gehören nicht ins Repository.
Sie werden über Umgebungsvariablen gesetzt, siehe `.env.example`.
Die echte `.env` ist in `.gitignore` eingetragen.
