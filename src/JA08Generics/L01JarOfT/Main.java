package JA08Generics.L01JarOfT;

public class Main {

    public static void main(String[] args) {

        Jar<String> jarOfTexts = new Jar<>();
        jarOfTexts.add("Hello");
        jarOfTexts.add("World");
        jarOfTexts.remove("Hello");
        System.out.println(jarOfTexts);
    }
}