package br.com.eudio.apigateway.controller;

import br.com.eudio.apigateway.convertes.NumberConverter;
import br.com.eudio.apigateway.exceptions.UnsupportedMathOperationException;
import br.com.eudio.apigateway.math.SimpleMath;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

import static org.apache.tomcat.util.http.parser.HttpParser.isNumeric;

@RestController
public class MathController {

    private static final String template = " hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    private SimpleMath math = new SimpleMath();


    @RequestMapping(value = "/sum/{numberOne}/{numberTwo}",
            method = RequestMethod.GET)
    public Double sum(
            @PathVariable(value = "numberOne")String numberOne,
            @PathVariable(value = "numberTwo")String numberTwo
    ) throws Exception {
        if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)){
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        return math.sum( NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo)) ;
    }

    @RequestMapping(value = "/sub/{numberOne}/{numberTwo}",
            method = RequestMethod.GET)
    public Double sub(
            @PathVariable(value = "numberOne")String numberOne,
            @PathVariable(value = "numberTwo")String numberTwo
    ) throws Exception {
        if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)){
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        return math.sub(NumberConverter.convertToDouble(numberOne) , NumberConverter.convertToDouble(numberTwo)) ;
    }

    @RequestMapping(value = "/mult/{numberOne}/{numberTwo}",
            method = RequestMethod.GET)
    public Double mult(
            @PathVariable(value = "numberOne")String numberOne,
            @PathVariable(value = "numberTwo")String numberTwo
    ) throws Exception {
        if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)){
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        return math.mult( NumberConverter.convertToDouble(numberOne) , NumberConverter.convertToDouble(numberTwo)) ;
    }

    @RequestMapping(value = "/med/{numberOne}/{numberTwo}",
            method = RequestMethod.GET)
    public Double med(
            @PathVariable(value = "numberOne")String numberOne,
            @PathVariable(value = "numberTwo")String numberTwo
    ) throws Exception {
        if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)){
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        return math.med(NumberConverter.convertToDouble(numberOne) , NumberConverter.convertToDouble(numberTwo)) ;
    }

    @RequestMapping(value = "/sqrt/{numberOne}",
            method = RequestMethod.GET)
    public Double sqrt(
            @PathVariable(value = "numberOne")String numberOne

    ) throws Exception {
        if(!NumberConverter.isNumeric(numberOne) ){
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        return math.sqrt(NumberConverter.convertToDouble(numberOne)) ;
    }

}
