package arch;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import com.opossum.jiraworklogreporter.job.RetrievalJob;
import com.opossum.jiraworklogreporter.service.WorklogEntryRetreivalService;
import org.slf4j.Logger;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.fields;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;
import static com.tngtech.archunit.library.GeneralCodingRules.*;

@AnalyzeClasses(packages = "com.opossum.jiraworklogreporter", importOptions = { ImportOption.DoNotIncludeTests.class })
public class CodingRulesTest {

    /**
     * Test that checks if no generic exceptions are thrown in the project
     * This rule has exceptions - either will be fixed in 2 classes or a custom error defined
     */
    @ArchTest
    private void no_gen_exc(JavaClasses classes) {
        noClasses().that().doNotBelongToAnyOf(WorklogEntryRetreivalService.class, RetrievalJob.class).should(THROW_GENERIC_EXCEPTIONS).check(classes);
    }

    /**
     * Test that checks if a specific library is not used in the project
     */
    @ArchTest
    private final ArchRule no_java_util_logging = NO_CLASSES_SHOULD_USE_JAVA_UTIL_LOGGING;

    /**
     * Test that checks if a specific library is not used in the project
     */
    @ArchTest
    private final ArchRule no_jodatime = NO_CLASSES_SHOULD_USE_JODATIME;

    /**
     * Test that checks if a field injection is used in the project. Constructor or the setter injection should be used.
     */
    @ArchTest
    private final ArchRule no_field_injection = NO_CLASSES_SHOULD_USE_FIELD_INJECTION;

    @ArchTest
    private final ArchRule loggers_should_be_private_static_final =
            fields().that().haveRawType(Logger.class)
                    .should().bePrivate()
                    .andShould().beStatic()
                    .andShould().beFinal()
                    .because("its a common sense");

    @ArchTest
    private final ArchRule no_access_to_standard_streams = NO_CLASSES_SHOULD_ACCESS_STANDARD_STREAMS;

    @ArchTest
    private void no_access_to_standard_streams_as_method(JavaClasses classes) {
        noClasses().should(ACCESS_STANDARD_STREAMS).check(classes);
    }
}
