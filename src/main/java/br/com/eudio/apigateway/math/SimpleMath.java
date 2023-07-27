package br.com.eudio.apigateway.math;

import br.com.eudio.apigateway.convertes.NumberConverter;
import br.com.eudio.apigateway.exceptions.UnsupportedMathOperationException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class SimpleMath {


    public Double sum(Double numberOne, Double numberTwo){
        return numberOne + numberTwo ;
    }


    public Double sub(Double numberOne, Double numberTwo){
        return numberOne - numberTwo ;
    }


    public Double mult(
 Double numberOne,
Double numberTwo){

        return numberOne * numberTwo ;
    }


    public Double med(
         Double numberOne,
         Double numberTwo
    )  {

        return (numberOne + numberTwo) / 2 ;
    }


    public Double sqrt(Double numberOne)  {
        return Math.sqrt(numberOne);
    }

}
