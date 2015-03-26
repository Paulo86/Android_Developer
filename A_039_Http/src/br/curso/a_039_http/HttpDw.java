package br.curso.a_039_http;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.http.util.ByteArrayBuffer;

import android.graphics.Bitmap;

public class HttpDw {

	public static final String LINK_IMAGEM = "http://172.16.6.31/wsn/foto.jpg";
	public static final String PATH_IMAGEM = "/sdcard/";
	public static final String NOME_IMAGEM = "foto.jpg";

	public static void gravarImagem() throws Exception {

		HttpURLConnection urlConnectioun = null;
		URL url = new URL(LINK_IMAGEM);
		urlConnectioun = (HttpURLConnection) url.openConnection();
		urlConnectioun.setDoInput(true);
		urlConnectioun.connect();
		//
		InputStream in = new BufferedInputStream(
				urlConnectioun.getInputStream());
		BufferedInputStream bis = new BufferedInputStream(in);
		ByteArrayBuffer baf = new ByteArrayBuffer(50);
		//
		int read = 0;
		int bufSize = 512;
		byte[] buffer = new byte[bufSize];
		//
		while (true) {
			read = bis.read(buffer);
			if (read == -1) {
				break;
			}

			baf.append(buffer, 0, read);
		}
		//
		File diretorio = new File(PATH_IMAGEM);
		if (!diretorio.exists()) {
			diretorio.mkdir();
		}
		//
		File arquivo = new File(PATH_IMAGEM + NOME_IMAGEM);
		if (arquivo.exists()) {
			arquivo.delete();
		}
		//
		FileOutputStream fileOutputStream = new FileOutputStream(PATH_IMAGEM
				+ NOME_IMAGEM);
		fileOutputStream.write(baf.toByteArray());
		fileOutputStream.flush();
		fileOutputStream.close();
	}

}
