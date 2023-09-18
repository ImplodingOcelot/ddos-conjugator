package help_i_want_the_sweet_release_of_death;

public class angrybear {
    int daysawake;
    int teethcount;

    public void constructor(int daysawake, int teethcount) {
        this.daysawake = daysawake;
        this.teethcount = teethcount;
    }

    public boolean isAngry() {
        return (this.daysawake > 3 && this.teethcount < 10) || (this.teethcount == 0) || (this.daysawake >= 5);
    }
}
