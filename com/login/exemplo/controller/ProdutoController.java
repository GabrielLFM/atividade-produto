package com.login.exemplo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.login.exemplo.dto.ProdutoRequestDTO;
import com.login.exemplo.dto.ProdutoResponseDTO;
import com.login.exemplo.entity.Produto;
import com.login.exemplo.repositories.ProdutoRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

	@Autowired
	ProdutoRepository produtoRepository;
	
	@GetMapping("{id}")
	public Optional<Produto> produtoPorId(@PathVariable int id){
		return produtoRepository.findById(id) ;
	}
	
	@PostMapping(value = "/cadastrar")
	public ResponseEntity<?> saveUser (@Valid @RequestBody ProdutoRequestDTO prod){
		Produto produto = new Produto(prod.getNome(), prod.getPreco(), prod.getQuantidade());
		produtoRepository.save(produto);
		return ResponseEntity.ok("O usuário foi cadastrado com sucesso!");
	}
	

	@GetMapping(value = "buscar")
	public ResponseEntity<?> ListarProduto1(){
		List<Produto> listaDeProdutos = produtoRepository.findAll();
		List<ProdutoResponseDTO> listaDTO = listaDeProdutos.stream().map(prod -> new ProdutoResponseDTO(prod)).toList();
		return ResponseEntity.ok(listaDTO);	
	}
	
	@GetMapping("/{id}")
	public List<Produto> listarProduto(){
		return produtoRepository.findAll();
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletar(@PathVariable int id){
		if (produtoRepository.existsById(id)) {
			produtoRepository.deleteById(id);
			return ResponseEntity.status(HttpStatus.OK).body("Excluido com Sucesso!"); // 204
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Esse Id não existe"); // 404
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Produto> atualizar(@PathVariable int id, @RequestBody Produto novaQuantidade){
		Optional<Produto> ProdutoExistente = produtoRepository.findById(id);
		
		if(ProdutoExistente.isPresent()) {
			Produto Produto = ProdutoExistente.get();
			Produto.setQuantidade(novaQuantidade.getQuantidade());
			produtoRepository.save(Produto);
			return ResponseEntity.ok(Produto);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}
