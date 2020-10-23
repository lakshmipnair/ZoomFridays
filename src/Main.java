import com.apartmentlist.al.util.ZoomUtil;

public class Main {

    public static void main(String[] args) {
        ZoomUtil.displayChoice();
        int choice = ZoomUtil.readUserChoice();
        while(choice != 5)
        {
            ZoomUtil.executeUsersChoice(choice);
            ZoomUtil.displayChoice();
            choice = ZoomUtil.readUserChoice();
        }

    }
}
