package services;

import exceptions.CustomUncheckedException;

public class UncheckedExceptionService {
    public void performOperation(boolean shouldThrow) {
        if (shouldThrow) {
            throw new CustomUncheckedException("Непроверяемое исключение произошло");
        }
    }
}
