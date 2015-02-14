package ArrayAndString;

/**
 * Created by ducdh1210 on 1/4/15.
 */
public class Amazon_1 {

    public static void main(String[] args) {
        int[] a = {45,86,12,57,95,32,100};
        MaxDiff(a);
    }

    private static void MaxDiff(int[] a)
    {
        int min = a[0]; // assume first element as minimum
        int maxdiff = 0;
        int posi = -1, posj = -1, minpos = 0;

        for (int i = 1; i < a.length; i++)
        {
            System.out.printf("\n** i: %d **", i);

            if (a[i] < min)
            {
                System.out.println("\na[i] < min");
                min = a[i];
                minpos = i;
            }
            else
            {
                int diff = a[i] - min;
                System.out.printf("\ndiff: %d\n", diff);
                if (diff > maxdiff)
                {
                    System.out.println("-- diff > maxdiff -- ");

                    maxdiff = diff;
                    posi = minpos;
                    posj = i;
                }
            }
            System.out.printf("min: %d, minPos:%d, maxdiff:%d \n", min, minpos, maxdiff);
            System.out.printf("posi: %d, posj: %d\n", posi, posj);

        }
        System.out.printf("\ni={%d}, j={%d}", posi, posj);
    }
}
