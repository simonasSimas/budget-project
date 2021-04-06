package eu.codeacademy;

public class SpendingData extends Record {

    private String expenditureCategory;

    private String paymentMethod;

    public SpendingData(float sum, String bonusInfo, String expenditureCategory, String paymentMethod) {
        super(sum, bonusInfo);
        this.expenditureCategory = expenditureCategory;
        this.paymentMethod = paymentMethod;
    }

    public String getExpenditureCategory() {
        return expenditureCategory;
    }

    public void setExpenditureCategory(String expenditureCategory) {
        this.expenditureCategory = expenditureCategory;
    }

    public String getExpenditureMethod() {
        return paymentMethod;
    }

    public void setExpenditureMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    @Override
    public String toString() {
        return "Spending data:"+ getDate().toString()+ "\n" +
                "Sum: " + getSum() + "\n" +
                "Expenditure category: " + expenditureCategory + "\n" +
                "Payment method: " + paymentMethod + "\n"  +
                "Record id: " + getId() + "\n" +
                "Bonus info: " + getBonusInfo();
    }


}
