package com.abaco.dto;

import static org.assertj.core.api.Assertions.assertThat;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.MethodName;

/**
 * Unit Test Class for data structure interface {@link CategoryDTO#CategoryDTO DTO}.
 */
@DisplayName("A Category Data Transfer Object")
@TestMethodOrder(MethodName.class)
class CategoryDTOTest {

	@Nested
	@DisplayName("For Contructor")
	class testConstructor {

		@Test
		@DisplayName("When all arguments")
		void testAllArguments() {
			final CategoryDTO expectModel = CategoryDTO.builder()
					.description(RandomStringUtils.randomAlphabetic(10))
					.type(RandomUtils.nextInt(10, 100))
					.nature(RandomUtils.nextInt(10, 100))
					.build();

			final CategoryDTO actualModel = new CategoryDTO(
					expectModel.getDescription(), 
					expectModel.getType(), 
					expectModel.getNature());

			thenSameModel(actualModel, expectModel);
		}

		@Test
		@DisplayName("When no argument")
		void testNoArgument() {
			final CategoryDTO expectModel = CategoryDTO.builder().build();

			final CategoryDTO actualModel = new CategoryDTO();

			thenSameModel(actualModel, expectModel);
		}
	}

	@Nested
	@DisplayName("For toString")
	class testToString {
		@Test
		@DisplayName("When existing object instance")
		void testDefault() {
			final String actualStringModel = CategoryDTO.builder()
					.description(RandomStringUtils.randomAlphanumeric(10))
					.type(RandomUtils.nextInt(10, 100))
					.nature(RandomUtils.nextInt(10, 100))
					.toString();

			assertThat(actualStringModel).isNotEmpty();
		}
	}

	@Nested
	@DisplayName("For field")
	class testField {

		@Nested
		@TestMethodOrder(MethodName.class)
		@DisplayName("Description")
		class testDescriptionField {

			@Test
			@DisplayName("When get same value")
			void testGetSameValue() {
				final CategoryDTO expectModel = CategoryDTO.builder()
						.description(RandomStringUtils.randomAlphanumeric(10))
						.build();

				final CategoryDTO actualModel = CategoryDTO.builder()
						.description(expectModel.getDescription())
						.build();

				assertThat(actualModel.getDescription())
					.isNotEmpty()
					.isEqualTo(expectModel.getDescription());
			}

			@Test
			@DisplayName("When set null value")
			void testSetNullValue() {
				final CategoryDTO expectModel = CategoryDTO.builder()
						.description(null)
						.build();

				CategoryDTO actualModel = new CategoryDTO();
				actualModel.setDescription(expectModel.getDescription());

				thenSameModel(actualModel, expectModel);
			}

			@Test
			@DisplayName("When set some valid value")
			void testSetSomeValue() {
				final CategoryDTO expectModel = CategoryDTO.builder()
						.description(RandomStringUtils.randomAlphanumeric(10))
						.build();

				CategoryDTO actualModel = new CategoryDTO();
				actualModel.setDescription(expectModel.getDescription());

				thenSameModel(actualModel, expectModel);
			}

			@Test
			@DisplayName("When build with null value")
			void testBuildNullValue() {
				final CategoryDTO expectModel = CategoryDTO.builder()
						.description(null)
						.build();

				final CategoryDTO actualModel = CategoryDTO.builder()
						.description(expectModel.getDescription())
						.build();

				thenSameModel(actualModel, expectModel);
			}

			@Test
			@DisplayName("When build with some valid value")
			void testBuildSomeValue() {
				final CategoryDTO expectModel = CategoryDTO.builder()
						.description(RandomStringUtils.randomAlphanumeric(10))
						.build();

				final CategoryDTO actualModel = CategoryDTO.builder()
						.description(expectModel.getDescription())
						.build();

				thenSameModel(actualModel, expectModel);
			}
		}

		@Nested
		@TestMethodOrder(MethodName.class)
		@DisplayName("Type")
		class testTypeField {

			@Test
			@DisplayName("When get same Integer value")
			void testGetSameValue() {
				final int expectFieldValue = 7;

				final CategoryDTO actualModel = CategoryDTO.builder()
						.type(expectFieldValue)
						.build();

				assertThat(actualModel.getType())
					.isNotZero()
					.isNotNegative()
					.isEqualTo(expectFieldValue);
			}

