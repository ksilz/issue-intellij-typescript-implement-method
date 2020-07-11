package com.betterprojectsfaster.talks.openj9memory.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.betterprojectsfaster.talks.openj9memory.web.rest.TestUtil;

public class ShoppingOrderTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(ShoppingOrder.class);
        ShoppingOrder shoppingOrder1 = new ShoppingOrder();
        shoppingOrder1.setId(1L);
        ShoppingOrder shoppingOrder2 = new ShoppingOrder();
        shoppingOrder2.setId(shoppingOrder1.getId());
        assertThat(shoppingOrder1).isEqualTo(shoppingOrder2);
        shoppingOrder2.setId(2L);
        assertThat(shoppingOrder1).isNotEqualTo(shoppingOrder2);
        shoppingOrder1.setId(null);
        assertThat(shoppingOrder1).isNotEqualTo(shoppingOrder2);
    }
}
