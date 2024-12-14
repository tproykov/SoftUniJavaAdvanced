package JA03SetsAndMapsAdvanced;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class L02SoftUniParty {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Set<String> vipGuests = new LinkedHashSet<>();
        Set<String> guests = new LinkedHashSet<>();

        String input1;
        while (!(input1 = scanner.nextLine()).equals("PARTY")) {

            if (Character.isDigit(input1.charAt(0))) {
                vipGuests.add(input1);
            }
            else{
                guests.add(input1);
            }
        }

        String input2;
        while (!(input2 = scanner.nextLine()).equals("END")) {

            if (Character.isDigit(input2.charAt(0))) {
                vipGuests.remove(input2);
            }
            else{
                guests.remove(input2);
            }
        }

        System.out.println(vipGuests.size() + guests.size());

        for (String vipGuest : vipGuests) {
            System.out.println(vipGuest);
        }

        for (String guest : guests) {
            System.out.println(guest);
        }
    }
}