package arch;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import jakarta.persistence.Entity;


import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

@AnalyzeClasses(packages = "com.opossum.jiraworklogreporter", importOptions = { ImportOption.DoNotIncludeTests.class })
public class PackageRulesTest {

    @ArchTest
    static final ArchRule Entities_must_reside_in_a_domain_package =
            classes().that().areAnnotatedWith(Entity.class).should().resideInAPackage("..entity..")
                    .as("Entities should reside in a package '..domain..'");

    @ArchTest
    static final ArchRule Services_must_reside_in_a_service_package =
            classes().that().haveNameMatching(".*Service").should().resideInAPackage("..service..").orShould().resideInAPackage("..mail..")
                    .as("Services should reside in a package '..service..'");

}
