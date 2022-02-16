import com.revature.weddingmart.daos.AssetBookingDAO;
import com.revature.weddingmart.daos.AssetDAO;
import com.revature.weddingmart.daos.AssetTypeDAO;
import com.revature.weddingmart.daos.MealChoiceDAO;
import com.revature.weddingmart.daos.MealOrderDAO;
import com.revature.weddingmart.daos.MealOrderPlusOneDAO;
import com.revature.weddingmart.daos.WeddingDAO;
import com.revature.weddingmart.daos.users.AttendeeDAO;
import com.revature.weddingmart.daos.users.BetrothedDAO;
import com.revature.weddingmart.daos.users.EmployeeDAO;
import com.revature.weddingmart.daos.users.UserDAO;
import com.revature.weddingmart.models.Asset;
import com.revature.weddingmart.models.AssetBooking;
import com.revature.weddingmart.models.AssetType;
import com.revature.weddingmart.models.MealChoice;
import com.revature.weddingmart.models.MealOrder;
import com.revature.weddingmart.models.MealOrderPlusOne;
import com.revature.weddingmart.models.Wedding;
import com.revature.weddingmart.models.users.Attendee;
import com.revature.weddingmart.models.users.Betrothed;
import com.revature.weddingmart.models.users.Employee;
import com.revature.weddingmart.models.users.User;

public class DAOTestDriver {

	public static void main(String[] args) {
		AssetTypeDAO assetTypeDAO = new AssetTypeDAO();
		AssetType assetType = new AssetType();
		assetType = assetTypeDAO.getById(1);
		
		AssetDAO assetDAO = new AssetDAO();
		Asset asset = new Asset();
		asset.setAddress("address");
		asset.setEmail("email");
		asset.setName("name");
		asset.setPhone("phone");
		asset.setPrice(9001.99);
		asset.setType(assetType);
		asset = assetDAO.addAsset(asset);
		
		UserDAO userDAO = new UserDAO();
		User user = new User();
		
		EmployeeDAO employeeDAO = new EmployeeDAO();
		Employee employee = new Employee();
		
		WeddingDAO weddingDAO = new WeddingDAO();
		Wedding wedding = new Wedding();
		
		BetrothedDAO betrothedDAO = new BetrothedDAO();
		Betrothed betrothed = new Betrothed();
		
		AssetBookingDAO assetBookingDAO = new AssetBookingDAO();
		AssetBooking assetBooking = new AssetBooking();
		
		AttendeeDAO attendeeDAO = new AttendeeDAO();
		Attendee attendee = new Attendee();
		
		MealChoiceDAO mealChoiceDAO = new MealChoiceDAO();
		MealChoice mealChoice = new MealChoice();
		
		MealOrderDAO mealOrderDAO = new MealOrderDAO();
		MealOrder mealOrder = new MealOrder();
		
		MealOrderPlusOneDAO mealOrderPlusOneDAO = new MealOrderPlusOneDAO();
		MealOrderPlusOne mealOrderPlusOne = new MealOrderPlusOne();
		
	}

}