			@Test
			@DisplayName("When set null value")
			void testSetNullvalue() {
				final CategoryDTO expectModel = CategoryDTO.builder()
						.type(null)
						.build();

				CategoryDTO actualModel = new CategoryDTO();
				actualModel.setType(expectModel.getType());

				thenSameModel(actualModel, expectModel);
			}

			@Test
			@DisplayName("When set some valid value")
			void testSetSomeValue() {
				final CategoryDTO expectModel = CategoryDTO.builder()
						.type(RandomUtils.nextInt(10, 100))
						.build();

				CategoryDTO actualModel = new CategoryDTO();
				actualModel.setType(expectModel.getType());

				thenSameModel(actualModel, expectModel);
			}

			@Test
			@DisplayName("When build with null value")
			void testBuildNullValue() {
				final CategoryDTO expectModel = CategoryDTO.builder()
						.type(null)
						.build();

				final CategoryDTO actualModel = CategoryDTO.builder()
						.type(expectModel.getType())
						.build();

				thenSameModel(actualModel, expectModel);
			}

			@Test
			@DisplayName("When build with some valid value")
			void testBuildSomeValue() {
				final CategoryDTO expectModel = CategoryDTO.builder()
						.type(RandomUtils.nextInt(10, 100))
						.build();

				final CategoryDTO actualModel = CategoryDTO.builder()
						.type(expectModel.getType())
						.build();

				thenSameModel(actualModel, expectModel);
			}
		}

		@Nested
		@TestMethodOrder(MethodName.class)
		@DisplayName("Nature")
		class testNatureField {

			@Test
			@DisplayName("When get same Int value")
			void testGetSameValue() {
				final int expectFieldValue = RandomUtils.nextInt(10, 100);

				final CategoryDTO actualModel = CategoryDTO.builder()
						.nature(expectFieldValue)
						.build();

				assertThat(actualModel.getNature())
					.isNotNull()
					.isNotZero()
					.isEqualTo(expectFieldValue);
			}

			@Test
			@DisplayName("When set null value")
			void testSetNullvalue() {
				final CategoryDTO expectModel = CategoryDTO.builder()
						.nature(null)
						.build();

				CategoryDTO actualModel = new CategoryDTO();
				actualModel.setNature(expectModel.getNature());

				thenSameModel(actualModel, expectModel);
			}

			@Test
			@DisplayName("When set some valid value")
			void testSetSomeValue() {
				final CategoryDTO expectModel = CategoryDTO.builder()
						.nature(RandomUtils.nextInt(10, 100))
						.build();

				CategoryDTO actualModel = new CategoryDTO();
				actualModel.setNature(expectModel.getNature());

				thenSameModel(actualModel, expectModel);
			}

			@Test
			@DisplayName("When build with null value")
			void testBuildNullValue() {
				final CategoryDTO expectModel = CategoryDTO.builder()
						.nature(null)
						.build();

				final CategoryDTO actualModel = CategoryDTO.builder()
						.nature(expectModel.getNature())
						.build();

				thenSameModel(actualModel, expectModel);
			}

			@Test
			@DisplayName("When build with some valid value")
			void testBuildSomeValue() {
				final CategoryDTO expectModel = CategoryDTO.builder()
						.nature(RandomUtils.nextInt(10, 100))
						.build();

				final CategoryDTO actualModel = CategoryDTO.builder()
						.nature(expectModel.getNature())
						.build();

				thenSameModel(actualModel, expectModel);
			}
		}

	}

	/**
	 * Check the given assertion at model for corner/nominal case
	 * 
	 * @param actual The element to check
	 * @param expect The Reference value to check
	 */
	private static void thenSameModel(final CategoryDTO actual, final CategoryDTO expect) {
		assertThat(actual).satisfies(dto -> {
			assertThat(dto.getDescription()).isEqualTo(expect.getDescription());
			assertThat(dto.getType()).isEqualTo(expect.getType());
			assertThat(dto.getNature()).isEqualTo(expect.getNature());
		});
	}
}
