package tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import services.CheckedExceptionService;

public class CheckedExceptionServiceTest {

    private CheckedExceptionService service;

    @Before
    public void setUp() {
        service = new CheckedExceptionService();
    }

    @Test
    public void testPerformOperation_ValidInput() {
        String input = "Тестовое значение";
        String expected = "Введено: " + input;
        String actual = service.performOperation(input);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testPerformOperation_NullInput() {
        String actual = service.performOperation(null);
        String expected = "Ошибка обработки ввода";
        Assert.assertEquals(expected, actual);
    }
}
