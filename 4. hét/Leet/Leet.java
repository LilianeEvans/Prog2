package leet;

/**
 *
 * @author Liliane
 */
import java.util.*;

public class Leet
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println("Normal String: " + str);
        str = str.toLowerCase();
        str = str.replaceAll("a", "@");
        str = str.replaceAll("b", "|o");
        str = str.replaceAll("c", "<");
        str = str.replaceAll("d", "|]");
        str = str.replaceAll("e", "3");
        str = str.replaceAll("f", "|=");
        str = str.replaceAll("g", "6");
        str = str.replaceAll("h", "|-|");
        str = str.replaceAll("i", "!");
        str = str.replaceAll("j", "_|");
        str = str.replaceAll("k", "|<");
        str = str.replaceAll("l", "|");
        str = str.replaceAll("m", "^^");
        str = str.replaceAll("n", "/V");
        str = str.replaceAll("o", "0");
        str = str.replaceAll("p", "|>");
        str = str.replaceAll("q", "9");
        str = str.replaceAll("r", "12");
        str = str.replaceAll("s", "$");
        str = str.replaceAll("t", "7");
        str = str.replaceAll("u", "[_]");
        str = str.replaceAll("v", "V");
        str = str.replaceAll("w", "VV");
        str = str.replaceAll("x", "%");
        str = str.replaceAll("y", "¥");
        str = str.replaceAll("z", "2");
        System.out.println("LeetSpeak: " + str);
    }
}

