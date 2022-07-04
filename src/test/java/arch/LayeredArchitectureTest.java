package arch;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.library.Architectures.layeredArchitecture;
import static com.tngtech.archunit.library.dependencies.SlicesRuleDefinition.slices;

@AnalyzeClasses(packages = "com.opossum.jiraworklogreporter", importOptions = { ImportOption.DoNotIncludeTests.class })
public class LayeredArchitectureTest {

    @ArchTest
    static final ArchRule layer_dependencies_are_respected = layeredArchitecture()
            .layer("Jobs").definedBy("com.opossum.jiraworklogreporter.job..")
            .layer("Services").definedBy("com.opossum.jiraworklogreporter.service..")
            .layer("Repository").definedBy("com.opossum.jiraworklogreporter.repository..")

            .whereLayer("Jobs").mayNotBeAccessedByAnyLayer()
            .whereLayer("Services").mayOnlyBeAccessedByLayers("Jobs")
            .whereLayer("Repository").mayOnlyBeAccessedByLayers("Services");

            // .ignoreDependency(SomeClass1.class, SomeClass2.class);

    @ArchTest
    public static final ArchRule NO_CYCLES = slices().matching("com.opossum.jiraworklogreporter.(**)").should().beFreeOfCycles();

}
