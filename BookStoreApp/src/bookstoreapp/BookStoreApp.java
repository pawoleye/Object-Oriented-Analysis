/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BookStoreApp;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.scene.layout.*;
import javafx.geometry.Insets;
import java.io.*;
import java.util.*;
import java.text.ParseException;
import static javafx.application.Application.launch;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.control.cell.*;
import javafx.scene.text.Font;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.WindowEvent;
import javafx.scene.control.TextField;


/**
 *
 * @author apisa
 */

public class BookStoreApp extends Application{
    private String user,pass;
    private Owner owner = Owner.getInstance();
    private Customer customer = new Customer(user,pass);
    private double totalCost = 0;
    
    
    @Override
    public void start(Stage primaryStage){
        
        //login code starts
        VBox loginVboxText = new VBox(15);
        VBox loginVboxInput = new VBox(5);
        HBox loginHbox = new HBox(10);
        VBox loginVbox = new VBox(10);
        
        
        Label welcomeMsg = new Label("Welcome to the BookStore App");
        Label usernameL = new Label("Username: ");
        Label passwordL = new Label("Password: ");
        Label blank1 = new Label("");
        Label blank2 = new Label("");
        Label blank3 = new Label("");
        TextField usernameTF = new TextField();
        TextField passwordTF = new TextField();
        Button loginBtn = new Button("Login");
        Label loginErrorOne = new Label("");
        Label loginErrorTwo = new Label("");
        
        loginVboxText.getChildren().addAll(welcomeMsg, usernameL, passwordL);
        loginVboxInput.getChildren().addAll(blank1, blank2, blank3, usernameTF, passwordTF, loginBtn);
        loginVboxText.setAlignment(Pos.CENTER_LEFT);
        loginVboxInput.setAlignment(Pos.CENTER_LEFT);
        
        
        loginHbox.getChildren().addAll(loginVboxText, loginVboxInput);
        loginHbox.setAlignment(Pos.CENTER);
        loginVbox.getChildren().addAll(loginHbox, loginErrorOne, loginErrorTwo);
        loginVbox.setAlignment(Pos.CENTER);
        
        Scene loginPage = new Scene(loginVbox, 800, 500);
        
        primaryStage.setScene(loginPage);
        primaryStage.setTitle("Bookstore App");
        primaryStage.show();
        //login code ends
        
        //owner-start-screen code begins
        VBox ownerStartVbox = new VBox(25);
        
        Button ownerViewBooksBtn = new Button("Books");
        Button ownerViewCustomersBtn = new Button("Customers");
        Button logoutBtn = new Button("Logout");
        ownerViewBooksBtn.setMaxWidth(150);
        ownerViewCustomersBtn.setMaxWidth(150);
        logoutBtn.setMaxWidth(150);
                
        ownerStartVbox.getChildren().addAll(ownerViewBooksBtn, ownerViewCustomersBtn, logoutBtn);
        ownerStartVbox.setAlignment(Pos.CENTER);
        
        Scene ownerStartScreen = new Scene(ownerStartVbox, 800, 500);
        
        
        //logoutButtonCode starts here
        logoutBtn.setOnAction(
                new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent e){
                loginErrorOne.setText("");
                loginErrorTwo.setText("");
                primaryStage.setScene(loginPage);
            }    
        }
        );
        //logoutButtonCode ends here
        
        
        //ownerShowBooks code starts here
        
        //table to display avalaiable books
        
        TableView<Book> ownerTableOfBooks = new TableView<Book>();
        
        final ObservableList<Book> availableBooks = 
            FXCollections.observableArrayList();
        
        final ObservableList<Customer> existingCustomers = 
            FXCollections.observableArrayList();            
        
        for(Book b : owner.getBooks()){
            availableBooks.add(b);
        }
        VBox ownerViewBooksVbox = new VBox(10);
        
        ownerTableOfBooks.setEditable(true);
        
        
        TableColumn ownerBookNameCol = new TableColumn("Book Name");
        ownerBookNameCol.setMinWidth(400);
        ownerBookNameCol.setCellValueFactory(
            new PropertyValueFactory<>("bookName"));
        
        
        TableColumn ownerBookPriceCol = new TableColumn("Book Price");
        ownerBookPriceCol.setMinWidth(400);
        ownerBookPriceCol.setCellValueFactory(
            new PropertyValueFactory<>("bookPrice"));
       
        ownerTableOfBooks.setItems(availableBooks);
        
         Label emptyAddBook = new Label("");
        
        ownerTableOfBooks.getColumns().addAll(ownerBookNameCol, ownerBookPriceCol);
        
        final TextField addBookName = new TextField();
        addBookName.setMaxWidth(400);
        addBookName.setPromptText("Book Name: ");

        final TextField addBookPrice = new TextField();
        addBookPrice.setMaxWidth(400);
        addBookPrice.setPromptText("Book Price: ");
        
        final Button addBookBtn = new Button("Add");
        addBookBtn.setMaxWidth(200);
        addBookBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                if(!(addBookName.getText().isEmpty()) && !(addBookPrice.getText().isEmpty())){
                    emptyAddBook.setText("");
                    Book b = new Book(addBookName.getText(), Double.parseDouble(addBookPrice.getText()));
                    availableBooks.add(b);
                    owner.addBook(b);
                    addBookName.clear();
                    addBookPrice.clear();
                    writeBook();
                }
                else{
                    emptyAddBook.setText("Cannot add empty book information");
                }
            }
        });
        
       Button deleteBookBtn = new Button("Delete");
       deleteBookBtn.setMaxWidth(200);
       deleteBookBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                ObservableList<Book> allBooks, selectedBook;
                
                allBooks = ownerTableOfBooks.getItems();
                selectedBook = ownerTableOfBooks.getSelectionModel().getSelectedItems();
                
                for(Book b : selectedBook){
                    allBooks.remove(b);
                    owner.removeBook(b);
                }
                writeBook();
            }
        });
        
       Button backBtnOne = new Button("Back");
       backBtnOne.setMaxWidth(200);
       backBtnOne.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                primaryStage.setScene(ownerStartScreen);
            }
        });
       
      

        
        HBox ownerViewBooksHboxOne = new HBox(10);
        HBox ownerViewBooksHboxTwo = new HBox(10);
        
        ownerViewBooksHboxOne.getChildren().addAll(addBookName, addBookPrice, addBookBtn);
        ownerViewBooksHboxTwo.getChildren().addAll(deleteBookBtn, backBtnOne, emptyAddBook);
        
        ownerViewBooksVbox.getChildren().addAll(ownerTableOfBooks, ownerViewBooksHboxOne, ownerViewBooksHboxTwo, emptyAddBook);
        
        
        Scene ownerViewBooksScreen = new Scene(ownerViewBooksVbox,800, 500);
        
               
        ownerViewBooksBtn.setOnAction(
                new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                emptyAddBook.setText("");
                primaryStage.setScene(ownerViewBooksScreen);
            }
        }
        );
        //ownerViewBooksScreen ends here
        
        //ownerViewCustomersScreen starts here
        
        TableView<Customer> tableOfCustomers = new TableView<Customer>();
        
        VBox ownerViewCustomersVbox = new VBox(10);
        
        tableOfCustomers.setEditable(true);
        
        TableColumn customerUsernameCol = new TableColumn("Customer Username");
        customerUsernameCol.setMinWidth(350);
        customerUsernameCol.setCellValueFactory(
            new PropertyValueFactory<>("username"));
        
        
        TableColumn customerPasswordCol = new TableColumn("Customer Password");
        customerPasswordCol.setMinWidth(350);
        customerPasswordCol.setCellValueFactory(
            new PropertyValueFactory<>("password"));
        
        TableColumn customerPointsCol = new TableColumn("Customer Points");
        customerPointsCol.setMinWidth(100);
        customerPointsCol.setCellValueFactory(
            new PropertyValueFactory<>("points"));
       
        tableOfCustomers.setItems(existingCustomers);
        
        Label emptyAddCustomer = new Label("");
        Label existingCustomerError = new Label("");
 
        tableOfCustomers.getColumns().addAll(customerUsernameCol, customerPasswordCol, customerPointsCol);
        
        final TextField addCustomerUsername = new TextField();
        addCustomerUsername.setMaxWidth(400);
        addCustomerUsername.setPromptText("Customer Username: ");

        final TextField addCustomerPassword = new TextField();
        addCustomerPassword.setMaxWidth(400);
        addCustomerPassword.setPromptText("Customer Password: ");
        
        final Button addCustomerBtn = new Button("Add");
        addCustomerBtn.setMaxWidth(200);
        addCustomerBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                if(!(addCustomerUsername.getText().isEmpty()) && !(addCustomerPassword.getText().isEmpty())){
                    boolean tf = false;
                    existingCustomerError.setText("");
                    emptyAddCustomer.setText("");
                    for(Customer c : owner.getCustomers()){
                        if(c.getUsername().equals((String)addCustomerUsername.getText())){
                            existingCustomerError.setText("Username already exists");
                            tf = true;
                            break;
                        }
                    }
                    if(tf == false){
                        Customer c = new Customer((String)addCustomerUsername.getText(), (String)addCustomerPassword.getText());
                        System.out.println(c.displayLoginMessage());
                        existingCustomers.add(c);
                        owner.addCustomer(c);
                        writeCustomer();
                        addCustomerUsername.clear();
                        addCustomerPassword.clear();
                    }
                }
                else{
                    existingCustomerError.setText("");
                    emptyAddCustomer.setText("Cannot add empty user informtion");
                }
            }
        });
        
       Button deleteCustomerBtn = new Button("Delete");
       deleteCustomerBtn.setMaxWidth(200);
       deleteCustomerBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                ObservableList<Customer> allCustomers, selectedCustomer;
                
                allCustomers = tableOfCustomers.getItems();
                selectedCustomer = tableOfCustomers.getSelectionModel().getSelectedItems();
                
                for(Customer c : selectedCustomer){
                    allCustomers.remove(c);
                    owner.removeCustomer(c);
                }
                writeCustomer();                
            }
        });
       
       Button backBtnTwo = new Button("Back");
       backBtnTwo.setMaxWidth(200);
       backBtnTwo.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                primaryStage.setScene(ownerStartScreen);
            }
        });

        
        HBox ownerViewCustomersHboxOne = new HBox(10);
        HBox ownerViewCustomersHboxTwo = new HBox(10);
        
        ownerViewCustomersHboxOne.getChildren().addAll(addCustomerUsername, addCustomerPassword, addCustomerBtn);
        ownerViewCustomersHboxTwo.getChildren().addAll(deleteCustomerBtn, backBtnTwo);
        
        ownerViewCustomersVbox.getChildren().addAll(tableOfCustomers, ownerViewCustomersHboxOne, ownerViewCustomersHboxTwo, emptyAddCustomer, existingCustomerError);
        
        
        Scene ownerViewCustomersScreen = new Scene(ownerViewCustomersVbox,800, 500);
        
        ownerViewCustomersBtn.setOnAction(
                new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                existingCustomerError.setText("");
                emptyAddCustomer.setText("");
                primaryStage.setScene(ownerViewCustomersScreen);
            }
        }
        );
        //ownerViewCustomersScreen ends here
        
        //customer-start-screen
        VBox customerStartVbox = new VBox(25);
        HBox customerStartHbox = new HBox(10);
        
        Label customerWelcomeMessage = new Label("");
