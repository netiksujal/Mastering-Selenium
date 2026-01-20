package WorkingWithSync;
import org.openqa.selenium.BuildInfo;

public class Test {
    public static void main(String[] args) {
        System.out.println(new BuildInfo().getReleaseLabel());
    }
}
