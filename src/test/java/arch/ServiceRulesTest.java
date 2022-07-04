package arch;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import org.springframework.stereotype.Service;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

@AnalyzeClasses(packages = "com.opossum.jiraworklogreporter", importOptions = { ImportOption.DoNotIncludeTests.class })
public class ServiceRulesTest {

	@ArchTest
    static final ArchRule all_services_must_be_services =
           classes().that().resideInAPackage("..service..").and().areNotInterfaces().and().haveSimpleNameNotStartingWith("Abstract").should().beAnnotatedWith(Service.class);

}
