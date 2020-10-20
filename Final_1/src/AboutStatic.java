public class AboutStatic {
    private static int numInstances = 0;
    protected static int getCount() {
        return numInstances;
    }

    private static void addInstance() {
        numInstances++;
    }

    AboutStatic() {
        AboutStatic.addInstance();
    }

    public static void main(String[] arguments) {
        System.out.println("Starting with " + AboutStatic.getCount() + " instances");
        for (int i = 0; i < 500; ++i){
            new AboutStatic();
        }
        System.out.println("Created " + AboutStatic.getCount() + " instances");
    }
}
