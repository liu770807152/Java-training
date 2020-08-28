package comp1110.mse;

import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Q4CypherTest {
    static final int DEFAULT_ITERATIONS = 10;

    @Test
    public void testEmpty() {
        assertFalse("isWellFormed() accepted a null string", Q4Cypher.isWellFormed(null));
        assertFalse("isWellFormed() accepted an empty string", Q4Cypher.isWellFormed(""));
        assertTrue("isWellFormed() rejected a simple string", Q4Cypher.isWellFormed("A"));
    }

    @Test
    public void testGoodBad() {
        Random r = new Random();
        for (int i = 0; i < DEFAULT_ITERATIONS; i++) {
            String good = goodString(r);
            assertTrue("isWellFormed() rejected good string '" + good + "'", Q4Cypher.isWellFormed(good));
            String bad = badString(r);
            assertFalse("isWellFormed() accepted bad string '" + bad + "'", Q4Cypher.isWellFormed(bad));
        }
    }

    @Test
    public void testSpaces() {
        Random r = new Random();
        for (int i = 0; i < DEFAULT_ITERATIONS; i++) {
            String bad = " " + goodString(r);
            assertFalse("isWellFormed() accepted bad string '" + bad + "'", Q4Cypher.isWellFormed(bad));
            bad = goodString(r) + " ";
            assertFalse("isWellFormed() accepted bad string '" + bad + "'", Q4Cypher.isWellFormed(bad));
            String good = goodString(r);
            assertTrue("isWellFormed() rejected good string '" + good + "'", Q4Cypher.isWellFormed(good));
        }
    }

    @Test
    public void testEncodeSmall() {
        Q4Cypher two = new Q4Cypher(2);
        String input = "CAT";
        String output = two.encode(input);
        String ref = "EDX";
        assertTrue("encode(\"" + input + "\") returned \"" + output + "\", but expected \"" + ref + "\"", ref.equals(output));
        input = "YOU";
        output = two.encode(input);
        ref = " RY";
        assertTrue("encode(\"" + input + "\") returned \"" + output + "\", but expected \"" + ref + "\"", ref.equals(output));

        Q4Cypher three = new Q4Cypher(3);
        input = "DOG";
        output = three.encode(input);
        ref = "GSL";
        assertTrue("encode(\"" + input + "\") returned \"" + output + "\", but expected \"" + ref + "\"", ref.equals(output));
        input = "THEY";
        output = three.encode(input);
        ref = "WLJ$";
        assertTrue("encode(\"" + input + "\") returned \"" + output + "\", but expected \"" + ref + "\"", ref.equals(output));
    }

    @Test
    public void testEncode() {
        Q4Cypher c = new Q4Cypher(42);
        for (int i = 0; i < foo.length; i += 2) {
            String input = foo[i];
            String output = c.encode(input);
            String ref = foo[i + 1];
            assertTrue("encode(\"" + input + "\") returned \"" + output + "\", but expected \"" + ref + "\"", ref.equals(output));

        }
    }

    String[] foo = {
            "'RJFZVCH0-/8NWJ-H>=#$R:GIY$Q@",
            "QB;8MJ8>'%(2ISG+G>>%'V?MP&- K",
            "7/CCT90IJQ?8WBSS>HU1::H'WW",
            "&Z45G-%?AI82R>PQ=HV3=>M-#$",
            "1U;923A3ZJA-V9",
            " E,+%'6)QB:'Q5",
            "A@?I1=NHN(?,LO6;Q",
            "000;$1C>E 8&GK39P",
            ".I5Z7HK7JKZ",
            "X9&L*<@-ACS",
            "@;#9BE#+D>=J>GM",
            "/+O+59S!;66D9CJ",
            "DA*:UJQB#+KXZ",
            "31V,H>F8U#DRU",
            "O3!1A#&O4V<3",
            ">#M#4RVE+N5-",
            "E3UZ'C%1LDVBE",
            "4#FLU7U'C<O<@",
            "?V6%=(@XO#S0(M9@WPO0O8BL)",
            ".F'R0W5NFVL*#I6>VPP2R<GR0",
            "/0(F%:XZ@K8$1Z967&YUC:1",
            "Y T8S.MP7C1Y,V646&ZWF>6",
            "0AW8RF=R44C?0!BOZW#!M?=)09F8K",
            "Z1H*E:2H+,<9+X?MYW$#PCB/7AOBV",
            "BFA$$6QXE1ARJ*17K",
            "162QR*FN<):LE&.5J"};


    private String goodString(Random r) {
        int len = 10 + r.nextInt(20);
        String rtn = "";
        for (int i = 0; i < len; i++) {
            rtn += "" + (char) (' ' + 1 + r.nextInt(58));
        }
        return rtn;
    }

    private String badString(Random r) {
        int len = 10 + r.nextInt(20);
        String rtn = "";
        for (int i = 0; i < len; i++) {
            if (r.nextBoolean()) {
                rtn += "" + ((char) (' ' - (1 + r.nextInt(10))));
            } else {
                rtn += "" + ((char) ('Z' + (1 + r.nextInt(10))));
            }
        }
        return rtn;
    }

    static final String[] x = {
            "E*C!%J-Z=N,0%43-N8Y,X65",
            "5V5OT?#Q5G&+!11,N9 /!;;",
            "E*C!%J-Z=N,0%43-N8Y,X65",
            "8Y8RWB&T8J).$44/Q<#2$>>",
            "E*C!%J-Z=N,0%43-N8Y,X65",
            "9Z9SXC'U9K*/%550R=$3%??",
            "E*C!%J-Z=N,0%43-N8Y,X65",
            ": :TYD(V:L+0&661S>%4&@@",
            "E*C!%J-Z=N,0%43-N8Y,X65",
            ";!;UZE)W;M,1'772T?&5'AA",
    };
}
