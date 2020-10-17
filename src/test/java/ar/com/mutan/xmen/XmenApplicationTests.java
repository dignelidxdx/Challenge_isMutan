package ar.com.mutan.xmen;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import ar.com.mutan.xmen.services.MutantService;

@SpringBootTest
class XmenApplicationTests {

	@Autowired
	MutantService mutantService;

	@Test
	void contextLoads() {
	}
	@Test
	void ADN_isValid() {

	}
	@Test
	void ADN_isMutant() {
		String[] dnaMutant = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};							

		System.out.println("************");
		System.out.println("Testing Mutants ");
		System.out.println("************");
		assertTrue(mutantService.isMutant(dnaMutant));


		String[] dnaMutant2 = {"AAAAAA","CAGTAC","TTATGT","AGAAGG","CACCTA","TCACTG"};							

		System.out.println("************");
		System.out.println("Testing Mutants 2 secuences");
		System.out.println("************");
		assertTrue(mutantService.isMutant(dnaMutant2));

	}

	@Test
	void ADN_isHuman() {
		String[] dnaMutant = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCTTA","TCACTG"};							

		System.out.println("************");
		System.out.println("Testing Human");
		System.out.println("************");

		assertFalse(mutantService.isMutant(dnaMutant));
	}

}
