package io.micronaut.starter.generator

import io.micronaut.starter.application.ApplicationType
import io.micronaut.starter.options.BuildTool
import io.micronaut.starter.options.Language
import io.micronaut.starter.options.TestFramework
import spock.lang.Ignore
import spock.lang.Unroll

class CreateAlexaSpec  extends CommandSpec {

    @Ignore("alexa-http-server not yet in bom")
    @Unroll
    void 'create-app with features #features #lang and #build and test framework: #testFramework'(ApplicationType applicationType,
                                                                                                  List<String> features,
                                                                                                  Language lang,
                                                                                                  BuildTool build,
                                                                                                  TestFramework testFramework) {
        given:
        generateProject(lang, build, features, applicationType, testFramework)

        when:
        build == BuildTool.GRADLE ? executeGradleCommand('test') : executeMavenCommand("test")

        then:
        testOutputContains("BUILD SUCCESS")

        where:
        applicationType         | features      | lang            | build            | testFramework
        ApplicationType.DEFAULT | ['aws-alexa'] | Language.JAVA   | BuildTool.GRADLE | TestFramework.JUNIT
        ApplicationType.DEFAULT | ['aws-alexa'] | Language.JAVA   | BuildTool.MAVEN  | TestFramework.JUNIT
        ApplicationType.DEFAULT | ['aws-alexa'] | Language.JAVA   | BuildTool.GRADLE | TestFramework.SPOCK
        ApplicationType.DEFAULT | ['aws-alexa'] | Language.JAVA   | BuildTool.MAVEN  | TestFramework.SPOCK
        ApplicationType.DEFAULT | ['aws-alexa'] | Language.KOTLIN | BuildTool.GRADLE | TestFramework.KOTLINTEST
        ApplicationType.DEFAULT | ['aws-alexa'] | Language.KOTLIN | BuildTool.MAVEN  | TestFramework.KOTLINTEST
        ApplicationType.DEFAULT | ['aws-alexa'] | Language.KOTLIN | BuildTool.GRADLE | TestFramework.JUNIT
        ApplicationType.DEFAULT | ['aws-alexa'] | Language.KOTLIN | BuildTool.MAVEN  | TestFramework.JUNIT
        ApplicationType.DEFAULT | ['aws-alexa'] | Language.GROOVY | BuildTool.GRADLE | TestFramework.SPOCK
        ApplicationType.DEFAULT | ['aws-alexa'] | Language.GROOVY | BuildTool.MAVEN  | TestFramework.SPOCK
    }

    @Unroll
    void 'create-function-app with features #features #lang and #build and test framework: #testFramework'(ApplicationType applicationType,
                                                                                                           List<String> features,
                                                                                                           Language lang,
                                                                                                           BuildTool build,
                                                                                                           TestFramework testFramework) {
        given:
        generateProject(lang, build, features, applicationType, testFramework)

        when:
        build == BuildTool.GRADLE ? executeGradleCommand('test') : executeMavenCommand("test")

        then:
        testOutputContains("BUILD SUCCESS")

        where:
        applicationType          | features       | lang            | build            | testFramework
        ApplicationType.FUNCTION | ['aws-alexa']  | Language.JAVA   | BuildTool.GRADLE | TestFramework.JUNIT
        ApplicationType.FUNCTION | ['aws-alexa']  | Language.JAVA   | BuildTool.MAVEN  | TestFramework.JUNIT
        ApplicationType.FUNCTION | ['aws-alexa']  | Language.JAVA   | BuildTool.GRADLE | TestFramework.SPOCK
        ApplicationType.FUNCTION | ['aws-alexa']  | Language.JAVA   | BuildTool.MAVEN  | TestFramework.SPOCK
        ApplicationType.FUNCTION | ['aws-alexa']  | Language.KOTLIN | BuildTool.GRADLE | TestFramework.KOTLINTEST
        ApplicationType.FUNCTION | ['aws-alexa']  | Language.KOTLIN | BuildTool.MAVEN  | TestFramework.KOTLINTEST
        ApplicationType.FUNCTION | ['aws-alexa']  | Language.KOTLIN | BuildTool.GRADLE | TestFramework.JUNIT
        ApplicationType.FUNCTION | ['aws-alexa']  | Language.KOTLIN | BuildTool.MAVEN  | TestFramework.JUNIT
        ApplicationType.FUNCTION | ['aws-alexa']  | Language.GROOVY | BuildTool.GRADLE | TestFramework.SPOCK
        ApplicationType.FUNCTION | ['aws-alexa']  | Language.GROOVY | BuildTool.MAVEN  | TestFramework.SPOCK
    }
}
