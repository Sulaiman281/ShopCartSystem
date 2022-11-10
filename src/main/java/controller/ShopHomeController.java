package controller;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import model.shop.Cart;
import model.shop.Category;
import model.shop.CategoryFactory;
import model.shop.Product;
import model.user.User;

import java.net.URL;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.ResourceBundle;

public class ShopHomeController implements Initializable {


    public static class PriceTableCell<Product> extends TableCell<Product, Double> {

        private final AnchorPane pane ;
        private final Label valueLabel ;
        // locale-aware currency format to use for formatting
        private DecimalFormat format;

        public PriceTableCell() {
            // grab an instance
            format = (DecimalFormat) NumberFormat.getCurrencyInstance();
            //get the currency symbol
            String symbol = "€";
            // replace the currency symbol with an empty string
            DecimalFormatSymbols symbols = format.getDecimalFormatSymbols();
            symbols.setCurrencySymbol("");
            format.setDecimalFormatSymbols(symbols);

            Label currencySignLabel = new Label(symbol);
            valueLabel = new Label();
            pane = new AnchorPane(currencySignLabel, valueLabel);
            AnchorPane.setLeftAnchor(currencySignLabel, 0.0);
            AnchorPane.setRightAnchor(valueLabel, 0.0);
            setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
        }

        @Override
        protected void updateItem(Double price, boolean empty) {
            super.updateItem(price, empty);
            if (empty) {
                setGraphic(null);
            } else {
                // manual formatting
                //String text = String.format("%,d.%02d", price / 100, Math.abs(price % 100));
                valueLabel.setText(format.format(price));
                setGraphic(pane);
            }
        }
    }

    public TableView<Product> tableView;
    public TableColumn<Product, Integer> product_id;
    public TableColumn<Product, String> product_name;
    public TableColumn<Product, Double> product_price;
    public TableColumn<Product,String> product_description;

    public ComboBox<String> category_select;

    private Cart cart;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        User user = new User("user","user123","pass123");
        user.addProfessionToUser(1);
        user.addProfessionToUser(4);
        user.addProfessionToUser(0);
        cart = new Cart(user);

        // Punt om data op te halen.
        product_id.setCellValueFactory(new PropertyValueFactory<>("productNumber"));
        product_name.setCellValueFactory(new PropertyValueFactory<>("name"));
        product_price.setCellValueFactory(new PropertyValueFactory<>("price"));
        product_description.setCellValueFactory(new PropertyValueFactory<>("description"));

        product_price.setCellFactory(e-> new PriceTableCell<>());

        category_select.getItems().addAll("Supplies","Equipment","Clothing");
        category_select.setOnAction(e->{
            String selection = category_select.getSelectionModel().getSelectedItem();
            Category category = new CategoryFactory().getInstance(selection);
            tableView.getItems().clear();
            tableView.getItems().addAll(category.getProducts());
        });
        tableView.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue) -> {
            TextInputDialog textInputDialog = new TextInputDialog();
            Button ok_btn = (Button) textInputDialog.getDialogPane().lookupButton(ButtonType.OK);
            ok_btn.setOnAction(event->{
                int quantity = Integer.parseInt(textInputDialog.getEditor().getText());
                cart.addItems(quantity, newValue);
            });
            textInputDialog.setTitle("Quantity Input");
            textInputDialog.setHeaderText("Enter Product Quantity");
            textInputDialog.getEditor().setPromptText("Quantity");
            textInputDialog.showAndWait();
        });
    }

    public void check_out(ActionEvent event) {
        //TODO calculate the total prize
        cart.makeReceipt();
        cart.printReceipt();
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.setTitle("Receipt");
        dialog.setHeaderText("Check out");
        dialog.setWidth(400);
        dialog.setHeight(400);
        dialog.setContentText(cart.getReceipt());
        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.showAndWait();
    }
}

