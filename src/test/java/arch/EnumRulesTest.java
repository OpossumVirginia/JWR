package arch;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition;

@AnalyzeClasses(packages = "com.opossum.jiraworklogreporter", importOptions = { ImportOption.DoNotIncludeTests.class })
public class EnumRulesTest {

  //@ArchTest
  //  static final ArchRule all_classes_in_enums_must_be_enums =
  //         ArchRuleDefinition.classes().that().resideInAPackage("..enums..")
  //                  .should().beEnums();

}
