package de.hhu.propra.thesis.architecture;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;
import static com.tngtech.archunit.library.Architectures.onionArchitecture;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import org.junit.jupiter.api.DisplayName;

@AnalyzeClasses(
    packages = "de.hhu.propra.thesis",
    importOptions = ImportOption.DoNotIncludeTests.class)
@DisplayName("Architekturregeln")
class ArchitectureTest {

  @ArchTest
  static final ArchRule ONION_ARCHITEKTUR = onionArchitecture()
      .domainModels("..domain.model..")
      .domainServices("..domain.service..")
      .applicationServices("..application..")
      .adapter("web", "..adapter.web..")
      .adapter("persistence", "..adapter.persistence..")
      .adapter("files", "..adapter.files..")
      .adapter("markdown", "..adapter.markdown..")
      .withOptionalLayers(true)
      .allowEmptyShould(true)
      .as("Die Anwendung folgt der Onion-Architektur");

  @ArchTest
  static final ArchRule DOMAIN_OHNE_SPRING = noClasses()
      .that().resideInAPackage("..domain..")
      .should().dependOnClassesThat().resideInAPackage("org.springframework..")
      .allowEmptyShould(true)
      .as("Die Domain haengt nicht von Spring ab");

  @ArchTest
  static final ArchRule APPLICATION_OHNE_INFRASTRUKTUR = noClasses()
      .that().resideInAPackage("..application..")
      .should().dependOnClassesThat().resideInAnyPackage(
          "org.springframework.web..",
          "org.springframework.data..",
          "jakarta.servlet..")
      .allowEmptyShould(true)
      .as("Die Application-Schicht haengt nicht von Web, Servlets oder Spring Data ab");
}
