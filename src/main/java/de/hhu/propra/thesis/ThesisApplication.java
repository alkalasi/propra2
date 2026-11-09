package de.hhu.propra.thesis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/** Startklasse der Anwendung. */
@SpringBootApplication
public class ThesisApplication {

  /**
   * Startet die Spring-Boot-Anwendung.
   *
   * @param args Kommandozeilenargumente
   */
  public static void main(String[] args) {
    SpringApplication.run(ThesisApplication.class, args);
  }
}
