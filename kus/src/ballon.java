import java.util.Collections;
import java.util.Vector;

public class ballon
{
    private int startx;
    private int endx;

    public ballon(){};

    public ballon(int start, int end)
    {
        startx=start;
        endx=end;
    }

    public     int getStart() { return startx; }

    public int  getEnd() { return endx; }

    public static ballon generator()
    {
        int startx=(int) (Math.random() * 20);
        int endx=startx+ (int) (Math.random() * 20);
        return new ballon(startx, endx);
    }

    public static Vector<ballon> sort (Vector<ballon> ballons)
    {
        for (int i=0; i<ballons.size()-1; i++)
        {
            for (int j=i+1; j<ballons.size(); j++)
            {
                if (ballons.elementAt(i).getEnd() > ballons.elementAt(j).getEnd())
                {
                    Collections.swap(ballons, i, j);
                }
            }
        }
        return ballons;
    }

}
