public class Main{
    public static void main(String[] args) {
        Generator generator = new Generator();
        for (int i = 1; i <= 50; i++)
        {
            generator.GenerateDot(String.valueOf(i));
            generator.GenerateGraphs(String.valueOf(i));
        }
    }
}