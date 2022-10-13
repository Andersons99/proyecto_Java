import Class.Aeropuerto;
import Model.AeropuertoModel;


import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.jupiter.api.Test;




public class TestAeropuertoModel {
    /**
 *
 * @author Anderson Sachez
 *   */
      @Test
    public void testCreate(){
    AeropuertoModel AeropuertoModel = new AeropuertoModel();
    Aeropuerto a = new Aeropuerto(7, "Aeropuerto Internacional Rosario", "Islas Malvinas", "Argentina",5000,6000);
    int resultado = AeropuertoModel.Create(a);
    assertNotEquals(0, resultado);
    }
   
    @Test
    public void testUdate(){
    int id =  7;
    AeropuertoModel AeropuertoModel = new AeropuertoModel();
    Aeropuerto a = new Aeropuerto(5,"SAVR", "Allen", "Argentina", 4000, 30000);
    int resultado = AeropuertoModel.Update(a,id);
   
    assertNotEquals(0, resultado);
    }
    
    @Test
    public void testDelet(){
    int id =  7;
    AeropuertoModel AeropuertoModel = new AeropuertoModel();
    int resultado = AeropuertoModel.Delete(id);
   
    assertNotEquals(0, resultado);
    }
    
   

    
   
}
