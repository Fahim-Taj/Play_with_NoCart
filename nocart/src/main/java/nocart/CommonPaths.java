package nocart;

public class CommonPaths
{
   public static String electronicsMenu = "//android.widget.TextView[@resource-id=\"com.nopstation.nopcommerce.nopstationcart:id/tvProductName\" and @text=\"Electronics\"]"; 
   public static String productList = "(//android.widget.ImageView[@content-desc=\"Placeholder\"])[4]"; 
   public static String mattressSelect = "//android.widget.TextView[@resource-id=\"com.nopstation.nopcommerce.nopstationcart:id/tvProductName\" and @text=\"Mattress Bedroom\"]"; 
   public static String scrollAdd = "//android.widget.ScrollView[@resource-id=\"com.nopstation.nopcommerce.nopstationcart:id/rootScrollViewBillingAddress\"]/android.widget.LinearLayout"; 
   public static String chsCountry = "(//android.widget.TextView[@resource-id=\"android:id/text1\"])[2]"; 
   public static String chsState = "//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"AA (Armed Forces Americas)\"]";
   public static String selectGrid = "//com.bs.ecommerce.customViews.RadioGridGroupforReyMaterial[@resource-id=\"com.nopstation.nopcommerce.nopstationcart:id/radioGridGroup\"]/android.widget.RelativeLayout[4]";
   public static String continueBtn = "(//android.widget.Button[@resource-id=\"com.nopstation.nopcommerce.nopstationcart:id/btnContinue\"])[2]";
   public static String srlPay = "//com.bs.ecommerce.customViews.RadioGridGroupforReyMaterial[@resource-id=\"com.nopstation.nopcommerce.nopstationcart:id/radioGridGroup\"]/android.widget.RelativeLayout[5]";
   public static String nxtBtn = "//android.widget.Button[@text=\"Next\"]";
}
