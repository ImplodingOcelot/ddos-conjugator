package help_i_want_the_sweet_release_of_death;

public class helpme {
    public static void main(String[] args) {
        System.out.println(go(13));
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
    public static String go(int a) {
        if(a <= 0)  {
           return "aplus";
        }
        String finalize = "";
        for(int i = 1; i <= a; i++) {
            finalize += i*10;
        }
        return finalize;
    }
    // make a method called prime that determines if a given number is a prime number
    public static boolean prime(int a) {
        if(a <= 1)  {
            return false;
        }
        for(int i = 2; i < a; i++) {
            if(a % i == 0)  {
                return false;
            }
        }
        return true;
    }
}

