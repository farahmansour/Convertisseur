/*
* Author : farahmansour
*Date : 3-March-2021
*Pour ce sommatif, j'ai crée un programme en utilisant java.fx qui nous permet de convertir des unités. Je l'ai fais pour les masses,
*les volumes et les longeurs. Le programme était un peu difficile à faire au début mais après avoir revu ce qu'on avait fait en cours, j'ai pu 
*le  faire facilement.
*/

package application;

//import java.awt.Event;
//import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class SampleController implements Initializable {

	// 1.déclarer tout ce qu'on a dans le sample.fxml (j'ai fait un copier coller du
	// controller skeleton)
	@FXML
	private ComboBox<String> cbolong1;
	// 2.Faire un tableau avec tous les unités
	ObservableList<String> list1 = FXCollections.observableArrayList("Kilomètre", "Centimètre", "Mètre", "Pouce",
			"Pied", "Mile");
	// 3.Faire un double des unités pour qu'on puisse les convertir (mettrre la
	// conversion entre paranthèses)
	double[] longeur = { 1.0, 100000, 1000, 39370, 3280.84, 0.621371 };

	@FXML
	private ComboBox<String> cbolong2;

	@FXML
	private TextField txtlong1;

	@FXML
	private TextField txtlong2;

	@FXML
	private Button btnquitter;

	@FXML
	private TextField txtvol1;

	@FXML
	private TextField txtvol2;

	@FXML
	private ComboBox<String> cbomasse1;
	// Faire les étapes 2 et 3 encore avec les masses
	ObservableList<String> list2 = FXCollections.observableArrayList("Grammes", "Miligrammes", "Kilogrammes", "Once",
			"Livre");
	double[] masse = { 1.0, 1000, 0.001, 0.035274, 0.0022046 };

	@FXML
	private ComboBox<String> cbomasse2;

	@FXML
	private ComboBox<String> cbovol1;

	@FXML
	private ComboBox<String> cbovol2;
	// Faire les étapes 2 et 3 encore avec les volumes
	ObservableList<String> list3 = FXCollections.observableArrayList("Litre", "Mililitre", "Un verre americain",
			"Once fluide");
	double[] volume = { 1.0, 1000, 4.16667, 33.814 };

	@FXML
	private TextField txtmasse2;

	@FXML
	private TextField txtmasse1;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		cbolong1.setItems(list1);
		cbolong2.setItems(list1);
		cbomasse1.setItems(list2);
		cbomasse2.setItems(list2);
		cbovol1.setItems(list3);
		cbovol2.setItems(list3);
		cbolong1.getSelectionModel().selectFirst();
		cbolong2.getSelectionModel().selectFirst();
		cbovol1.getSelectionModel().selectFirst();
		cbovol2.getSelectionModel().selectFirst();
		cbomasse1.getSelectionModel().selectFirst();
		cbomasse2.getSelectionModel().selectFirst();
	}

	// Faire que le boutton "quitter" quitte
	@FXML
	public void fermer() {
		System.exit(0);
	}

	// Appeller les méthodes
	@FXML
	void calculer1() {
		convertir(txtlong1, txtlong2, cbolong1, cbolong2, longeur);
	}

	@FXML
	void calculer2() {
		convertir(txtlong2, txtlong1, cbolong2, cbolong1, longeur);
	}

	@FXML
	void calculer3() {
		convertir(txtmasse1, txtmasse2, cbomasse1, cbomasse2, masse);
	}

	@FXML
	void calculer4() {
		convertir(txtmasse2, txtmasse1, cbomasse2, cbomasse1, masse);
	}

	@FXML
	void calculer5() {
		convertir(txtvol1, txtvol2, cbovol1, cbovol2, volume);
	}

	@FXML
	void calculer6() {
		convertir(txtvol2, txtvol1, cbovol2, cbovol1, volume);
	}

//Les méthodes pour convertir
	public void convertir(TextField txtA, TextField txtB, ComboBox boxA, ComboBox boxB, double[] tab) {
		verifNum(txtA);
		int item1 = boxA.getSelectionModel().getSelectedIndex();
		int item2 = boxB.getSelectionModel().getSelectedIndex();
		try {
			double taux = tab[item2] / tab[item1];
			double res = taux * (Double.parseDouble(txtA.getText()));
			txtB.setText(String.format("%4f", res));
		} catch (NumberFormatException e) {
			txtA.setText("0");
		}

	}

//Gestion numéique - accepter seulement des caractères numériques
	public void verifNum(TextField a) {
		if (a.getText().equals(""))
			a.setText("0");
		a.textProperty().addListener((observable, oldValue, newValue) -> {
			if (!newValue.matches("^[0-9](\\.[0-9]+)?$")) {
				a.setText(newValue.replaceAll("[^\\d*\\.]", ""));
			}

		});

	}
}
