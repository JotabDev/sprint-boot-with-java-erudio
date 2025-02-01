package com.br.jotab;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping()
public class MathController {


	 @GetMapping("/sum/{numberOne}/{numberTwo}")
	    public Double sum(
	            @PathVariable(value = "numberOne") String numberOne,
	            @PathVariable(value = "numberTwo") String numberTwo) {
	        
	        if (!isNumber(numberOne) || !isNumber(numberTwo)) {
	            throw new IllegalArgumentException("Invalid input: both parameters must be numbers.");
	        }
	        
	        return convertToDouble(numberOne) + convertToDouble(numberTwo);
	    }

	    private Double convertToDouble(String strNumber) {
	        if (strNumber == null) return 0D;
	        String number = strNumber.replaceAll(",", ".");
	        if (isNumber(number)) return Double.parseDouble(number);
	        return 0D;
	    }

	    private boolean isNumber(String strNumber) {
	        if (strNumber == null) return false;
	        String number = strNumber.replaceAll(",", ".");
	        return number.matches("[-+]?\\d+(\\.\\d+)?");
	    }
	
}