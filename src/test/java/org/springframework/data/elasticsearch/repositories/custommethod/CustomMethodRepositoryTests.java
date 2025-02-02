/*
 * Copyright 2018-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.data.elasticsearch.repositories.custommethod;

import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.junit.jupiter.ElasticsearchTemplateConfiguration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.data.elasticsearch.utils.IndexInitializer;
import org.springframework.test.context.ContextConfiguration;

/**
 * @author Don Wellington
 * @author Mark Paluch
 * @author Peter-Josef Meisch
 */
@ContextConfiguration(classes = { CustomMethodRepositoryTests.Config.class })
public class CustomMethodRepositoryTests extends CustomMethodRepositoryBaseTests {

	@Configuration
	@Import({ ElasticsearchTemplateConfiguration.class })
	@EnableElasticsearchRepositories(
			basePackages = { "org.springframework.data.elasticsearch.repositories.custommethod" },
			considerNestedRepositories = true)
	static class Config {}

	@Autowired private ElasticsearchTemplate elasticsearchTemplate;

	@BeforeEach
	public void before() {
		IndexInitializer.init(elasticsearchTemplate, SampleEntity.class);
	}
}
