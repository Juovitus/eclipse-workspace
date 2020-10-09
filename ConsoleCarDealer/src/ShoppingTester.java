

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import controller.ListDetailsHelper;
import model.ListDetails;
import model.ListType;
import model.Shopper;

public class ShoppingTester {
	public static void main(String[] args) {
			Shopper susan = new Shopper("Susan");
			ListDetailsHelper ldh = new ListDetailsHelper();
			ListType shampoo = new ListType("Target", "Shampoo");
			ListType brush = new ListType("Target", "Brush");
			List<ListType> susansItems = new ArrayList<ListType>();
			susansItems.add(shampoo);
			susansItems.add(brush);
			ListDetails susansList = new ListDetails("Susan's ShoppingList", LocalDate.now(), susan);
			susansList.setListOfItems(susansItems);
			ldh.insertNewListDetails(susansList);
			List<ListDetails> allLists = ldh.getLists();
			for(ListDetails a: allLists) {
				System.out.print(a.toString());
			}
	}
}
