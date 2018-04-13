package com.cucc.ccalculator;

import android.text.TextUtils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Calculate extends MainActivity {

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
                        if(items.size() - iterate == 2) {
                            n1 = Integer.parseInt(items.get(iterate + 1));
                            result = result + n1;
                            break;
                        }
                        if (items.get(iterate + 2).equals("*") || items.get(iterate + 2).equals("/")) {
                            break;
                        }
                        n1 = Integer.parseInt(items.get(iterate + 1));
                        result = result + n1;
                        break;
                    }
                    case "-": {
                        if(items.size() - iterate == 2) {
                            n1 = Integer.parseInt(items.get(iterate + 1));
                            result = result - n1;
                            break;
                        }
                        if (items.get(iterate + 2).equals("*") || items.get(iterate + 2).equals("/")) {
                            break;
                        }
                        n1 = Integer.parseInt(items.get(iterate + 1));
                        result = result - n1;
                        break;
                    }
                    case "*": {
                        if(items.get(1).equals("*")||items.get(1).equals("/")) {
                            result = result * Integer.parseInt(items.get(iterate+1));
                            break;
                        }
                        result = result + (Integer.parseInt(items.get(iterate-1)) * Integer.parseInt(items.get(iterate+1)));
                        break;
                    }
                    case "/": {
                        if(items.get(1).equals("*")||items.get(1).equals("/")) {
                            result = result / Integer.parseInt(items.get(iterate+1));
                            break;
                        }
                        result = result + (Integer.parseInt(items.get(iterate-1)) / Integer.parseInt(items.get(iterate+1)));
                        break;
                    }

                }
            }
            iterate++;
        }
    }

    public boolean hasIndex(int index){
        if(index < items.size()) return false;
        else return true;
    }

    protected static int getResult(){
        return result;
    }

    protected static void setResult(){
        result = 0;
    }

}
