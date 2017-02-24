package main;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import messagesjava.*;
import messagesjava.PassagemProto.PassagemEntrada.Categoria;

public class ExecPassagens {

	public static String convertJsonToProto(String mensagem) throws Exception {
		try {
			ArrayList<PassagemProto.PassagemEntrada> listPassagemProto = new ArrayList<PassagemProto.PassagemEntrada>();

			JSONArray jsonArray;

			JSONObject jsonObject = new JSONObject(mensagem);

			jsonArray = jsonObject.getJSONArray("pessoa");

			for (int i = 0; i < jsonArray.length(); i++) {

				PassagemProto.PassagemEntrada passagem = new PassagemProto.PassagemEntrada();
				passagem = PassagemProto.PassagemEntrada.newBuilder()
						.setCatCadastrada(Categoria.CAT01)
						.setCatCobrada(Categoria.CAT01)
						.setCatDetectada(Categoria.CAT01)
						.setDatahora(Long.parseLong(jsonArray.getJSONObject(i).getString("email"))
						
						).build();

				listPassagemProto.add(passagem);

			}

			return listPassagemProto.toString();

		} catch (Exception e) {
			throw e;
		}

	}
}
