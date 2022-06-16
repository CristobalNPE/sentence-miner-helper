import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ClippingManager {
  private List<String> clippings;
  private HashMap<String, ArrayList<Clipping>> orderedClippings;

  public ClippingManager() {
    this.clippings = new ArrayList<>();
    this.orderedClippings = new HashMap<>();
  }
  /*
  * Se puede cambiar mover la lista a variable de entorno, usada solo para leer el archivo y almacenar
  * el data en un HashMap, como variable de clase.
  * */
  public void getClipsFromFile(String fileRoute) {
    try {
      this.clippings = Files.readAllLines(Paths.get(fileRoute));
    } catch (Exception e) {
      System.out.println("Error reading file :" + e);
    }



  }

  /*Podriamos crear una clase Clipping, que almacene todos los datos del clip,
   * incluyendo autor, fecha, el mismo clip. luego almacenar en hashmap usando
   * el get.bookName como KEY
   * */
  public void printClippingsWithStep(int step) {
    for (int i = 3; i < this.clippings.size(); i = i + step) {
      if (!this.clippings.get(i).isEmpty()) {
        System.out.println(this.clippings.get(i));
      }

    }
  }

  public void getTitlesOfClippings() {

    /*Por algun motivo esta funcion encuentra un libro duplicado, puede ser debido al japones*/
    for (int i = 0; i < this.clippings.size(); i = i + 5) {
      this.orderedClippings.putIfAbsent(this.clippings.get(i).trim(), new ArrayList<>());
    }
  }

  public void printTitles() {
    System.out.println(this.orderedClippings.size() + " found: \n");
    for (String title : this.orderedClippings.keySet()) {
      System.out.println(title);
    }
  }


}
