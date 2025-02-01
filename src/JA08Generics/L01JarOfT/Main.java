package JA08Generics.L01JarOfT;

public class Main {

    public static void main(String[] args) {

        Pickle pickle1 = new Pickle();
        Pickle pickle2 = new Pickle();

        Jar<Pickle> jarOfPickles = new Jar<>();

        jarOfPickles.add(pickle1);
        jarOfPickles.add(pickle2);

        jarOfPickles.remove();
    }
}