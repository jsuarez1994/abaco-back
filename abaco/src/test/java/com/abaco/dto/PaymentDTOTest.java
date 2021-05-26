package com.abaco.dto;

import static org.assertj.core.api.Assertions.assertThat;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.MethodName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

/**
 * Unit Test Class for data structure interface {@link PaymentDTO#PaymentDTO DTO}.
 */
@DisplayName("A Payment Data Transfer Object")
@TestMethodOrder(MethodName.class)
class PaymentDTOTest {

	@Nested
	@DisplayName("For Contructor")
	class testConstructor {

		@Test
		@DisplayName("When all arguments")
		void testAllArguments() {
			final PaymentDTO expectModel = PaymentDTO.builder()
					.description(RandomStringUtils.randomAlphabetic(10))
					.period(RandomStringUtils.randomAlphabetic(10))
					.quantity(RandomUtils.nextDouble(10, 100))
					.category(CategoryDTO.builder()
						.description(RandomStringUtils.randomAlphabetic(10))
						.type(RandomUtils.nextInt(10, 100))
						.nature(RandomUtils.nextInt(10, 100))
						.build())
					.build();

			final PaymentDTO actualModel = new PaymentDTO(
					expectModel.getDescription(), 
					expectModel.getPeriod(),
					expectModel.getQuantity(), 
					expectModel.getCategory());

			thenSameModel(actualModel, expectModel);
		}

		@Test
		@DisplayName("When no argument")
		void testNoArgument() {
			final PaymentDTO expectModel = PaymentDTO.builder().build();

			final PaymentDTO actualModel = new PaymentDTO();

			thenSameModel(actualModel, expectModel);
		}
	}

	@Nested
	@DisplayName("For toString")
	class testToString {
		@Test
		@DisplayName("When existing object instance")
		void testDefault() {
			final String actualStringModel = PaymentDTO.builder()
					.description(RandomStringUtils.randomAlphabetic(10))
					.period(RandomStringUtils.randomAlphabetic(10))
					.quantity(RandomUtils.nextDouble(10, 100))
					.category(CategoryDTO.builder()
						.description(RandomStringUtils.randomAlphabetic(10))
						.type(RandomUtils.nextInt(10, 100))
						.nature(RandomUtils.nextInt(10, 100))
						.build())
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
			@DisplayName("When get same value for description")
			void testGetSameValue() {
				final PaymentDTO expectModel = PaymentDTO.builder()
						.description(RandomStringUtils.randomAlphanumeric(10))
						.build();

				final PaymentDTO actualModel = PaymentDTO.builder()
						.description(expectModel.getDescription())
						.build();

				assertThat(actualModel.getDescription())
					.isNotEmpty()
					.isEqualTo(expectModel.getDescription());
			}

			@Test
			@DisplayName("When set null value")
			void testSetNullValue() {
				final PaymentDTO expectModel = PaymentDTO.builder()
						.description(null)
						.build();

				PaymentDTO actualModel = new PaymentDTO();
				actualModel.setDescription(expectModel.getDescription());

				thenSameModel(actualModel, expectModel);
			}

			@Test
			@DisplayName("When set some valid value")
			void testSetSomeValue() {
				final PaymentDTO expectModel = PaymentDTO.builder()
						.description(RandomStringUtils.randomAlphanumeric(10))
						.build();

				PaymentDTO actualModel = new PaymentDTO();
				actualModel.setDescription(expectModel.getDescription());

				thenSameModel(actualModel, expectModel);
			}

			@Test
			@DisplayName("When build with null value")
			void testBuildNullValue() {
				final PaymentDTO expectModel = PaymentDTO.builder()
						.description(null)
						.build();

				final PaymentDTO actualModel = PaymentDTO.builder()
						.description(expectModel.getDescription())
						.build();

				thenSameModel(actualModel, expectModel);
			}

			@Test
			@DisplayName("When build with some valid value")
			void testBuildSomeValue() {
				final PaymentDTO expectModel = PaymentDTO.builder()
						.description(RandomStringUtils.randomAlphanumeric(10))
						.build();

				final PaymentDTO actualModel = PaymentDTO.builder()
						.description(expectModel.getDescription())
						.build();

				thenSameModel(actualModel, expectModel);
			}
		}

		@Nested
		@TestMethodOrder(MethodName.class)
		@DisplayName("Period")
		class testPeriodField {

			@Test
			@DisplayName("When get same value for period")
			void testGetSameValue() {
				final PaymentDTO expectModel = PaymentDTO.builder()
						.period(RandomStringUtils.randomAlphanumeric(10))
						.build();

				final PaymentDTO actualModel = PaymentDTO.builder()
						.period(expectModel.getPeriod())
						.build();

				assertThat(actualModel.getPeriod())
					.isNotEmpty()
					.isEqualTo(expectModel.getPeriod());
			}

			@Test
			@DisplayName("When set null value")
			void testSetNullvalue() {
				final PaymentDTO expectModel = PaymentDTO.builder()
						.period(null)
						.build();

				PaymentDTO actualModel = new PaymentDTO();
				actualModel.setPeriod(expectModel.getPeriod());

				thenSameModel(actualModel, expectModel);
			}

			@Test
			@DisplayName("When set some valid value")
			void testSetSomeValue() {
				final PaymentDTO expectModel = PaymentDTO.builder()
						.period(RandomStringUtils.randomAlphanumeric(10))
						.build();

				PaymentDTO actualModel = new PaymentDTO();
				actualModel.setPeriod(expectModel.getPeriod());

				thenSameModel(actualModel, expectModel);
			}

