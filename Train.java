
/**
 * Write a description of class Train here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Train extends Card
{
    RouteColor color;
    private static final String path = "resources\\images\\cards\\train cards\\";
    /**
     * import from csv in the format RouteColor
     * 
     */
    public Train(RouteColor color){
        this.color = color;
    }

    public String getImage(){
        return path+color+".jpg";
    }
}
