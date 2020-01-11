package br.com.diego.forum.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.diego.forum.controller.dto.TopicoDto;
import br.com.diego.forum.modelo.Curso;
import br.com.diego.forum.modelo.Topico;
import br.com.diego.forum.repository.TopicoRepository;

@RestController
public class TopicosController {

	@Autowired
	private TopicoRepository topicoRepository;

	@RequestMapping("/topicos")
	public List<TopicoDto> listar(String nomeCurso) {
		List<Topico> topico = null;
		
		if (nomeCurso == null) {
			 topico = topicoRepository.findAll();
		}else {
			topico = topicoRepository.findByCurso_Nome(nomeCurso);
		}
		return TopicoDto.convert(topico);
	}

}
