package com.automation.selenium.helper;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import javax.imageio.ImageIO;

import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.Logger;

public class FileUtility {
	static Logger logger = Logger.getLogger(FileUtility.class);
	static final int BUFFER = 2048;

	/**
	 * Recursive file copy
	 * @param srcPath
	 * @param dstPath
	 * @throws IOException
	 */
	public static void copyFile(final File srcPath, final File dstPath) throws IOException {

		if (srcPath.isDirectory()) {
			if (!dstPath.exists()) {
				dstPath.mkdir();
			}

			String[] files = srcPath.list();
			for (String file : files) {
				copyFile(new File(srcPath, file), new File(dstPath, file));
			}
		} else {
			if (!srcPath.exists()) {
				throw new IOException("Directory Not Found ::: " + srcPath);
			} else {
				if (!dstPath.getParentFile().exists()) {
					dstPath.getParentFile().mkdirs();
				}

				try (InputStream in = new FileInputStream(srcPath)){
					try (OutputStream out = new FileOutputStream(dstPath)){

						// Transfer bytes
						byte[] buf = new byte[1024];
						int len;

						while ((len = in.read(buf)) > 0) {
							out.write(buf, 0, len);
						}
					} 
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void copyFile(final String srcPath, final String dstPath) throws IOException {
		copyFile(new File(srcPath), new File(dstPath));
	}

	/**
	 * Deletes Directory with Files.
	 *
	 * @param   path
	 *
	 * @return
	 */
	public static boolean deleteDirectory(final File path) {
		if (path.exists()) {
			File[] files = path.listFiles();
			for (File file : files) {
				if (file.isDirectory()) {
					deleteDirectory(file);
				} else {
					file.delete();
				}
			}
		}

		return path.delete();
	}

	public static boolean deleteDirectory(final String dir) {
		return deleteDirectory(new File(dir));
	}

	/**
	 * Read contents of a file.
	 *
	 * @param   path
	 *
	 * @return  content
	 *
	 * @throws  IOException
	 */
	public static String readFromFile(final File path) throws IOException {

		try (FileInputStream fis = new FileInputStream(path)){
			return readFromFile(fis);
		} catch(Exception e) {
			throw new IOException();
		}
	}

	/**
	 * Read contents From Stream.
	 *
	 * @param   path
	 *
	 * @return  content
	 *
	 * @throws  IOException
	 */
	public static String readFromFile(final InputStream path) throws IOException {
		StringBuilder stringBuilder = new StringBuilder();

		try (InputStreamReader fr = new InputStreamReader(path);
				BufferedReader br = new BufferedReader(fr);){
			String line;
			while ((line = br.readLine()) != null) {
				stringBuilder.append(line).append("\n");
			}
		}  catch (IOException e) {
			e.printStackTrace();
		}
		return stringBuilder.toString();
	}

	/**
	 * Constructs ImageElement from bytes and stores it.
	 *
	 * @param  path
	 */
	public static synchronized void writeImage(final String path, final byte[] byteArray) {
		if (byteArray.length == 0) {
			return;
		}

		try {
			File parentDir = new File(path).getParentFile();
			if (!parentDir.exists()) {
				parentDir.mkdirs();
			}

			byte[] decodeBuffer = Base64.decodeBase64(byteArray);
			try(InputStream in = new ByteArrayInputStream(decodeBuffer);
					FileOutputStream fos = new FileOutputStream(path);){

				BufferedImage img = ImageIO.read(in);

				ImageIO.write(img, "png", fos);
				img = null;
			} 
		}catch (Exception e) {
			logger.error(e);
		}
	}

	/**
	 * @param   filePath
	 *
	 * @throws  Exception
	 */

	public static void writeToFile(final String filePath, final String content) throws IOException {
		try {
			File parentDir = new File(filePath).getParentFile();
			if (!parentDir.exists()) {
				parentDir.mkdirs();
			}
			try(FileOutputStream fileOutputStream = new FileOutputStream(filePath);
					OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream, "UTF8");
					BufferedWriter bw = new BufferedWriter(outputStreamWriter);){
				bw.write(content);	
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

	public static String getLatestFile(final String folder) {
		String file = null;
		File folderFile = new File(folder);
		if (folderFile.exists() && folderFile.isDirectory()) {
			File[] files = folderFile.listFiles();
			long date = 0;

			for (int i = 0; i < files.length; i++) {
				if (files[i].lastModified() > date) {
					date = files[i].lastModified();
					file = files[i].getAbsolutePath();
				}
			}
		}

		return file;
	}

	public static String decodePath(final String path) throws UnsupportedEncodingException {
		return URLDecoder.decode(path, "UTF-8");
	}
}
