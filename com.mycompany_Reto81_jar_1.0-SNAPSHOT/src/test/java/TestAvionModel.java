import Class.Avion;
import Model.AvionModel;


import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.jupiter.api.Test;




public class TestAvionModel {
    /**
 *
 * @author Anderson Sachez
 *   */
      @Test
    public void testCreate(){
    AvionModel AvionModel = new AvionModel();
    Avion  a = new Avion(8,"Boeing", 100, 500, 400000);
    int resultado = AvionModel.Create(a);
    assertNotEquals(0, resultado);
    }
   
    @Test
    public void testUdate(){
    int id =  3;
    AvionModel AvionModel = new AvionModel();
    Avion  a = new Avion(8,"turbofan CFM-56", 300, 200, 800000);
    int resultado = AvionModel.Update(a,id);
   
    assertNotEquals(0, resultado);
    }
    
    @Test
    public void testDelet(){
    int id =  7;
    AvionModel AvionModel = new AvionModel();
    int resultado = AvionModel.Delete(id);
   
    assertNotEquals(0, resultado);
    }
    
   

    
   
}

