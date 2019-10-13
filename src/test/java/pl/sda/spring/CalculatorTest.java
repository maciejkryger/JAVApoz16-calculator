package pl.sda.spring;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.sda.spring.operation.OperationType;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
public class CalculatorTest {

    @Autowired
    private Calculator calculator;

    @Test
    public void shouldReturnFiveForGivenArgumentsOnAdditionOperation() {
        //given
        double arg1 = 2.0;
        double arg2 = 3.0;

        //when
        double actual = calculator.calculate(OperationType.ADDITION, arg1, arg2);

        //then
        Assert.assertEquals(5.0, actual, 0.00000001);
    }

    @Test
    public void shouldReturnOneForGivenArgumentsOnSUBTRACTIONOperation(){
        //given
        double x = 3;
        double y = 2;

        //when
        double actual = calculator.calculate(OperationType.SUBTRACTION, x, y);

        //then
        Assert.assertEquals(1,actual,0.000000001);
    }

    @Test
    public void shouldReturnSixForGivenArgumentOnMultiplicationOperation(){

        //given
        double x = 3;
        double y = 2;

        //when
        double actual = calculator.calculate(OperationType.MULTIPLICATION,x,y);

        //then
        Assert.assertEquals(6,actual,0.000000001);

    }


    @Test
    public void shouldReturnThreeForGivenArgumentOnDivisionOperation(){

        //given
        double x = 6;
        double y = 2;

        //when
        double actual = calculator.calculate(OperationType.DIVISION,x,y);

        //then
        Assert.assertEquals(3,actual,0.000000001);

    }

    @Test(expected = RuntimeException.class)
    public void shouldReturnExceptionForGivenArgumentOnDivisionOperation(){

        //given
        double x = 6;
        double y = 0;

        //when
        double actual = calculator.calculate(OperationType.DIVISION,x,y);
    }

    @Test
    public void shouldReturnTenForGivenArgumentOnDivisionOperation(){

        //given
        double x = 100;
        double y = 10;

        //when
        double actual = calculator.calculate(OperationType.PERCENTAGE,x,y);

        //then
        Assert.assertEquals(10,actual,0.000000001);
    }

    @Test
    public void shouldReturnTwentyFiveForGivenArgumentOnPowerOperation(){

        //given
        double x = 5;
        double y = 3;

        //when
        double actual = calculator.calculate(OperationType.POWER,x,y);

        //then
        Assert.assertEquals(125,actual,0.000000001);
    }


    @Test
    public void shouldReturnOneForGivenArgumentOnPowerOperation(){

        //given
        double x = 5;
        double y = 0;

        //when
        double actual = calculator.calculate(OperationType.POWER,x,y);

        //then
        Assert.assertEquals(1,actual,0.000000001);
    }


}
