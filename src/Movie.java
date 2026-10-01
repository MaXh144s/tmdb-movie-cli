package src;

import java.util.Locale;

import com.google.gson.annotations.SerializedName;

public class Movie {

    private int id;
    private String title;

    @SerializedName("overview")
    private String overView;

    @SerializedName("release_date")
    private String releaseDate;
    @SerializedName("vote_average")
    private Double voteAverage;
    @SerializedName("vote_count")
    private int voteCount;

    public Movie() {
    }

    public Movie(int id, String title) {
        this.title = title;
        this.id = id;
    }

    public Movie(String title, int id, String overView, String releaseDate) {
        this.title = title;
        this.id = id;
        this.overView = overView;
        this.releaseDate = releaseDate;
    }

    public Movie(String title, int id, String overView, String releaseDate, Double voteAverage, int voteCount) {
        this.title = title;
        this.id = id;
        this.overView = overView;
        this.releaseDate = releaseDate;
        this.voteAverage = voteAverage;
        this.voteCount = voteCount;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getoverView() {
        return overView;
    }

    public void setoverView(String overView) {
        this.overView = overView;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Double getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(Double voteAverage) {
        this.voteAverage = voteAverage;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(int voteCount) {
        this.voteCount = voteCount;
    }

    public String toString() {
        Locale.setDefault(Locale.of("pt", "BR"));
        String formattedTitle = title.length() > 30
                ? title.substring(0, 27) + "..."
                : title;

        if (voteAverage >= 0 && voteCount >= 0) {
            return String.format(
                    "Title: %-32s | Rating: %-5.1f | Votes: %-6d | Release Date: %-10s",
                    formattedTitle,
                    voteAverage,
                    voteCount,
                    releaseDate);
        }

        return String.format(
                "Title: %-32s | Release Date: %-10s | Nenhuma avaliação registrada.",
                formattedTitle,
                releaseDate);
    }
}
