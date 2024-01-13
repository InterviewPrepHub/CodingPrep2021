package String;

import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

public class Test {
    public static void main(String[] args) {
        String s = "dc::content::metadata::en_us::watch::15";
        String[] s1 = s.split("::");
        System.out.println(s1[0]);

        if (s1[0].equals(ApplicationEnum.DC.name().toLowerCase())) {
            System.out.println("yes");
        }

    }
}
