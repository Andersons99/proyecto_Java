import Class.Ruta;
import Model.AvionModel;
import Model.RutaModel;


import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.jupiter.api.Test;




public class TestRutaModel {
    /**
 *
 * @author Anderson Sachez
 *   */
      @Test
    public void testCreate(){
    RutaModel RutaModel= new RutaModel();
    Ruta  a = new Ruta(1, 30, 3, 2);
    int resultado = RutaModel.Create(a);
    assertNotEquals(0, resultado);
    }
   
    @Test
    public void testUdate(){
    int id =  3;
    RutaModel RutaModel = new RutaModel();
    Ruta  a = new Ruta(3, 60, 3, 5);
    int resultado = RutaModel.Update(a,id);
   
    assertNotEquals(0, resultado);
    }
    
    @Test
    public void testDelet(){
    int id =  7;
    AvionModel RutaModel = new AvionModel();
    int resultado = RutaModel.Delete(id);
   
    assertNotEquals(0, resultado);
    }
    
   

    
   
}



    

