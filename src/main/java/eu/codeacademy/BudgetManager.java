package eu.codeacademy;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class BudgetManager {
    public static void run() {
        Budget budget = new Budget();
        File file = new File();
        Scanner sc = new Scanner(System.in);
        String input = "";

        while (!input.equals("9")) {
            menu();
            input = sc.nextLine();
            switch (input) {
                case "1": {
                    //ivesti pajamas
                    System.out.println("Iveskite pajamu suma");
                    try {
                        float sum = sc.nextFloat();
                        System.out.println("Iveskite kategorija");
                        sc.nextLine();
                        String category = sc.nextLine();
                        System.out.println("Iveskite pajamu tipa");
                        String incomeType = sc.nextLine();
                        System.out.println("Iveskite papildoma informacija");
                        String bonusInfo = sc.nextLine();
                        IncomeData incomeData = new IncomeData(sum, bonusInfo, category, incomeType);
                        budget.addRecord(incomeData);
                    } catch (InputMismatchException nfe){
                        System.out.println("Neteisinga ivestis");
                    }
                }
                break;
                case "2": {
                    //ivesti islaidas
                    try {
                        System.out.println("Iveskite pajamu suma");
                        float sum = sc.nextFloat();
                        System.out.println("Iveskite islaidu kategorija");
                        sc.nextLine();
                        String category = sc.nextLine();
                        System.out.println("Iveskite mokejimo metoda");
                        String paymentMethod = sc.nextLine();
                        System.out.println("Iveskite papildoma informacija");
                        String bonusInfo = sc.nextLine();
                        SpendingData spendingData = new SpendingData(sum, bonusInfo, category, paymentMethod);
                        budget.addRecord(spendingData);
                    }  catch (InputMismatchException nfe){
                        System.out.println("Neteisinga ivestis");
                    }
                }
                break;
                case "3": {
                    List<IncomeData> income = budget.getIncome();
                    for (IncomeData incomeData : income) {
                        System.out.println(incomeData.toString());
                    }
                }
                break;
                case "4": {
                    List<SpendingData> expenditures = budget.getExpenditures();
                    for (SpendingData expenses : expenditures) {
                        System.out.println(expenses.toString());
                    }
                }
                break;
                case "5": {
                    System.out.println(budget.gautiBalansa());
                }
                break;
                case "6": {
                    input = EdditingMenu.editARecord(budget);
                }
                    break;
                case "7" : {
                    budget.setRecords(file.getRecordsFromFile());
                }
                    break;
                case "8" : {

                    file.saveThisData(budget.getRecords());
                }break;
                case "9" : {
                }break;
                default: {
                    System.out.println("Wrong option");
                }
                break;
            }
        }
    }

    private static void menu() {
        System.out.println("[1] Ivesti pajamas");
        System.out.println("[2] Ivesti islaidas");
        System.out.println("[3] Gauti pajamu irasus");
        System.out.println("[4] Gauti islaidu irasus");
        System.out.println("[5] Balansas");
        System.out.println("[6] Redaguoti irasa");
        System.out.println("[7] Gaut irasus is failo");
        System.out.println("[8] Issaugoti irasus i faila");
        System.out.println("[9] Baigti darba");
    }
}
