package br.com.diego.forum.controller.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.diego.forum.modelo.Topico;

@Entity
public class TopicoDto {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String titulo;
	private String mensagem;
	private LocalDateTime data;
	
	public TopicoDto(Topico topico) {
		this.mensagem = topico.getMensagem();
		this.titulo = topico.getTitulo();
		this.data = topico.getDataCriacao();
	}
	
	public Long getId() {
		return id;
	}
	public String getTitulo() {
		return titulo;
	}
	public String getMensagem() {
		return mensagem;
	}
	public LocalDateTime getData() {
		return data;
	}

	public static List<TopicoDto> convert(List<Topico> topicos) {
		// TODO Auto-generated method stub
		return topicos.stream().map(TopicoDto:: new).collect(Collectors.toList());
	}

}
