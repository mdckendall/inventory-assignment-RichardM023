import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
import java.util.InputMismatchException;

class Main {
  private List<Item> inventory;
  private Scanner scanner;

public Main() {
  inventory = new ArrayList<>();
  scanner = new Scanner(System.in);
}
  public void run() {
    int choice;
    do {
      InvenMenu();
      choice = getUserInput();
      switch (choice) {
        case 1:
          addItem();
          break;
        case 2:
          deleteItem();
          break;
        case 3:
          updateItem();
          break;
        case 4:
          showAllItem();
        case 5: 
          System.out.println("");
          break;
        default:
          System.out.println("Invalid choice. Try again.");
          break;
      }
    } while(choice != 5);
  }
  
  private void InvenMenu() {
    System.out.println("Press 1 to add an item.");
    System.out.println("Press 2 to delete an item.");
    System.out.println("Press 3 to update an item.");
    System.out.println("Press 4 to show all the items.");
    System.out.println("Press 5 to quit the program.");
  }
  private int getUserInput() {
    try {
      return scanner.nextInt();
    } catch (InputMismatchException e) {
      scanner.nextLine();
      return -1;
    }
  }
  private void addItem() {
    scanner.nextLine();
    System.out.println("Enter the name:");
    String name = scanner.nextLine();
    System.out.println("Enter the serial number:");
    String serialNum = scanner.nextLine();
    System.out.println("Enter the value in dollars (whole number):");
    int value = scanner.nextInt();
    Item item = new Item(name, serialNum, value);
    inventory.add(item);
  }
  private void deleteItem() {
    scanner.nextLine();
    System.out.println("Enter the serial number of the item to delete:");
    String serialNum = scanner.nextLine();
    boolean remove = false;
    for(Item item : inventory) {
      if(item.getSerialNum().equals(serialNum)) {
        inventory.remove(item);
        remove = true;
        break;
      }
    }
  }
  private void updateItem() {
    scanner.nextLine();
    System.out.println("Enter the serial number of the item to change:");
    String serialNum = scanner.nextLine();
    for (Item item : inventory) {
      if(item.getSerialNum().equals(serialNum)) {
        System.out.println("Enter the new name:");
        String newName = scanner.nextLine();
        System.out.println("Enter the new value in dollars (whole number)");
        int newValue = scanner.nextInt();
        item.setName(newName);
        item.setValue(newValue);
        
      }
    }
  }
  private void showAllItem() {
    
    for (Item item : inventory) {
        System.out.println(item);
    }
  }
  
  public static void main(String[] args) {
    Inventory inventory = new Inventory();
    inventory.run();
  }
}

class Item {
  private String name;
  private String serialNum;
  private int value;

  public Item(String name, String serialNum, int value) {
    this.name = name;
    this.serialNum = serialNum;
    this.value = value;
  }
  public String getName() {
    return name;
  }
  public String getSerialNum() {
    return serialNum;
  }
  public int value() {
    return value;
  }
  public void setName(String name){
    this.name = name;
  }
  public void setValue(int value) {
    this.value = value;
  }
  @Override
  public String toString() {
    return name + "," + serialNum + "," + value;
  }
}
