package arch;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import org.springframework.context.annotation.Profile;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

@AnalyzeClasses(packages = "com.opossum.jiraworklogreporter", importOptions = { ImportOption.DoNotIncludeTests.class })
public class JobsRulesTest {

	@ArchTest
    static final ArchRule all_jobs_must_have_profile =
           classes().that().resideInAPackage("..job..").should().beAnnotatedWith(Profile.class).as("Jobs must have profile, otherwise it will be triggered by tests");

}
