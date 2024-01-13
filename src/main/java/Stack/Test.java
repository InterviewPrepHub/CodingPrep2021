package Stack;

public enum Test {

    DC;

    public static boolean isValid(String source) {
        try {
            Test.valueOf(source);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
