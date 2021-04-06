package eu.codeacademy;

public class IncomeData extends Record {

    private String incomeCategory;
    private String incomeType;

    public IncomeData(float sum, String bonusInfo, String incomeCategory, String incomeType) {
        super(sum, bonusInfo);
        this.incomeCategory = incomeCategory;
        this.incomeType = incomeType;
    }

    public String getIncomeCategory() {
        return incomeCategory;
    }

    public void setIncomeCategory(String incomeCategory) {
        this.incomeCategory = incomeCategory;
    }

    public String getIncomeType() {
        return incomeType;
    }

    public void setIncomeType(String incomeType) {
        this.incomeType = incomeType;
    }

    @Override
    public String toString() {
        return "Income data: " + getDate().toString()+ "\n" +
                "Sum: " + getSum() + "\n" +
                "Income category: " + incomeCategory + "\n" +
                "Income type=" + incomeType + "\n" +
                "Record id: " + getId() + "\n" +
                "Bonus info:" + getBonusInfo();
    }
}
