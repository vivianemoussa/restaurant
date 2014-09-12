package citygrill.data;

import java.util.ArrayList;

import com.order.R;

import citygrill.data.Product.Type;
import citygrill.restaurant.Table;

/**
 * The Class DataProvider.
 */
public class DataProvider {

	public static ArrayList<Table> tables;
	public static ArrayList<Product> products;
	public static ArrayList<ProductCategory> categories;

	/**
	 * Gets the tables in the restaurant.
	 *
	 * @return the tables
	 */
	public static void generateTables()
	{
		tables=new ArrayList<Table>();
		tables.add(new Table(0,3));
		tables.add(new Table(1,4));
		tables.add(new Table(2,4));
		tables.add(new Table(3,2));
		tables.add(new Table(4,6));
		tables.add(new Table(5,8));
		tables.add(new Table(6,4));
		tables.add(new Table(7,2));

		tables.get(4).empty=false; 
		tables.get(4).curClients=5;
		tables.get(2).empty=false; 
		tables.get(2).curClients=3;

	}

	/**
	 * Gets the tables.
	 *
	 * @return the tables
	 */
	public static ArrayList<Table> getTables()
	{
		return tables;
	}

	/**
	 * Generate products.
	 */
	public static void generateProducts()
	{
		products=new ArrayList<Product>();
		products.add(new Product("Ciorba vacuta", 8, R.drawable.soup, Type.Soup));
		products.add(new Product("Ciorba pui", 8, R.drawable.soup1, Type.Soup));
		products.add(new Product("Ciorba burta", 8.5f, R.drawable.soup2, Type.Soup));
		products.add(new Product("Supa de taitei", 7, R.drawable.soup3, Type.Soup));

		products.add(new Product("Chocolate Muffin", 6, R.drawable.pic12, Type.Dessert));
		products.add(new Product("Chocolate Dosa Rolled", 12, R.drawable.pic10, Type.Dessert));
		products.add(new Product("Chocolate Pancakes", 8, R.drawable.pic02, Type.Dessert));
		products.add(new Product("Crab Cake", 8, R.drawable.pic01, Type.Dessert));
		products.add(new Product("Pancakes", 10.5f, R.drawable.pancakes, Type.Dessert));

		products.add(new Product("Steak Sirloin", 14, R.drawable.pic03, Type.MainDish));
		products.add(new Product("Chicken Burger", 16, R.drawable.pic04, Type.MainDish));
		products.add(new Product("Swizz Ham and Cheese", 12, R.drawable.pic05, Type.MainDish));
		products.add(new Product("Sea Food Platter", 13.5f, R.drawable.pic06, Type.MainDish));
		products.add(new Product("Deluxe Sandwich", 14, R.drawable.pic07, Type.MainDish));
		products.add(new Product("Pepperoni Pizza", 16, R.drawable.pic08, Type.MainDish));
		products.add(new Product("Chinese Meal", 14, R.drawable.pic09, Type.MainDish));
		products.add(new Product("Allegro Pasta", 14.5f, R.drawable.pic11, Type.MainDish));
		products.add(new Product("Spaghete milaneze", 13, R.drawable.food1, Type.MainDish));
		products.add(new Product("Platou pentru", 23, R.drawable.main_dish, Type.MainDish));
		products.add(new Product("Pasta", 25, R.drawable.pasta, Type.MainDish));

		products.add(new Product("Peroni", 7, R.drawable.alcoolfirmtakes, Type.Alcoholic));
		products.add(new Product("Bergenbier", 4.5f, R.drawable.martininuevo, Type.Alcoholic));
		products.add(new Product("Ursus", 5, R.drawable.alcoholicdrink, Type.Alcoholic));
		products.add(new Product("Stella", 5, R.drawable.alcoolimages, Type.Alcoholic));
		products.add(new Product("Pina Colada", 14, R.drawable.alcoolirish, Type.Alcoholic));

		products.add(new Product("Splin", 4, R.drawable.carynesplin, Type.NonAlcoholic));
		products.add(new Product("Cocktail drink", 4, R.drawable.cocktails, Type.NonAlcoholic));
		products.add(new Product("Jus", 4, R.drawable.colorjus, Type.NonAlcoholic));
		products.add(new Product("Prigat", 5, R.drawable.jus, Type.NonAlcoholic));
		products.add(new Product("Virgin Mary", 8, R.drawable.drink2, Type.NonAlcoholic));

		products.add(new Product("Alune", 4, R.drawable.other, Type.Other));
		products.add(new Product("Nachos", 6.5f, R.drawable.other, Type.Dessert));
	}

	/**
	 * Gets the products.
	 *
	 * @return the products
	 */
	public static ArrayList<Product> getProducts()
	{
		return products;
	}

	/**
	 * Generates the product categories.
	 */
	public static void generateProductCategories()
	{
		categories=new ArrayList<ProductCategory>();
		categories.add(new ProductCategory("Bauturi Alcoolice", Type.Alcoholic, R.drawable.alcoholicdrinks));
		categories.add(new ProductCategory("Bauturi Nealcoolice", Type.NonAlcoholic, R.drawable.champ));
		categories.add(new ProductCategory("Mancaruri gatite", Type.MainDish, R.drawable.main_dish));
		categories.add(new ProductCategory("Supe/Ciorbe",Type.Soup, R.drawable.soup4));
		categories.add(new ProductCategory("Deserturi", Type.Dessert, R.drawable.dessert));
		categories.add(new ProductCategory("Diverse", Type.Other, R.drawable.other));		
	}

	/**
	 * Gets the product categories.
	 *
	 * @return the product categories
	 */
	public static ArrayList<ProductCategory> getProductCategories()
	{
		return categories;
	}

	/**
	 * Gets the products from a given category (of a given type).
	 *
	 * @param category the category
	 * @return the products from category
	 */
	public static ArrayList<Product> getProductsFromCategory(Type category)
	{
		ArrayList<Product> retProds=new ArrayList<Product>();
		for(Product p:products)
			if(p.type==category)
				retProds.add(p);
		return retProds;
	}

	/**
	 * Gets a table with the given id.
	 *
	 * @param id the id
	 * @return the table
	 */
	public static Table getTable(int id)
	{
		for(Table t: tables)
			if( t.id==id)
				return t;
		return null;
	}

	/**
	 * Gets an order with a given id.
	 *
	 * @param tableID the table id
	 * @param orderID the order id
	 * @return the table
	 */
	public static Order getOrder(int tableID, int orderID)
	{
		for(Order o: tables.get(tableID).tableOrder.orders)
			if(o.id==orderID)
				return o;
		return null;
	}

	/**
	 * Gets an order product from a given order.
	 *
	 * @param order the order
	 * @param product the product
	 * @return the table
	 */
	public static OrderProduct getOrder(Order order, Product product)
	{
		for(OrderProduct o: order.products)
			if(o.product==product)
				return o;
		return null;
	}
}