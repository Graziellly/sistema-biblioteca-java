import java.time.LocalDate; 
import java.util.ArrayList; 
import java.util.List; 

public class Biblioteca { 
    
    private List<Livro> livros = new ArrayList<>(); 
    private List<Autor> autores = new ArrayList<>(); 
    private List<Emprestimo> emprestimos = new ArrayList<>(); 
    
    public Biblioteca() { 
        Autor a1 = new Autor(1, "Machado de Assis", LocalDate.of(1839, 6, 21)); 
        Autor a2 = new Autor(2, "Clarice Lispector", LocalDate.of(1920, 12, 10)); 
        
        autores.add(a1); 
        autores.add(a2); 
        
        livros.add(new Livro(1, "Dom Casmurro", a1, true, LocalDate.now(), LocalDate.now())); 
        livros.add(new Livro(2, "Memorias Postumas de Bras Cubas", a1, true, LocalDate.now(), LocalDate.now())); 
        livros.add(new Livro(3, "A Hora da Estrela", a2, true, LocalDate.now(), LocalDate.now())); 
    } 
        
    public void listarLivrosDisponiveis() {
         System.out.println("\n=== LIVROS DISPONIVEIS ==="); 
         
         boolean temDisponivel = false; 
         
         for (Livro livro : livros) { 
            if (livro.isDisponivel()) { 
                temDisponivel = true; 
                System.out.println("ID: " + livro.getId() 
                + " | Titulo: " + livro.getTitulo() 
                + " | Autor: " + livro.getAutor().getNome()); 
            } 
        } 
        
        if (!temDisponivel) { 
            System.out.println("Nenhum livro disponivel no momento."); 
        } 
    } 
    
    public Livro buscarLivroPorId(int id) { 
        for (Livro livro : livros) { 
            if (livro.getId() == id && livro.isDisponivel()) { 
                return livro; 
            } 
        } 
        return null; 
    } 
    public void realizarEmprestimo(Livro livro, String nomeCliente) { 
        livro.setDisponivel(false); 
        livro.setDataAtualizacao(LocalDate.now()); 
        
        int idEmprestimo = emprestimos.size() + 1; 
        Emprestimo e = new Emprestimo(idEmprestimo, livro, nomeCliente, LocalDate.now(), null); 
        emprestimos.add(e); 
    }
 }