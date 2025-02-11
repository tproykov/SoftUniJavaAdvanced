package JA09IteratorsAndComparators.E08PetClinics;

public class Clinic {

    private String name;
    private Pet[] rooms;

    public Clinic(String name, int roomsCount) {
        this.name = name;

        if (roomsCount % 2 == 0) {
            throw new IllegalArgumentException("Invalid Operation!");
        }

        this.rooms = new Pet[roomsCount];
    }

    public boolean add(Pet pet) {

        int n = this.rooms.length;
        int center = n / 2;

        for (int i = 0; i < n; i++) {
            int index;

            if (i % 2 == 0) {
                index = center + (i / 2);
            } else {
                index = center - ((i + 1) / 2);
            }

            if (rooms[index] == null) {
                rooms[index] = pet;
                return true;
            }
        }
        return false;
    }

    public boolean release() {
        int n = this.rooms.length;
        int center = n / 2;

        for (int i = center; i < n; i++) {
            if (rooms[i] != null) {
                rooms[i] = null;
                return true;
            }
        }

        for (int i = 0; i < center; i++) {
            if (rooms[i] != null) {
                rooms[i] = null;
                return true;
            }
        }
        return false;
    }

    public boolean hasEmptyRooms() {

        for (Pet pet : rooms) {

            if (pet == null) {
                return true;
            }
        }
        return false;
    }

    public void printRoom(int roomNumber) {

        int index = roomNumber - 1;

        if (rooms[index] == null) {
            System.out.println("Room empty");
        } else {
            System.out.println(rooms[index].toString());
        }
    }

    public void printAll() {

        for (Pet pet : rooms) {

            if (pet == null) {
                System.out.println("Room empty");
            } else {
                System.out.println(pet.toString());
            }
        }
    }
}