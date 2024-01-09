package Model;

/**
 *
 * @author phamm
 */
public class Song {
    String name;
    int duration;
    public Song() {}
    public Song (String name, int duration) {
        this.name = name;
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Song{" + "name=" + name + ", duration=" + duration + '}';
    }
    
    
}
