public class HealthRecord{

    private int height;

    private static final int MIN_PERMITTED_HEIGHT = 50;
    private static final int MAX_PERMITTED_HEIGHT = 175;
    private static final int DEFAULT_HEIGHT = 100;

    private static int tallestHeight = MIN_PERMITTED_HEIGHT;
    private static int shortestHeight = MAX_PERMITTED_HEIGHT;

    //ADD NEW STATIC FIELDS
    public static int counter=0;
    public static double averageHeight;

    public HealthRecord(int  height) {
        setHeight(height);
        counter++; //to count each student after height is set
    }
    public int getHeight() {
        return this.height;
    }

    public void setHeight(int height) {

        if (height > MIN_PERMITTED_HEIGHT) {
            this.height = height;
        } else {
            this.height = DEFAULT_HEIGHT;
        }

        if (height > tallestHeight) {
            tallestHeight = this.height;
        }
        if (height < shortestHeight) {
            shortestHeight = this.height;
        }

        //update average height y'=(y*n+x)/(n+1)
        averageHeight = (averageHeight*counter+this.height)/(counter+1);
    }

    //add static method (average height)
    public static double getAverageHeight() {
        return averageHeight;
    }
    public static int getTallestHeight() {
        return tallestHeight;
    }
    public static int getShortestHeight() {
        return shortestHeight;
    }
    public void displayDetails() {
        System.out.println("Height (cm) : " + getHeight());
    }

    public static void displayClassDetails() {
        System.out.println("-.-.-.-.-.-.-.-.-.-.-.-.-.-.-");
        System.out.println("The Tallest Height (cm) : " + getTallestHeight());
        System.out.println("-.-.-.-.-.-.-.-.-.-.-.-.-.-.-");
        System.out.println("The Shortest Height (cm) : " + getShortestHeight());
        System.out.println("-.-.-.-.-.-.-.-.-.-.-.-.-.-.-");
        System.out.println("The average Height (cm) : " + getAverageHeight());
        System.out.println("<><><><><><><><><><><><><><><>");
    }
}
