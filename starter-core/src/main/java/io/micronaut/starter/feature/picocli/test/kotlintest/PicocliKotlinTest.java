/*
 * Copyright 2020 original authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.micronaut.starter.feature.picocli.test.kotlintest;

import io.micronaut.starter.application.Project;
import io.micronaut.starter.application.generator.GeneratorContext;
import io.micronaut.starter.feature.picocli.test.PicocliTestFeature;
import io.micronaut.starter.options.Language;
import io.micronaut.starter.options.TestFramework;
import io.micronaut.starter.template.RockerTemplate;

import javax.inject.Singleton;

@Singleton
public class PicocliKotlinTest implements PicocliTestFeature {

    @Override
    public String getName() {
        return "picocli-kotlintest";
    }

    @Override
    public void doApply(GeneratorContext generatorContext) {
        generatorContext.removeTemplate("testDir");
        generatorContext.addTemplate("picocliKotlinTest", getTemplate(generatorContext.getProject()));
    }

    @Override
    public TestFramework getTestFramework() {
        return TestFramework.KOTLINTEST;
    }

    @Override
    public Language getDefaultLanguage() {
        return Language.KOTLIN;
    }

    public RockerTemplate getTemplate(Project project) {
        return new RockerTemplate(getTestFramework().getSourcePath("/{packagePath}/{className}Command", Language.KOTLIN), picocliKotlinTestTest.template(project));
    }

}
