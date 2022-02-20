package br.com.compass.questao10;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Pergunta {
	private String pergunta;
	private String resposta;

	public String getPergunta() {
		return pergunta;
	}

	public String getResposta() {
		return resposta;
	}

	public Pergunta(String pergunta) {
		this.pergunta = pergunta;

		String feliz = "\\:\\-\\)";
		String chateado = "\\:\\-\\(";
		
		long resultadoDivertido;
		long resultadoChateado;
		int countaFeliz = 0;
		int countaChateado = 0;

		Pattern patternFeliz = Pattern.compile(feliz);
		Pattern patternChateado = Pattern.compile(chateado);

		Matcher matcherFeliz = patternFeliz.matcher(pergunta);
		Matcher matcherchateado = patternChateado.matcher(pergunta);

		while(matcherFeliz.find())
			countaFeliz++;
		while(matcherchateado.find())
			countaChateado++;

		resultadoDivertido = countaFeliz;
		resultadoChateado = countaChateado;

		if (resultadoDivertido > resultadoChateado) 
			this.resposta = "Divertido";
		
		if (resultadoDivertido < resultadoChateado) 
			this.resposta = "Chateado";
		
		if (resultadoDivertido == resultadoChateado) 
			this.resposta = "Neutro";
	}
}
