package com.github.austinmckinley;

import org.junit.Test;
import org.springframework.http.HttpStatus;

import static org.junit.Assert.*;

public class CardValidationControllerTest {
    @Test
    public void foo() throws Exception {
        CardValidationController controller = new CardValidationController();

        assertEquals(controller.validateCard(new CardRequest("4485286850676868")).getStatusCode(), HttpStatus.OK);
        assertEquals(controller.validateCard(new CardRequest("377495863040587")).getStatusCode(), HttpStatus.OK);
        assertEquals(controller.validateCard(new CardRequest("5275189262247602")).getStatusCode(), HttpStatus.OK);
        assertEquals(controller.validateCard(new CardRequest("6011604555006546")).getStatusCode(), HttpStatus.OK);

        assertEquals(controller.validateCard(new CardRequest("6111604555006546")).getStatusCode(), HttpStatus.BAD_REQUEST);
        assertEquals(controller.validateCard(new CardRequest("4485286853676868")).getStatusCode(), HttpStatus.BAD_REQUEST);
        assertEquals(controller.validateCard(new CardRequest("448528T853676868")).getStatusCode(), HttpStatus.BAD_REQUEST);
    }

    @Test
    public void bar() {
        CardValidationController controller = new CardValidationController();
        System.out.println(controller.getSum("4485286850676868") * 9);
    }
}