package br.com.eudio.apigateway.controller;

import br.com.eudio.apigateway.exceptions.UnsupportedMathOperationException;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

import static org.apache.tomcat.util.http.parser.HttpParser.isNumeric;

@RestController
public class MathController {

    private static final String template = " hello, %s!";
    private final AtomicLong counter = new AtomicLong();


    @RequestMapping(value = "/sum/{numberOne}/{numberTwo}",
            method = RequestMethod.GET)
    public Double sum(
            @PathVariable(value = "numberOne")String numberOne,
            @PathVariable(value = "numberTwo")String numberTwo
    ) throws Exception {
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)){
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        return convertToDouble(numberOne) + convertToDouble(numberTwo) ;
    }

    @RequestMapping(value = "/sub/{numberOne}/{numberTwo}",
            method = RequestMethod.GET)
    public Double sub(
            @PathVariable(value = "numberOne")String numberOne,
            @PathVariable(value = "numberTwo")String numberTwo
    ) throws Exception {
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)){
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        return convertToDouble(numberOne) - convertToDouble(numberTwo) ;
    }

    @RequestMapping(value = "/mult/{numberOne}/{numberTwo}",
            method = RequestMethod.GET)
    public Double mult(
            @PathVariable(value = "numberOne")String numberOne,
            @PathVariable(value = "numberTwo")String numberTwo
    ) throws Exception {
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)){
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        return convertToDouble(numberOne) * convertToDouble(numberTwo) ;
    }

    @RequestMapping(value = "/med/{numberOne}/{numberTwo}",
            method = RequestMethod.GET)
    public Double med(
            @PathVariable(value = "numberOne")String numberOne,
            @PathVariable(value = "numberTwo")String numberTwo
    ) throws Exception {
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)){
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        return (convertToDouble(numberOne) + convertToDouble(numberTwo)) / 2 ;
    }

    @RequestMapping(value = "/sqrt/{numberOne}",
            method = RequestMethod.GET)
    public Double sqrt(
            @PathVariable(value = "numberOne")String numberOne

    ) throws Exception {
        if(!isNumeric(numberOne) ){
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        return Math.sqrt(convertToDouble(numberOne)) ;
    }

    private Double convertToDouble(String Strnumber) {
        if(Strnumber == null) return 0D;
        String number = Strnumber.replaceAll(",",".");
        if (isNumeric(number)) return Double.parseDouble(number);
        return 0D;
    }

    private boolean isNumeric(String Strnumber) {
        if(Strnumber == null) return false;
        String number = Strnumber.replaceAll(",",".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }


}