			@Test
			@DisplayName("When build with null value")
			void testBuildNullValue() {
				final PaymentDTO expectModel = PaymentDTO.builder()
						.period(null)
						.build();

				final PaymentDTO actualModel = PaymentDTO.builder()
						.period(expectModel.getPeriod())
						.build();

				thenSameModel(actualModel, expectModel);
			}

			@Test
			@DisplayName("When build with some valid value")
			void testBuildSomeValue() {
				final PaymentDTO expectModel = PaymentDTO.builder()
						.period(RandomStringUtils.randomAlphanumeric(10))
						.build();

				final PaymentDTO actualModel = PaymentDTO.builder()
						.period(expectModel.getPeriod())
						.build();

				thenSameModel(actualModel, expectModel);
			}
		}

		@Nested
		@TestMethodOrder(MethodName.class)
		@DisplayName("Quantity")
		class testQuantityField {

			@Test
			@DisplayName("When get same value for quantity")
			void testGetSameValue() {
				final PaymentDTO expectModel = PaymentDTO.builder()
						.quantity(RandomUtils.nextDouble(10, 100))
						.build();

				final PaymentDTO actualModel = PaymentDTO.builder()
						.quantity(expectModel.getQuantity())
						.build();

				assertThat(actualModel.getQuantity())
					.isNotZero()
					.isEqualTo(expectModel.getQuantity());
			}

			@Test
			@DisplayName("When set null value")
			void testSetNullvalue() {
				final PaymentDTO expectModel = PaymentDTO.builder()
						.quantity(null)
						.build();

				PaymentDTO actualModel = new PaymentDTO();
				actualModel.setQuantity(expectModel.getQuantity());

				thenSameModel(actualModel, expectModel);
			}

			@Test
			@DisplayName("When set some valid value")
			void testSetSomeValue() {
				final PaymentDTO expectModel = PaymentDTO.builder()
						.quantity(RandomUtils.nextDouble(10, 100))
						.build();

				PaymentDTO actualModel = new PaymentDTO();
				actualModel.setQuantity(expectModel.getQuantity());

				thenSameModel(actualModel, expectModel);
			}

			@Test
			@DisplayName("When build with null value")
			void testBuildNullValue() {
				final PaymentDTO expectModel = PaymentDTO.builder()
						.quantity(null)
						.build();

				final PaymentDTO actualModel = PaymentDTO.builder()
						.quantity(expectModel.getQuantity())
						.build();

				thenSameModel(actualModel, expectModel);
			}

			@Test
			@DisplayName("When build with some valid value")
			void testBuildSomeValue() {
				final PaymentDTO expectModel = PaymentDTO.builder()
						.quantity(RandomUtils.nextDouble(10, 100))
						.build();

				final PaymentDTO actualModel = PaymentDTO.builder()
						.quantity(expectModel.getQuantity())
						.build();

				thenSameModel(actualModel, expectModel);
			}
		}

		@Nested
		@TestMethodOrder(MethodName.class)
		@DisplayName("Category")
		class testCategoryField {

			// Data Transfer Object populates to test Category Object
			final CategoryDTO categoryDtoPopulated = CategoryDTO.builder()
					.description(RandomStringUtils.randomAlphabetic(10))
					.type(RandomUtils.nextInt(10, 100))
					.nature(RandomUtils.nextInt(10, 100))
					.build();

			@Test
			@DisplayName("When get same value for category")
			void testGetSameValue() {
				final PaymentDTO expectModel = PaymentDTO.builder()
						.category(categoryDtoPopulated)
						.build();

				final PaymentDTO actualModel = PaymentDTO.builder()
						.category(expectModel.getCategory())
						.build();

				assertThat(actualModel.getCategory())
					.isNotNull()
					.isEqualTo(expectModel.getCategory());
			}

			@Test
			@DisplayName("When set null value")
			void testSetNullvalue() {
				final PaymentDTO expectModel = PaymentDTO.builder()
						.category(null)
						.build();

				PaymentDTO actualModel = new PaymentDTO();
				actualModel.setCategory(expectModel.getCategory());

				thenSameModel(actualModel, expectModel);
			}

			@Test
			@DisplayName("When set some valid value")
			void testSetSomeValue() {
				final PaymentDTO expectModel = PaymentDTO.builder()
						.category(categoryDtoPopulated)
						.build();

				PaymentDTO actualModel = new PaymentDTO();
				actualModel.setCategory(expectModel.getCategory());

				thenSameModel(actualModel, expectModel);
			}

			@Test
			@DisplayName("When build with null value")
			void testBuildNullValue() {
				final PaymentDTO expectModel = PaymentDTO.builder()
						.category(categoryDtoPopulated)
						.build();

				final PaymentDTO actualModel = PaymentDTO.builder()
						.category(expectModel.getCategory())
						.build();

				thenSameModel(actualModel, expectModel);
			}

			@Test
			@DisplayName("When build with some valid value")
			void testBuildSomeValue() {
				final PaymentDTO expectModel = PaymentDTO.builder()
						.category(categoryDtoPopulated)
						.build();

				final PaymentDTO actualModel = PaymentDTO.builder()
						.category(expectModel.getCategory())
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
	private static void thenSameModel(final PaymentDTO actual, final PaymentDTO expect) {
		assertThat(actual).satisfies(dto -> {
			assertThat(dto.getDescription()).isEqualTo(expect.getDescription());
			assertThat(dto.getPeriod()).isEqualTo(expect.getPeriod());
			assertThat(dto.getQuantity()).isEqualTo(expect.getQuantity());
			assertThat(dto.getCategory()).isEqualTo(expect.getCategory());
		});
	}
}
