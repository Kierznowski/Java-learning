package org.example;

import java.util.Scanner;

public class ExpensesApp {
    public void run() {

        Scanner scanner = new Scanner(System.in);
        ExpenseManager expenseManager = new ExpenseManager();

        while(true) {
            System.out.println("1. Show all expenses");
            System.out.println("2. Show expenses from given month");
            System.out.println("3. Add expense");
            System.out.println("4. Quit");
            System.out.println("Choose option: ");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1 -> expenseManager.displayAllExpenses();
                case 2 -> expenseManager.displayMonthlyExpenses(scanner);
                case 3 -> expenseManager.addExpense(scanner);
                case 4 -> {
                    scanner.close();
                    System.exit(0);
                }
            }
        }

    }
}
