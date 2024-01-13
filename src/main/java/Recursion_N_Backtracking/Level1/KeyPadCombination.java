package Recursion_N_Backtracking.Level1;

import java.util.ArrayList;

public class KeyPadCombination {

    public static void main(String[] args) {
//                         0,    1,    2,    3,    4,    5,    6,    7,    8,   9
        String[] code = {".;","abc","def","ghi","jkl","mno","pqrs","tu","vwx","yz"};

        KeyPadCombination k = new KeyPadCombination();

        String str = "576";
        k.getKPC(str, code);

    }

    private ArrayList<String> getKPC(String str, String[] codes) {

        if (str.length() == 0) {
            ArrayList<String> bes = new ArrayList<>();
            bes.add("");
            return bes;
        }
        char ch = str.charAt(0);
        String s = str.substring(1);

        ArrayList<String> rres = getKPC(s, codes);
        ArrayList<String> mres = new ArrayList<>();

        String codesCh = codes[Character.getNumericValue(ch)];
        for (int i=0;i<codesCh.length();i++) {
            char c = codesCh.charAt(i);
            for (String res : rres) {
                mres.add(c+res);
            }
        }

        return mres;
    }
}
