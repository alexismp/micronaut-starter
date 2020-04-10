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
package io.micronaut.starter.feature;

import io.micronaut.starter.command.MicronautCommand;
import io.micronaut.starter.options.BuildTool;
import io.micronaut.starter.options.Language;
import io.micronaut.starter.options.TestFramework;
import io.micronaut.starter.util.VersionInfo;

import javax.inject.Singleton;
import java.util.List;

@Singleton
public class AnnotationApi implements Feature, DefaultFeature {

    @Override
    public String getName() {
        return "annotation-api";
    }

    @Override
    public boolean shouldApply(MicronautCommand micronautCommand, Language language, TestFramework testFramework, BuildTool buildTool, List<Feature> selectedFeatures) {
        return VersionInfo.getJavaVersion() >= 9;
    }
}