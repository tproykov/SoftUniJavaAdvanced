package JA11ExamPreparation.E023WorldOfTanks;

import java.util.ArrayList;
import java.util.List;

public class Terrain {

    private String type;
    private List<Tank> tanks;
    private int area;

    public Terrain(String type, int area) {
        this.type = type;
        this.area = area;
        this.tanks = new ArrayList<>();
    }

// • Method addTank(Tank tank) – adds an entity to the collection of Tanks.
//    If the Tank with the same combination of brand and model exists on the Terrain, return the following String:
//    o	"Tank with this brand and model already exists!"
//    If the Terrain type is "Swamp" and the weight of the tank you are trying to add to this Terrain is more than 14000 return the following String:
//    o	"This {tank brand} is too heavy for this terrain!"
//    If the Tank is added successfully to the Terrain return the following String:
//    o	"Tank {tank brand} {tank model} added."

// • Method removeTank(String brand, String model) – removes a Tank by given brand and model, if such exists, and returns boolean (true if it is removed, otherwise – false)

//•	Method getTanksByBarrelCaliberMoreThan(int barrelCaliber)– returns String that lists the Tanks that meet the search criteria (with barrel caliber more than the searched one) in the following format:
//    o	Tanks with caliber more than {barrel caliber}mm: {Tank brand1}, {Tank brand2}, …{Tank brandn}"
//    If there are no Tanks matching the requested caliber on the Terrain, return:
//    o	"There are no tanks with the specified caliber."

// • Method getTankByBrandAndModel(String brand, String model) – returns the matching Tank, if such exists, otherwise – returns null.

// • Method getTheMostArmoredTank() – returns String –  the tank with the thickest armor in the following format:
//    o	"{tank brand} {tank model} is the most armored tank with {armor thikness}mm. armor thickness."
    
// • Method getCount() – returns the count of Tanks on the given Terrain.

//•	Method getStatistics() – returns a String in the following format (print the Tanks in order of addition):
//    o	"Tanks located in the {terrain type (lowercased)}:
//            -- {tank brand1} {tank model1}
//-- {tank brand2} {tank model2}
//(…)
//        -- {tank brandn} {tank modeln}"
//    If there are no Tanks on some of the Terrains print only this text:
//    o	"There are no tanks in the {terrain type (lowercased)}."




}
