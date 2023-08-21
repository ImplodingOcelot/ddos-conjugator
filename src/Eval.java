public class Eval {
    public int calc(int curr, int finalPercent, int wantedPercent) {
        int regPercent = 100 - finalPercent;
        int a = curr * regPercent;
        int b = wantedPercent - a;
        int c = b * 100 / finalPercent;
        return c;
    }
}