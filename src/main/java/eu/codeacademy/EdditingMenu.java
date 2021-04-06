package eu.codeacademy;

import java.util.InputMismatchException;
import java.util.Scanner;

public class EdditingMenu {
    public static String editARecord(Budget budget) {
        boolean noSuchId = true;
        Scanner sc = new Scanner(System.in);
        System.out.println("Iveskite iraso ID kuri norite redaguoti :");
        int id = sc.nextInt();
        String choice = "";
        for (Record record : budget.getRecords()) {
            if (record.getId() == id) {
                noSuchId = false;
                while (!choice.equals("5")) {
                    editMenu();
                    sc.nextLine();
                    choice = sc.nextLine();
                    switch (choice) {
                        case "1":
                            System.out.println("Dabartine suma : " + record.getSum());
                            System.out.print("Iveskite nauja suma : ");
                            try {
                                record.setSum(sc.nextFloat());
                            } catch (InputMismatchException nfe) {
                                System.out.println("Neteisinga ivestis");
                            }
                            System.out.println("Suma perrasyta");

                            break;
                        case "2":
                            if (record instanceof IncomeData) {
                                System.out.println("Dabartine kategorija: " + ((IncomeData) record).getIncomeCategory());
                                System.out.print("Iveskite nauja kategorija: ");
                                try {
                                    ((IncomeData) record).setIncomeCategory(sc.nextLine());
                                } catch (InputMismatchException nfe) {
                                    System.out.println("Neteisinga ivestis");
                                }
                            } else if (record instanceof SpendingData) {
                                System.out.println("Dabartine kategorija: " + ((SpendingData) record).getExpenditureCategory());
                                System.out.print("Iveskite nauja kategorija: ");
                                try {
                                    ((SpendingData) record).setExpenditureCategory(sc.nextLine());
                                } catch (InputMismatchException nfe) {
                                    System.out.println("Neteisinga ivestis");
                                }
                            }
                            break;
                        case "3":
                            if (record instanceof IncomeData) {
                                System.out.println("Dabartinis pajamu tipas: " + ((IncomeData) record).getIncomeType());
                                System.out.print("Iveskite nauja pajamu tipa: ");
                                try {
                                    ((IncomeData) record).setIncomeType(sc.nextLine());
                                } catch (InputMismatchException nfe) {
                                    System.out.println("Neteisinga ivestis");
                                }
                            } else if (record instanceof SpendingData) {
                                System.out.println("Dabartinis mokejimo metodas: " + ((SpendingData) record).getExpenditureMethod());
                                System.out.print("Iveskite nauja metoda: ");
                                try {
                                    ((SpendingData) record).setExpenditureMethod(sc.nextLine());
                                } catch (InputMismatchException nfe) {
                                    System.out.println("Neteisinga ivestis");
                                }
                            }
                            break;
                        case "4":
                            System.out.println("Dabartine papildoma informacija: " + record.getBonusInfo());
                            System.out.print("Iveskite nauja informacija: ");
                            try {
                                record.setBonusInfo(sc.nextLine());
                            } catch (InputMismatchException nfe) {
                                System.out.println("Neteisinga ivestis");
                            }
                            break;
                        case "5":
                            break;
                        default:
                            System.out.println("Neteisinga ivestis");
                    }
                }
                break;
            }
        }

        if(noSuchId){
            System.out.println("Ivestas ID neegzistuoja");
        }
        return "";
    }

    private static void editMenu() {
        System.out.println("[1] Redaguoti suma");
        System.out.println("[2] Redaguoti kategorija");
        System.out.println("[3] Redaguoti mokejmo metoda/pajamu tipa");
        System.out.println("[4] Redaguoti papildoma informacija");
        System.out.println("[5] Grizti");
    }
}

