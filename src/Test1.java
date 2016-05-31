import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Test1 {
        /**
         * find the second largest integer in an array.
         * @param ia an array of integers
         * @return the second largest number in ia
         */
        private int currentMax;

    private int secondLargest(int[] ia)
        {
            if (ia.length < 2) {
                System.err.println("Error: Nothing to compare with. Array size is < 2");
                System.exit(1);
            } else if (Arrays.stream(ia).allMatch(s -> s == ia[0])) {
                System.err.println("Error: There are only the same values in an array");
                System.exit(1);
            } 
            else {
                List<Integer> list = new ArrayList<>(ia.length);

                for (int anIa : ia) {
                    list.add(anIa);
                }
                currentMax = list.parallelStream().max(Integer::compareTo).get();
                Integer maxObject = currentMax;
                while(Objects.equals(maxObject, list.parallelStream().max(Integer::compareTo).get())){
                    list.remove(maxObject);
                }
                currentMax = list.parallelStream().max(Integer::compareTo).get();
            }
            return currentMax;
        } //secondLargest

        /**
         * print (System.out.println()) all pairs of numbers chosen from ia,
         * such that each pair of numbers adds up to target.
         * @param ia an array of integers
         * @param target the target integer
         */
        private void findPairs(int[] ia,int target){
            if(ia.length < 2){
                System.out.println("Array length is less than 2!");
                System.exit(1);
            }
            Arrays.sort(ia);
            int left = 0; int right = ia.length -1;
            while(left < right){
                int sum = ia[left] + ia[right];
                if(sum == target){
                    System.out.println(ia[left] + "," + ia[right]);
                    left = left + 1;
                    right = right - 1;
                }else if(sum < target){
                    left = left + 1; }
                else if (sum > target){
                    right = right - 1;
                }
            }
        } //findPairs

    public static void main(String[] args) {
        Test1 test1 = new Test1();
        int[] anArray = {2,4,1,5,-14,20,0,6};
        int x = test1.secondLargest(anArray);
        System.out.println(x);

        System.out.println(";;;;;;;;;");
        test1.findPairs(anArray, 6);
    }
}
