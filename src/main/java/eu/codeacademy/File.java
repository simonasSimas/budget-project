package eu.codeacademy;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class File {
    public void saveThisData(List<Record> recordList) {
        clearFile();
        PrintWriter pw = write();
        for (Record record : recordList) {
            if (record instanceof IncomeData) {
                pw.println("I," + record.getId() + "," + record.getSum() + "," + ((IncomeData) record).getIncomeCategory() + "," + ((IncomeData) record).getIncomeType() + "," + record.getBonusInfo() + "," + record.getDate());
            } else if (record instanceof SpendingData) {
                pw.println("S," + record.getId() + "," + record.getSum() + "," + ((SpendingData) record).getExpenditureCategory() + "," + ((SpendingData) record).getExpenditureMethod() + "," + record.getBonusInfo() + "," + record.getDate());
            }
        }
        pw.close();
    }

    public ArrayList<Record> getRecordsFromFile() {
        ArrayList<Record> listFromFile = new ArrayList<>();
        Scanner sc = scannerFromFile();
        List<String> stringOfAllRecords = new ArrayList<>();
        while(sc.hasNextLine()){
            String line = sc.nextLine();
            stringOfAllRecords.add(line);
        }
        for (String s : stringOfAllRecords) {
            if (s.startsWith("I")) {
                int comma = s.indexOf(",");
                comma+=1;
                int id = Integer.parseInt(s.substring(comma , s.indexOf(",",comma)));
                comma = s.indexOf(",",comma)+1;
                float sum = Float.parseFloat(s.substring(comma, s.indexOf(",",comma)));
                comma = s.indexOf(",",comma)+1;
                String category = s.substring(comma, s.indexOf(",",comma));
                comma = s.indexOf(",",comma)+1;
                String methodOrType = s.substring(comma, s.indexOf(",",comma));
                comma = s.indexOf(",",comma)+1;
                String bonusInfo = s.substring(comma, s.indexOf(",",comma));
                comma = s.indexOf(",",comma)+1;
                String date = s.substring(comma);
                IncomeData incomeData = new IncomeData(sum,bonusInfo,category,methodOrType);
                incomeData.setId(id);
                incomeData.setDate(date);
                listFromFile.add(incomeData);
            }else {
                int comma = s.indexOf(",");
                comma+=1;
                int id = Integer.parseInt(s.substring(comma, s.indexOf(",",comma)));
                comma = s.indexOf(",",comma)+1;
                float sum = Float.parseFloat(s.substring(comma, s.indexOf(",",comma)));
                comma = s.indexOf(",",comma)+1;
                String category = s.substring(comma, s.indexOf(",",comma));
                comma = s.indexOf(",",comma)+1;
                String methodOrType = s.substring(comma, s.indexOf(",",comma));
                comma = s.indexOf(",",comma)+1;
                String bonusInfo = s.substring(comma, s.indexOf(",",comma));
                comma = s.indexOf(",",comma)+1;
                String date = s.substring(comma);
                SpendingData spendingData = new SpendingData(sum,bonusInfo,category,methodOrType);
                spendingData.setId(id);
                spendingData.setDate(date);
                listFromFile.add(spendingData);
            }
        }
        return listFromFile;
    }


    private Scanner scannerFromFile() {
        java.io.File file = new java.io.File("budget_data.txt");
        Scanner sc = null;
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return sc;
    }

    private PrintWriter write() {
        FileWriter fw = null;
        try {
            fw = new FileWriter("budget_data.txt", true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new PrintWriter(fw);
    }

    private void clearFile() {
        FileWriter fw = null;
        try {
            fw = new FileWriter("budget_data.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        PrintWriter pw = new PrintWriter(fw);
        pw.println();
        pw.close();
    }
}
