package rsapelda;

import java.util.Arrays;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.math.*;

class KulcsPar {

    java.math.BigInteger d, e, m;

    public KulcsPar() {
        int meretBitekben = 700 * (int) (java.lang.Math.log((double) 10)
                / java.lang.Math.log((double) 2));

        java.math.BigInteger p = new java.math.BigInteger(meretBitekben, 100, new java.util.Random());
        java.math.BigInteger q = new java.math.BigInteger(meretBitekben, 100, new java.util.Random());

        m = p.multiply(q);

        java.math.BigInteger z = p.subtract(java.math.BigInteger.ONE).
                multiply(q.subtract(java.math.BigInteger.ONE));

        do {
            do {
                d = new java.math.BigInteger(meretBitekben, new java.util.Random());
            } while (d.equals(java.math.BigInteger.ONE));
        } while (!z.gcd(d).equals(java.math.BigInteger.ONE));

        e = d.modInverse(z);
    }
}

public class RSAPelda {

    public static void main(String[] args) {
        try {
            KulcsPar jSzereplo = new KulcsPar();
            BufferedWriter writer = new BufferedWriter(new FileWriter("out.txt"));
            // i -> j
            String tisztaSzoveg = "Once upon a midnight dreary while I pondered weak and weary Over many a quaint and curious volume of forgotten lore While I nodded nearly napping suddenly there came a tapping As of some one gently rapping rapping at my chamber door Tis some visitor I muttered tapping at my chamber door Only this and nothing more Ah distinctly I remember it was in the bleak December And each separate dying ember wrought its ghost upon the floor Eagerly I wished the morrow vainly I had sought to borrow From my books surcease of sorrow sorrow for the lost Lenore For the rare and radiant maiden whom the angels named Lenore Nameless here for evermore And the silken sad uncertain rustling of each purple curtai Thrilled me filled me with fantastic terrors never felt before So that now to still the beating of my heart I stood repeating Tis some visitor entreating entrance at my chamber door Some late visitor entreating entrance at my chamber door This it is and nothing more Presently my soul grew stronger hesitating then no longer Sir said I or Madam truly your forgiveness I implore But the fact is I was napping and so gently you came rapping And so faintly you came tapping tapping at my chamber door That I scarce was sure I heard you here I opened wide the door Darkness there and nothing more Deep into that darkness peering long I stood there wondering fearing Doubting dreaming dreams no mortal ever dared to dream before But the silence was unbroken and the darkness gave no token And the only word there spoken was the whispered word Lenore This I whispered and an echo murmured back the word Lenore Merely this and nothing more Back into the chamber turning all my soul within me burning Soon again I heard a tapping somewhat louder than before Surely said I surely that is something at my window lattice Let me see then what thereat is and this mystery explore Let my heart be still a moment and this mystery explore This the wind and nothing more";

            // kódol i
            byte[] buffer = tisztaSzoveg.getBytes("UTF-8");
            java.math.BigInteger[] titkos = new java.math.BigInteger[buffer.length];

            for (int i = 0; i < titkos.length; ++i) {
                titkos[i] = new java.math.BigInteger(new byte[]{buffer[i]});
                titkos[i] = titkos[i].modPow(jSzereplo.e, jSzereplo.m);
                if (i < titkos.length - 1) {
                    writer.write(titkos[i] + System.getProperty("line.separator"));
                } else {
                    writer.write(titkos[i].toString());
                }
            }
            // -----------------------------------------
            writer.close();
            // dekódol j
            for (int j = 0; j < titkos.length; ++j) {
                titkos[j] = titkos[j].modPow(jSzereplo.d, jSzereplo.m);
                buffer[j] = titkos[j].byteValue();
            }
            System.out.println(new String(buffer));
        } catch (IOException e) {
        }
    }
}
