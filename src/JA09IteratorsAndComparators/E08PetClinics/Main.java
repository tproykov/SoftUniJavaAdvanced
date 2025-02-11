package JA09IteratorsAndComparators.E08PetClinics;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nCommands = Integer.parseInt(scanner.nextLine());

        Map<String, Pet> pets = new HashMap<>();
        Map<String, Clinic> clinics = new HashMap<>();

        for (int i = 0; i < nCommands; i++) {
            String line = scanner.nextLine();
            String[] tokens = line.split("\\s+");
            String command = tokens[0];

            try {
                switch (command) {
                    case "Create":

                        if (tokens[1].equals("Pet")) {

                            String petName = tokens[2];
                            int petAge = Integer.parseInt(tokens[3]);
                            String petKind = tokens[4];
                            Pet pet = new Pet(petName, petAge, petKind);
                            pets.put(petName, pet);

                        }
                        else if (tokens[1].equals("Clinic")) {

                            String clinicName = tokens[2];
                            int roomsCount = Integer.parseInt(tokens[3]);
                            Clinic clinic = new Clinic(clinicName, roomsCount);
                            clinics.put(clinicName, clinic);
                        }
                        break;

                    case "Add":

                        String petName = tokens[1];
                        String clinicName = tokens[2];

                        if (!pets.containsKey(petName) || !clinics.containsKey(clinicName)) {
                            throw new IllegalArgumentException();
                        }
                        boolean addResult = clinics.get(clinicName).add(pets.get(petName));
                        System.out.println(addResult);
                        break;

                    case "Release":

                        clinicName = tokens[1];
                        if (!clinics.containsKey(clinicName)) {
                            throw new IllegalArgumentException();
                        }
                        boolean releaseResult = clinics.get(clinicName).release();
                        System.out.println(releaseResult);
                        break;

                    case "HasEmptyRooms":

                        clinicName = tokens[1];
                        if (!clinics.containsKey(clinicName)) {
                            throw new IllegalArgumentException();
                        }
                        boolean emptyRooms = clinics.get(clinicName).hasEmptyRooms();
                        System.out.println(emptyRooms);
                        break;

                    case "Print":

                        clinicName = tokens[1];
                        if (!clinics.containsKey(clinicName)) {
                            throw new IllegalArgumentException();
                        }
                        Clinic clinic = clinics.get(clinicName);
                        if (tokens.length == 2) {
                            clinic.printAll();
                        } else if (tokens.length == 3) {
                            int roomNumber = Integer.parseInt(tokens[2]);
                            clinic.printRoom(roomNumber);
                        }
                        break;

                    default:
                        break;
                }
            } catch (IllegalArgumentException ex) {
                System.out.println("Invalid Operation!");
            }
        }
    }
}