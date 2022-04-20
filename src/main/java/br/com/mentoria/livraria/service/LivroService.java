/**
 * O livro Service funciona como um classe que realiza as ações CRUD do objeto Livro
 * Ela implementa a ilivroService que  cria as funções que usaremos aqui
 */

package br.com.mentoria.livraria.service;

import br.com.mentoria.livraria.service.dto.AlterarLivroDto;
import br.com.mentoria.livraria.service.dto.LivroDto;
import br.com.mentoria.livraria.service.dto.CriarLivroDto;
import br.com.mentoria.livraria.model.Autor;
import br.com.mentoria.livraria.model.Categoria;
import br.com.mentoria.livraria.model.Livro;
import br.com.mentoria.livraria.repository.AutorRepository;
import br.com.mentoria.livraria.repository.CategoriaRepository;
import br.com.mentoria.livraria.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LivroService implements ILivroService {

    private final LivroRepository livroRepository;
    private final AutorRepository autorRepository;
    private final CategoriaRepository categoriaRepository;


    @Autowired
    public LivroService(LivroRepository livroRepository, AutorRepository autorRepository, CategoriaRepository categoriaRepository) {
        this.livroRepository = livroRepository;
        this.autorRepository = autorRepository;
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    public LivroDto salvarLivro(CriarLivroDto criarLivroDto) {
        // TODO: 13/04/2022 usar findById
        Autor autor = autorRepository.findByNome(criarLivroDto.getNomeAutor());
        Categoria categoria = categoriaRepository.findByNomeCategoria(criarLivroDto.getTipoCategoria());

        Livro livro = new Livro(criarLivroDto.getTitulo(),
                                criarLivroDto.getResumo(),
                                criarLivroDto.getSumario(),
                                criarLivroDto.getPreco(),
                                criarLivroDto.getPaginas(),
                                criarLivroDto.getIsbn(),
                                autor,
                                categoria);
        livroRepository.save(livro);
        return new LivroDto(livro);

    }

    @Override
    public LivroDto alterarLivro(AlterarLivroDto alterarLivroDto) {
        Autor autor = autorRepository.findByNome(alterarLivroDto.getNomeAutor());
        Categoria categoria = categoriaRepository.findByNomeCategoria(alterarLivroDto.getTipoCategoria());
        Livro livro = livroRepository.getById(alterarLivroDto.getId());
     //   Livro livro = new Livro(alterarLivroDto.getTitulo(), alterarLivroDto.getResumo(), alterarLivroDto.getSumario(), alterarLivroDto.getPreco(), alterarLivroDto.getPaginas(), alterarLivroDto.getIsbn(), autor, categoria);
        livro.setNome(alterarLivroDto.getTitulo());
        livro.setResumo(alterarLivroDto.getResumo());
        livro.setSumario(alterarLivroDto.getSumario());
        livro.setPreco(alterarLivroDto.getPreco());
      //  livro.setAutor(autor);
      //  livro.setCategoria(categoria);
        // TODO: Verificar como alterar os autores
        livroRepository.save(livro);
        return new LivroDto(livro);
    }
}
