package com.example.androidhomework2;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import java.util.ArrayList;

public class Calculator implements Parcelable {

    private ArrayList<Integer> numbers = new ArrayList<>();
    private ArrayList<String> actions = new ArrayList<>();
    private boolean lastIsInt = false;
    private boolean afterEqual = true;
    private int result = 0;
    private String label = "";

    protected Calculator(Parcel in) {
    }

    public static final Creator<Calculator> CREATOR = new Creator<Calculator>() {
        @Override
        public Calculator createFromParcel(Parcel in) {
            return new Calculator(in);
        }

        @Override
        public Calculator[] newArray(int size) {
            return new Calculator[size];
        }
    };

    public Calculator() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }

    public void newSimbol(int num) {
        if (afterEqual) {
            numbers.clear();
            actions.clear();
            label = label.substring(0, 0);
            afterEqual = false;
            lastIsInt = false;
            actions.add("+");
            result = 0;
        }
        if (!lastIsInt) {
            numbers.add(num);
            lastIsInt = true;
        } else {
            numbers.set(numbers.size() - 1, numbers.get(numbers.size() - 1) * 10 + num);
        }
        label += Integer.toString(num);
    }

    public void newAction(String action) {
        if (lastIsInt) {
            actions.add(action);
            label += action;
            lastIsInt = false;
        } else if (label.equals("")) {
            label += "";
        } else {
            actions.set(actions.size() - 1, action);
            label = label.substring(0, label.length() - 1);
            label += action;
            lastIsInt = false;
        }
        afterEqual = false;
    }

    public void calculate() {
        for (int i = 0; i < numbers.size(); i++) {
            if (actions.get(i).equals("+")) {
                result += numbers.get(i);
            } else if (actions.get(i).equals("-")) {
                result -= numbers.get(i);
            }
        }

        label = Integer.toString(result);
        actions.clear();
        numbers.clear();

        if (result >= 0) {
            actions.add("+");
            numbers.add(result);
        } else {
            actions.add("-");
            numbers.add(-result);
        }
        result = 0;
        afterEqual = true;
    }

    public void eraseAll() {
        numbers.clear();
        actions.clear();
        label = "";
        lastIsInt = false;
        afterEqual = true;

        Log.d("ERASE", "numbers");
    }

    public String showLabel() {
        return label;
    }

    public ArrayList<Integer> getNumbers() {
        return numbers;
    }

    public ArrayList<String> getActions() {
        return actions;
    }

    public boolean getIsLastIsInt() {
        return lastIsInt;
    }

    public boolean getIsAfterEqual() {
        return afterEqual;
    }

    public int getResult() {
        return result;
    }

    public String getLabel() {
        return label;
    }

    public void setNumbers(ArrayList<Integer> numbers) {
        this.numbers = numbers;
    }

    public void setActions(ArrayList<String> actions) {
        this.actions = actions;
    }

    public void setLastIsInt(boolean lastIsInt) {
        this.lastIsInt = lastIsInt;
    }

    public void setAfterEqual(boolean afterEqual) {
        this.afterEqual = afterEqual;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
