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
 * Unit Test Class for data structure interface {@link UserDTO#UserDTO DTO}.
 */
@DisplayName("A User Data Transfer Object")
@TestMethodOrder(MethodName.class)
class UserDTOTest {

	@Nested
	@DisplayName("For Contructor")
	class testConstructor {

		@Test
		@DisplayName("When all arguments")
		void testAllArguments() {
			final UserDTO expectModel = UserDTO.builder()
					.name(RandomStringUtils.randomAlphabetic(10))
					.surname(RandomStringUtils.randomAlphabetic(10))
					.email(RandomStringUtils.randomAlphabetic(10))
					.password(RandomStringUtils.randomAlphabetic(10))
					.porcentPaymentPersonal(RandomUtils.nextInt(10, 100))
					.porcentPaymentPermanent(RandomUtils.nextInt(10, 100))
					.porcentSaving(RandomUtils.nextInt(10, 100))
					.build();

			final UserDTO actualModel = new UserDTO(
					expectModel.getName(),
					expectModel.getSurname(),
					expectModel.getEmail(),
					expectModel.getPassword(),
					expectModel.getPorcentPaymentPersonal(),
					expectModel.getPorcentPaymentPermanent(),
					expectModel.getPorcentSaving());

			thenSameModel(actualModel, expectModel);
		}

		@Test
		@DisplayName("When no argument")
		void testNoArgument() {
			final UserDTO expectModel = UserDTO.builder().build();

			final UserDTO actualModel = new UserDTO();

			thenSameModel(actualModel, expectModel);
		}
	}

	@Nested
	@DisplayName("For toString")
	class testToString {

		@Test
		@DisplayName("When existing object instance")
		void testDefault() {
			final String actualStringModel = UserDTO.builder()
					.name(RandomStringUtils.randomAlphabetic(10))
					.surname(RandomStringUtils.randomAlphabetic(10))
					.email(RandomStringUtils.randomAlphabetic(10))
					.password(RandomStringUtils.randomAlphabetic(10))
					.porcentPaymentPersonal(RandomUtils.nextInt(10, 100))
					.porcentPaymentPermanent(RandomUtils.nextInt(10, 100))
					.porcentSaving(RandomUtils.nextInt(10, 100))
					.toString();

			assertThat(actualStringModel).isNotEmpty();
		}
	}

	@Nested
	@DisplayName("For field")
	class testField {

		@Nested
		@TestMethodOrder(MethodName.class)
		@DisplayName("Name")
		class testNameField {

			@Test
			@DisplayName("When get same value for name")
			void testGetSameValue() {
				final UserDTO expectModel = UserDTO.builder()
						.name(RandomStringUtils.randomAlphanumeric(10))
						.build();

				final UserDTO actualModel = UserDTO.builder()
						.name(expectModel.getName())
						.build();

				assertThat(actualModel.getName())
					.isNotEmpty()
					.isEqualTo(expectModel.getName());
			}

			@Test
			@DisplayName("When set null value")
			void testSetNullValue() {
				final UserDTO expectModel = UserDTO.builder()
						.name(null)
						.build();

				UserDTO actualModel = new UserDTO();
				actualModel.setName(expectModel.getName());

				thenSameModel(actualModel, expectModel);
			}

			@Test
			@DisplayName("When set some valid value")
			void testSetSomeValue() {
				final UserDTO expectModel = UserDTO.builder()
						.name(RandomStringUtils.randomAlphanumeric(10))
						.build();

				UserDTO actualModel = new UserDTO();
				actualModel.setName(expectModel.getName());

				thenSameModel(actualModel, expectModel);
			}

			@Test
			@DisplayName("When build with null value")
			void testBuildNullValue() {
				final UserDTO expectModel = UserDTO.builder()
						.name(null)
						.build();

				final UserDTO actualModel = UserDTO.builder()
						.name(expectModel.getName())
						.build();

				thenSameModel(actualModel, expectModel);
			}

			@Test
			@DisplayName("When build with some valid value")
			void testBuildSomeValue() {
				final UserDTO expectModel = UserDTO.builder()
						.name(RandomStringUtils.randomAlphanumeric(10))
						.build();

				final UserDTO actualModel = UserDTO.builder()
						.name(expectModel.getName())
						.build();

				thenSameModel(actualModel, expectModel);
			}
		}

		@Nested
		@TestMethodOrder(MethodName.class)
		@DisplayName("Surname")
		class testSurnameField {

			@Test
			@DisplayName("When get same value for surname")
			void testGetSameValue() {
				final UserDTO expectModel = UserDTO.builder()
						.surname(RandomStringUtils.randomAlphanumeric(10))
						.build();

				final UserDTO actualModel = UserDTO.builder()
						.surname(expectModel.getSurname())
						.build();

				assertThat(actualModel.getSurname())
					.isNotEmpty()
					.isEqualTo(expectModel.getSurname());
			}

			@Test
			@DisplayName("When set null value")
			void testSetNullValue() {
				final UserDTO expectModel = UserDTO.builder()
						.surname(null)
						.build();

				UserDTO actualModel = new UserDTO();
				actualModel.setSurname(expectModel.getSurname());

				thenSameModel(actualModel, expectModel);
			}

			@Test
			@DisplayName("When set some valid value")
			void testSetSomeValue() {
				final UserDTO expectModel = UserDTO.builder()
						.surname(RandomStringUtils.randomAlphanumeric(10))
						.build();

				UserDTO actualModel = new UserDTO();
				actualModel.setSurname(expectModel.getSurname());

				thenSameModel(actualModel, expectModel);
			}

			@Test
			@DisplayName("When build with null value")
			void testBuildNullValue() {
				final UserDTO expectModel = UserDTO.builder()
						.surname(null)
						.build();

				final UserDTO actualModel = UserDTO.builder()
						.surname(expectModel.getSurname())
						.build();

				thenSameModel(actualModel, expectModel);
			}

			@Test
			@DisplayName("When build with some valid value")
			void testBuildSomeValue() {
				final UserDTO expectModel = UserDTO.builder()
						.surname(RandomStringUtils.randomAlphanumeric(10))
						.build();

				final UserDTO actualModel = UserDTO.builder()
						.surname(expectModel.getSurname())
						.build();

				thenSameModel(actualModel, expectModel);
			}
		}

		@Nested
		@TestMethodOrder(MethodName.class)
		@DisplayName("Email")
		class testEmailField {

			@Test
			@DisplayName("When get same value for email")
			void testGetSameValue() {
				final UserDTO expectModel = UserDTO.builder()
						.email(RandomStringUtils.randomAlphanumeric(10))
						.build();

				final UserDTO actualModel = UserDTO.builder()
						.email(expectModel.getEmail())
						.build();

				assertThat(actualModel.getEmail())
					.isNotEmpty()
					.isEqualTo(expectModel.getEmail());
			}

			@Test
			@DisplayName("When set null value")
			void testSetNullValue() {
				final UserDTO expectModel = UserDTO.builder()
						.email(null)
						.build();

				UserDTO actualModel = new UserDTO();
				actualModel.setEmail(expectModel.getEmail());

				thenSameModel(actualModel, expectModel);
			}

			@Test
			@DisplayName("When set some valid value")
			void testSetSomeValue() {
				final UserDTO expectModel = UserDTO.builder()
						.email(RandomStringUtils.randomAlphanumeric(10))
						.build();

				UserDTO actualModel = new UserDTO();
				actualModel.setEmail(expectModel.getEmail());

				thenSameModel(actualModel, expectModel);
			}

			@Test
			@DisplayName("When build with null value")
			void testBuildNullValue() {
				final UserDTO expectModel = UserDTO.builder()
						.email(null)
						.build();

				final UserDTO actualModel = UserDTO.builder()
						.email(expectModel.getEmail())
						.build();

				thenSameModel(actualModel, expectModel);
			}

			@Test
			@DisplayName("When build with some valid value")
			void testBuildSomeValue() {
				final UserDTO expectModel = UserDTO.builder()
						.email(RandomStringUtils.randomAlphanumeric(10))
						.build();

				final UserDTO actualModel = UserDTO.builder()
						.email(expectModel.getEmail())
						.build();

				thenSameModel(actualModel, expectModel);
			}
		}

		@Nested
		@TestMethodOrder(MethodName.class)
		@DisplayName("Password")
		class testPasswordField {

			@Test
			@DisplayName("When get same value for password")
			void testGetSameValue() {
				final UserDTO expectModel = UserDTO.builder()
						.password(RandomStringUtils.randomAlphanumeric(10))
						.build();

				final UserDTO actualModel = UserDTO.builder()
						.password(expectModel.getPassword())
						.build();

				assertThat(actualModel.getPassword())
					.isNotEmpty()
					.isEqualTo(expectModel.getPassword());
			}

			@Test
			@DisplayName("When set null value")
			void testSetNullValue() {
				final UserDTO expectModel = UserDTO.builder()
						.password(null)
						.build();

				UserDTO actualModel = new UserDTO();
				actualModel.setPassword(expectModel.getPassword());

				thenSameModel(actualModel, expectModel);
			}

			@Test
			@DisplayName("When set some valid value")
			void testSetSomeValue() {
				final UserDTO expectModel = UserDTO.builder()
						.password(RandomStringUtils.randomAlphanumeric(10))
						.build();

				UserDTO actualModel = new UserDTO();
				actualModel.setPassword(expectModel.getPassword());

				thenSameModel(actualModel, expectModel);
			}

			@Test
			@DisplayName("When build with null value")
			void testBuildNullValue() {
				final UserDTO expectModel = UserDTO.builder()
						.password(null)
						.build();

				final UserDTO actualModel = UserDTO.builder()
						.password(expectModel.getPassword())
						.build();

				thenSameModel(actualModel, expectModel);
			}

			@Test
			@DisplayName("When build with some valid value")
			void testBuildSomeValue() {
				final UserDTO expectModel = UserDTO.builder()
						.password(RandomStringUtils.randomAlphanumeric(10))
						.build();

				final UserDTO actualModel = UserDTO.builder()
						.password(expectModel.getPassword())
						.build();

				thenSameModel(actualModel, expectModel);
			}
		}

		@Nested
		@TestMethodOrder(MethodName.class)
		@DisplayName("PorcentPaymentPersonal")
		class testPorcentPaymentPersonalField {

			@Test
			@DisplayName("When get same value for porcent payment personal")
			void testGetSameValue() {
				final int expectFieldValue = 7;

				final UserDTO actualModel = UserDTO.builder()
						.porcentPaymentPersonal(expectFieldValue)
						.build();

				assertThat(actualModel.getPorcentPaymentPersonal())
					.isNotZero()
					.isNotNegative()
					.isEqualTo(expectFieldValue);
			}

			@Test
			@DisplayName("When set null value")
			void testSetNullvalue() {
				final UserDTO expectModel = UserDTO.builder()
						.porcentPaymentPersonal(null)
						.build();

				UserDTO actualModel = new UserDTO();
				actualModel.setPorcentPaymentPersonal(expectModel.getPorcentPaymentPersonal());

				thenSameModel(actualModel, expectModel);
			}

			@Test
			@DisplayName("When set some valid value")
			void testSetSomeValue() {
				final UserDTO expectModel = UserDTO.builder()
						.porcentPaymentPersonal(RandomUtils.nextInt(10, 100))
						.build();

				UserDTO actualModel = new UserDTO();
				actualModel.setPorcentPaymentPersonal(expectModel.getPorcentPaymentPersonal());

				thenSameModel(actualModel, expectModel);
			}

			@Test
			@DisplayName("When build with null value")
			void testBuildNullValue() {
				final UserDTO expectModel = UserDTO.builder()
						.porcentPaymentPersonal(null)
						.build();

				final UserDTO actualModel = UserDTO.builder()
						.porcentPaymentPersonal(expectModel.getPorcentPaymentPersonal())
						.build();

				thenSameModel(actualModel, expectModel);
			}

			@Test
			@DisplayName("When build with some valid value")
			void testBuildSomeValue() {
				final UserDTO expectModel = UserDTO.builder()
						.porcentPaymentPersonal(RandomUtils.nextInt(10, 100))
						.build();

				final UserDTO actualModel = UserDTO.builder()
						.porcentPaymentPersonal(expectModel.getPorcentPaymentPersonal())
						.build();

				thenSameModel(actualModel, expectModel);
			}
		}

		@Nested
		@TestMethodOrder(MethodName.class)
		@DisplayName("PorcentPaymentPermanent")
		class testPorcentPaymentPermanentField {

			@Test
			@DisplayName("When get same value for porcent payment permanent")
			void testGetSameValue() {
				final int expectFieldValue = 7;

				final UserDTO actualModel = UserDTO.builder()
						.porcentPaymentPermanent(expectFieldValue)
						.build();

				assertThat(actualModel.getPorcentPaymentPermanent())
					.isNotZero()
					.isNotNegative()
					.isEqualTo(expectFieldValue);
			}

			@Test
			@DisplayName("When set null value")
			void testSetNullvalue() {
				final UserDTO expectModel = UserDTO.builder()
						.porcentPaymentPermanent(null)
						.build();

				UserDTO actualModel = new UserDTO();
				actualModel.setPorcentPaymentPermanent(expectModel.getPorcentPaymentPermanent());

				thenSameModel(actualModel, expectModel);
			}

			@Test
			@DisplayName("When set some valid value")
			void testSetSomeValue() {
				final UserDTO expectModel = UserDTO.builder()
						.porcentPaymentPermanent(RandomUtils.nextInt(10, 100))
						.build();

				UserDTO actualModel = new UserDTO();
				actualModel.setPorcentPaymentPermanent(expectModel.getPorcentPaymentPermanent());

				thenSameModel(actualModel, expectModel);
			}

			@Test
			@DisplayName("When build with null value")
			void testBuildNullValue() {
				final UserDTO expectModel = UserDTO.builder()
						.porcentPaymentPermanent(null)
						.build();

				final UserDTO actualModel = UserDTO.builder()
						.porcentPaymentPermanent(expectModel.getPorcentPaymentPermanent())
						.build();

				thenSameModel(actualModel, expectModel);
			}

			@Test
			@DisplayName("When build with some valid value")
			void testBuildSomeValue() {
				final UserDTO expectModel = UserDTO.builder()
						.porcentPaymentPermanent(RandomUtils.nextInt(10, 100))
						.build();

				final UserDTO actualModel = UserDTO.builder()
						.porcentPaymentPermanent(expectModel.getPorcentPaymentPermanent())
						.build();

				thenSameModel(actualModel, expectModel);
			}
		}

		@Nested
		@TestMethodOrder(MethodName.class)
		@DisplayName("PorcentSaving")
		class testPorcentSavingField {

			@Test
			@DisplayName("When get same value for pocent saving")
			void testGetSameValue() {
				final int expectFieldValue = 7;

				final UserDTO actualModel = UserDTO.builder()
						.porcentSaving(expectFieldValue)
						.build();

				assertThat(actualModel.getPorcentSaving())
					.isNotZero()
					.isNotNegative()
					.isEqualTo(expectFieldValue);
			}

			@Test
			@DisplayName("When set null value")
			void testSetNullvalue() {
				final UserDTO expectModel = UserDTO.builder()
						.porcentSaving(null)
						.build();

				UserDTO actualModel = new UserDTO();
				actualModel.setPorcentSaving(expectModel.getPorcentSaving());

				thenSameModel(actualModel, expectModel);
			}

			@Test
			@DisplayName("When set some valid value")
			void testSetSomeValue() {
				final UserDTO expectModel = UserDTO.builder()
						.porcentSaving(RandomUtils.nextInt(10, 100))
						.build();

				UserDTO actualModel = new UserDTO();
				actualModel.setPorcentSaving(expectModel.getPorcentSaving());

				thenSameModel(actualModel, expectModel);
			}

			@Test
			@DisplayName("When build with null value")
			void testBuildNullValue() {
				final UserDTO expectModel = UserDTO.builder()
						.porcentSaving(null)
						.build();

				final UserDTO actualModel = UserDTO.builder()
						.porcentSaving(expectModel.getPorcentSaving())
						.build();

				thenSameModel(actualModel, expectModel);
			}

			@Test
			@DisplayName("When build with some valid value")
			void testBuildSomeValue() {
				final UserDTO expectModel = UserDTO.builder()
						.porcentSaving(RandomUtils.nextInt(10, 100))
						.build();

				final UserDTO actualModel = UserDTO.builder()
						.porcentSaving(expectModel.getPorcentSaving())
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
	private static void thenSameModel(final UserDTO actual, final UserDTO expect) {
		assertThat(actual).satisfies(dto -> {
			assertThat(dto.getName()).isEqualTo(expect.getName());
			assertThat(dto.getSurname()).isEqualTo(expect.getSurname());
			assertThat(dto.getEmail()).isEqualTo(expect.getEmail());
			assertThat(dto.getPassword()).isEqualTo(expect.getPassword());
			assertThat(dto.getPorcentPaymentPersonal()).isEqualTo(expect.getPorcentPaymentPersonal());
			assertThat(dto.getPorcentPaymentPermanent()).isEqualTo(expect.getPorcentPaymentPermanent());
			assertThat(dto.getPorcentSaving()).isEqualTo(expect.getPorcentSaving());
		});
	}
}
