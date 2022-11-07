package controle;

import modelo.*;
import util.Input;

/**
 *
 * @author Andre
 */
public class CadastroEndereco {
    
    public static Endereco cadastrar() {
        Endereco end = new Endereco();
        setarInformacoes(end);
        return end;
    }
    
    public static void setarInformacoes(Endereco end) {
        if(end == null){
            System.out.println("Falha ao setar informações de Endereco!");
            return;
        }
        
        System.out.print("Cidade: ");
        end.setCidade(Input.nextLine());
        
        System.out.print("Rua: ");
        end.setRua(Input.nextLine());
        
        System.out.print("Número: ");
        end.setNumero(Input.nextInt());
    }
}
