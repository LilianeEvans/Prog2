import org.junit.Test;
import static org.junit.Assert.*;
import com.mycompany.mavenbinfa.LZWBinFa;

public class LZWBinFaTest {
    
    LZWBinFa binfa = new LZWBinFa();
    
    @Test
    public void testegyBitFeldolg() {
        for (char c : "01111001001001000111".toCharArray()) {
            binfa.egyBitFeldolg(c);
        }
        
        assertEquals(4, binfa.getMelyseg(), 0.0);
        assertEquals(2.75, binfa.getAtlag(), 0.001);
        assertEquals(0.957427, binfa.getSzoras(), 0.0001);
    }
    
}
