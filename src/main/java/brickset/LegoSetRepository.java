package brickset;

import countries.Country;
import repository.Repository;

import java.util.Comparator;
import java.util.Optional;

/**
 * Represents a repository of {@code LegoSet} objects.
 */
public class LegoSetRepository extends Repository<LegoSet> {

    public LegoSetRepository() {
        super(LegoSet.class, "brickset.json");
    }

    // Method 1

    /**
     * Prints the names of LEGO sets in alphabetical order
     *
     *
     */

    public  void namesInAlphabeticalOrder (){
        getAll().stream()
                .map(LegoSet::getName)
                .sorted(Comparator.nullsFirst(Comparator.naturalOrder()))
                .forEach(System.out::println);
    }


    // Method 2

    /**
     * Returns the maximum piece of LEGO sets
     *
     * return long
     */

    public  long maximumPieces (){
      return   getAll().stream()
                .mapToLong(LegoSet::getPieces)
                .max()
                .getAsLong();
    }

    // Method 3

    /**
     * Returns the first LEGO number starts with number 2
     *
     * return String
     */
    public Optional<LegoSet> firstNumberStartsWithTwo (){
        return getAll().stream()
                .filter(LegoSet -> LegoSet.getNumber().charAt(0) == '2')
                .findFirst();

    }



    // Method 4

    /**
     * Returns the longest number of characters of LEGO theme
     *
     * return String
     */
    public String longestTheme (){
        return   getAll().stream()
                .map(LegoSet::getTheme)
                .max(Comparator.comparingInt(String::length))
                .get();
    }




    // Method 5

    /**
     * Prints the subtheme of each LEGO in  ascending order
     *
     */
    public  void printSubthemeOfEachLegoInAscendingOrder (){
        getAll().stream()
                .map(LegoSet::getSubtheme)
                .sorted(Comparator.nullsFirst(Comparator.comparingInt(String::length)))
                .forEach(System.out::println);

    }








    public static void main(String[] args){



        var repository = new LegoSetRepository();

        repository.namesInAlphabeticalOrder();

        System.out.println(repository.maximumPieces());

        System.out.println(repository.firstNumberStartsWithTwo());

        System.out.println(repository.longestTheme());

        repository.printSubthemeOfEachLegoInAscendingOrder();



    }

}


