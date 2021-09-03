package assignments.A02_ArrayListExercises;

import java.util.List;
import java.util.ArrayList;

public class ListExercises {

    // Quadratic!
    public static <E> boolean unique(List<E> list ){
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                if( i != j ){
                    if(list.get(i).equals(list.get(j))){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static List<Integer> allMultiples(List<Integer> list, int a){
        List<Integer> new_list = new ArrayList<Integer>();
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i) % a == 0){
                new_list.add(list.get(i));
            }
        }
        return new_list;
    }

    public static List<String> allStringsOfSize(List<String> list, int len){
        List new_list = new ArrayList<String>();
        for (int i = 0; i < list.size(); i++) {
            if( list.get(i).length() == len ){
                new_list.add(list.get(i));
            }
        }
        return new_list;
    }

    public static <E> boolean isPermutation(List<E> list_a, List<E> list_b){
        if(list_a.size() != list_b.size()) return false;
        for (int i = list_a.size()-1; i >= 0; i--) {
            E a_item = list_a.get(i); // Important so that Java knows to call the remove(E i) version, not remove(int i)
            if(!list_b.contains(a_item)){
                return false;
            }
            list_a.remove(a_item);
            list_b.remove(a_item);
        }
        return true;
    }

    public static List<String> stringToListOfWords(String in){
        ArrayList<String> list = new ArrayList<>();
        list.addAll(List.of(in.split("\\s+")));
        return list;
    }

    public static List<String> stringToListOfWordsEC(String in){
        ArrayList<String> list = new ArrayList<>();
        list.addAll(List.of(in.replaceAll("[,.!:;?]", "").split("\\s+")));
        return list;
    }

    // Avoid 'manual' looping all-together.
    public static <E> void removeAllInstancesA(List<E> list, E item) {
        while (list.contains(item)) {
            list.remove(item); // Uses the remove(E i) method - Object (E) equal to i
        }
    }

    // Go 'backwards' so the shifting doesn't bite you in the butt.
    public static <E> void removeAllInstancesB(List<E> list, E item) {
        for (int i = list.size()-1; i >= 0; i--) {
            if( list.get(i) == item ){
                list.remove(i); // Using the remove(int i) method - At index i
            }
        }
    }

    public static void main(String[] args) {



        System.out.println("** unique()");
        ArrayList<Integer> ints = new ArrayList<>();
        ints.addAll(List.of(1, 2, 3, 1));
        System.out.println(ints+" "+(unique(ints) ? "Unique" : "Not Unique"));
        ArrayList<Character> chars = new ArrayList<>();
        chars.addAll(List.of('a', 'b', 'c', 'd'));
        System.out.println(chars+" "+(unique(chars) ? "Unique" : "Not Unique"));

        System.out.println("\n** allMultiples()");
        ints = new ArrayList<>();
        ints.addAll(List.of(1, 2, 3, 4, 5, 6, 7, 9));
        System.out.println("multiples of "+3+" in "+ints+" :");
        System.out.println(allMultiples(ints, 3));

        System.out.println("\n** allStringsOfSize()");
        ArrayList<String> strs = new ArrayList<>();
        strs.addAll(List.of("We", "Are", "some", "words", "So", "To"));
        System.out.println(strs + " ? length 2:");
        System.out.println(allStringsOfSize(strs, 2));

        System.out.println("\n** isPermutation()");
        ArrayList<Integer> intsA = new ArrayList<>();
        ArrayList<Integer> intsB = new ArrayList<>();
        intsA.addAll(List.of(1, 2, 3, 4));
        intsB.addAll(List.of(3, 2, 1, 4));
        System.out.println(intsA);
        System.out.println(intsB);
        System.out.println(isPermutation(intsA, intsB) ? "Permutation" : "Not Permutation");

        ArrayList<Character> charsA = new ArrayList<>();
        ArrayList<Character> charsB = new ArrayList<>();
        charsA.addAll(List.of('a', 'b', 'c', 'd', 'e'));
        charsB.addAll(List.of('a', 'b', 'a', 'd', 'a'));
        System.out.println(charsA);
        System.out.println(charsB);
        System.out.println(isPermutation(charsA, charsB) ? "Permutation" : "Not Permutation");

        System.out.println("\n** removeAllInstances():");
        ArrayList<Integer> test_raw = new ArrayList<>();
        test_raw.addAll(List.of(1, 2, 3, 4, 5 ));

        System.out.println("Version A");
        ArrayList<Integer> test1 = (ArrayList<Integer>) test_raw.clone();
        System.out.println(test1);
        removeAllInstancesA(test1, 2);
        System.out.println(test1);
        System.out.println("Version B");
        ArrayList<Integer> test2 = (ArrayList<Integer>) test_raw.clone();
        System.out.println(test2);
        removeAllInstancesB(test2, 2);
        System.out.println(test2);

        System.out.println("\n** stringToListOfWords():");
        String testStr = "Hello! I. Am. A. Programmer?";
        System.out.println(stringToListOfWords(testStr));
        System.out.println("EC: "+stringToListOfWordsEC(testStr));
    }
}
