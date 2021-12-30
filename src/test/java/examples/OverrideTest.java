package examples;

import edu.berkeley.cs.jqf.fuzz.Fuzz;
import edu.berkeley.cs.jqf.fuzz.JQF;
import org.junit.runner.RunWith;

@RunWith(JQF.class)
public class OverrideTest {

    @Fuzz
    public void testFoo(int x) {
        new A().foo(x);
    }

    @Fuzz
    public void testFoo1(int x) {
        new A().foo1(x);
    }
}
