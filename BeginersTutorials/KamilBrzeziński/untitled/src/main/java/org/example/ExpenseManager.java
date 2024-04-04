package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExpenseManager {
    List<Expense> expenses = new ArrayList<>();

    public void displayAllExpenses() {
        expenses.forEach(ExpenseManager::displayExpense);
    }

    private static void displayExpense(Expense expense) {
        System.out.println("______________________________________________________");
        System.out.println("Description: " + expense.description());
        System.out.println("Type: " + expense.type());
        System.out.println("Value: " + expense.value());
        System.out.println("Month: " + expense.month());
        System.out.println("------------------------------------------------------");
    }

    public void displayMonthlyExpenses(Scanner scanner) {
        System.out.println("Month: ");
        int month = Integer.parseInt(scanner.nextLine());

        expenses.stream()
                .filter(expense -> expense.month() == month)
                .forEach(ExpenseManager::displayExpense);
    }

    public void addExpense(Scanner scanner) {
        System.out.println("Description: ");
        String description = scanner.nextLine();
        System.out.println("Type: ");
        String type = scanner.nextLine();
        System.out.println("Value: ");
        double value = Double.parseDouble(scanner.nextLine());
        System.out.println("Month: ");
        int month = Integer.parseInt(scanner.nextLine());

        Expense expense = new Expense(type, month, value, description);
        expenses.add(expense);
    }
}
