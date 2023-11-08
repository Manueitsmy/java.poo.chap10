import org.junit.jupiter.api.Test;

public class TestHomer {
HomerSimpson homerSimpson = new HomerSimpson() {

@Test
void Testdrink(){
	HomerSimpson.drinkBeer().contains("duff");
}
@Test
void Testeat() {
	HomerSimpson.eat().contains("donuts");
}
};
}


