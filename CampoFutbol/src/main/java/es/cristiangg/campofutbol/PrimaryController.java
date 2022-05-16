package es.cristiangg.campofutbol;

import es.cristiangg.campofutbol.entities.Estadio;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

public class PrimaryController implements Initializable{

    private Estadio estadioSeleccionada;
    @FXML
    private TableView<Estadio> tableViewEstadio;
    @FXML
    private TableColumn<Estadio, String> columnNombre;
    @FXML
    private TableColumn<Estadio, String> columnLocalizacion;
    @FXML
    private TableColumn<Estadio, String> columnDivision;
    @FXML
    private TextField textFieldNombre;
    @FXML
    private TextField textFieldLocalizacion;
    @FXML
    private AnchorPane rootEstadioView;
    
    @Override
    public void initialize(URL url, ResourceBundle rb){
        columnNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        columnLocalizacion.setCellValueFactory(new PropertyValueFactory<>("localizacion"));
        columnDivision.setCellValueFactory(
                cellData -> {
                    SimpleStringProperty property = new SimpleStringProperty();
                    if (cellData.getValue().getDivision()!= null){
                        property.setValue(cellData.getValue().getDivision().getNombre());
                    }
                    return property;
                });
        tableViewEstadio.getSelectionModel().selectedItemProperty().addListener
                (observable, oldValue, newValue) -> {
                    estadioSeleccionada = newValue;
                    if (estadioSeleccionada != null){
                        textFieldNombre.setText(estadioSeleccionada.getNombre());
                        textFieldLocalizacion.setText(estadioSeleccionada.getLocalizacion());
                    }else {
                        textFieldNombre.setText("");
                        textFieldLocalizacion.setText("");
                    }
                });
            cargarTodosEstadio();
        }
        private void cargarTodosEstadio(){
            Query queryEstadioFindAll = App.em.createNamedQuery("Estadio.findAll");
            List<Estadio> listEstadio = queryEstadioFindAll.getResultList();
            tableViewEstadio.setItems(FXCollections.observableArrayList(ListEstadio));
        }
    
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
}
