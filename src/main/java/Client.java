import com.pokebank.PokebankPackage.PokeBank;
import com.pokebank.PokebankPackage.Pokemon;
import com.pokebank.PokebankPackage.Treinador;

/**Client do projeto PokeBank com Java
 * 
 * À fazeres:
 * Basicamente tudo
 * Criar menu de acesso
 * Verificação de login
 * 
 */
public class Client {
    public static void main(String[] args) throws Exception {

        Treinador rhuan = new Treinador("Rhuan", "123456", new Pokemon("Pikachu"));
        rhuan.listarEquipe();
        PokeBank pallet = new PokeBank("Pallet");
        pallet.addTreinador(rhuan);
        
    }
}
