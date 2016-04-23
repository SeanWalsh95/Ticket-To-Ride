import java.awt.*;
import java.util.*;
import java.io.File;
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

    public Image getImage(){
        String filePath = path+color+".jpg";
        try(Scanner sc = new Scanner(new File(filePath))){
            Toolkit toolkit = Toolkit.getDefaultToolkit();
            return toolkit.getImage(filePath);
        }catch(Exception e){
            System.err.println("(ERR Train.getImage): Cannot find file \""+filePath+"\"");
        }
        return null;
    }
}
