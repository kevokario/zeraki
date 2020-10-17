import java.util.ArrayList;
import java.util.Arrays;

public class Zeraki {

    /**
     * This function takes an array of integers, Filters and returns the missing
     * integer
     * 
     * @return missing ineger from array
     */
    public int arrayFilter(int[] array) {

        // step 1 : Sort the array in ascending order
        Arrays.sort(array);

        // step 2 : check for missing value
        int missing_integer = -1;
        int a, b = 0;

        for (int i = 0; i < array.length - 1; i++) {

            /**
             * a is the first int in the array b is the next int in the array
             * 
             */
            a = array[i];
            b = array[(i + 1)];
            /**
             * if a + 1 is the same as the next int, there is no missing value if a + 1 is
             * not equal to the next int in the array, a+1 is the missing digit. Return it
             * and break from the loop
             * 
             */
            if ((a + 1) != b) {
                missing_integer = a + 1;
                break;
            }
        }

        return missing_integer;
    }

    /**
     * This is a function that takes in a string and reverts it in groups of four
     * 
     * @return a reversed string
     */
    public String reverseString(String n) {
        String reversed = "";
        // step 1 : Get the number of group of characters of 4 the string has
        int string_length = n.length();

        int complete_groups = string_length / 4;

        int incomplete_groups = string_length % 4;

        int incomlete_groups_start_index = string_length - incomplete_groups;

        // I will se an arrayList to hold my substrings

        ArrayList<String> string_groups = new ArrayList<>();

        // subivide the string in groups of 4 characters
        int counter = 0;
        for (int i = 0; i < (complete_groups * 4); i++) {

            if ((i % 4) == 3 && i != 0) {
                string_groups.add(n.substring(counter, i + 1));
                counter = i + 1;
            }
        }
        // if the string has reminders, add them
        if (incomplete_groups > 0) {
            string_groups.add(n.substring(incomlete_groups_start_index));
        }

        // For each string in our arrayList, Reverse it

        for (int i = 0; i < string_groups.size(); i++) {
            char[] sting_array = string_groups.get(i).toCharArray();
            char[] reverse_string = new char[sting_array.length];

            for (int j = 0; j < reverse_string.length; j++) {
                reverse_string[j] = sting_array[sting_array.length - (j + 1)];
            }

            string_groups.set(i, new String(reverse_string));
            reversed += new String(reverse_string);
            reverse_string = sting_array = null;

        }
        return reversed;

    }

    public static void main(String[] args) {

        System.out.println("\n+ + + + + + + + + + + + + + + + + + + + + + + + + + + + + + +\n\n "
                + " Welcome To Zeraki Assessment By Kelvin Kario 0704 219 247"
                + "\n\n+ + + + + + + + + + + + + + + + + + + + + + + + + + + + + + +\n");
        // Testing the Function array Filter with an array
        // Expecting 2
        int[] array = { 3, 5, 1, 4 };

        int result = new Zeraki().arrayFilter(array);
        String arrayFilterResult = "None Missing ";
        if (result != -1) {
            arrayFilterResult = result + "";
        }
        System.out.println(
                "Array of integers `" + Arrays.toString(array) + "`  Missing integer : " + arrayFilterResult + "\n");

        // Testing the Function array Filter with an array
        // Expecting none missing
        int[] array1 = { 3, 5, 2, 1, 4 };

        int result1 = new Zeraki().arrayFilter(array);
        String arrayFilterResult1 = "None Missing ";
        if (result1 != -1) {
            arrayFilterResult1 = result1 + "";
        }

        System.out.println(
                "Array of integers `" + Arrays.toString(array1) + "`  Missing integer : " + arrayFilterResult1 + "\n");


    
        // Testing Reverse String Function
        String toReverse = "Lorem at";
        String reversed = new Zeraki().reverseString(toReverse);
        System.out.println("String to reverse : `" + toReverse + "` = `" + reversed + "`\n");

        //Testing Reverse String Function
        String toReverse1 = "Tempor ip";
        String reversed1 = new Zeraki().reverseString(toReverse1);
        System.out.println("String to reverse : `" + toReverse1 + "` = `" + reversed1 + "`\n");

        //Testing Reverse String Function
        String toReverse2 = "Welcome To Zeraki Assessment By Kelvin Kario 0704 219 247";
        String reversed2 = new Zeraki().reverseString(toReverse2);
        System.out.println("String to reverse : `" + toReverse2 + "` = `" + reversed2 + "`\n");
    }

}