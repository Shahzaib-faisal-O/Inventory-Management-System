import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Product {
    private SimpleIntegerProperty productId;
    private SimpleStringProperty productType;
    private SimpleStringProperty productBrandName;
    private SimpleStringProperty productName;
//    private SimpleDoubleProperty productMoney;
    private SimpleIntegerProperty productPrice;
    private SimpleStringProperty productStatus;

    public Product(int productId, String productType, String productBrandName, String productName,int productPrice, String productStatus) {
        this.productId =new SimpleIntegerProperty (productId);
        this.productType =new SimpleStringProperty (productType);
        this.productBrandName = new SimpleStringProperty (productBrandName);
        this.productName = new SimpleStringProperty (productName);
        this.productPrice = new SimpleIntegerProperty (productPrice);
        this.productStatus = new SimpleStringProperty (productStatus);
    }

    public int getProductId() {
        return productId.get();
    }

    public SimpleIntegerProperty productIdProperty() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId.set(productId);
    }

    public String getProductType() {
        return productType.get();
    }

    public SimpleStringProperty productTypeProperty() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType.set(productType);
    }

    public String getProductBrandName() {
        return productBrandName.get();
    }

    public SimpleStringProperty productBrandNameProperty() {
        return productBrandName;
    }

    public void setProductBrandName(String productBrandName) {
        this.productBrandName.set(productBrandName);
    }

    public String getProductName() {
        return productName.get();
    }

    public SimpleStringProperty productNameProperty() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName.set(productName);
    }

    public int getProductPrice() {
        return productPrice.get();
    }

    public SimpleIntegerProperty productPriceProperty() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice.set(productPrice);
    }

    public String getProductStatus() {
        return productStatus.get();
    }

    public SimpleStringProperty productStatusProperty() {
        return productStatus;
    }

    public void setProductStatus(String productStatus) {
        this.productStatus.set(productStatus);
    }
}

