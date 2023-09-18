package help_i_want_the_sweet_release_of_death;

class Tweet {
    String message;
    int retweets;
    int likes;

    public void constructor(String message_, int likes_, int retweets_) {
        this.message = message_;
        this.likes = likes_;
        this.retweets = retweets_;
    }

    public void addLike(int addLike) {
        this.likes += addLike;
    }

    public void addRetweet(int addedRetweets) {
        this.retweets += addedRetweets;
    }

    public boolean notLiked() {
        return this.likes < 10;
    }

    public boolean kindaLiked() {
        return this.likes < this.retweets;
    }

    public boolean isTrending() {
        return this.likes + this.retweets > 75;
    }

    public String ToString() {
        return "Message: " + this.message + " Likes: " + this.likes + " Retweets: " + this.retweets;
    }
}
