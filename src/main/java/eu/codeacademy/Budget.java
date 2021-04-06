package eu.codeacademy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Budget {
    public ArrayList<Record> records;

    public Budget() {
        records = new ArrayList<>();
    }

    public ArrayList<Record> getRecords() {
        return records;
    }

    public void addRecord(Record record) {
        records.add(record);
    }

    public List<SpendingData> getExpenditures() {
        List<SpendingData> listOfSpendingData = new ArrayList<>();
        for (Record record : records){
            if (record instanceof SpendingData){
                listOfSpendingData.add((SpendingData) record);
            }
        }
        return listOfSpendingData;
    }

    public List<IncomeData> getIncome() {
        List<IncomeData> listOfIncomes = new ArrayList<>();
        for (Record record : records){
            if (record instanceof  IncomeData){
                listOfIncomes.add((IncomeData) record);
            }
        }
        return listOfIncomes;
    }

    public float gautiBalansa() {
        float expenses = 0;
        for (SpendingData spendingData : getExpenditures()) {
            expenses += spendingData.getSum();
        }
        float incomeSum = 0;
        for (IncomeData incomeData : getIncome()) {
            incomeSum += incomeData.getSum();
        }
        return (incomeSum - expenses);
    }

    public float expendituresSum() {
        float expenses = 0;
        for (SpendingData expenseRecord : getExpenditures()) {
            expenses += expenseRecord.getSum();
        }
        return expenses;
    }

    public float incomeSum() {
        float income = 0;
        for (IncomeData incomeData : getIncome()) {
            income += incomeData.getSum();
        }
        return income;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return this.getRecords().stream().anyMatch(r-> r.getId()==((Record) o).getId());
    }

    @Override
    public int hashCode() {
        return 0;
    }

    public void setRecords(ArrayList<Record> records) {
        this.records = records;
    }

}
