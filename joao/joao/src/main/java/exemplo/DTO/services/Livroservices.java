package exemplo.DTO.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Service;

import com.DTO.entitites.Livro;

import exemplo.DTO.Livro.LivroDTO;

@Service
public class Livroservices {
	
	private final EnableJpaRepositories livroRepositories;
	
	@Autowired
	public void LivroService(ListCrudRepository livroRepository) {
		this.livroRepositories = livroRepositories;
	}
	
	//Método modificado para utilizar o DTO
	public LivroDTO salvar(Livro livro) {
		Livro salvarLivro = livroRepository.save(livro);
		return new LivroDTO(salvarLivro.getId(), salvarLivro.getTitulo(), salvarLivro.getAutor());
	}
	
	//Método modificado para utilizar o DTO
	public LivroDTO atualizar(Long id, Livro livro) {
		CrudRepository livroRepositories;
		Livro existeLivro = livroRepositories.findById(id).orElseThrow(() -> new RuntimeException("Livro não encontrado"));
		existeLivro.setTitulo(livro.getTitulo());
		existeLivro.setAutor(livro.getAutor());
		CrudRepository livroRepositories1;
		Livro updatedLivro = livroRepositories1.save(existeLivro);
		return new LivroDTO(updatedLivro.getId(), updatedLivro.getTitulo(), updatedLivro.getAutor());
	}
	
	public boolean deletar(Long id) {
		CrudRepository livroRepositories;
		Optional <Livro> existeCliente = livroRepositories.findById(id);
		if(existeCliente.isPresent()) {
			CrudRepository livroRepositories;
			livroRepositories.deleteById(id);
			return true;
		}
		return false;
	}
	
	public List<Livro> buscarTodos(){
		ListCrudRepository livroRepositories;
		return livroRepositories.findAll();
	}
	
	public Livro buscarPorId(Long id) {
		CrudRepository livroRepositories;
		Optional <Livro> Livro = livroRepositories.findById(id);
		return Livro.orElse(null);
	}
}
