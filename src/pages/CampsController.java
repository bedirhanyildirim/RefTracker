package pages;

import DatabaseClasses.*;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import static pages.LoginController.dbConnection;
import tableObjects.CampsTable;
import tableObjects.RefugeeTable;

public class CampsController implements Initializable {

    @FXML
    private TableView<CampsTable> campsTable = new TableView<>();
    @FXML
    private Button addCampButton;
    @FXML
    private Button findCampButton;
    @FXML
    private Button campDetailButton;

    @FXML
    private void addClicked(MouseEvent event) {
        //add camp
    }

    @FXML
    private void findClicked(MouseEvent event) {
        //find camp
    }

    @FXML
    private void detailClicked(MouseEvent event) {
        //camp detail
    }
    private ObservableList<CampsTable> campSites = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        campSites = FXCollections.observableArrayList();

        EntityManager em = dbConnection.newEntityManager();
        TypedQuery<CampSite> tq = em.createQuery("SELECT cs FROM CampSite cs", CampSite.class);
        List<CampSite> csList = tq.getResultList();
        for (int i = 0; i < csList.size(); i++) {
            CampSite c = csList.get(i);
            campSites.add(new CampsTable(c.getName(), c.getLocation(), findCampType(c)));
        }
        setColumns();
        em.close();
        
        campsTable.setItems(campSites);
    }

    public void setCampSites(ObservableList<CampsTable> campSites) {
        this.campSites = campSites;
    }

    public ObservableList<CampsTable> getCampSites() {
        return campSites;
    }

    public void setColumns() {

        TableColumn name = new TableColumn("Name");
        TableColumn location = new TableColumn("Location");
        TableColumn campType = new TableColumn("Camp Type");

        name.setCellValueFactory(new PropertyValueFactory<CampsTable, String>("name"));
        location.setCellValueFactory(new PropertyValueFactory<CampsTable, String>("location"));
        campType.setCellValueFactory(new PropertyValueFactory<CampsTable, String>("campType"));

        campsTable.getColumns().clear();
        campsTable.getColumns().addAll(name, location, campType);
        campsTable.setItems(campSites);
    }

    public String findCampType(CampSite campS) {
        int campTypeID = campS.getCampType();

        EntityManager em = LoginController.dbConnection.newEntityManager();
        TypedQuery<CampType> q1 = em.createQuery("SELECT t FROM CampType t WHERE t.id ='" + campTypeID + "'", CampType.class);
        CampType ct = q1.getSingleResult();
        em.close();
        return ct.getName();
    }

}