//        if(customer != null){
//            customerWelcomeMessage = new Label(customer.displayLoginMessage());
//        }
                
        TableView<Book> customerTableOfBooks = new TableView<Book>();
                
        TableColumn customerBookNameCol = new TableColumn("Book Name");
        customerBookNameCol.setMinWidth(375);
        customerBookNameCol.setCellValueFactory(
            new PropertyValueFactory<>("bookName"));
        
        
        TableColumn customerBookPriceCol = new TableColumn("Book Price");
        customerBookPriceCol.setMinWidth(375);
        customerBookPriceCol.setCellValueFactory(
            new PropertyValueFactory<>("bookPrice"));
        
        TableColumn customerSelectBookCol = new TableColumn("Select");
        customerSelectBookCol.setMinWidth(50);
        customerSelectBookCol.setCellValueFactory(
            new PropertyValueFactory<>("bookSelect"));
        
        customerTableOfBooks.setItems(availableBooks);
                
        customerTableOfBooks.getColumns().addAll(customerBookNameCol, customerBookPriceCol, customerSelectBookCol);
        
        
        Button buyBookBtn = new Button("Buy"); 
        buyBookBtn.setMaxWidth(200);
        
        
       Button redeemPointsAndBuyBtn = new Button("Redeem points and Buy");
       redeemPointsAndBuyBtn.setMaxWidth(200);
               
      
        
        Button customerLogoutBtnOne = new Button("Logout");
        customerLogoutBtnOne.setMaxWidth(200);
        customerLogoutBtnOne.setOnAction(
                new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent e){
                loginErrorOne.setText("");
                loginErrorTwo.setText("");
                availableBooks.removeAll(availableBooks);
                owner.getBooks().removeAll(owner.getBooks());
                existingCustomers.removeAll(existingCustomers);
                owner.getCustomers().removeAll(owner.getCustomers());
                primaryStage.setScene(loginPage);
            }    
        }
        );
        
        customerStartHbox.getChildren().addAll(buyBookBtn, redeemPointsAndBuyBtn, customerLogoutBtnOne);     
        customerStartVbox.getChildren().addAll(customerWelcomeMessage, customerTableOfBooks, customerStartHbox);
        customerStartVbox.setAlignment(Pos.CENTER);
       
        
        Scene customerStartScreen = new Scene(customerStartVbox, 800, 500);
        
        
        
        //customerStartScreen Code ends here
        
        
        //customerCostScreen code start here
        
        VBox customerCostVbox = new VBox(50);
        
        Label totalCostMsg = new Label();
        
        Label pointsAndStatusMsg = new Label();
        
        
        
        Button customerLogoutBtnTwo = new Button("Logout");
        customerLogoutBtnTwo.setMaxWidth(200);
        customerLogoutBtnTwo.setOnAction(
                new EventHandler<ActionEvent>(){    
            @Override
            public void handle(ActionEvent e){
                loginErrorOne.setText("");
                loginErrorTwo.setText("");
                availableBooks.removeAll(availableBooks);
                owner.getBooks().removeAll(owner.getBooks());
                existingCustomers.removeAll(existingCustomers);
                owner.getCustomers().removeAll(owner.getCustomers());
                primaryStage.setScene(loginPage);
            }    
        }
        );
        
        Label buyError = new Label("");
        
        customerCostVbox.getChildren().addAll(totalCostMsg, pointsAndStatusMsg, customerLogoutBtnTwo, buyError);
        customerCostVbox.setAlignment(Pos.CENTER);
        
        
        Scene customerCostScreen = new Scene(customerCostVbox, 800, 500);
        
        
        buyBookBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                ObservableList<Book> removingBooks = FXCollections.observableArrayList();
                for(Book b : availableBooks){
                    if(b.getBookSelect().isSelected()){
                        buyError.setText("");
                        System.out.println(b.getBookName()+" is selected. The price is: "+b.getBookPrice());
                        totalCost = totalCost + b.getBookPrice();
                        System.out.println(totalCost);
                        removingBooks.add(b);
                        owner.removeBook(b);
                        primaryStage.setScene(customerCostScreen);
                    }
                    else{
                        buyError.setText("Select a book to buy.");
                    }
                }
                System.out.println(totalCost);
                double gainedPoints = totalCost*10;
                double newPoints = customer.getPoints() + gainedPoints;
                customer.setPoints(newPoints);
                System.out.println(customer.getPoints());
                owner.getBooks().removeAll(removingBooks);
                availableBooks.removeAll(removingBooks);
                
                totalCostMsg.setText("Total Cost: " + totalCost);
                if(customer != null){
                    pointsAndStatusMsg.setText("Points: " + customer.getPoints() + ", Status: " + customer.getStatus().getStatus());
                }
                writeCustomer();
                writeBook();
            }
        });
        
        redeemPointsAndBuyBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                if(customer.getPoints() > 0){
                    ObservableList<Book> removingBooks = FXCollections.observableArrayList();

                    for(Book b : availableBooks){
                        if(b.getBookSelect().isSelected()){
                            buyError.setText("");
                            totalCost = totalCost + b.getBookPrice();
                            removingBooks.add(b);
                            owner.removeBook(b);
                            primaryStage.setScene(customerCostScreen);
                            double neededPoints = (b.getBookPrice()*100);
                            System.out.println(neededPoints);
                            double remainingPoints = customer.getPoints() - neededPoints;
                            totalCost = -(remainingPoints/100);
                            if(remainingPoints < 0){
                                remainingPoints = 0;
                            }
                            System.out.println(remainingPoints);
                            customer.setPoints(remainingPoints);
                            if(totalCost < 0){
                                totalCost = 0;
                            }
                        }
                        else{
                            buyError.setText("Select a book to buy.");
                        }
                    }
                    
                    availableBooks.removeAll(removingBooks);
                    owner.getBooks().removeAll(removingBooks);

                    totalCostMsg.setText("Total Cost: " + totalCost);
                    if(customer != null){
                        pointsAndStatusMsg.setText("Remaining Points: " + customer.getPoints() + ", Status: " + customer.getStatus().getStatus());
                    }
                    writeCustomer();
                    writeBook();
                }
                else{
                    buyError.setText("Insufficient points.");
                }
            }
        }); 
        
        loginBtn.setOnAction(
                new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {  
                //Reads the book data from the file
                if(availableBooks.isEmpty()){
                     String bName, bPrice;
                    File r= new File("books.txt");
                     try {
                        Scanner s = new Scanner(r);
                        while (s.hasNextLine()) {
                        bName = s.nextLine();
                        bPrice = s.nextLine();
                        Book n = new Book(bName,Double.parseDouble(bPrice));
                        owner.addBook(n); 
                        availableBooks.add(n); 
                        }     
                     } catch (IOException ex) {
                      System.out.println("An error occurred.");
                      ex.printStackTrace();
                    }
                }
                //Reads the customer data from the file
                if(existingCustomers.isEmpty()){
                   String username, password;
                    double points;

                    File fi= new File("customerlist.txt");
                 try {
                    Scanner k = new Scanner(fi);
                    while (k.hasNextLine()) {
                    username = k.nextLine();
                    password = k. nextLine();
                    points = Double.parseDouble(k.nextLine());
                    Customer c = new Customer(username,password);
                    c.setPoints(points);
                    if(points >= 1000){
                        c.setStatus(c.getStatus().setGold());
                    }
                    else{
                        c.setStatus(c.getStatus().setSilver());
                    }
                    owner.addCustomer(c);
                    existingCustomers.add(c);                     
                    }     
                 } catch (Exception ex) {
                  System.out.println("An error occurred.");
                  ex.printStackTrace();
                }    
                }
               //checks the login and switches to either owner screen or cusomer screen if existing password and username are correct
                if(usernameTF.getText().equals("admin") && passwordTF.getText().equals("admin")){
                    primaryStage.setScene(ownerStartScreen);
                    usernameTF.clear();
                    passwordTF.clear();
                    loginErrorOne.setText("");
                    loginErrorTwo.setText("");
                }
                else{
                    for(Customer c : owner.getCustomers()){
                        if(usernameTF.getText().equals(c.getUsername()) && passwordTF.getText().equals(c.getPassword())){
                            customer = c;
                            totalCost = 0;
                            System.out.println(c.displayLoginMessage());
                            primaryStage.setScene(customerStartScreen);
                            usernameTF.clear();
                            passwordTF.clear(); 
                            customerWelcomeMessage.setText(c.displayLoginMessage());
                        }
                        else{
                            loginErrorOne.setText("Either user does not exist or username does not match password.");
                            loginErrorTwo.setText("Please check your inputs and try again.");
                        }
                    }
                }
            }
        }
        );        
    }
    
    //Appends the current books to the file
    public void writeBook(){
        try { 
            new FileWriter("books.txt", false).close();
            FileWriter s = new FileWriter("books.txt",true); // set the second parameter to true to enable appending
            for (Book o : owner.getBooks()) {
                s.write(o.getBookName()+"\n");
                s.write(Double.toString(o.getBookPrice())+"\n");
            }
            s.close();
        } catch (IOException ex) {
        System.out.println("An error occurred.");
        ex.printStackTrace();
        }
    }
    //Appends the current customers to the file
    public void writeCustomer(){
        try { 
            new FileWriter("customerlist.txt", false).close();
            FileWriter s = new FileWriter("customerlist.txt",true); // set the second parameter to true to enable appending
            for (Customer c : owner.getCustomers()) {
                s.write(c.getUsername()+"\n");
                s.write(c.getPassword()+"\n");
                s.write(String.valueOf(c.getPoints())+"\n");
            }
            s.close();
        } catch (IOException ex) {
        System.out.println("An error occurred.");
        ex.printStackTrace();
        } 
    }
 
    public static void main(String[] args) {
        launch(args);
    }
    
}