package nocart;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.PointerInput.Origin;
import org.openqa.selenium.interactions.PointerInput.Kind;
import org.openqa.selenium.interactions.PointerInput.MouseButton;
import org.openqa.selenium.interactions.Sequence;
import io.appium.java_client.AppiumDriver;
import java.time.Duration;
import java.util.Arrays;

public class Scroll
{
    public static void performScroll(AppiumDriver driver, WebElement element, double startRatio, double endRatio, int durationMillis)
    {
        Point location = element.getLocation();
        Dimension size = element.getSize();
        int startX = location.getX() + (int) (size.width * startRatio);
        int endX = location.getX() + (int) (size.width * endRatio);
        int startY = location.getY() + size.height;
        int endY = location.getY() + (int) (size.height * startRatio);

        PointerInput scroll = new PointerInput(Kind.TOUCH, "finger1");
        Sequence scrollSequence = new Sequence(scroll, 0);
        scrollSequence.addAction(scroll.createPointerMove(Duration.ofMillis(0), Origin.viewport(), startX, startY));
        scrollSequence.addAction(scroll.createPointerDown(MouseButton.LEFT.asArg()));
        scrollSequence.addAction(scroll.createPointerMove(Duration.ofMillis(durationMillis), Origin.viewport(), endX, endY));
        scrollSequence.addAction(scroll.createPointerUp(MouseButton.LEFT.asArg()));
        driver.perform(Arrays.asList(scrollSequence));
    } 
}
