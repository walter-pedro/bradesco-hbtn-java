public class Program {
    public Program() {
    }

    public static void main(String[] var0) {
        FormaGeometrica var1 = new FormaGeometrica();

        try {
            System.out.printf("Area: %d", var1.area());
        } catch (Exception var3) {
            System.out.println(var3);
        }

    }
}