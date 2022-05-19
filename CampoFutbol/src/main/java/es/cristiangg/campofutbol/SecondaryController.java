package es.cristiangg.campofutbol;

import es.cristiangg.campofutbol.entities.Division;
import es.cristiangg.campofutbol.entities.Estadio;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class SecondaryController implements Initializable {
    
    private Estadio estadio;
    private boolean nuevoEstadio;
    
    private static final char EUROPA = 'E';
    private static final char MEDIA = 'M';
    private static final char DESCENSO = 'D';
    
    private static final String FOTO_ESTADIO = "Fotos";
    
    @FXML
    private TextField textFieldNombre;
    @FXML
    private TextField textFieldLocalizacion;
    @FXML
    private TextField textFieldTelefono;
    @FXML
    private TextField textFieldEmail;
    @FXML
    private TextField textFieldProvincia;
    @FXML
    private ComboBox<Division> comboBoxDivision;
    @FXML
    private DatePicker datePickerfecha_fundacion;
    @FXML
    private RadioButton radioButtonEuropa;
    @FXML
    private RadioButton radioButtonMedia;
    @FXML
    private RadioButton radioButtonDescenso;
    @FXML
    private TextField textFieldPrecio;
    @FXML
    private TextField textFieldMedida_Campo;
    @FXML   
    private CheckBox checkBoxEntradasDis;
    @FXML
    private ImageView imageViewFoto;
    @FXML
    private ToggleGroup categoria_clubs;
    @FXML
    private AnchorPane rootSecondary;
    
    @Override
    public void initialize(URL url, ResourceBundle rb){
    }
    
    public void setEstadio(Estadio estadio, boolean nuevoEstadio){
        App.em.getTransaction().begin();
        if(!nuevoEstadio){
           this.estadio = App.em.find(Estadio.class, estadio.getId());
        } else {
            this.estadio = estadio;
        }
        this.nuevoEstadio = nuevoEstadio;
        mostrarDatos();
    }
    
    private void mostrarDatos() {
        textFieldNombre.setText(estadio.getNombre());
        textFieldLocalizacion.setText(estadio.getLocalizacion());
        
        if (estadio.getTelefono() != null){
            textFieldTelefono.setText(String.valueOf(estadio.getTelefono()));
        }
        if (estadio.getEmail() != null){
            textFieldEmail.setText(String.valueOf(estadio.getEmail()));
        }
        if (estadio.getProvincia() != null){
            textFieldProvincia.setText(String.valueOf(estadio.getProvincia()));
        }
        if (estadio.getPrecio() != null){
            textFieldPrecio.setText(String.valueOf(estadio.getPrecio()));
        }
        if (estadio.getMedidaCampo() != null){
            textFieldMedida_Campo.setText(String.valueOf(estadio.getMedidaCampo()));
        }
        if (estadio.getEntradasDisponibles() != null){
            checkBoxEntradasDis.setSelected(estadio.getEntradasDisponibles());
        }
        if (estadio.getCategoriaClubs() != null){
            switch (estadio.getCategoriaClubs()){
                case EUROPA:
                    radioButtonEuropa.setSelected(true);
                    break;
                    case MEDIA:
                    radioButtonMedia.setSelected(true);
                    break;
                    case DESCENSO:
                    radioButtonDescenso.setSelected(true);
                    break;
            }
        }
        if (estadio.getFechaFundacion() != null){
            
        }
    }
            
        
    
    
    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }
}