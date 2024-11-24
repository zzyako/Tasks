package services;

import exceptions.CustomCheckedException;

public class CheckedExceptionService {
    public String performOperation(String input) {
        try {
            if (input == null) {
                throw new CustomCheckedException("Входные данные не должны быть null");
            }
            return "Введено: " + input;
        } catch (CustomCheckedException e) {
            System.out.println("Исключение обработано: " + e.getMessage());
            return "Ошибка обработки ввода";
        } finally {
            System.out.println("Выполнение блока finally");
        }
    }
}
