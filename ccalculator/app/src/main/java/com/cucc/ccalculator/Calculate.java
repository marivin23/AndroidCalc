package com.cucc.ccalculator;

import android.text.TextUtils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Calculate extends MainActivity {

    private static int multiples = 1;
    static int result = 0;

    public void calculateArray(List<String> items) {

        int iterate = 0;
        Iterator itr = items.iterator();
        String s = "";
        int n1;
        result = Integer.parseInt(items.get(0));

        while(itr.hasNext()) {

            s = itr.next().toString();
            if (!TextUtils.isDigitsOnly(s)) {

                switch (s) {
                    case "+": {
                        n1 = Integer.parseInt(items.get(iterate + 1));
                        result = result + n1;
                        break;
                    }
                    case "-": {
                        n1 = Integer.parseInt(items.get(iterate + 1));
                        result = result - n1;
                        break;
                    }
                    case "*": {
                        int secondaryResult = 0;
                        if(iterate >= 2 ){
                            if((!items.get(iterate - 2).equals("+") && !items.get(iterate - 2).equals("+"))){
                               secondaryResult = Integer.parseInt(items.get(iterate-1)) * Integer.parseInt(items.get(iterate+1));
                               result = secondaryResult + result;
                            }
                        } else {
                            //result = result * Integer.parseInt(items.get(iterate+1));
                        }
                        break;
                    }

                }
            }
            iterate++;
        }
    }

    protected static int getResult(){
        return result;
    }

    protected static void setResult(){
        result = 0;
    }

}
