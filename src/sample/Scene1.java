package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.BarChart;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import sun.util.resources.cldr.rof.CalendarData_rof_TZ;

import java.io.File;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class Scene1 implements Initializable {
    @FXML
    private Button addProduct_addBtn;

    @FXML
    private TextField addProduct_brand;

    @FXML
    private Button addProduct_btn;

    @FXML
    private TableColumn<Product, String> addProduct_col_brand;

    @FXML
    private TableColumn<Product, Integer> addProduct_col_price;

    @FXML
    private TableColumn<Product, Integer> addProduct_col_productId;

    @FXML
    private TableColumn<Product, String> addProduct_col_productName;

    @FXML
    private TableColumn<Product, String> addProduct_col_status;

    @FXML
    private TableColumn<Product, String> addProduct_col_type;

    @FXML
    private Button addProduct_deleteBtn;

    @FXML
    private AnchorPane addProduct_form;

    @FXML
    private ImageView addProduct_imageView;

    @FXML
    private Button addProduct_importBtn;

    @FXML
    private TextField addProduct_productId;

    @FXML
    private TextField addProduct_productName;

    @FXML
    private TextField addProduct_productType;

    @FXML
    private Button addProduct_resetBtn;

    @FXML
    private TextField addProduct_search;

    @FXML
    private TextField addProduct_status;

    @FXML
    private TableView<Product> addProduct_tableView;

    @FXML
    private Button addProduct_updateBtn;

    @FXML
    private Button close;

    @FXML
    private Label home_avaliableProduct;

    @FXML
    private Button home_btn;

    @FXML
    private AnchorPane home_form;

    @FXML
    private AreaChart<?, ?> home_incomeChart;

    @FXML
    private Label home_numberOrders;

    @FXML
    private BarChart<?, ?> home_orderChart;

    @FXML
    private Label home_totalIncome;

    @FXML
    private Button logout;

    @FXML
    private AnchorPane main_form;

    @FXML
    private Button minimize;

    @FXML
    private Button oders_btn;

    @FXML
    private Button orders_addBtn;

    @FXML
    private TextField orders_amount;

    @FXML
    private Label orders_balance;

    @FXML
    private ComboBox<?> orders_brandName;

    @FXML
    private TableColumn<?, ?> orders_col_brand;

    @FXML
    private TableColumn<?, ?> orders_col_price;

    @FXML
    private TableColumn<?, ?> orders_col_productName;

    @FXML
    private TableColumn<?, ?> orders_col_quantity;

    @FXML
    private TableColumn<?, ?> orders_col_type;

    @FXML
    private AnchorPane orders_form;

    @FXML
    private Button orders_payBtn;

    @FXML
    private ComboBox<?> orders_productName;

    @FXML
    private ComboBox<?> orders_productType;

    @FXML
    private Spinner<?> orders_quantity;

    @FXML
    private Button orders_reciptBtn;

    @FXML
    private Button orders_resetBtn;

    @FXML
    private TableView<?> orders_tableView;

    @FXML
    private Label orders_total;

    @FXML
    private Label username;
/*-------------------------------------------------------------------*/
@FXML
private void importImage(ActionEvent event) {
    FileChooser fileChooser = new FileChooser();
    fileChooser.setTitle("Select Image");
    fileChooser.getExtensionFilters().addAll(
            new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif")
    );
    File file = fileChooser.showOpenDialog(addProduct_importBtn.getScene().getWindow());
    if (file != null) {
        Image image = new Image(file.toURI().toString());
        addProduct_imageView.setImage(image);
    }
}


    /* -------------------------------------------------------------------*/

    public void switchForm(ActionEvent event){
        if(event.getSource()==home_btn){
            home_form.setVisible(true);
            addProduct_form.setVisible(false);
            orders_form.setVisible(false);

            home_btn.setStyle("-fx-border-color:linear-gradient(to bottom right,#23825e,#6d6e30);");
            addProduct_btn.setStyle("-fx-background-color:transparent");
            oders_btn.setStyle("-fx-background-color:transparent");

        }else if(event.getSource()==addProduct_btn){
            home_form.setVisible(false);
            addProduct_form.setVisible(true);
            orders_form.setVisible(false);
            home_btn.setStyle("-fx-background-color:transparent");
            addProduct_btn.setStyle("-fx-border-color:linear-gradient(to bottom right,#23825e,#6d6e30)");
            oders_btn.setStyle("-fx-background-color:transparent");
        }else if(event.getSource()==oders_btn){
            home_form.setVisible(false);
            addProduct_form.setVisible(false);
            orders_form.setVisible(true);
            home_btn.setStyle("-fx-background-color:transparent");
            addProduct_btn.setStyle("-fx-background-color:transparent");
            oders_btn.setStyle("-fx-border-color:linear-gradient(to bottom right,#23825e,#6d6e30)");
        }
    }
    public void setLogout(){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);// setting the alert type
        alert.setTitle("Conformation message ");
        alert.setHeaderText(null);
        alert.setContentText("Are you Sure you want to logout ");
        Optional<ButtonType> option =alert.showAndWait();//button type
        if (option.get().equals(ButtonType.OK)){
            logout.getScene().getWindow().hide();// to hide the previous window
            //Link my login Form here
            try{
                Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
                Stage stage = new Stage();
                Scene scene= new Scene(root);
                stage.initStyle(StageStyle.TRANSPARENT);// for hiding the window close and minimize button.
                stage.setScene(scene);
                stage.show();
            }catch(Exception e){e.printStackTrace();}
        }
    }

    public void setMinimize(){// minimize button java definition
        Stage stage =(Stage)main_form.getScene().getWindow();
        stage.setIconified(true);
    }
    public void close(){
        System.exit(0);
    }
