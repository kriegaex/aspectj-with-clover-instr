import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import print.PrintingObject;

public class TestPrintingObject {

    private PrintingObject printingObject;

    @Before
    public void before() {
        printingObject = new PrintingObject();
    }

    @Test
    public void testHello() {
        Assert.assertEquals("Hello", printingObject.returnHello());
    }

    @Test
    public void testWorld() {
        Assert.assertEquals("World", printingObject.returnWorld());
    }
}
