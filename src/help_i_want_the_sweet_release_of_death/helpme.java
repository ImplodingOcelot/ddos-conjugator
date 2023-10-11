package help_i_want_the_sweet_release_of_death;

public class helpme {
    public static void main(String[] args) {
        System.out.println(aplus(20));
    }

    public static int aplus(int i) {
        int j = 0;
        while (i != 1) {
            if (i % 2 == 0) {
                i /= 2;
            } else {
                i = i * 3 + 1;
            }
            j++;
        }
        return j;
    }
}

