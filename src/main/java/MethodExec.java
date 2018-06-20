import print.PrintingObject;

public class MethodExec {

    public static void main(String[] args) {
        PrintingObject printingObject = new PrintingObject();

        String hello = printingObject.returnHello();

        String world = printingObject.returnWorld();

        System.out.println(hello + " " + world);
    }
}
