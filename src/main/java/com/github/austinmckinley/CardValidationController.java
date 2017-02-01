package com.github.austinmckinley;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CardValidationController {

    @Autowired
    public CardValidationController() {

    }

    @RequestMapping(value = "/validate", method = RequestMethod.POST)
    public ResponseEntity<String> validateCard(@RequestBody CardRequest cardRequest) {
        if (validate(cardRequest.getCardNumber())) {
            return ResponseEntity.ok("YES");
        } else {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    // Alt method
    public boolean validate(String cardNumber) {
        char[] chars = cardNumber.toCharArray();

        if (chars.length > 16 || chars.length < 15) {
            return false;
        }

        int checkDigit = getSum(cardNumber) * 9 % 10;
        return checkDigit == Character.getNumericValue(chars[chars.length - 1]);
    }

    public int getSum(String cardNumber) {
        int sum = 0;
        boolean superDigit = true;
        char[] chars = cardNumber.toCharArray();

        for (int i = chars.length - 2; i >= 0; i--) {
            if (superDigit) {
                int temp = Character.getNumericValue(chars[i]) * 2;
                if (temp > 9) {
                    sum += temp % 10;
                    sum += 1;
                } else {
                    sum += temp;
                }
            } else {
                sum += Character.getNumericValue(chars[i]);
            }
            superDigit = !superDigit;
        }
        return sum;
    }
}
