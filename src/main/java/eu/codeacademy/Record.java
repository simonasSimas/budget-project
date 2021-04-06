package eu.codeacademy;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Random;

public class Record {

    private int id = new Random().nextInt(1000);
    private float sum;
    private String date = LocalDateTime.now().toString();
    private String bonusInfo;

    public Record(float sum, String bonusInfo) {
        this.sum = sum;
        this.bonusInfo = bonusInfo;
    }

    public Record() {
    }

    public float getSum() {
        return sum;
    }

    public void setSum(float sum) {
        this.sum = sum;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getBonusInfo() {
        return bonusInfo;
    }

    public void setBonusInfo(String bonusInfo) {
        this.bonusInfo = bonusInfo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}