//    _________________________________________________________________________________________________
//                           table view work  in progress hay sara kaam kudh hi kar lo gay
private String[] brands = { "Brand1", "Brand2", "Brand3", "Brand4" };
    public void setAddProduct_addBtn(ActionEvent event) {
        int productId = Integer.parseInt(addProduct_productId.getText());
        String type = addProduct_productType.getText();
        String brand = addProduct_brand.getText(); //brands[(int) (Math.random() * brands.length)]; // Fill in the appropriate value for the brand
        String productName = addProduct_productName.getText();
        int price = 2000;  // Fill in the appropriate value for the price
        String status = addProduct_status.getText();

        Product product = new Product(productId, type, brand, productName, price, status);
        addProduct_tableView.getItems().add(product);
        addProduct_productId.clear();
        addProduct_productName.clear();
        addProduct_productType.clear();
        addProduct_status.clear();
        addProduct_brand.clear();;
    }

/*    @FXML
    private void updateSelectedProduct(ActionEvent event) {
        Product selectedProduct = addProduct_tableView.getSelectionModel().getSelectedItem();
        if (selectedProduct != null) {
            int productId = Integer.parseInt(addProduct_productId.getText());
            String type = addProduct_productType.getText();
            String brand = brands[(int) (Math.random() * brands.length)];
            String productName = addProduct_productName.getText();
            int price = (int) (Math.random() * 100); // Generate a random price between 0 and 100
            String status = addProduct_status.getText();

            selectedProduct.setProductId(productId);
            selectedProduct.setType(type);
            selectedProduct.setBrand(brand);
            selectedProduct.setProductName(productName);
            selectedProduct.setPrice(price);
            selectedProduct.setStatus(status);

            addProduct_tableView.refresh();
        }
    }*/

    @FXML
    private void resetFields(ActionEvent event) {
        addProduct_productId.clear();
        addProduct_productType.clear();
        addProduct_productName.clear();
        addProduct_status.clear();
    }
ObservableList<Product> list= FXCollections.observableArrayList(
        new Product(2212,"Oil","Shell","Diesel",  2000,"Avalibale"),
        new Product(2212,"Oil","Shell","Diesel",  2000,"Avalibale"),
        new Product(2212,"Oil","Shell","Diesel",  2000,"Avalibale"),
        new Product(2212,"Oil","Shell","Diesel",  2000,"Avalibale"),
        new Product(2212,"Oil","Shell","Diesel",  2000,"Avalibale"),
        new Product(2212,"Oil","Shell","Diesel",  2000,"Avalibale"),
        new Product(2212,"Oil","Shell","Diesel",  2000,"Avalibale"),
        new Product(2212,"Oil","Shell","Diesel",  2000,"Avalibale"),
        new Product(2212,"Oil","Shell","Diesel",  2000,"Avalibale"),
        new Product(2212,"Oil","Shell","Diesel",  2000,"Avalibale"),
        new Product(2212,"Oil","Shell","Diesel",  2000,"Avalibale"),
        new Product(2212,"Oil","Shell","Diesel",  2000,"Avalibale"),
        new Product(2212,"Oil","Shell","Diesel",  2000,"Avalibale"),
        new Product(2212,"Oil","Shell","Diesel",  2000,"Avalibale"),
        new Product(2212,"Oil","Shell","Diesel",  2000,"Avalibale"),
        new Product(2212,"Oil","Shell","Diesel",  2000,"Avalibale"),
        new Product(2212,"Oil","Shell","Diesel",  2000,"Avalibale"),
        new Product(2212,"Oil","Shell","Diesel",  2000,"Avalibale"),
        new Product(2212,"Oil","Shell","Diesel",  2000,"Avalibale"),
        new Product(2212,"Oil","Shell","Diesel",  2000,"Avalibale"),
        new Product(2212,"Oil","Shell","Diesel",  2000,"Avalibale"),
        new Product(2212,"Oil","Shell","Diesel",  2000,"Avalibale"),
        new Product(2212,"Oil","Shell","Diesel",  2000,"Avalibale"),
        new Product(2212,"Oil","Shell","Diesel",  2000,"Avalibale"),
        new Product(2212,"Oil","Shell","Diesel",  2000,"Avalibale"),
        new Product(2212,"Oil","Shell","Diesel",  2000,"Avalibale"),
        new Product(2212,"Oil","Shell","Diesel",  2000,"Avalibale"),
        new Product(2212,"Oil","Shell","Diesel",  2000,"Avalibale"),
        new Product(2212,"Oil","Shell","Diesel",  2000,"Avalibale"),
        new Product(2212,"Oil","Shell","Diesel",  2000,"Avalibale")

);
    @Override
    public void initialize(URL location, ResourceBundle resources) {// to create an observable list for default data
addProduct_col_productId.setCellValueFactory(new PropertyValueFactory<>("ProductId"));
addProduct_col_type.setCellValueFactory(new PropertyValueFactory<>("ProductType"));
addProduct_col_brand.setCellValueFactory(new PropertyValueFactory<>("ProductBrandName"));
addProduct_col_productName.setCellValueFactory(new PropertyValueFactory<>("ProductName"));
addProduct_col_price.setCellValueFactory(new PropertyValueFactory<>("ProductPrice"));
addProduct_col_status.setCellValueFactory(new PropertyValueFactory<>("ProductStatus"));
        addProduct_tableView.setItems(list);
    }
//    ______________________________________________________________________________________________________
}
