package com.qa.spring.domain;


import org.junit.Test;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

public class ProductTest {
	@Test
	public void testEquals() {
		EqualsVerifier.forClass(Product.class)
		.suppress(Warning.NONFINAL_FIELDS)
		.usingGetClass()
		.verify();
	}

}
