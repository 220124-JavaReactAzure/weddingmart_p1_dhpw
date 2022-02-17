import java.util.Date;

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
		UserDAO userDAO = new UserDAO();
		User user = new User();
		user.setEmail("email");
		user.setPassword("password");
		user.setPhone("phone");
		user.setUsername("username");
		user = userDAO.addUser(user);
		System.out.println(user);
		
		AssetTypeDAO assetTypeDAO = new AssetTypeDAO();
		AssetType assetType = new AssetType();
		assetType.setId(0);
		assetType.setDescription("caterer");
		
		AssetDAO assetDAO = new AssetDAO();
		Asset asset = new Asset();
		asset.setAddress("address");
		asset.setEmail("email");
		asset.setName("name");
		asset.setPhone("phone");
		asset.setPrice(9001.99);
		asset.setType(assetType);
		asset = assetDAO.addAsset(asset);
		System.out.println(asset);
		
		EmployeeDAO employeeDAO = new EmployeeDAO();
		Employee employee = new Employee();
		employee.setManager(false);
		employee.setUser(user);
		employee = employeeDAO.addEmployee(employee);
		System.out.println(employee);
		
		WeddingDAO weddingDAO = new WeddingDAO();
		Wedding wedding = new Wedding();
		wedding.setBudget(18002);
		wedding = weddingDAO.addWedding(wedding);
		System.out.println(wedding);
		
		BetrothedDAO betrothedDAO = new BetrothedDAO();
		Betrothed betrothed = new Betrothed();
		betrothed.setUser(user);
		betrothed.setWedding(wedding);
		betrothed = betrothedDAO.addBetrothed(betrothed);
		System.out.println(betrothed);
		
		AssetBookingDAO assetBookingDAO = new AssetBookingDAO();
		AssetBooking assetBooking = new AssetBooking();
		assetBooking.setAsset(asset);
		assetBooking.setWedding(wedding);
		assetBooking = assetBookingDAO.addAssetBooking(assetBooking);
		
		AttendeeDAO attendeeDAO = new AttendeeDAO();
		Attendee attendee = new Attendee();
		attendee.setUser(user);
		attendee.setWedding(wedding);
		attendee = attendeeDAO.addAttendee(attendee);
		System.out.println(attendee);
		
		MealChoiceDAO mealChoiceDAO = new MealChoiceDAO();		
		MealChoice mealChoice = new MealChoice();		
		mealChoice.setId(0);
		mealChoice.setDescription("meat");
		
		MealOrderDAO mealOrderDAO = new MealOrderDAO();
		MealOrder mealOrder = new MealOrder();
		mealOrder.setAttendee(attendee);
		mealOrder.setLunchChoice(mealChoice);
		mealOrder.setDinnerChoice(mealChoice);
		mealOrder = mealOrderDAO.addMealOrder(mealOrder);
		System.out.println(mealOrder);
		
		MealOrderPlusOneDAO mealOrderPlusOneDAO = new MealOrderPlusOneDAO();
		MealOrderPlusOne mealOrderPlusOne = new MealOrderPlusOne();
		mealOrderPlusOne.setAttendee(attendee);
		mealOrderPlusOne.setLunchChoice(mealChoice);
		mealOrderPlusOne.setDinnerChoice(mealChoice);
		mealOrderPlusOne = mealOrderPlusOneDAO.addMealOrderPlusOne(mealOrderPlusOne);
		System.out.println(mealOrderPlusOne);
		
		userDAO.deleteUser(user);
		assetDAO.deleteAsset(asset);
		mealChoiceDAO.deleteMealChoice(mealChoice);
		weddingDAO.deleteWedding(wedding);
	}

}
