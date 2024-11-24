package tests;

import exceptions.CustomUncheckedException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import services.UncheckedExceptionService;

public class UncheckedExceptionServiceTest {

    private UncheckedExceptionService service;

    @Before
    public void setUp() {
        service = new UncheckedExceptionService();
    }
    @Test
    public void testPerformOperation_NoException() {
        try {
            service.performOperation(false);
        } catch (CustomUncheckedException e) {
            Assert.fail("Не ожидалось исключение, но оно было выброшено");
        }
    }
    @Test(expected = CustomUncheckedException.class)
    public void testPerformOperation_WithException() {
        service.performOperation(true);
    }
}
