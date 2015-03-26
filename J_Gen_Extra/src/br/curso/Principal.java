package br.curso;

import java.lang.reflect.Field;

public class Principal {

	public static void main(String args[]) {

		try {
			String nomeClasse = "br.curso.Produto";

			Class classToInvestigate = Class.forName(nomeClasse);

			Field[] aFields = classToInvestigate.getDeclaredFields();
			//
			for (Field field : aFields) {
				System.out.println(field.getName() + " - "
						+ field.getType().toString());
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
