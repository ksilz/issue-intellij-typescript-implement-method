package com.betterprojectsfaster.talks.openj9memory;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

class ArchTest {

    @Test
    void servicesAndRepositoriesShouldNotDependOnWebLayer() {

        JavaClasses importedClasses = new ClassFileImporter()
            .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
            .importPackages("com.betterprojectsfaster.talks.openj9memory");

        noClasses()
            .that()
                .resideInAnyPackage("com.betterprojectsfaster.talks.openj9memory.service..")
            .or()
                .resideInAnyPackage("com.betterprojectsfaster.talks.openj9memory.repository..")
            .should().dependOnClassesThat()
                .resideInAnyPackage("..com.betterprojectsfaster.talks.openj9memory.web..")
        .because("Services and repositories should not depend on web layer")
        .check(importedClasses);
    }
}
