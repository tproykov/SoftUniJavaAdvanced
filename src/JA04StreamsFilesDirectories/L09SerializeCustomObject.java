package JA04StreamsFilesDirectories;

import java.io.*;

public class L09SerializeCustomObject {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

//        Person person = new Person("Ivan", 24);
//
//        FileOutputStream fos = new FileOutputStream("C:\\Users\\todor\\Zoho WorkDrive (Dr Todor Proykov)\\My Folders\\GitHub Repositories\\SoftUniJavaAdvanced\\src\\JA04StreamsFilesDirectories\\resources\\output.txt");
//        ObjectOutputStream oos = new ObjectOutputStream(fos);
//
//        oos.writeObject(person);
//
//        oos.close();


        FileInputStream fis = new FileInputStream("C:\\Users\\todor\\Zoho WorkDrive (Dr Todor Proykov)\\My Folders\\GitHub Repositories\\SoftUniJavaAdvanced\\src\\JA04StreamsFilesDirectories\\resources\\output.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);

        Person person = (Person) ois.readObject();

        System.out.println(person);
    }
}