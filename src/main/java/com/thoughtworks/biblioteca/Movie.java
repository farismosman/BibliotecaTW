public class Movie {
    
    public String name;
    public String director;
    public String rating;

    public Movie(String name, String director, String rating) {
        this.name = name;
        this.director = director;
        this.rating = rating;
    }
    
    @Override
    public String toString(){
        return name + director + rating;
    }
}
