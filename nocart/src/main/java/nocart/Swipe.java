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

public class Swipe
{
    public static void performSwipe(AppiumDriver driver, WebElement element, double startRatio, double endRatio, int durationMillis)
    {
        Point location = element.getLocation();
        Dimension size = element.getSize();
        int startX = location.getX() + (int) (size.width * startRatio);
        int endX = location.getX() + (int) (size.width * endRatio);
        int startY = location.getY() + size.height / 2;
        
        PointerInput swipe = new PointerInput(Kind.TOUCH, "finger1");
        Sequence swipeSequence = new Sequence(swipe, 0);
        swipeSequence.addAction(swipe.createPointerMove(Duration.ofMillis(0), Origin.viewport(), startX, startY));
        swipeSequence.addAction(swipe.createPointerDown(MouseButton.LEFT.asArg()));
        swipeSequence.addAction(swipe.createPointerMove(Duration.ofMillis(durationMillis), Origin.viewport(), endX, startY));
        swipeSequence.addAction(swipe.createPointerUp(MouseButton.LEFT.asArg()));
        driver.perform(Arrays.asList(swipeSequence));
    } 
} 