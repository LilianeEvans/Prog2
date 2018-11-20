import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class RSATeszt {

    public static void main(String args[]) {
        try {
            // beolvassa a titkos szöveget tartalmazó txt fájlt, és megszámolja, hogy hány sorból áll
            // mivel a titkos szöveg karakterenként kódolt, ezért ahány sor van a fájlban, annyi karakter hosszú az eredeti szöveg
            BufferedReader inputStream = new BufferedReader(new FileReader("out.txt"));
            String line = null;
            List<String> lines = new ArrayList<String>();
            int sorokSzama = 0;

            while ((line = inputStream.readLine()) != null) {
                lines.add(line);
                sorokSzama++;
            }
            inputStream.close();

            // beolvassa a karakterek előfordulásának gyakoriságát tartalmazó txt fájlt
            // ebben a fájlban előfordulási gyakoriság alapján csökkenő sorrend szerint vannak rendezve a karakterek
            // a karakterek mindig az adott sor első karakterei
            BufferedReader betu = new BufferedReader(new FileReader("angol.txt"));

            List<Character> gyakorisag = new ArrayList<Character>();
            int betukSzama = 0;
            line = null;

            while ((line = betu.readLine()) != null) {
                gyakorisag.add(line.charAt(0));
                betukSzama++;
            }
            betu.close();

            // tartalmilag megegyező jeleket keres, ha talál, leáll és növeli az adott jel előfordulásainak számát 1-gyel
            // ha nem talál, akkor pedig a soron következő jellel folytatja a vizsgálatot, és az elemek változót 1-gyel növeli
            // tehát az elemek nevű változó az egymástól eltérő jelek számát adja meg
            Jel buff[] = new Jel[sorokSzama];
            int elemek = 0;
            buff[elemek] = new Jel(lines.get(0));
            elemek++;
            boolean talalt = false;

            for (int i = 1; i < sorokSzama; i++) {
                talalt = false;
                for (int j = 0; j < elemek; j++) {
                    if (buff[j].getValue().compareTo(lines.get(i)) == 0) {
                        buff[j].incElofordulas();
                        talalt = true;
                    }
                }

                if (!talalt) {
                    buff[elemek] = new Jel(lines.get(i));
                    elemek++;

                }

            }

            /*         for (int i = 0; i < elemek; i++) {
                System.out.println(buff[i].getElofordulas());
            } */
            
            // sorbarendezi az elemeket gyakoriság alapján
            for (int i = 0; i < elemek - 1; i++) {
                for (int j = i + 1; j < elemek; j++) {
                    if (buff[i].getElofordulas() < buff[j].getElofordulas()) {
                        Jel temp1 = new Jel(buff[i].getValue());
                        temp1.setElofordulas(buff[i].getElofordulas());
                        buff[i] = buff[j];
                        buff[j] = temp1;
                    }
                }
            }

            /* for (int i = 0; i < elemek; i++) {
                System.out.println(buff[i].getElofordulas());
            } */
            
            // a jelekhez kulcsot rendel - a leggyakrabban előforduló jelhez a leggyakrabban előforduló karaktert rendeli
            for (int i = 0; i < gyakorisag.size(); i++) {
                buff[i].setChar(gyakorisag.get(i));
            }

            // ha a vizsgált sor megegyezik a jel értékével, akkor kiírja a jelhoz tartozó karaktert
            for (String line1 : lines) {
                for (int i = 0; i < elemek; i++) {
                    if (line1.compareTo(buff[i].getValue()) == 0) {
                        System.out.print(buff[i].getChar());
                    }
                }
            }

            System.out.println();

        } catch (IOException e) {
        }
    }
}
