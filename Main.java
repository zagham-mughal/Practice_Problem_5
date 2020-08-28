package sample;

import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;
import javafx.scene.text.*;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }




    private BorderPane  root;
    private HBox titlehb , namehb , phonehb , addresshb , customerhb , bottomhb;
    private  VBox sizevb , toppingsvb , crustvb , customersvb , ordervb;
    private FlowPane toppingsfp;
    private  Button okbtn , canclebtn;
    private TextField nametf , addresstf , phonetf;
    private Label titlelb , namelb , phonelb , addresslb , sizelb, toppinglb , crustlb;
    private RadioButton smallrb , mediummrb , largerb , thinrb , thickrb;
    private ToggleGroup sizetg , crusttg;
    private CheckBox peppronicb , sausagecb , linguicacb , olivescb , mushroomscb , tomatoescb , anchoviescb;

    @Override
    public void start(Stage primaryStage) throws Exception{



        titlelb =new Label("Order your Pizza Now !");
        titlelb.setFont(new Font(36));
        titlehb = new HBox(titlelb);
        namelb = getLable("Name: ");
        nametf = getTextField("Enter Your Name..");
        namehb = new HBox(namelb , nametf);
        phonelb = getLable("Phone: ");
        phonetf = getTextField("Enter Your Phone..");
        phonehb = new HBox(phonelb , phonetf);
        addresslb = getLable("Address: ");
        addresstf = getTextField("Entr Your Address..");
        addresshb = new HBox(addresslb , addresstf);
        customersvb = new VBox(10 ,namehb , phonehb , addresshb);
        //Size
        sizelb = new Label("Size:");
        smallrb = new RadioButton("Small");
        mediummrb = new RadioButton("Medium");
        largerb = new RadioButton("Large");
        sizetg = new ToggleGroup();
        smallrb.setToggleGroup(sizetg);
        mediummrb.setToggleGroup(sizetg);
        largerb.setToggleGroup(sizetg);
        sizevb = new VBox(sizelb , smallrb , mediummrb , largerb);
        sizevb.setSpacing(10);
        //Crust
        crustlb = new Label("Crust");
        thinrb = new RadioButton("Thin");
        thickrb = new RadioButton("Thick");
        crusttg = new ToggleGroup();
        thinrb.setToggleGroup(crusttg);
        thickrb.setToggleGroup(crusttg);
        crustvb = new VBox(crustlb , thinrb , thickrb);
        crustvb.setSpacing(10);
        //Topping
        toppinglb = new Label("Topping");
        peppronicb = new CheckBox("Pepproni");
        sausagecb = new CheckBox("Sausage");
        linguicacb = new CheckBox("Linguicia");
        olivescb = new CheckBox("Olives");
        mushroomscb = new CheckBox("Mushrooms");
        tomatoescb = new CheckBox("Tomatoes");
        anchoviescb = new CheckBox("Anchovies");
        toppingsfp = new FlowPane(Orientation.VERTICAL, peppronicb , sausagecb , linguicacb , olivescb , mushroomscb , tomatoescb , anchoviescb);
        toppingsfp.setPadding(new Insets(0 , 10 ,0 , 10));
        toppingsfp.setHgap(20);
        toppingsfp.setVgap(10);
        toppingsfp.setPrefWrapLength(100);
        toppingsvb = new VBox(toppinglb , toppingsfp);
        customerhb = new HBox(50 , sizevb , crustvb , toppingsvb);
        ordervb = new VBox(20 , customersvb , customerhb);

        //Buttons
        okbtn = new Button("OK");
        okbtn.setPrefWidth(80);
        canclebtn = new Button("Cancle");
        canclebtn.setPrefWidth(80);

        Region spacer = new Region();

        bottomhb = new HBox(10 , spacer , okbtn , canclebtn);
        bottomhb.setHgrow(spacer, Priority.ALWAYS);
        bottomhb.setPadding(new Insets(20 ,10 , 20 , 10));



        root = new BorderPane();
        root.setTop(titlehb);
        root.setCenter(ordervb);
        root.setBottom(bottomhb);
        Scene scene = new Scene( root , 500, 400 );
        primaryStage.setScene(scene);
        primaryStage.setTitle("Pizza Order");
        primaryStage.show();





    }

    private TextField getTextField(String text) {
        TextField tf = new TextField();
        tf.setPromptText(text);
        tf.setPrefColumnCount(20);
        tf.setFont(Font.font("Arial" , 16));
        return tf;
    }

    private Label getLable(String lableText) {
        Label lb = new Label(lableText);
        lb.setPrefWidth(100);
        lb.setFont(Font.font("Arial" , 16));
        return lb;
    }


}
